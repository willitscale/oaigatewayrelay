package uk.co.n3tw0rk.oaigatewayrelay.events.feature;

/**
 * 
 * @author M00SEMARKTWO

DO-NOT-DISTURB – DND
USE: Occurs when a device enables or disables the do-not-disturb (DND) feature. When the
<DND_Message> field is blank, the device is disabling DND.
MONITOR TYPE: Device
SYNTAX: DND,<Resync_Code>,<Mon_Cross_Ref_ID>,<DND_Ext>,<DND_Message>,
<DND_Text><CR><LF>
Where:
• DND_Ext: Identifies the extension number of the device changing its DND status.
• DND_Message: Displays the text string, up to 16 characters, of the system-programmed
DND message.
• DND_Text: Displays the text string, up to 16 characters, of the user-programmable message.
NOTE: Text strings are delimited by vertical slashes (|).
EXAMPLES: Extension 105 goes into DND with a message of “OUT TO LUNCH UNTIL 1 PM.”
001,DND,,<MON105>,105,|OUT TO LUNCH|,|UNTIL 1PM|
Extension 105 returns from lunch and removes his phone from DND.
001,DND,<MON105>,105
Extension 105 goes into DND with “OUT TO LUNCH” (no custom text).
001,DND,<MON105>,105|OUT TO LUNCH|

 */
public class DoNotDisturb {

}
