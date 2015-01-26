package uk.co.n3tw0rk.oaigatewayrelay.websocket.responses.generic;

import uk.co.n3tw0rk.oaigatewayrelay.websocket.abstraction.WebSocketResponse;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.constants.OperationMap;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.constants.ResponseMap;

public class ControllerInvalid extends WebSocketResponse
{
	public ControllerInvalid( Object data, String session )
	{
		super( OperationMap.GENERIC_CONTROLLER,
			OperationMap.GENERIC_INVALID_ACTION, 
			data, session, ResponseMap.RESPONSE_INVALID_CONTROLLER );
	}

	@Override
	public WebSocketResponse getResponse()
	{
		return this;
	}
	
	@Override
	public void process( Object data ){}
}
