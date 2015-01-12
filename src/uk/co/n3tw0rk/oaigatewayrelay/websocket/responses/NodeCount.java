package uk.co.n3tw0rk.oaigatewayrelay.websocket.responses;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.WebSocketResponse;

public class NodeCount extends WebSocketResponse
{
	public NodeCount( Object data )
	{
		super( "NodeCount", data );
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
