package uk.co.n3tw0rk.oaigatewayrelay.events.miscellaneous;

/**
 * 
 * @author M00SEMARKTWO



DISPLAY STATION CHANGE – DSC
NOTE: This event is available only in protocol versions 08.00 and later.
USE: Returns the input entered at the station over which the application currently has full control.
This is dependent on the station state at any particular time.
NOTE: This event goes only to the node that is in control based on the device state.
MONITOR TYPE: Device
SYNTAX: DSC,<Resync_Code>,<Mon_Cross_Ref_ID>,<Subject_Ext>,
<Display_Control_Type>,<Display_Event_Type>,<Display_Event_Action>,
<Input><CR><LF>
Where:
• Subject_Ext: Specifies the device sending the event.
• Display_Control_Type: Specifies the type of Display Control the application has (1 =
full connected control, which is the only value currently available).
• Display_Event_Type: Specifies the type of display event that was generated. Possible
values include:
0 = Keypad digit
1 = Menu key
2 = Action
• Display_Event_Action: Specifies the action that occurred. This is only returned if
<Display_Event_Type> is Action (2). Possible values include:
0 = Terminate
1 = Cursor Left
2 = Cursor Right
3 = Next
4 = Previous
5 = Clear
6 = Cancel
• Input: Indicates the input generated at the station.
EXAMPLES: The user at station 1000 pressed keypad digit 5.
001,DSC,,<MON1000>,1000,1,0,5
The user at station 1000 pressed menu key 3.
001,DSC,,<MON1000>,1000,1,1,3

 */
public class DisplayStationChange {

}
