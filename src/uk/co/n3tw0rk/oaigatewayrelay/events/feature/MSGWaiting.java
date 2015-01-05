package uk.co.n3tw0rk.oaigatewayrelay.events.feature;

/**
 * 
 * @author M00SEMARKTWO

MSG WAITING – MW
USE: Occurs when a new message has been left or a message has been canceled at a station. The
<Mailbox> parameter applies only to voice mail devices leaving/canceling messages. It is possible
to have multiple voice mailboxes use the same device for notification (i.e., multiple mailboxes
can light the message lamp at the same station).
MONITOR TYPE: Device
SYNTAX: MW,<Resync_Code>,<Mon_Cross_Ref_ID>,<Device_Receiving_Message>,
<Device_Leaving_Message>,<Mailbox>,<Number_Of_Messages>,
<On/Off><CR><LF>
Where:
• Device_Receiving_Message: Identifies the extension number of the device whose message
waiting indication has changed.
• Device_Leaving_Message: Indicates the extension number of the device that left the
message.
• Mailbox: Identifies the mailbox where the message was left if voice mail was used.
• Number_Of_Messages: Indicates the number of messages left by the
<Device_Leaving_Message>. If blank, the Message Waiting indication is disabled.
• On/Off: Indicates the state of the message waiting indication (1 = Enabled; 0 = Disabled).
EXAMPLES: Extension 106 leaves a message at extension 105.
001,MW,,<MON105>,105,106,,1,1
Extension 106 cancels a message at extension 105.
001,MW,,<MON105>,105,106,,,0

 */
public class MSGWaiting {

}
