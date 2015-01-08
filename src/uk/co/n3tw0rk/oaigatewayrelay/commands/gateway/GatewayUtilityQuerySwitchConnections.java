package uk.co.n3tw0rk.oaigatewayrelay.commands.gateway;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Command;

/**
 * 
 * @author M00SEMARKTWO

GATEWAY UTILITY QUERY SWITCH CONNECTIONS – _UQC
USE: Returns a list of all configured phone system connections.
SYNTAX: _UQC,<InvokeID><CR>
CONFIRMATION: <Sequence_Number>,CF,_UQC,<InvokeID>,<Outcome>,
<Number_Of_Switch_Connections>,<Switch_Data1>,...,
<Switch_DataN><CR><LF>
Where:
• Number_Of_Switch_Connections: Indicates the number of configured connections.
• Switch_Data: Specifies the following comma-separated information:
— Connection_Number: Indicates the internal connection number that the CT Gateway
uses.
— Connected_State: Specifies whether or not the phone system is connected (0 =
Not Connected; 1 = Connected).
— Node_Number: Specifies the node number associated with the connection. If
blank, the phone system is not connected.

 */

public class GatewayUtilityQuerySwitchConnections extends Command
{
	@Override
	public String buildCommand()
	{
		return null;
	}

	@Override
	public void confirmation()
	{
	}
}