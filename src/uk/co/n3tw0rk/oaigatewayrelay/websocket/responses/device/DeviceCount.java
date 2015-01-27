package uk.co.n3tw0rk.oaigatewayrelay.websocket.responses.device;

import uk.co.n3tw0rk.oaigatewayrelay.controllers.SystemController;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.abstraction.WebSocketResponse;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.constants.OperationMap;

public class DeviceCount extends WebSocketResponse
{
	public int mDeviceCount;
	
	public DeviceCount( Object data, String session )
	{
		super( OperationMap.DEVICE_CONTROLLER,
			OperationMap.DEVICE_COUNT_ACTION, 
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
		this.mDeviceCount = SystemController
			.instance()
			.getDevices()
			.size();
	}
}
