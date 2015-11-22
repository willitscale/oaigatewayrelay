package uk.co.n3tw0rk.oaigatewayrelay.utils;

public class Logger
{
	public static final int SILENT_LEVEL = 0x0;
	public static final int ERROR_LEVEL = 0x1;
	public static final int DEBUG_LEVEL = 0x2;
	public static final int WARNING_LEVEL = 0x4;
	public static final int NOTICE_LEVEL = 0x8;
	public static final int MESSAGE_LEVEL = 0xF;
	
	public static void console( String message, int level )
	{
		System.out.println( message );
	}
}
