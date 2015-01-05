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
		if( name.compareTo( "version" ) == 0 ) { VERSION = value; }
		else if( name.compareTo( "debugging" ) == 0 ) { DEBUGGING = ( value.compareTo( "yes" ) == 0 ); } 
		else if( name.compareTo( "pbx_host" ) == 0 ){ PBX_HOST = value; }
		else if( name.compareTo( "pbx_port" ) == 0 ){ PBX_PORT = Integer.parseInt( value ); }
		else if( name.compareTo( "pbx_name" ) == 0 ){ PBX_NAME = value; }
		else if( name.compareTo( "pbx_pass" ) == 0 ){ PBX_PASS = value; }
		else if( name.compareTo( "db_protocol" ) == 0 ) { DB_PROTOCOL = value; }
		else if( name.compareTo( "db_hostname" ) == 0 ) { DB_HOSTNAME = value; }
		else if( name.compareTo( "db_username" ) == 0 ) { DB_USERNAME = value; }
		else if( name.compareTo( "db_password" ) == 0 ) { DB_PASSWORD = value; }
		else if( name.compareTo( "db_database" ) == 0 ) { DB_DATABASE = value; }
		else if( name.compareTo( "db_reconnect" ) == 0 ) { DB_RECONNECT = ( value.compareTo( "yes" ) == 0 ); }
		else if( name.compareTo( "ws_type" ) == 0 ){ WS_TYPE = value; }
		else if( name.compareTo( "ws_host" ) == 0 ){ WS_HOST = value; }
		else if( name.compareTo( "ws_port" ) == 0 ){ WS_PORT = Integer.parseInt( value ); }

		CONFIG_VALUES.put( name, value );
	}
}
