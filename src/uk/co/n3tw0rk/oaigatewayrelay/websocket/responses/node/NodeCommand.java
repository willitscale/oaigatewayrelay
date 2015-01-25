package uk.co.n3tw0rk.oaigatewayrelay.websocket.responses.node;

import uk.co.n3tw0rk.oaigatewayrelay.websocket.abstraction.WebSocketResponse;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.constants.OperationMap;

public class NodeCommand extends WebSocketResponse
{
	public NodeCommand( Object data, String session )
	{
		super( OperationMap.NODE_CONTROLLER,
			OperationMap.NODE_COMMAND_ACTION, 
			data, session );
	}
	
	@Override
	public WebSocketResponse getResponse()
	{
		return this;
	}
	
	@Override
	public void process( Object data )
	{
		
	}
}
