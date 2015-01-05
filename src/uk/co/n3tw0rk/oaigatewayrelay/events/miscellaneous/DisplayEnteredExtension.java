package uk.co.n3tw0rk.oaigatewayrelay.events.miscellaneous;

/**
 * 
 * @author M00SEMARKTWO

DISPLAY ENTERED EXTENSION – DEE
NOTE: This event is available only in protocol versions 08.00 and later.
USE: Occurs whenever an extension is entered as a result of a PROMPT_EXTENSION prompt,
regardless of the validity of the extension.
NOTE: This note is sent only to the node that is controlled by the device state.
MONITOR TYPE: Device
SYNTAX: DEE,<Resync_Code>,<Mon_Cross_Ref_ID>,<Subject_Ext>,
<Display_Control_Type>,<Extension_Entered>,<Extension_Valid><CR><LF>
Where:
• Subject_Ext: Specifies the device sending the event.
• Display_Control_Type: Specifies the type of Display Control the application has (1 =
full connected control, which is the only value currently available).
• Extension_Entered: Specifies the extension entered at the station as a response to the
PROMPT_EXTENSION prompt.
• Extension_Valid: Indicates whether the extension number is valid (1) or invalid (0) in
the phone system.
EXAMPLES: A PROMPT_EXTENSION prompt was issued, and the user entered the valid extension 1100.
001,DEE,,<MON1000>,1000,1,1100,1
A PROMPT_EXTENSION prompt was issued, and the user entered the invalid extension 999.
001,DEE,,<MON1000>,1000,1,999,0
MONITOR ENDED – ME
USE: Occurs when the system can no longer provide the requested events associated with the specified
<Mon_Cross_Ref_ID>. This event is unsolicited.
MONITOR TYPE: Call, Call via Device, Device
SYNTAX: ME,<Resync_Code>,<Mon_Cross_Ref_ID>,<Event_Cause><CR><LF>
EXAMPLE: A monitor session (Cross-Reference ID 1) associated with extension 100 can no longer be
provided because extension 100 becomes unequipped.
001,ME,,001,36

 */
public class DisplayEnteredExtension {

}
