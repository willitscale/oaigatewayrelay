package uk.co.n3tw0rk.oaigatewayrelay.threads;

import uk.co.n3tw0rk.oaigatewayrelay.buffers.PBXOutbound;
import uk.co.n3tw0rk.oaigatewayrelay.commands.pbx.NoOperation;
import uk.co.n3tw0rk.oaigatewayrelay.utils.Config;

public class OAIAlive implements Runnable
{

	@Override 
	public void run()
	{
		for(;;)
		{
			try
			{
				Thread.sleep( Config.PBX_NOOP * 1000 );
				PBXOutbound.addCommand( new NoOperation() );
			}
			catch( Exception exception )
			{
				exception.printStackTrace();
			}
		}
	}
	
}
