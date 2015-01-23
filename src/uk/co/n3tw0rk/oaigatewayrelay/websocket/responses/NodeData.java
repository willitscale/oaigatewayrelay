package uk.co.n3tw0rk.oaigatewayrelay.websocket.responses;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.WebSocketResponse;

public class NodeData extends WebSocketResponse
{
	public NodeData( Object data, String session )
	{
		super( "NodeCount", data, session );
	}
	
	@Override
	public WebSocketResponse getResponse()
	{
		return this;
	}
	
	@Override
	public void process( Object data, String session )
	{
		
	}
}
