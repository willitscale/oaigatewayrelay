package uk.co.n3tw0rk.oaigatewayrelay.websocket.responses;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.WebSocketResponse;
import uk.co.n3tw0rk.oaigatewayrelay.controllers.SystemController;

public class DeviceCount extends WebSocketResponse
{
	public int mDeviceCount;
	
	public DeviceCount( Object data )
	{
		super( "DeviceCount", data );
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
