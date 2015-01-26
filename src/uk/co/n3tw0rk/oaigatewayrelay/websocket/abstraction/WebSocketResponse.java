package uk.co.n3tw0rk.oaigatewayrelay.websocket.abstraction;

import uk.co.n3tw0rk.oaigatewayrelay.websocket.constants.ResponseMap;

/**
 * <strong>Web Socket Response</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 2015-01-25
 */
public abstract class WebSocketResponse
{
	/** Controller Name */
	public String mController;

	/** Action Name */
	public String mAction;

	/** Session Key */
	public String mSession;

	/** Response State */
	public int mState;

	/**
	 * <strong>Constructor Sub-Routine</strong>
	 * 
	 * @param action
	 * @param controller
	 * @param data
	 * @param session
	 */
	public WebSocketResponse( String action, String controller, 
		Object data, String session )
	{
		this( action, controller, data, session, 
			ResponseMap.RESPONSE_GOOD );
	}
	
	/**
	 * <strong>Constructor Sub-Routine</strong>
	 * 
	 * @param action
	 * @param controller
	 * @param data
	 * @param session
	 * @param state
	 */
	public WebSocketResponse( String action, String controller, 
		Object data, String session, int state )
	{
		this.mState = state;
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
