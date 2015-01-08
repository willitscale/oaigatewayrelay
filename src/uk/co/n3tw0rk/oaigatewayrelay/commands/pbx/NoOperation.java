package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Command;

/**
 * <strong>No Operation Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 28-12-2014
 *
 * 	NO OPERATION – _NO
 * 	USE: 
 * 		Allows the attached computer to verify that the System OAI link and system are operational.
 * 		The phone system simply replies back without performing any operation.
 * 	
 * 	NOTE: 
 * 		This command does not require the <Affected_Ext> parameter because it does not
 * 		apply to a specific extension on the system.
 * 
 * PREMIUM FEATURE: 
 * 		System OAI Events or Third-Party Call Control
 * 
 *	SYNTAX: 
 *		_NO,<InvokeID><CR>
 *
 *	CONFIRMATION: 
 *		<Sequence_Number>,CF,_NO,<InvokeID>,<Outcome>[,<NumNodes>,<NodeData1>,...,<NodeDataN>]<CR><LF>
 * 
 * 	Where <Node Data> includes the following:
 * 		• Node Number: Indicates the number of the node configured for the Gateway.
 * 		• Node Status: Indicates if the node responded (1) or did not respond (0) to the _NO command.
 * 
 * NOTE: 
 * 		The information in brackets is returned only if the Gateway is node aware (see
 *		page 211 for details). The brackets, however, are not returned (i.e., they are not included in the
 *		response).
 *
 *	DESKTOP OAI: 
 *		AT
 *
 *	EXAMPLES: 
 *		A _NO command is sent in a single node scenario or to a Gateway that is not node aware.
 *		_NO,<InvokeID>
 *		001,CF,_NO,<InvokeID>,0
 *		A _NO command is sent to a Gateway connected to three nodes when node aware. The
 *		confirmation indicates nodes 1 and 2 confirmed the _NO command, but node 3 failed to issue
 *		a confirmation.
 *		_NO,<InvokeID>
 *		001,CF,_NO,<InvokeID>,0,3,1,1,2,1,3,0
 */
public class NoOperation extends Command
{
	public static final String COMMAND = "_NO";

	@Override
	public String buildCommand()
	{
		return COMMAND + "," + this.getInvokeID();
	}

	@Override
	public void confirmation()
	{
	}
}
