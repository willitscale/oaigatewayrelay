package uk.co.n3tw0rk.oaigatewayrelay.websocket.constants;

public class ResponseMap
{
	/** Unknown Statuses **/
	public static final int RESPONSE_UNKNOWN = 0x00;
	
	/** Good Responses **/
	public static final int RESPONSE_GOOD = 0x11;
	
	/** Invalid Responses **/
	public static final int RESPONSE_INVALID_CONTROLLER = 0x91;
	public static final int RESPONSE_INVALID_ACTION = 0x92;
	public static final int RESPONSE_INVALID_DATA = 0x93;
	public static final int RESPONSE_INVALID_PARAMETER = 0x94;
	
}
