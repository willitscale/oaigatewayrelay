package uk.co.n3tw0rk.oaigatewayrelay.commands.gateway;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.commands.Command;

/**
 * 
 * @author M00SEMARKTWO

GATEWAY RETRIEVE DATA TO ATTACHED CALL – _GRD
NOTE: This command is available only in CT Gateway version 4.2xx and later.
USE: Obtains the associated block of data for a call. The application must provide the Call ID for the
call and the tag associated with the data.
SYNTAX: _GRD,<InvokeID>,<CallID>,<Tag>
Where:
• CallID: Indicates a Call ID for the call.
• Tag: Specifies the tag associated with the data. When data is retrieved the tag is
required.
CONFIRMATION: CF,_GRD,<InvokeID>,<Return_Code>,<CallID>,<Tag>,<Date>,<Time>,
<Byte_Count>,<Attachment_Data>
Where:
• Date: Indicates the date when the data was attached to the call. Format is MMDDYY.
• Time: Indicates the time when the data was attached to the call. Format is HHMMSS
where HH can range from 01-24.
• Byte_Count: Specifies the number of bytes in the attached data.
• Attachment_Data: Specifies the data attached to the call by an application associated
with the tag.
COMMON FAILURE
OUTCOME VALUES: Invalid_Call_Identifier (8): The <Call_ID> parameter is blank or invalid.
Generic_System_Resource_Availability (22): The Tag supplied is in valid format and the
Call_ID is found, but the tag does not correspond to any data for the call.
Value_Out_Of_Range (31): The tag is blank or greater than 32 characters.

 */

public class GatewayRetrieveDataToAttachedCall extends Command
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