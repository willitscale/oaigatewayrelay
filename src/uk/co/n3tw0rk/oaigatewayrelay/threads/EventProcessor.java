package uk.co.n3tw0rk.oaigatewayrelay.threads;

import uk.co.n3tw0rk.oaigatewayrelay.buffers.PBXInbound;

public class EventProcessor implements Runnable
{
	@Override
	public void run()
	{
		for(;;)
		{
			try
			{
				if( PBXInbound.hasNext() )
				{
					PBXInbound.getNextEvent().process();
				}
				else
				{
					synchronized( this )
					{
						this.wait();
					}
				}
			}
			catch( Exception e )
			{
				
			}
		}
	}
	
	public synchronized void newEvent()
	{
		this.notify();
	}
}
