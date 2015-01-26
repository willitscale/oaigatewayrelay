package uk.co.n3tw0rk.oaigatewayrelay.utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

import uk.co.n3tw0rk.oaigatewayrelay.consts.ErrorCodes;

public class Config
{
	public final static String requiredConfigVariables[] = { 
		"version", 
		"debugging", 
		"db_protocol", 
		"db_hostname",
		"db_database", 
		"db_reconnect", 
		"db_username", 
		"db_password", 
		"pbx_host", 
		"pbx_port", 
		"pbx_name", 
		"pbx_pass", 
		"pbx_type", 
		"pbx_noop", 
		"ws_type",
		"ws_host", 
		"ws_port" };

	public static HashMap<String,String> CONFIG_VALUES = new HashMap<String,String>();

	/** Config File */
	public static String CONFIG_FILE = "config.ini";
	
	/** Application Version */
	public static String VERSION;
	
	/** Verbose Console Debugging */
	public static boolean DEBUGGING = true;

	public static String PBX_HOST;
	public static int PBX_PORT;
	public static String PBX_NAME;
	public static String PBX_PASS;
	public static char PBX_TYPE = 0x87;
	public static int PBX_NOOP;

	public static String DB_PROTOCOL;
	public static String DB_HOSTNAME;
	public static String DB_DATABASE;
	public static String DB_USERNAME;
	public static String DB_PASSWORD;
	public static boolean DB_RECONNECT;
	
	public static String WS_TYPE;
	public static String WS_HOST;
	public static int WS_PORT;

	public static void read()
	{
		FileInputStream fileInputStream = null;
		File file = null;
		
		try
		{
			fileInputStream = new FileInputStream( CONFIG_FILE );
			file = new File( CONFIG_FILE );
			fileInputStream.close();
		}
		catch( Exception e )
		{
			if( DEBUGGING )
			{
				e.printStackTrace();
			}
		}

		try
		{
			fileInputStream = new FileInputStream( file );
			DataInputStream dataInputStream = new DataInputStream( fileInputStream );
			InputStreamReader inputStreamReader = new InputStreamReader( dataInputStream );
			BufferedReader bufferedReader = new BufferedReader( inputStreamReader );

			String stringLine = null;
			String stringArray[] = null;

			while ( ( stringLine = bufferedReader.readLine() ) != null )
			{
				if( stringLine.length() > 0 && 
					stringLine.substring( 0, 1 ).compareTo( "#" ) != 0 && 
					stringLine.substring( 0, 1 ).compareTo( "[" ) != 0  )
				{
					stringArray = stringLine.split( "=" );
					if( stringArray.length == 2 )
					{
						setVariable( stringArray[0].trim(), stringArray[1].trim() );
					}
				}
			}

			inputStreamReader.close();
		}
		catch( Exception e )
		{
			if( DEBUGGING )
			{
				e.printStackTrace();
			}
		}
		
		check();
	}
	public static void check()
	{
		LinkedList<String> missingConfigurations = new LinkedList<String>();

		for( int i = 0; i < requiredConfigVariables.length; i++ )
		{
			if( !CONFIG_VALUES.containsKey( requiredConfigVariables[ i ] ) )
			{
				missingConfigurations.add( requiredConfigVariables[ i ] );
			}
		}
		
		boolean closeApplication = false;
		
		for( String missingValue : missingConfigurations )
		{
			closeApplication = true;
			System.out.println( "Configuration value missing : " + missingValue );
		}

		if( closeApplication )
		{
			Toolkit.killApplication( ErrorCodes.MISSING_CONFIG );
		}
	}
	
	public static void setVariable( String name, String value )
	{
		if( 0 == name.compareTo( "version" ) ) { VERSION = value; }
		else if( 0 == name.compareTo( "debugging" ) ) { DEBUGGING = ( value.compareTo( "yes" ) == 0 ); } 
		else if( 0 == name.compareTo( "pbx_host" ) ){ PBX_HOST = value; }
		else if( 0 == name.compareTo( "pbx_port") ){ PBX_PORT = Integer.parseInt( value ); }
		else if( 0 == name.compareTo( "pbx_name" ) ){ PBX_NAME = value; }
		else if( 0 == name.compareTo( "pbx_pass" ) ){ PBX_PASS = value; }
		else if( 0 == name.compareTo( "pbx_noop" ) ){ PBX_NOOP = Integer.parseInt( value ); }
		else if( 0 == name.compareTo( "db_protocol" ) ) { DB_PROTOCOL = value; }
		else if( 0 == name.compareTo( "db_hostname" ) ) { DB_HOSTNAME = value; }
		else if( 0 == name.compareTo( "db_username" ) ) { DB_USERNAME = value; }
		else if( 0 == name.compareTo( "db_password" ) ) { DB_PASSWORD = value; }
		else if( 0 == name.compareTo( "db_database" ) ) { DB_DATABASE = value; }
		else if( 0 == name.compareTo( "db_reconnect" ) ) { DB_RECONNECT = ( value.compareTo( "yes" ) == 0 ); }
		else if( 0 == name.compareTo( "ws_type" ) ){ WS_TYPE = value; }
		else if( 0 == name.compareTo( "ws_host" ) ){ WS_HOST = value; }
		else if( 0 == name.compareTo( "ws_port" ) ){ WS_PORT = Integer.parseInt( value ); }

		CONFIG_VALUES.put( name, value );
	}
}
