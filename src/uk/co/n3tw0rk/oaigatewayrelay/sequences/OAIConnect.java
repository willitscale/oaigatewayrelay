package uk.co.n3tw0rk.oaigatewayrelay.sequences;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Command;
import uk.co.n3tw0rk.oaigatewayrelay.buffers.PBXOutbound;
import uk.co.n3tw0rk.oaigatewayrelay.commands.gateway.NodeAware;
import uk.co.n3tw0rk.oaigatewayrelay.commands.pbx.MonitorStart;
import uk.co.n3tw0rk.oaigatewayrelay.commands.pbx.QueryDeviceInfo;
import uk.co.n3tw0rk.oaigatewayrelay.commands.system.Connection;
import uk.co.n3tw0rk.oaigatewayrelay.utils.Config;

public class OAIConnect
{
	boolean mComplete = false;
	int mStage = 1;
	Command mActiveCommand = null;

	public Command activeCommand()
	{
		return this.mActiveCommand;
	}
	
	public void clearActiveCommand()
	{
		this.mActiveCommand = null;
	}
	
	public boolean nextSequence()
	{
		if( this.mComplete )
		{
			return false;
		}
		
		if( null != this.mActiveCommand )
		{
			return false;
		}
		
		switch( this.mStage )
		{
			case 1 :
			{
				this.mActiveCommand = PBXOutbound.addCommand( new Connection()
					.setSocketType( Config.PBX_TYPE )
					.setApplicationName( "oaigatewayrelay" )
					.setPassword( "" ) );
				break;
			}
			case 2 :
			{
				this.mActiveCommand = PBXOutbound.addCommand( new NodeAware()
					.setSetting( 1 ) );
				break;
			}
			
			case 3 :
			{
				this.mActiveCommand = PBXOutbound.addCommand( new MonitorStart()
					.setAffectedExt( -1 )
					.setMonitorType( 3 )
					.setMonitorOptions( "A:FFFF,C:FFFF,F:FFFF" ) );
				break;
			}

			case 4 :
			{
				this.mActiveCommand = PBXOutbound.addCommand( new MonitorStart()
					.setAffectedExt( -1 )
					.setMonitorType( 11 )
					.setMonitorOptions( "S:FFFF" ) );
				break;
			}
			
			case 5 :
			{
				this.mActiveCommand = PBXOutbound.addCommand( new QueryDeviceInfo()
					.setAffectedExt( 1876 ) );
				this.mComplete = true;
				break;
			}
		}

		this.mStage++;
		
		return true;
	}
}
