package uk.co.n3tw0rk.oaigatewayrelay.abstraction;

public abstract class WebSocketResponse
{
	public String mOperation;
	
	public WebSocketResponse( String operation, Object data, String session )
	{
		this.mOperation = operation;
		this.process( data, session );
	}

	public abstract WebSocketResponse getResponse();
	public abstract void process( Object data, String session );
}
