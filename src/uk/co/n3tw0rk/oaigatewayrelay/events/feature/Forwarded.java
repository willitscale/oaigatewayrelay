package uk.co.n3tw0rk.oaigatewayrelay.events.feature;

/**
 * 
 * @author M00SEMARKTWO

FORWARDED – FW
USE: Occurs when a station enables or disables manual call forwarding. This does not include system
forwards.
MONITOR TYPE: Device
SYNTAX: FW,<Resync_Code>,<Mon_Cross_Ref_ID>,<Forwarding_Ext>,
<Destination_Ext>,<Outside_Number>,<Forward_Type><CR><LF>
Where:
• Forwarding_Ext: Identifies the extension number of the device that changed its manual
forwarding type.
• Destination_Ext: Indicates the new manual forward’s internal destination. For a manual
forward to the public network, this is the extension number of the trunk access code
used (i.e., ARS, the trunk, or trunk group extension). This field is blank when this event
indicates that manual forwarding is disabled.
• Outside_Number: Identifies the outside number if manually forwarding to the public
network; otherwise, this is blank.
• Forward_Type: Indicates the type of manual forward being enabled (see page 15).
EXAMPLES: Extension 106 forwards all calls to extension 200.
001,FW,,<MON106>,106,200,,I
Extension 106 turns off forwarding.
001,FW,,<MON106>,106,,,N
Extension 106 forwards if-busy to trunk 97061, phone number 961-9000.
001,FW,,<MON106>,106,97061,9619000,B

 */
public class Forwarded {

}
