package uk.co.n3tw0rk.oaigatewayrelay.commands.gateway;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.commands.Command;

/**
 * 
 * @author M00SEMARKTWO

GATEWAY UTILITY QUERY STATISTICS – _UQS
USE: Returns certain information about either an application or a phone system connection.
SYNTAX: _UQS,<InvokeID>,<Type>,<Item_Number><CR>
Where:
• Type: Indicates if the connection is for a phone system or an application (0 = Phone
System; 1 = Application).
• Item_Number: Specifies the connection number for a phone system connection or the
application number for an application.
CONFIRMATION: For a switch connection:
<Sequence_Number>,CF,_UQS,<InvokeID>,<Outcome>,<Type>,
<Item_Number>,<Bytes_Sent>,<Bytes_Received>,<Msgs_Sent>,<Msgs_Rcvd>,
<Minor_Alarms>,<Major_Alarms><CR><LF>
For an application connection:
<Sequence_Number>,CF,_UQS,<InvokeID>,<Outcome>,<Type>,
<Item_Number>,<Bytes_Sent>,<Bytes_Received>,<Msgs_Sent>,<Msgs_Rcvd>,
<CR><LF>
Where:
• Type: Indicates if the connection is for a phone system or an application (0 = Phone
System; 1 = Application).
• Item_Number: Specifies the connection number for a phone system connection or the
application number for an application.
• Bytes_Sent: Indicates the total number of bytes the CT Gateway has sent to the application/phone
system.
• Bytes_Received: Indicates the total number of bytes the CT Gateway has received from
the application/phone system.
• Msgs_Sent: Indicates the total number of messages the CT Gateway has sent to the
application/phone system.
• Msgs_Rcvd: Indicates the total number of messages the CT Gateway has received from
the application/phone system.
• Minor_Alarms: Indicates the total number of minor link failures detected on the phone
system connection.
• Major_Alarms: Indicates the total number of major link failures detected on the phone
system connection.
NOTE: If a significant number of minor/major alarms are returned, it may indicate a problem
with the connection between the CT Gateway and the phone system.
ALSO: If this command fails, the confirmation ends after the <Outcome>.

 */

public class GatewayUtilityQueryStatistics extends Command
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