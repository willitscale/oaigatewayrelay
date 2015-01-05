package uk.co.n3tw0rk.oaigatewayrelay.events.feature;

/**
 * 
 * @author M00SEMARKTWO

GENERAL INFORMATION – GI
USE: Occurs when a station is on a transfer announcement call and is waiting at voice mail.
MONITOR TYPE: Device
SYNTAX
(V >= 5.15):
GI,<Resync_Code>,<Mon_Cross_Ref_ID>,<Affected_Ext>,<Call_ID>,
<Dest_Extension>,<Reason><CR><LF>
Where:
• Dest_Extension: Identifies the extension number of the device where the
<Affected_Ext> is waiting.
• Reason: Indicates why the event occurred (1 = Prompting for Mailbox; 2 = Waiting to
Complete Transfer).
EXAMPLE: Extension 1000 is waiting to complete a transfer to voice mail.
001,GI,,<MON1000>,1000,4101,2504,2

 */
public class GeneralInformation {

}
