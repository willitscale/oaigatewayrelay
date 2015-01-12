package uk.co.n3tw0rk.oaigatewayrelay.factories;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.WebSocketResponse;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.responses.DeviceCount;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.responses.DeviceData;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.responses.DeviceList;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.responses.NodeCount;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.responses.NodeData;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.responses.NodeList;

public class WebSocketOperation
{
	public String operation;
	public Object data;
	
	public WebSocketResponse process()
	{
		if( null == operation || operation.isEmpty() )
		{
			return null;
		}

		if( 0 == "DeviceCount".compareToIgnoreCase( operation ) )
		{
			return new DeviceCount( data );
		}
		else if( 0 == "DeviceData".compareToIgnoreCase( operation ) )
		{
			return new DeviceData( data );
		}
		else if( 0 == "DeviceList".compareToIgnoreCase( operation ) )
		{
			return new DeviceList( data );
		}
		else if( 0 == "NodeCount".compareToIgnoreCase( operation ) )
		{
			return new NodeCount( data );
		}
		else if( 0 == "NodeList".compareToIgnoreCase( operation ) )
		{
			return new NodeList( data );
		}
		else if( 0 == "NodeData".compareToIgnoreCase( operation ) )
		{
			return new NodeData( data );
		}
		
		return null;
	}
}
