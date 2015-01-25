package uk.co.n3tw0rk.oaigatewayrelay.websocket.responses.device;

import uk.co.n3tw0rk.oaigatewayrelay.websocket.abstraction.WebSocketResponse;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.constants.OperationMap;

public class DeviceCommand extends WebSocketResponse
{
	public DeviceCommand( Object data, String session )
	{
		super( OperationMap.DEVICE_CONTROLLER,
			OperationMap.DEVICE_COMMAND_ACTION, 
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
