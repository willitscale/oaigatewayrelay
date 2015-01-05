package uk.co.n3tw0rk.oaigatewayrelay.events.system;

/**
 * 
 * @author M00SEMARKTWO

NIGHT MODE STATUS – NM
NOTE: This event is available only in protocol versions 05.10 and later.
USE: Occurs when the system’s night mode status changes.
MONITOR TYPE: System
SYNTAX: NM,<Resync_Code>,<Mon_Cross_Ref_ID>,<Network_Node_Number>,
<On/Off><CR><LF>
Where:
• Network_Node_Number: Indicates the node number of the connected phone system. If
the system is not networked, this will be “1.” When this event is sent to an application
by the CT Gateway, this field specifies the node number of the phone system that originally
generated the event.
• On/Off: Indicates the night mode status of the system (1 = Enabled; 0 = Disabled).
EXAMPLE: The night mode for the system has just been enabled.
001,NM,,<Mon_Cross_Ref_ID>,1,1

 */
public class NightModeStatus {

}
