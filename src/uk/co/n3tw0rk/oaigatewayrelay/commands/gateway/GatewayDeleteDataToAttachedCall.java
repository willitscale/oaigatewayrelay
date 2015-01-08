package uk.co.n3tw0rk.oaigatewayrelay.commands.gateway;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Command;

/**
 * 
 * @author M00SEMARKTWO

GATEWAY DELETE DATA TO ATTACHED CALL – _GDD
NOTE: This command is available only in CT Gateway version 4.2xx and later.
USE: Deletes the associated block of data for a call. It requires that the application provide the Call
ID for the call and the tag associated with the data.
SYNTAX: _GDD,<InvokeID>,<CallID>,<Tag>
Where:
• CallID: Indicates the Call ID for the call.
• Tag: Specifies the required tag associated with the data for the call. When data is
retrieved, the tag is required.
CONFIRMATION: CF,_GDD,<InvokeID>,<Outcome>,<CallID>,<Tag>
COMMON FAILURE
OUTCOME VALUES:
Invalid_Call_Identifier (8): The <Call_ID> parameter is blank or invalid.
Generic_System_Resource_Availability (22): The tag supplied is in valid format and the Call
ID is valid, but the tag does not correspond to any tags for the call.
Value_Out_Of_Range (31): No tag is supplied or the supplied tag does not correspond to any
data attached to the call.

 */

public class GatewayDeleteDataToAttachedCall extends Command
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