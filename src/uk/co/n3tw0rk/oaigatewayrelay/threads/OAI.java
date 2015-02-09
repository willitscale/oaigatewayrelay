package uk.co.n3tw0rk.oaigatewayrelay.threads;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.commands.Command;
import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Event;
import uk.co.n3tw0rk.oaigatewayrelay.buffers.PBXInbound;
import uk.co.n3tw0rk.oaigatewayrelay.buffers.PBXOutbound;
import uk.co.n3tw0rk.oaigatewayrelay.commands.system.Connection;
import uk.co.n3tw0rk.oaigatewayrelay.database.mysql.MySQLConnection;
import uk.co.n3tw0rk.oaigatewayrelay.events.acknowledgement.Confirmation;
import uk.co.n3tw0rk.oaigatewayrelay.events.miscellaneous.ResyncEnded;
import uk.co.n3tw0rk.oaigatewayrelay.factories.EventFactory;
import uk.co.n3tw0rk.oaigatewayrelay.sequences.OAIConnect;
import uk.co.n3tw0rk.oaigatewayrelay.utils.Config;

public class OAI implements Runnable
{
	private final long RETRY_DELAY = 1000L;

	private BufferedOutputStream out = null;
	private BufferedReader in = null;
	private Socket socket = null;
	private byte[] byteBuffer;
	private String tmpString;

	/**
	 *  >> ? oaigatewayrelay
	 *  << 000,RS,0,00:57,010415,V10.10,V4.0.3.91,3,0,1,3,1
	 *  << 001,RD,0,
	 *  << 002,CF,_NA,1,0,1
	 *  << 3,CF,_MS,2,0,0226,000001,1000,000002,1001,000003,1087,000004,1003,000005,1004,000006,1143,000007,1129,000008,1007,000009,1109,000010,1009,000011,1128,000012,1108,000013,1012,000014,1013,000015,1014,000016,1015,000017,1016,000018,1017,000019,1018,000020,1019,000021,1020,000022,1021,000023,1022,000024,1023,000025,1024,000026,1121,000027,1026,000028,1027,000029,1028,000030,1074,000031,1030,000032,1031,000033,1034,000034,1092,000035,1086,000036,1056,000037,1103,000038,1119,000039,1040,000040,1041,000041,1042,000042,1043,000043,1044,000044,1110,000045,1046,000046,1047,000047,1048,000048,1070,000049,1088,000050,1083,000051,1052,000052,1053,000053,1054,000054,1008,000055,1090,000056,1100,000057,1058,000058,1059,000059,1114,000060,1061,000061,1062,000062,1120,000063,1076,000064,1069,000065,1501,000066,1502,000067,1503,000068,1504,000069,1500,000070,1032,000071,1102,000072,1165,000073,1104,000074,1065,000075,1049,000076,1033,000077,1066,000078,1067,000079,311,000080,1101,000081,1115,000082,1125,000083,2521,000084,1068,000085,1029,000086,1072,000087,1063,000088,1039,000089,1081,000090,1064,000091,1085,000092,1105,000093,1078,000094,1050,000095,1002,000096,1077,000097,1051,000098,1010,000099,1036,000100,1011,000101,1006,000102,1082,000103,1073,000104,1038,000105,1091,000106,1060,000107,1093,000108,1094,000109,1095,000110,1096,000111,1097,000112,1098,000113,1099,000114,1057,000115,1106,000116,1111,000117,1055,000118,1107,000119,1089,000120,1035,000121,1112,000122,1045,000123,1113,000124,1130,000125,1117,000126,1118,000127,1071,000128,1075,000129,1025,000130,1122,000131,1123,000132,1124,000133,1127,000134,1126,000135,1084,000136,1116,000137,1079,000138,1131,000139,1132,000140,1133,000141,1134,000142,1135,000143,1136,000144,1137,000145,1138,000146,1139,000147,1140,000148,1141,000149,1142,000150,1005,000151,1144,000152,1145,000153,1146,000154,1147,000155,1148,000156,1149,000157,1150,000158,1151,000159,1152,000160,1153,000161,1154,000162,1155,000163,1156,000164,1157,000165,1158,000166,1159,000167,1160,000168,1161,000169,1162,000170,1163,000171,1164,000172,1037,000173,1166,000174,1167,000175,1168,000176,1169,000177,1170,000178,1171,000179,1508,000180,1505,000181,1506,000182,1507,000183,1500,000184,1633,000185,1666,000186,1667,000187,1701,000188,1715,000189,1725,000190,2621,000191,311,000192,1810,000193,1811,000194,1833,000195,1834,000196,1840,000197,1841,000198,1842,000199,1843,000200,1844,000201,1845,000202,1854,000203,1855,000204,1856,000205,1857,000206,1861,000207,1862,000208,1864,000209,1865,000210,1866,000211,1867,000212,1868,000213,1869,000214,1870,000215,1872,000216,1873,000217,1874,000218,1876,000219,1877,000220,1878,000221,1879,000222,1880,000223,1884,000224,1818,000225,1888,000226,1881,A:00FC,C:FFFE,F:1FFF
	 *  << 004,CF,_MS,3,0,0002,000227,1:,000228,2:,S:00FE
	 *  << 005,CF,_QI,4,0,1876,0,0,|Test|,|Test|,0,0,,0000,0000,,0,0,64,0,0,0123456789
	 *  << 006,LF,,000015,1014,5485,|Test|,2004
	 */

	@Override
	public void run()
	{
		
		OAIConnect connectSequence = new OAIConnect();

		/*
		LinkedList<String> messages = new LinkedList<String>();
		
		messages.add( null );
		messages.add( "000,RS,0,00:57,010415,V10.10,V4.0.3.91,3,0,1,3,1" );
		messages.add( "001,RD,0," );
		messages.add( "002,CF,_NA,1,0,1" );
		messages.add( "3,CF,_MS,2,0,0226,000001,1000,000002,1001,000003,1087,000004,1003,000005,1004,000006,1143,000007,1129,000008,1007,000009,1109,000010,1009,000011,1128,000012,1108,000013,1012,000014,1013,000015,1014,000016,1015,000017,1016,000018,1017,000019,1018,000020,1019,000021,1020,000022,1021,000023,1022,000024,1023,000025,1024,000026,1121,000027,1026,000028,1027,000029,1028,000030,1074,000031,1030,000032,1031,000033,1034,000034,1092,000035,1086,000036,1056,000037,1103,000038,1119,000039,1040,000040,1041,000041,1042,000042,1043,000043,1044,000044,1110,000045,1046,000046,1047,000047,1048,000048,1070,000049,1088,000050,1083,000051,1052,000052,1053,000053,1054,000054,1008,000055,1090,000056,1100,000057,1058,000058,1059,000059,1114,000060,1061,000061,1062,000062,1120,000063,1076,000064,1069,000065,1501,000066,1502,000067,1503,000068,1504,000069,1500,000070,1032,000071,1102,000072,1165,000073,1104,000074,1065,000075,1049,000076,1033,000077,1066,000078,1067,000079,311,000080,1101,000081,1115,000082,1125,000083,2521,000084,1068,000085,1029,000086,1072,000087,1063,000088,1039,000089,1081,000090,1064,000091,1085,000092,1105,000093,1078,000094,1050,000095,1002,000096,1077,000097,1051,000098,1010,000099,1036,000100,1011,000101,1006,000102,1082,000103,1073,000104,1038,000105,1091,000106,1060,000107,1093,000108,1094,000109,1095,000110,1096,000111,1097,000112,1098,000113,1099,000114,1057,000115,1106,000116,1111,000117,1055,000118,1107,000119,1089,000120,1035,000121,1112,000122,1045,000123,1113,000124,1130,000125,1117,000126,1118,000127,1071,000128,1075,000129,1025,000130,1122,000131,1123,000132,1124,000133,1127,000134,1126,000135,1084,000136,1116,000137,1079,000138,1131,000139,1132,000140,1133,000141,1134,000142,1135,000143,1136,000144,1137,000145,1138,000146,1139,000147,1140,000148,1141,000149,1142,000150,1005,000151,1144,000152,1145,000153,1146,000154,1147,000155,1148,000156,1149,000157,1150,000158,1151,000159,1152,000160,1153,000161,1154,000162,1155,000163,1156,000164,1157,000165,1158,000166,1159,000167,1160,000168,1161,000169,1162,000170,1163,000171,1164,000172,1037,000173,1166,000174,1167,000175,1168,000176,1169,000177,1170,000178,1171,000179,1508,000180,1505,000181,1506,000182,1507,000183,1500,000184,1633,000185,1666,000186,1667,000187,1701,000188,1715,000189,1725,000190,2621,000191,311,000192,1810,000193,1811,000194,1833,000195,1834,000196,1840,000197,1841,000198,1842,000199,1843,000200,1844,000201,1845,000202,1854,000203,1855,000204,1856,000205,1857,000206,1861,000207,1862,000208,1864,000209,1865,000210,1866,000211,1867,000212,1868,000213,1869,000214,1870,000215,1872,000216,1873,000217,1874,000218,1876,000219,1877,000220,1878,000221,1879,000222,1880,000223,1884,000224,1818,000225,1888,000226,1881,A:00FC,C:FFFE,F:1FFF" );
		messages.add( "004,CF,_MS,3,0,0002,000227,1:,000228,2:,S:00FE" );
		messages.add( "005,CF,_QI,4,0,1876,0,0,|Test|,|Test|,0,0,,0000,0000,,0,0,64,0,0,0123456789" );
		messages.add( "006,LF,,000015,1014,5485,|Test|,2004" );

		try
		{

			System.out.println( "Connected" );
			System.out.println( "Listening" );
			while( true )
			{
				if( 0 == messages.size() )
				{
					break;
				}

				if( null != connectSequence.activeCommand() )
				{
					tmpString = messages.pop();
					
					if( null != tmpString )
					{
						*/
		try
		{
			System.out.println( "Connecting to " + Config.PBX_HOST + ":" + Config.PBX_PORT );
			
			this.socket = new Socket( Config.PBX_HOST, Config.PBX_PORT );
			
			System.out.println( "Connected" );
			
			this.in = new BufferedReader( new InputStreamReader( this.socket.getInputStream() ) );
			this.out = new BufferedOutputStream( this.socket.getOutputStream() );
			this.out.flush();

			System.out.println( "Listening" );
			while( true )
			{
				if( this.in.ready() )
				{
					tmpString = this.in.readLine();
					
					if( 4 <= tmpString.length() )
					{
						tmpString = tmpString.substring( 4 ).intern().trim();

						System.out.println( " << " + tmpString );

						String[] parts = Event.splitEvent( tmpString );

						if( 0 < parts.length )
						{
							int invokeID = 0;
							Event event = EventFactory.getEvent( parts );

							if( event instanceof Confirmation )
							{
								invokeID = ( ( Confirmation ) event ).getInvokeID();

								Command command = PBXOutbound.getCommand( invokeID );
								command.setEvent( event );
								if( command.hasCompleted() )
								{
									connectSequence.clearActiveCommand();
								}
							}
							else if( connectSequence.activeCommand() instanceof Connection && 
								event instanceof ResyncEnded )
							{
								connectSequence.clearActiveCommand();
							}
							else
							{
								PBXInbound.addEvent( event );
							}
							
							/*
								CREATE TABLE `events` (
								  `event_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
								  `event_datetime` datetime DEFAULT NULL,
								  `event_string` text,
								  `event_code` varchar(3) DEFAULT NULL,
								  `command_id` int(10) unsigned DEFAULT NULL,
								  PRIMARY KEY (`event_id`)
								) ENGINE=InnoDB DEFAULT CHARSET=latin1;
							 */
							
							String eventCode = "";
							
							if( null != event )
							{
								eventCode = event.getEvent();
							}

							MySQLConnection
								.instance()
								.executeQuery( "INSERT INTO `events` " +
									"( event_datetime, event_string, event_code, command_id )" + 
									" VALUES " + 
									"( NOW(), \"" + tmpString + "\", \"" + eventCode + "\", " + invokeID + " )" );
						}
					}
					else
					{
						this.delay();
					}
				}
				else if( connectSequence.nextSequence() || connectSequence.completed() )
				{
					tmpString = PBXOutbound.getNextMessage();

					if( null != tmpString )
					{
						if( 4 <= tmpString.length() )
						{
							//System.out.println( " >> " + tmpString.intern().trim() );
							System.out.println( " >> " + tmpString.substring( 4 ).intern().trim() );
						}
	
						this.byteBuffer = tmpString.getBytes( "ISO-8859-1" ); // This char set is important for the byte sequence!
	
						for( int i = 0; i < this.byteBuffer.length; i++ )
						{
							this.out.write( this.byteBuffer[ i ] );
						}
	
						this.out.flush();
					}
					else
					{
						this.delay();
					}
				}
				else
				{
					this.delay();
				}
			}
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		finally
		{
			try { this.in.close(); } catch ( Exception e ) { e.printStackTrace(); }
			try { this.out.close(); } catch ( Exception e ) { e.printStackTrace(); }
			try { this.socket.close(); } catch ( Exception e ) { e.printStackTrace(); }
			try { Thread.sleep( RETRY_DELAY ); } catch( Exception e ) { e.printStackTrace(); }
			run();
		}
	}
	
	/**
	 * 
	 * Cut down CPU consumption while inactive
	 */
	public void delay()
	{
		try
		{
			Thread.sleep( 100L ); 
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
	}
	
}
