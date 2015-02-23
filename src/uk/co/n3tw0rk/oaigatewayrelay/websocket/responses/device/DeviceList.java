package uk.co.n3tw0rk.oaigatewayrelay.websocket.responses.device;

import java.util.LinkedList;
import java.util.List;

import uk.co.n3tw0rk.oaigatewayrelay.controllers.SystemController;
import uk.co.n3tw0rk.oaigatewayrelay.data.Devices;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.abstraction.WebSocketResponse;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.constants.OperationMap;

public class DeviceList extends WebSocketResponse
{
	public List<Integer> mDevices;

	public DeviceList( Object data, String session )
	{
		super( OperationMap.DEVICE_CONTROLLER,
			OperationMap.DEVICE_LIST_ACTION, 
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
		this.mDevices = new LinkedList<Integer>();
		
		Devices devices = SystemController.instance().getDevices();
		
		for( Object key : devices.getKeys() )
		{
			this.mDevices.add( devices.getStructure( key ).getExtension() );
		}
	}
}
