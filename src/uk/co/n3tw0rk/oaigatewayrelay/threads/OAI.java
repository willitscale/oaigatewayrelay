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
import uk.co.n3tw0rk.oaigatewayrelay.utils.Logger;

public class OAI implements Runnable
{
	private final long RETRY_DELAY = 1000L;

	private BufferedOutputStream out = null;
	private BufferedReader in = null;
	private Socket socket = null;
	private byte[] byteBuffer;
	private String tmpString;

	@Override
	public void run()
	{
		
		OAIConnect connectSequence = new OAIConnect();

		try
		{
			Logger.console( "Connecting to " + Config.PBX_HOST + ":" + Config.PBX_PORT, Logger.MESSAGE_LEVEL );
			
			this.socket = new Socket( Config.PBX_HOST, Config.PBX_PORT );
			
			Logger.console( "Connected", Logger.MESSAGE_LEVEL );
			
			this.in = new BufferedReader( new InputStreamReader( this.socket.getInputStream() ) );
			this.out = new BufferedOutputStream( this.socket.getOutputStream() );
			this.out.flush();

			Logger.console( "Listening", Logger.MESSAGE_LEVEL );
			
			while( true )
			{
				if( this.in.ready() )
				{
					tmpString = this.in.readLine();
					
					if( 4 <= tmpString.length() )
					{
						tmpString = tmpString.substring( 4 ).intern().trim();

						Logger.console( " << " + tmpString, Logger.MESSAGE_LEVEL );

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
/*
							MySQLConnection
								.instance()
								.executeQuery( "INSERT INTO `events` " +
									"( event_datetime, event_string, event_code, command_id )" + 
									" VALUES " + 
									"( NOW(), \"" + tmpString + "\", \"" + eventCode + "\", " + invokeID + " )" );
*/
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
							Logger.console( " >> " + tmpString.substring( 4 ).intern().trim(), Logger.MESSAGE_LEVEL );
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
