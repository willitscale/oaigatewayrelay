package uk.co.n3tw0rk.oaigatewayrelay.threads;

import uk.co.n3tw0rk.websocketregistration.config.Config;
import uk.co.n3tw0rk.websocketregistration.events.EventRegistration;
import uk.co.n3tw0rk.websocketregistration.threads.ChannelWebSocketServer;

public class OAIApplication implements Runnable
{
	@Override
	public void run()
	{
		( new Thread( new OAI() ) ).start();
		
		try
		{
			( new ChannelWebSocketServer( Config.SERVER_SOCKET, new EventRegistration() ) ).start();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		
		this.indefinite();
	}
	
	public void indefinite()
	{
		try
		{
			while( true )
			{
				Thread.sleep( Long.MAX_VALUE );
			}
		}
		catch( InterruptedException exception )
		{
			exception.printStackTrace();
		}
		finally
		{
			this.indefinite();
		}
	}
}
