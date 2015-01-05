package uk.co.n3tw0rk.oaigatewayrelay.commands.gateway;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Command;

/**
 * 
 * 
 * @author M00SEMARKTWO

GATEWAY UTILITY QUERY INFO – _UQI
USE: Returns certain information about either an application or a phone system connection.
SYNTAX: _UQI,<InvokeID>,<Type>,<Item_Number><CR>
Where:
• Type: Indicates if the connection is for a phone system or an application (0 = Phone
System; 1 = Application).
• Item_Number: Specifies the connection number for a phone system connection or the
application number for an application.
CONFIRMATION: For a switch connection:
<Sequence_Number>,CF,_UQI,<InvokeID>,<Outcome>,<Type>,
<Item_Number>,<|User_Description|>,<|Switch_Description|>,
<|Protocol|>,<|KSU_Version|><CR><LF>
For an application connection:
<Sequence_Number>,CF,_UQI,<InvokeID>,<Outcome>,<Type>,
<Item_Number>,<Node_Awareness>,<Expanded_Format>,<Responses_Ordered>,
<Events_Delayed><CR><LF>
Where:
• Type: Indicates if the connection is for a phone system or an application (0 = Phone
System; 1 = Application).
• Item_Number: Specifies the connection number for a phone system connection or the
application number for an application.
• User_Description: Displays the description of the phone system as entered in the CT
Gateway.
• Switch_Description: Displays the description of the phone system as entered in database
programming.
• Protocol: Indicates the protocol version running on the phone system. This is in the format
Vxx.yy where xx is the major version and yy is the revision number.
• KSU_Version: Indicates the software version running on the phone system. This is in
the format Vxx.yy where xx is the major version and yy is the revision number.
• Node_Awareness: Indicates whether or not the application is node aware (0 = Not Node
Aware; 1 = Node Aware).
• Expanded_Format: Indicates whether or not the expanded format is enabled for the
application (0 = Expanded Format Disabled; 1 = Expanded Format Enabled). (See
page 119 for more information on the expanded format.)
• Responses_Ordered: Indicates whether or not the responses that are sent to the application
are in order (0 = Not Ordered; 1 = Ordered).
• Events_Delayed: Indicates whether or not the events received from the application are
being delayed (0 = Not Delayed; 1 = Delayed).
NOTE: If this command fails, the confirmation ends after the <Resync_Code>.

 */
public class GatewayUtilityQueryInfo extends Command
{
	@Override
	public String buildCommand()
	{
		return null;
	}
}