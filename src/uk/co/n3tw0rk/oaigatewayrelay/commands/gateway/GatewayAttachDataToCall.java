package uk.co.n3tw0rk.oaigatewayrelay.commands.gateway;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.commands.Command;

/**
 * 
 * @author M00SEMARKTWO

GATEWAY ATTACH DATA TO CALL – _GAD
NOTE: This command is available only in CT Gateway version 4.2xx and later.
USE: Associates a block of data to a call.
NOTE: Attached Data are associated to calls. The data attached to a call persists until either
the call is ended or any application decides to delete the specific attached data item for the call.
ALSO: Multiple attachments can be made to a call. Each attachment must have a unique tag.
It is also possible for an application to attach multiple items to a call as long as each has a
unique tag.
SYNTAX: _GAD,<InvokeID>,<CallID>,<Tag>,<Byte_Count><Attachment_Data>
Where:
• CallID: Indicates a Call ID that is already being monitored. The application must have
received the Monitor Start confirmation before attaching the data.
• Tag: Indicates a tag associated with the data for the call. When data is retrieved, the tag
is required. However, an application is not required to supply the tag; the command
response generates a tag if none is supplied by the application.
A tag can be up to 32 characters and application-supplied tags must begin with a character
A through Z. The command will convert the characters to upper case so a tag of
APP1 is the same as a tag of app1.
• Byte_Count: Indicates the number of bytes to attach. Valid values are 1 - 256.
• Attachment_Data: Indicates the data that the application wants to attach to the call.
CONFIRMATION: CF,_GAD,<InvokeID>,<Outcome>,<CallID>,<Tag>,<Date>,<Time>
Where:
• Tag: Indicates either the user-supplied tag or a Gateway-generated tag. A Gateway-generated
tag is supplied only when the return code is Success (0); otherwise the user-supplied
tag is returned.
• Date: Indicates the date (MMDDYY) when data was attached to the call.
• Time: Indicates the time (HHMMSSTTT) when the data was attached to the call where :
HH can range from 01-24,
MM can range from 00-59,
SS can range from 00-59, and
TTT can range from 000-999
COMMON FAILURE
OUTCOME VALUES:
Invalid_Call_Identifier (8): The <Call_ID> parameter is blank or invalid.
Generic_System_Resource_Availability (22): There is insufficient memory to create the
attachment.
Resource_Busy (24): The tag supplied is in valid format and the CallID is valid, but the tag
already exists for the call.
Value_Out_Of_Range (31): The application supplied a tag value and the tag does not begin
with a character A through Z or the tag is too long.
Invalid_Device_Monitor (50): The application does not have a monitor for the call 
Invalid_Message_Length (44): The byte count is > 256. The Gateway uses the byte count to
count the number of bytes in the data to be saved. This byte count is compared to the data in
the command packet received via IP for correctness. If the byte count is found incorrect the CT
Gateway returns an error. 
 */

public class GatewayAttachDataToCall extends Command
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
