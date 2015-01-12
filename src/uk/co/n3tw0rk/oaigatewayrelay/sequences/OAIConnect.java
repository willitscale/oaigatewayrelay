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
	public static final int STAGE_CONNECT = 0x01;
	public static final int STAGE_NODE_AWARE = 0x02;
	public static final int STAGE_MONITOR_STATIONS = 0x03;
	public static final int STAGE_MONITOR_SYSTEM = 0x04;
	public static final int STAGE_MOCK = 0x05;
	
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
			case STAGE_CONNECT :
			{
				this.mActiveCommand = PBXOutbound.addCommand( new Connection()
					.setSocketType( Config.PBX_TYPE )
					.setApplicationName( "oaigatewayrelay" )
					.setPassword( "" ) );
				break;
			}
			case STAGE_NODE_AWARE :
			{
				this.mActiveCommand = PBXOutbound.addCommand( new NodeAware()
					.setSetting( 1 ) );
				break;
			}
			
			case STAGE_MONITOR_STATIONS :
			{
				this.mActiveCommand = PBXOutbound.addCommand( new MonitorStart()
					.setAffectedExt( -1 )
					.setMonitorType( MonitorStart.MONITOR_TYPE_ALL_STATIONS )
					.setMonitorOptions( "A:FFFF,C:FFFF,F:FFFF" ) );
				break;
			}

			case STAGE_MONITOR_SYSTEM :
			{
				this.mActiveCommand = PBXOutbound.addCommand( new MonitorStart()
					.setAffectedExt( -1 )
					.setMonitorType( MonitorStart.MONITOR_TYPE_SYSTEM )
					.setMonitorOptions( "S:FFFF" ) );
				break;
			}
			
			/** MOCK **/
			case 5 :
			{
				this.mActiveCommand = PBXOutbound.addCommand( new QueryDeviceInfo()
					.setAffectedExt( 1876 ) );
				this.mComplete = true;
				break;
			}
			/** MOCK **/
		}

		this.mStage++;
		
		return true;
	}
}
