package uk.co.n3tw0rk.oaigatewayrelay.websocket.factories;

import uk.co.n3tw0rk.oaigatewayrelay.websocket.abstraction.FactoryResponse;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.abstraction.WebSocketResponse;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.constants.OperationMap;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.responses.node.*;

public class WebSocketNodeResponse extends FactoryResponse
{
	public WebSocketNodeResponse( String action, Object data, String session )
	{
		super( action, data, session );
	}

	public WebSocketResponse process()
	{
		if( null == this.mAction || this.mAction.isEmpty() )
		{
			return null;
		}

		if( 0 == OperationMap.NODE_COUNT_ACTION.compareToIgnoreCase( this.mAction ) )
		{
			return new NodeCount( this.mData, this.mSession );
		}
		else if( 0 == OperationMap.NODE_DATA_ACTION.compareToIgnoreCase( this.mAction ) )
		{
			return new NodeData( this.mData, this.mSession );
		}
		else if( 0 == OperationMap.NODE_LIST_ACTION.compareToIgnoreCase( this.mAction ) )
		{
			return new NodeList( this.mData, this.mSession );
		}
		else if( 0 == OperationMap.NODE_MONITOR_ACTION.compareToIgnoreCase( this.mAction ) )
		{
			return new NodeMonitor( this.mData, this.mSession );
		}
		else if( 0 == OperationMap.NODE_COMMAND_ACTION.compareToIgnoreCase( this.mAction ) )
		{
			return new NodeCommand( this.mData, this.mSession );
		}

		return null;
	}
	
}
