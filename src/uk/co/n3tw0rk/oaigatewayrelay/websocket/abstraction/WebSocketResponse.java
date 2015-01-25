package uk.co.n3tw0rk.oaigatewayrelay.websocket.abstraction;

public abstract class WebSocketResponse
{
	public String mController;
	public String mAction;
	public String mSession;
	public String mState;
	
	public WebSocketResponse( String action, String controller, 
		Object data, String session )
	{
		this.mController = controller;
		this.mAction = action;
		this.mSession = session;
		this.process( data );
	}

	/**
	 * <strong>Get Response Method</strong>
	 * 
	 * @return WebSocketResponse
	 */
	public abstract WebSocketResponse getResponse();
	
	/**
	 * <strong>Process Method</strong>
	 * 
	 * @param data 
	 * @return void
	 */
	public abstract void process( Object data );
}
