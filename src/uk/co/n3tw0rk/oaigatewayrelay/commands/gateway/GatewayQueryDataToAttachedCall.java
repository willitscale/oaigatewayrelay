package uk.co.n3tw0rk.oaigatewayrelay.commands.gateway;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.commands.Command;

/**
 * 
 * @author M00SEMARKTWO
 *
 * GATEWAY QUERY DATA TO ATTACHED CALL – _GQD
 * NOTE: This command is available only in CT Gateway version 4.2xx and later.
 * USE: Allows an application to get all the attached data information related to a particular call.
 * SYNTAX: _GRD,<InvokeID>,<CallID>,<Tag>
 * Where CallID is a Call ID for the call.
 * CONFIRMATION: CF,_GQD,<InvokeID>,<Return_Code>,<Num_Attachments>,<Tag_Item1>,...
 * <Tag_Itemn>
Where:
• Num_Attachments: Indicates the number of tags associated with the call.
• Tag_Item1, ... Tag_Itemn: Are comprised of <Tag>, <Date>,<Time>.
Where:
— Date: Indicates the date (MMDDYY) when data was attached to the call.
— Time: Indicates the time (HHMMSSTTT) when the data was attached to the call
where :
HH can range from 01-24,
MM can range from 00-59,
SS can range from 00-59, and
TTT can range from 000-999
COMMON FAILURE
OUTCOME VALUES:
Success (0): The Call ID is for a known call, but there is not any data attached to the call. The
<Num_Attachments> field will be set to 0.
Invalid_Call_Identifier (8): The <Call_ID> parameter is blank or invalid.

 */
public class GatewayQueryDataToAttachedCall extends Command
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