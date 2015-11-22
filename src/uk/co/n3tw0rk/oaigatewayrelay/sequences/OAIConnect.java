package uk.co.n3tw0rk.oaigatewayrelay.sequences;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.commands.Command;
import uk.co.n3tw0rk.oaigatewayrelay.buffers.PBXOutbound;
import uk.co.n3tw0rk.oaigatewayrelay.commands.gateway.NodeAware;
import uk.co.n3tw0rk.oaigatewayrelay.commands.pbx.MonitorStart;
import uk.co.n3tw0rk.oaigatewayrelay.commands.pbx.QueryAgentState;
import uk.co.n3tw0rk.oaigatewayrelay.commands.pbx.QueryDeviceInfo;
import uk.co.n3tw0rk.oaigatewayrelay.commands.pbx.QueryListExtended;
import uk.co.n3tw0rk.oaigatewayrelay.commands.system.Connection;
import uk.co.n3tw0rk.oaigatewayrelay.consts.MonitorTypes;
import uk.co.n3tw0rk.oaigatewayrelay.controllers.SystemController;
import uk.co.n3tw0rk.oaigatewayrelay.data.Devices;
import uk.co.n3tw0rk.oaigatewayrelay.threads.OAIAlive;
import uk.co.n3tw0rk.oaigatewayrelay.utils.Config;
import uk.co.n3tw0rk.oaigatewayrelay.utils.Logger;

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
	public static final int STAGE_QUERY_HUNT_GROUPS = 0x05;
	public static final int STAGE_QUERY_AGENTS = 0x06;
	public static final int STAGE_QUERY_DNDS = 0x07;
	public static final int STAGE_QUERY_FEATURES = 0x08;
	public static final int STAGE_QUERY_TRUNKS = 0x09;
	public static final int STAGE_QUERY_NODES = 0x0A;
	public static final int STAGE_CONNECTED = 0x0B;
	
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

			case STAGE_QUERY_HUNT_GROUPS :
			{
				this.mActiveCommand = PBXOutbound.addCommand( new QueryListExtended()
					.setListType(QueryListExtended.LIST_TYPE_HUNT_GROUP_LIST)
					.setEntityFieldMask(QueryListExtended.MASK_STATION_LIST_USER|
						QueryListExtended.MASK_HUNT_GROUP_LIST_DESC));
				break;
			}

			case STAGE_QUERY_AGENTS :
			{
				this.mActiveCommand = PBXOutbound.addCommand( new QueryListExtended()
					.setListType(QueryListExtended.LIST_TYPE_ACD_AGENT)
					.setEntityFieldMask(QueryListExtended.MASK_ACD_AGENT_DESC));
				break;
			}

			case STAGE_QUERY_DNDS :
			{
				this.mActiveCommand = PBXOutbound.addCommand( new QueryListExtended()
					.setListType(QueryListExtended.LIST_TYPE_DND_LIST)
					.setEntityFieldMask(QueryListExtended.MASK_DND_LIST_MESSAGE));
				break;
			}

			case STAGE_QUERY_FEATURES :
			{
				this.mActiveCommand = PBXOutbound.addCommand( new QueryListExtended()
					.setListType(QueryListExtended.LIST_TYPE_FEATURE_LIST)
					.setEntityFieldMask(QueryListExtended.MASK_FEATURE_LIST_FEAT_NUM |
						QueryListExtended.MASK_FEATURE_LIST_FEAT_NAME |
						QueryListExtended.MASK_FEATURE_LIST_IS_ADMIN |
						QueryListExtended.MASK_FEATURE_LIST_IS_DIR |
						QueryListExtended.MASK_FEATURE_LIST_IS_DIAG |
						QueryListExtended.MASK_FEATURE_LIST_IS_TOGGLE));
				break;
			}

			case STAGE_QUERY_TRUNKS :
			{
				this.mActiveCommand = PBXOutbound.addCommand( new QueryListExtended()
					.setListType(QueryListExtended.LIST_TYPE_TRUNK_LIST)
					.setEntityFieldMask(QueryListExtended.MASK_TRUNK_LIST_USER|
							QueryListExtended.MASK_TRUNK_LIST_DESC|
							QueryListExtended.MASK_TRUNK_LIST_ANS_SUPERVISION));
				break;
			}
			
			case STAGE_QUERY_NODES :
			{
				this.mActiveCommand = PBXOutbound.addCommand( new QueryListExtended()
					.setListType(QueryListExtended.LIST_TYPE_NODE_DATA)
					.setEntityFieldMask(QueryListExtended.MASK_NODE_DATA_DESC |
						QueryListExtended.MASK_NODE_DATA_NET_EN |
						QueryListExtended.MASK_NODE_DATA_PROTOCOL |
						QueryListExtended.MASK_NODE_DATA_KSU_SW |
						QueryListExtended.MASK_NODE_DATA_PREM |
						QueryListExtended.MASK_NODE_DATA_COUNTRY |
						QueryListExtended.MASK_NODE_DATA_TCPIP |
						QueryListExtended.MASK_NODE_DATA_VOICE_MAIL |
						QueryListExtended.MASK_NODE_DATA_MAX_PARTIES));
				break;
			}

			case STAGE_CONNECTED :
			{
				( new Thread( new OAIAlive() ) ).start();
				this.dataInfo();
				this.mComplete = true;
				break;
			}
		}

		this.mStage++;
		
		return true;
	}
	
	public void dataInfo()
	{
		Logger.console( "Devices: " + SystemController.instance().getDevices().size(), Logger.MESSAGE_LEVEL );
		Logger.console( "Hunt Groups: " + SystemController.instance().getHuntGroups().size(), Logger.MESSAGE_LEVEL );
		Logger.console( "Agents: " + SystemController.instance().getAgents().size(), Logger.MESSAGE_LEVEL );
		Logger.console( "Nodes: " + SystemController.instance().getNodes().size(), Logger.MESSAGE_LEVEL );
		Logger.console( "DNDs: " + SystemController.instance().getDNDs().size(), Logger.MESSAGE_LEVEL );
		Logger.console( "Features: " + SystemController.instance().getFeatures().size(), Logger.MESSAGE_LEVEL );
		Logger.console( "Trunks: " + SystemController.instance().getTrunks().size(), Logger.MESSAGE_LEVEL );
		
		//for( Object key : devices.getKeys() )
		//{
			
			//int extension = devices.getStructure( key ).getExtension();

			//PBXOutbound.addCommand( new QueryDeviceInfo().setAffectedExt( extension ) );
			//PBXOutbound.addCommand( new QueryAgentState().setAffectedExt( extension ) );
		//}
	}
}
