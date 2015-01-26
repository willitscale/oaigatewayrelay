package uk.co.n3tw0rk.oaigatewayrelay.websocket.responses.device;

import uk.co.n3tw0rk.oaigatewayrelay.websocket.abstraction.WebSocketResponse;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.constants.OperationMap;
import uk.co.n3tw0rk.websocketregistration.exceptions.HandshakeException;
import uk.co.n3tw0rk.websocketregistration.exceptions.WebsocketVersionException;
import uk.co.n3tw0rk.websocketregistration.factories.WebsocketVersionFactory;
import uk.co.n3tw0rk.websocketregistration.pools.ChannelSocketPool;

public class DeviceMonitor extends WebSocketResponse
{
	public DeviceMonitor( Object data, String session )
	{
		super( OperationMap.DEVICE_CONTROLLER,
			OperationMap.DEVICE_MONITOR_ACTION,
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
		( new Thread( new Runnable()
		{
			@Override
			public void run()
			{
				for(;;)
				{
					try
					{
						Thread.sleep( 2000l );
						ChannelSocketPool.put( mSession, WebsocketVersionFactory.parcelString( "HUR DUR" ) );
					}
					catch( WebsocketVersionException e )
					{
						e.printStackTrace();
					}
					catch( HandshakeException e )
					{
						e.printStackTrace();
					}
					catch( Exception e )
					{
						e.printStackTrace();
					}
				}
			}
		} ) ).start();
	}
}
