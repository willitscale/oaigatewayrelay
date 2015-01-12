package uk.co.n3tw0rk.oaigatewayrelay.websocket.responses;

import java.util.LinkedList;
import java.util.List;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.WebSocketResponse;
import uk.co.n3tw0rk.oaigatewayrelay.controllers.SystemController;
import uk.co.n3tw0rk.oaigatewayrelay.data.Devices;

public class DeviceList extends WebSocketResponse
{
	public List<Integer> mDevices;
	
	public DeviceList( Object data )
	{
		super( "DeviceList", data );
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
		
		for( Integer key : devices.getKeys() )
		{
			this.mDevices.add( devices.getStructure( key ).getExtension() );
		}
	}
}
