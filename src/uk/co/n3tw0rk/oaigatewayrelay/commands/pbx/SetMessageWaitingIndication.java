package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

SET MESSAGE WAITING INDICATION – _SM
USE: Sets the message waiting indication ON or OFF for the <Affected_Ext>. The Extension Feature
(_EF) command can also be used to perform this function (see page 120). The _SM command
can delete any or all of the station’s messages.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _SM,<InvokeID>,<Affected_Ext>,<On/Off>,
<Device_Leaving_Message>,<Number_Of_Msgs>,<Mailbox_Number><CR>
Where:
• Affected_Ext: Indicates a keyset or single-line set.
• On/Off: Turns ON or OFF the message indicator at the <Affected_Extension> (0 = Off;
1 = On).
• Device_Leaving_Message: Specifies the extension of the device leaving the message.
This must be a valid extension if the <On/Off> field is set to On. If the <On/Off> field
is set to Off and the <Device_Leaving_Message> field is left blank, all messages at the
<Affected_Extension> are deleted.
NOTE: Prior to V07.00, a separate _SM command was required to delete each message
from a station if the messages originated from different extensions. As of V07.00,
all messages can be deleted, regardless of the originating extension, if the <On/Off>
field is set to Off and the <Device_Leaving_Message> field is left blank.
• Number_of_Msgs: Specifies a decimal value in the range 1-999 that indicates the number
of messages <Device_Leaving_Message> is leaving. The default value is “1” if the
command is turning on the message indication.
• Mailbox_Number: (Optional) Identifies the specific mailbox where the messages are
located, if using a voice mail application.
CONFIRMATION: <Sequence_Number>,CF,_SM,<InvokeID>,<Outcome><CR><LF>
COMMON FAILURE
OUTCOME VALUES:
Generic_Unspecified (1): The <On/Off>, <Number_Of_Msgs>, or <Mailbox_Number> contains
invalid characters.
Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
Generic_State_Incompatibility (15): The <Affected_Ext>’s device type does not support this
command.
DESKTOP OAI: None
EXAMPLES: Leave a message on extension 100 from extension 299.
_SM,<InvokeID>,100,1,299,1,
001,CF,_SM,<InvokeID>,0
EXAMPLES: Delete the messages on extension 1000 that originated from extensions 1001, 1002, and 1003.
_SM,1,1000,0,1001,2,1000
_SM,1,1000,0,1002,2,1000
_SM,1,1000,0,1003,2,1000
Delete all messages (regardless of originating extension) at extension 1000.
_SM,1,1000,0 (Leave <Device_Leaving_Message> parameter blank.)
 */
public class SetMessageWaitingIndication {

}
