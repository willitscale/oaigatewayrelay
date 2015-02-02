package uk.co.n3tw0rk.oaigatewayrelay.commands.gateway;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.commands.Command;

/**
 * 
 * @author M00SEMARKTWO

GATEWAY UTILITY QUERY VERSION – _UQV
USE: Allows applications to identify which version the Gateway is running.
SYNTAX: _UQV,<InvokeID><CR>
CONFIRMATION: <Sequence_Number>,CF,_UQV,<InvokeID>,<Outcome>,
<Version_Number>,<Version_Type>,<Protocol_Version><CR><LF>
Where:
• Version_Number: Indicates the version of the CT Gateway.
• Version_Type: Specifies the development phase of the CT Gateway. Possible values are:
0 = preAlpha
1 = Alpha
2 = Beta
3 = Production
• Protocol_Version: Indicates the version of the OAI protocol. This is in the form of
Vxx.yyzz where xx.yy matches the OAI protocol level for which the CT Gateway was
developed and zz indicates the actual CT Gateway revision of the protocol. There can
be up to 100 Gateway-based protocol revisions (00-99).

 */

public class GatewayUtilityQueryVersion extends Command
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