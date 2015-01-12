package uk.co.n3tw0rk.oaigatewayrelay.websocket.error;

public class JsonError
{
	public String error = "";
	public int code = 0;
	
	public JsonError( String error, int code )
	{
		this.error = error;
		this.code = code;
	}
}