package uk.co.n3tw0rk.oaigatewayrelay.events.call;

/**
 * 
 * @author M00SEMARKTWO

RETRIEVED – RE
USE: Occurs when a call that was held on a device is now being re-established at that device (i.e.,
the call is connected – in a talking state – again).
MONITOR TYPE: Device, Call, Call via Device
SYNTAX
(V >= 02.20):
RE,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,<Retrieving_Ext>,
<Local_Cnx_State>,<Event_Cause>,<Internal_Retrieved_Ext>,
<Retrieved_Device_Outside_Number>,<Retrieved_Device_Trunk_Number>,
<Retrieved_Device_Type><CR><LF>
Where:
• Retrieving_Ext: Identifies the device that retrieved the call from hold.
• Internal_Retrieved_Ext: Identifies the internal extension of the device that was on hold
at <Retrieving_Ext>. This field may be blank if the retrieved call is a conference call.
• Retrieved_Device_Outside_Number: Indicates the outside caller’s Caller ID/ANI number
for an incoming CO call, if available. This can be added/modified with the Modify
Call (_MD) command but cannot be deleted. This field is always blank for IC
calls.
• Retrieved_Device_Trunk_Number: Identifies the outside number of the trunk used for
the call (e.g., the number received in DNIS or DID information). This information can
be added/modified with the Modify Call (_MD) command but cannot be deleted.
This field is always blank for IC calls.
• Retrieved_Device_Type: Indicates the type of device that is retrieving the call on hold (I
= Internal Party; E = External Party).
EXAMPLES: Extension 105 calls extension 101.
001,OR,,<MON105>,0014,105,,I,101,,C,22
002,DE,,<MON101>,0014,101,,I,105,,,,,I,101,,,A,22
003,DE,,<MON105>,0014,101,,I,105,,,,,I,101,,,C,22
Extension 101 answers, and extension 105 puts the call on hold.
004,ES,,<MON105>,0014,101,,I,105,,,I,101,,C,35
005,ES,,<MON101>,0014,101,,I,105,,,I,101,,C,35
006,HE,,<MON101>,0014,105,C,22
007,HE,,<MON105>,0014,105,H,22
Extension 105 retrieves the call from hold.
008,RE,,<MON101>,0014,105,C,35,101,,,I
009,RE,,<MON105>,0014,105,C,35,101,,,I
 */
public class Retrieved {

}
