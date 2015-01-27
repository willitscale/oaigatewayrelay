package uk.co.n3tw0rk.oaigatewayrelay.websocket.factories;

import uk.co.n3tw0rk.oaigatewayrelay.websocket.abstraction.WebSocketResponse;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.constants.OperationMap;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.responses.generic.ControllerInvalid;

public class WebSocketOperation
{
	public String controller;
	public String action;
	public Object data;
	
	public WebSocketResponse process( String session )
	{
		if( null == controller || controller.isEmpty() )
		{
			return new ControllerInvalid( this.data, session );
		}

		if( 0 == OperationMap.DEVICE_CONTROLLER.compareToIgnoreCase( controller ) )
		{
			return ( new WebSocketDeviceResponse( this.action, this.data, session ) ).process();
		}
		else if( 0 == OperationMap.NODE_CONTROLLER.compareToIgnoreCase( controller ) )
		{
			return ( new WebSocketNodeResponse( this.action, this.data, session ) ).process();
		}

		return new ControllerInvalid( this.data, session );
	}
}
