package uk.co.n3tw0rk.oaigatewayrelay.websocket.factories;

import uk.co.n3tw0rk.oaigatewayrelay.websocket.abstraction.FactoryResponse;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.abstraction.WebSocketResponse;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.constants.OperationMap;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.responses.device.*;

public class WebSocketDeviceResponse extends FactoryResponse
{
	public WebSocketDeviceResponse( String action, Object data, String session )
	{
		super( action, data, session );
	}

	public WebSocketResponse process()
	{
		if( null == this.mAction || this.mAction.isEmpty() )
		{
			return null;
		}

		if( 0 == OperationMap.DEVICE_COUNT_ACTION.compareToIgnoreCase( this.mAction ) )
		{
			return new DeviceCount( this.mData, this.mSession );
		}
		else if( 0 == OperationMap.DEVICE_DATA_ACTION.compareToIgnoreCase( this.mAction ) )
		{
			return new DeviceData( this.mData, this.mSession );
		}
		else if( 0 == OperationMap.DEVICE_LIST_ACTION.compareToIgnoreCase( this.mAction ) )
		{
			return new DeviceList( this.mData, this.mSession );
		}
		else if( 0 == OperationMap.DEVICE_MONITOR_ACTION.compareToIgnoreCase( this.mAction ) )
		{
			return new DeviceMonitor( this.mData, this.mSession );
		}
		else if( 0 == OperationMap.DEVICE_COMMAND_ACTION.compareToIgnoreCase( this.mAction ) )
		{
			return new DeviceCommand( this.mData, this.mSession );
		}

		return null;
	}
	
}
