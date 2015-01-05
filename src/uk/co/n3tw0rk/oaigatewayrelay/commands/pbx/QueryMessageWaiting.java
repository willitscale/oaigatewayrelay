package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

QUERY MESSAGE WAITING – _QM
NOTE: This command is available only for protocol versions 03.20 and later.
USE: Queries information about station messages waiting at the specified device.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _QM,<InvokeID>,<Affected_Ext><CR>
Where valid device types for <Affected_Ext> are keysets or single-line sets.
CONFIRMATION: <Sequence_Number>,CF,_QM,<InvokeID>,<Outcome>,<Number_of_Extensions>,
<Extension>,<Description>,<Time>,<Date>,<Mailbox_Number>,
<Number_of_Messages>,.....<CR><LF>
Where:
• Number_of_Extensions: Indicates the number of extension/mailbox combinations that
have left messages, followed by sequences of <Extension>, <Description>, <Date>,
<Time>, <Mailbox_Number>, <Number_of_Messages> for each message. If zero, no
other fields follow. The extension-mailbox combinations are listed in no particular
order.
• Extension: Indicates the extension number of the device leaving the message.
• Description: Identifies the device leaving the message and is a text string containing up
to 20 characters, delimited by vertical slashes (|).
• Time: Contains the time, in 24-hour format (HH:MM), when the message was left. For
voice mail messages, this is the time that voice mail last lit the lamp, not the time the
message was left.
• Date: Contains the date (MMDDYY) that the message was left. For voice mail messages,
this is the date that voice mail last lit the lamp, not the date the message was left.
• Mailbox_Number: Indicates the number of the mailbox that left the message at the
<Affected_Ext>. If the message is not from a mailbox, this field is empty.
• Number_Of_Messages: Indicates the number of messages that the extension/mailbox
combination left at the <Affected_Ext>. This field is always greater than or equal to
one.
COMMON FAILURE
OUTCOME VALUES:
Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
DESKTOP OAI: None
EXAMPLES: Extension 100 has no messages.
_QM,<InvokeID>,100
001,CF,_QM,<InvokeID>,0,0
Extension 100 has two messages: one from extension 101 and one from extension 102.
_QM,<InvokeID>,100
001,CF,_QM,<InvokeID>,0,2,101,|Extension 101|,08:00,010197,,1,
102,|Extension 102|,09:00,022697,,1
Extension 100 has two messages from voice mail. Voice mail's message-notification
application is extension 2501, and the mailbox number is 120.
_QM,<InvokeID>,100
001,CF,_QM,<InvokeID>,0,1,2501,|Voice Mail|,08:00,121296,120,2
Extension 100 has two messages from voice mail and one message from extension 105. Voice
mail's message-notification application is extension 2501, and the mailbox number is 120.
_QM,<InvokeID>,100
001,CF,_QM,<InvokeID>,0,2,2501,|Voice Mail|,10:10,030397,120,
2,105,|Ext 105|,23:59,123196,,1
Extension 100 has two messages from voice mail: one from mailbox 100 and one from
mailbox 200. Voice mail's message-notification application is extension 2501.
_QM,<InvokeID>,100
001,CF,_QM,<InvokeID>,0,2,2501,|Voice Mail|,11:11,010195,100,1,
2501,|Voice Mail|,08:08,080888,200,1

 */
public class QueryMessageWaiting {

}
