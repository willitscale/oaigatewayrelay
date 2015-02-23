package uk.co.n3tw0rk.oaigatewayrelay.sequences;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.commands.Command;
import uk.co.n3tw0rk.oaigatewayrelay.buffers.PBXOutbound;
import uk.co.n3tw0rk.oaigatewayrelay.commands.gateway.NodeAware;
import uk.co.n3tw0rk.oaigatewayrelay.commands.pbx.MonitorStart;
import uk.co.n3tw0rk.oaigatewayrelay.commands.pbx.QueryAgentState;
import uk.co.n3tw0rk.oaigatewayrelay.commands.pbx.QueryDeviceInfo;
import uk.co.n3tw0rk.oaigatewayrelay.commands.system.Connection;
import uk.co.n3tw0rk.oaigatewayrelay.consts.MonitorTypes;
import uk.co.n3tw0rk.oaigatewayrelay.controllers.SystemController;
import uk.co.n3tw0rk.oaigatewayrelay.data.Devices;
import uk.co.n3tw0rk.oaigatewayrelay.threads.OAIAlive;
import uk.co.n3tw0rk.oaigatewayrelay.utils.Config;

/**
 * <strong>OAI Connect Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 25-01-2015
 *
 */
public class OAIConnect
{
	public static final int STAGE_CONNECT = 0x01;
	public static final int STAGE_NODE_AWARE = 0x02;
	public static final int STAGE_MONITOR_STATIONS = 0x03;
	public static final int STAGE_MONITOR_SYSTEM = 0x04;
	public static final int STAGE_CONNECTED = 0x05;
	
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
	
	public boolean completed()
	{
		return this.mComplete;
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
					.setMonitorType( MonitorTypes.MONITOR_TYPE_ALL_STATIONS )
					.setMonitorOptions( "A:FFFF,C:FFFF,F:FFFF" ) );
				break;
			}

			case STAGE_MONITOR_SYSTEM :
			{
				this.mActiveCommand = PBXOutbound.addCommand( new MonitorStart()
					.setAffectedExt( -1 )
					.setMonitorType( MonitorTypes.MONITOR_TYPE_SYSTEM )
					.setMonitorOptions( "S:FFFF" ) );
				break;
			}

			case STAGE_CONNECTED :
			{
				( new Thread( new OAIAlive() ) ).start();
				this.dataSync();
				this.mComplete = true;
				break;
			}
		}

		this.mStage++;
		
		return true;
	}
	
	public void dataSync()
	{
		Devices devices = SystemController.instance().getDevices();
		
		for( Object key : devices.getKeys() )
		{
			int extension = devices.getStructure( key ).getExtension();

			PBXOutbound.addCommand( new QueryDeviceInfo().setAffectedExt( extension ) );
			PBXOutbound.addCommand( new QueryAgentState().setAffectedExt( extension ) );
		}
	}
}
