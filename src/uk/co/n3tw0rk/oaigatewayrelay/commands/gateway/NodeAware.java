package uk.co.n3tw0rk.oaigatewayrelay.commands.gateway;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.commands.Command;

/**
 * <strong>Node Aware Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 04-01-2015
 *
 *	NODE AWARE – _NA
 *
 *	USE: 
 *		Sent by the application to inform the Gateway that it wants to operate in a node aware state.
 *		The node aware state also changes the way the Gateway returns the No Operation (_NO)
 *		confirmation (see page 139) and the Link Status (LS) event (see page 81).
 *	
 *	NOTE: 
 *		When sent to the CT Gateway, this command indicates that the command-issuing
 *		application is capable of handling the failure of any single node in the system. It also means that
 *		the application will be responsible for the recovery of the node when the node successfully reestablishes
 *		a connection. In the course of recovery, the application should initialize only the
 *		node that failed. If the application does not use this command, it places additional stress on the
 *		non-failing nodes.
 *
 *	ALSO: 
 *		In a CT Gateway configuration, every application will try to recover the failed node, and,
 *		in the case of non-node aware applications, all other nodes as well. During this recovery, it is
 *		best that a node-aware application not affect the non-failed nodes as it could adversely affect
 *		the performance of other node-aware applications on the CT Gateway.
 *
 *	SYNTAX: 
 *		_NA,<InvokeID>,<Setting><CR>
 *
 *	Where <Setting> is either “0” for deactivate or “1” for activate.
 *
 *	CONFIRMATION: 
 *		<Sequence_Number>,CF,_NA,<InvokeID>,<Outcome>,<Setting><CR><LF>
 *
 *	Where:
 *		• Outcome: Indicates the setting has been changed to the specified value, if “0.” If the
 *		Outcome is not “0,” the <Setting> field is not returned.
 *		• Setting: Indicates the Gateway is doing Node Aware processing (1) or normal processing
 *		(0). This field is returned only with a successful command response.
 *
 *	SPECIAL CASE
 *	
 *	PROCESSING:
 *		The following special cases exist for processing the _NA command, which deal with the interaction
 *		of the Node Aware command during a time when a switch node loses connectivity
 *		with the Gateway.
 *
 *		• Case 1: The Application is not node aware when a connection to a node is lost. Normally,
 *		the Gateway would stop communicating with the application at this point. However,
 *		the application can issue a Node Aware command and attempt to activate node
 *		awareness. If this is done, the application can communicate and interact with the nodes
 *		that are still connected with the Gateway. Commands to non-communicating nodes will
 *		result in failure outcomes as the extensions specified are no longer known in the Gateway
 *		Database.
 *
 *		• Case 2: The Application is node aware when a connection to a phone system node is
 *		lost. If the Application attempts to change the Node Aware setting to inactive, the Gateway
 *		will deny this request (the outcome reflects the network problem). 
 */
public class NodeAware extends Command
{
	/** Command */
	public static final String COMMAND = "_NA";

	/** Setting Value */
	protected int mSetting = 0;

	/**
	 * <strong>Set Setting Method</strong>
	 * 
	 * @param setting
	 * @return NodeAware
	 */
	public NodeAware setSetting( int setting )
	{
		this.mSetting = setting;
		return this;
	}

	/**
	 * <strong>Get Setting Method</strong>
	 * 
	 * @return int
	 */
	public int getSetting()
	{
		return this.mSetting;
	}

	/**
	 * <strong>Build Command Method</strong>
	 * 
	 * @return String
	 */
	@Override
	public String buildCommand()
	{
		return COMMAND + "," + this.getInvokeID() + "," + this.getSetting();
	}

	@Override
	public void confirmation()
	{
	}
}
