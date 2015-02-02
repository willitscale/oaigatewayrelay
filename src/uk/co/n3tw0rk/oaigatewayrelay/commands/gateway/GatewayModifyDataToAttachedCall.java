package uk.co.n3tw0rk.oaigatewayrelay.commands.gateway;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.commands.Command;

/**
 * 
 * @author M00SEMARKTWO

GATEWAY MODIFY DATA TO ATTACHED CALL – _GMD
NOTE: This command is available only in CT Gateway version 4.2xx and later.
USE: Modifies the associated block of data for a call. It requires that the application provide the Call
ID for the call and the tag associated with the data.
SYNTAX: _GMD,<InvokeID>,<CallID>,<Tag>,<Byte_Count>,<Attachment_Data>
Where:
• CallID: Indicates the Call ID for the call.
NOTE: The retriever of the data is not required to have a call monitor for the call.
However, the application that attached the data should not terminate the call monitor
when it attaches data to it.
• Tag: Specifies the required tag associated with the data for the call.
• Byte_Count: Specifies the number of bytes to attach. Valid values are 1 - 256.
• Attachment_Data: -Specifies the data that the application wants to attach to the call.
NOTE: Using a Modify command will change the date and time of the data attachment.
CONFIRMATION: CF,_GMD,<InvokeID>,<Return_Code>,<CallID>,<Tag>,<Date>,<Time>
Where:
• Date: Indicates the date (MMDDYY) when data was attached to the call.
• Time: Indicates the time (HHMMSSTTT) when the data was attached to the call where :
HH can range from 01-24,
MM can range from 00-59,
SS can range from 00-59, and
TTT can range from 000-999
COMMON FAILURE
OUTCOME VALUES: Invalid_Call_Identifier (8): The <Call_ID> parameter is blank or invalid.
Generic_System_Resource_Availability (22): There is insufficient memory to modify the
attachment.
NOTE: If there is an error due to insufficient memory, the original attachment that was being
replaced will be deleted as it was in he middle of being replaced.
Value_Out_Of_Range (31): The supplied tag does not correspond to any data attached to the
call.
Invalid_Message_Length (44): The byte count is > 256. The Gateway uses the byte count to
count the number of bytes in the data to be saved. This byte count is compared to the data in
the command packet received via IP for correctness. If the byte count is incorrect the CT Gateway
returns an error. 

 */

public class GatewayModifyDataToAttachedCall extends Command
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