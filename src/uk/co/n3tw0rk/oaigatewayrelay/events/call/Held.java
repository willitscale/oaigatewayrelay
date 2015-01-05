package uk.co.n3tw0rk.oaigatewayrelay.events.call;

/**
 * 
 * @author M00SEMARKTWO

HELD – HE
USE: Occurs when a call that was established on a device is now on hold at that device or another
device (transfer-to-hold).
MONITOR TYPE: Device, Call, Call via Device
SYNTAX: HE,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,<Activate_Hold_Ext>,
<Local_Cnx_State>,<Event_Cause><CR><LF>
Where:
• Call_ID: Identifies the call being put on hold.
• Activate_Hold_Ext: Identifies the station that placed the call on hold.
EXAMPLES: Extension 100 calls extension 101.
001,OR,,<MON100>,86415,100,,I,101,,C,22
002,DE,,<MON101>,86415,101,,I,100,,,,,I,101,,,A,22
003,DE,,<MON100>,86415,101,,I,100,,,,,I,101,,,C,22
Extension 101 answers, and extension 100 puts the call onto hold.
004,ES,,<MON100>,86415,101,,I,100,,,I,101,,C,35
005,ES,,<MON101>,86415,101,,I,100,,,I,101,,C,35
006,HE,,<MON101>,86415,100,C,42
007,HE,,<MON100>,86415,100,H,42
Or, extension 101 answers, and extension 100 puts the call on transfer-hold.
004,ES,,<MON100>,86415,101,,I,100,,,I,101,,C,35
005,ES,,<MON101>,86415,101,,I,100,,,I,101,,C,35
006,HE,,<MON101>,86415,100,C,38
007,HE,,<MON100>,86415,100,H,38

 */
public class Held {

}
