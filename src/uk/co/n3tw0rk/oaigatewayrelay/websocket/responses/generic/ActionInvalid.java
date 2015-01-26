package uk.co.n3tw0rk.oaigatewayrelay.websocket.responses.generic;

import uk.co.n3tw0rk.oaigatewayrelay.websocket.abstraction.WebSocketResponse;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.constants.OperationMap;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.constants.ResponseMap;

/**
 * <strong>Action Invalid Response</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 2015-01-25
 */
public class ActionInvalid extends WebSocketResponse
{
	/**
	 * <strong>Constructor Sub-Routine</strong>
	 * 
	 * @param data
	 * @param session
	 */
	public ActionInvalid( Object data, String session )
	{
		super( OperationMap.GENERIC_CONTROLLER,
			OperationMap.GENERIC_INVALID_ACTION, 
			data, session, ResponseMap.RESPONSE_INVALID_ACTION );
	}

	@Override
	public WebSocketResponse getResponse()
	{
		return this;
	}
	
	@Override
	public void process( Object data ){}
}
