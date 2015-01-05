package uk.co.n3tw0rk.oaigatewayrelay.utils;

public class Toolkit
{
	public static void killApplication( int errorCode )
	{
		if( Config.DEBUGGING )
		{
			System.out.println( "Closing application " );
			System.out.println( "Error Code : " + errorCode );
		}

		System.exit( 0 );
	}
}
