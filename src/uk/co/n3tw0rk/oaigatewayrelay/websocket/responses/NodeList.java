package uk.co.n3tw0rk.oaigatewayrelay.websocket.responses;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.WebSocketResponse;

public class NodeList extends WebSocketResponse
{
	public NodeList( Object data )
	{
		super( "NodeList", data );
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
