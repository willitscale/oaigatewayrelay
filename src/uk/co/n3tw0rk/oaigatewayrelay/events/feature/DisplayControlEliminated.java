package uk.co.n3tw0rk.oaigatewayrelay.events.feature;

/**
 * 
 * @author M00SEMARKTWO

DISPLAY CONTROL ELIMINATED – DCE
NOTE: This event is available only in protocol versions 08.00 and later.
USE: Occurs whenever a station loses Display Control.
MONITOR TYPE: Device
SYNTAX: DCE,<Resync_Code>,<Mon_Cross_Ref_ID>,<Subject_Ext>,<Reason>,
<Display_Control_Type><CR><LF>
Where:
• Subject_Ext: Specifies the device sending the event.
• Reason: Indicates why the device is losing Display Control. Possible values include:
0 = Application stopped control
1 = Call changed state
2 = Switch stopped monitor
3 = Network communication failure
4 = Max allowed features
5 = Feature code used
• Display_Control_Type: Specifies the type of Display Control the application has (1 =
full connected control, which is the only value currently available).
EXAMPLE: Device monitor at 1000 was stopped using the _MP command.
001,DCE,,<MON1000>,1000,0,1

 */
public class DisplayControlEliminated {

}
