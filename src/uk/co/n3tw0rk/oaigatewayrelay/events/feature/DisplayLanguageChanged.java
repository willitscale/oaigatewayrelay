package uk.co.n3tw0rk.oaigatewayrelay.events.feature;

/**
 * 
 * @author M00SEMARKTWO

DISPLAY LANGUAGE CHANGED – DLC
NOTE: This event is available only in protocol versions 08.00 and later.
USE: Occurs whenever the language on a station changes. The station language can be changed in
Database Programming, or the user can enter the Change Language feature code (default is
301) at the station.
MONITOR TYPE: Device
SYNTAX: DLC,<Resync_Code>,<Mon_Cross_Ref_ID>,<Subject_Ext>,<New_Language>,
<Previous_Language><CR><LF>
Where:
• Subject_Ext: Specifies the device sending the event.
• New Language: Indicates the new language assigned to the station (0 = Primary; 1 =
Secondary).
• Previous_Language: Indicates the language used at the station before the change (0 =
Primary; 1 = Secondary).
EXAMPLE: Station 1000 changed its language from primary to secondary.
001,DLC,,<MON1000>,1000,1,0

 */
public class DisplayLanguageChanged {

}
