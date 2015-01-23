package uk.co.n3tw0rk.oaigatewayrelay.websocket.responses;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.WebSocketResponse;
import uk.co.n3tw0rk.oaigatewayrelay.controllers.SystemController;
import uk.co.n3tw0rk.websocketregistration.exceptions.HandshakeException;
import uk.co.n3tw0rk.websocketregistration.exceptions.WebsocketVersionException;
import uk.co.n3tw0rk.websocketregistration.factories.WebsocketVersionFactory;
import uk.co.n3tw0rk.websocketregistration.pools.ChannelSocketPool;

public class DeviceCount extends WebSocketResponse
{
	public int mDeviceCount;
	
	public DeviceCount( Object data, String session )
	{
		super( "DeviceCount", data, session );
	}

	@Override
	public WebSocketResponse getResponse()
	{
		return this;
	}
	
	@Override
	public void process( Object data, final String session )
	{
		this.mDeviceCount = SystemController
			.instance()
			.getDevices()
			.size();
		
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
						ChannelSocketPool.put( session, WebsocketVersionFactory.parcelString( "HUR DUR" ) );
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
