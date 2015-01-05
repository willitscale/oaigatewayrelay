package uk.co.n3tw0rk.oaigatewayrelay.utils;

public class OAIToolkit
{
	private static final int ENDIAN_LENGTH = 3;
	private static final int BYTE_SIZE = 256;

	private static final char NEWLINE = 0x0D;
	private static final char BREAK = 0x00;

	/**
	 * @param socketType 0x87 and 0x84 are the only two types of socket connection available I believe? 
	 * 					There possibly could be some more but we only need 0x87 (see the manual for more info)
	 * @param name Application Name
	 * @param password PBX Password ( blank for our phone system at the moment, is this safe? )
	 * @see Page 218 of System OAI Toolkit Spec Manual
	 * @return Valid connection String
	 */
	public static String buildConnectionPBXCommand( char socketType, String name, String password )
	{
		return buildPBXString( String.format( "%1$c%2$s%3$c%4$s%5$c",
				socketType, password, BREAK, name, BREAK ), false );
	}

	/**
	 * 
	 * @param String
	 * @param boolean
	 * @return String
	 */
	public static String buildPBXString( String command, boolean newLine )
    {
    	return String.format( "%1$4s%2$s%3$s", 
    		buildLittleEndian( command.length() + ( ( newLine ) ? 1 : 0 ) ),
    		command, ( newLine ) ? Character.toString( NEWLINE ) : "" );
    }

	/**
	 * 
	 * @param int
	 * @return String
	 */
	private static String buildLittleEndian( int stringLength )
    {
    	StringBuilder littleEndianString = new StringBuilder( "" );
    	double endian = stringLength / Math.pow( BYTE_SIZE, ENDIAN_LENGTH );
    	for( int i = 0; i <= ENDIAN_LENGTH; i++ )
    	{
    		char tmpByte = ( char )( int )( ( ENDIAN_LENGTH == i ) ? 
    			Math.round( endian ) : Math.floor( endian ) );
    		endian -= tmpByte;
    		endian *= BYTE_SIZE;
    		littleEndianString.insert( 0, tmpByte );
    	}
    	return littleEndianString.toString();
    }
}
