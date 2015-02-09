package uk.co.n3tw0rk.oaigatewayrelay.threads;

import uk.co.n3tw0rk.oaigatewayrelay.utils.Config;
import uk.co.n3tw0rk.websocketregistration.events.EventRegistration;
import uk.co.n3tw0rk.websocketregistration.threads.ChannelWebSocketServer;

public class OAIApplication implements Runnable
{
	public static OAI mOAIThread;
	
	public static EventProcessor mEventProcessorThread;
	
	@Override
	public void run()
	{
		mOAIThread = new OAI();
		mEventProcessorThread = new EventProcessor();

		( new Thread( mOAIThread ) ).start();
		( new Thread( mEventProcessorThread ) ).start();

		try
		{
			( new ChannelWebSocketServer( Config.WS_HOST, 
				Config.WS_PORT, new EventRegistration() ) ).start();
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
