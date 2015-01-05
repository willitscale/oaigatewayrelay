package uk.co.n3tw0rk.oaigatewayrelay.events.call;

/**
 * 
 * 
 * @author M00SEMARKTWO

DIVERTED – DI
USE: Occurs when the system delivers or attempts to deliver a call to a device that redirects the call
to another device. The call may be redirected immediately (e.g., immediate forward) or after it
has already rung at the redirecting device (e.g., delayed manual forward, transfer recall, etc.).
MONITOR TYPE: Device, Call, Call via Device
SYNTAX: DI,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,<Diverted_From_Ext>,
<New_Dest_Ext>,<Diverted_To_Outside_Number>,<Local_Cnx_State>,
<Event_Cause><CR><LF>
Where:
• Diverted_From_Ext: Identifies the extension number of the station ringing before the
call was diverted.
• New_Dest_Ext: Indicates the extension number of the call’s new destination (i.e., where
the call rings after being diverted). If the call is diverted to a public network, this is the
extension number of the trunk.
• Diverted_To_Outside_Number: Indicates the outside number if the call was diverted to
the public network.
EXAMPLES: Extension 100 calls extension 101, and extension 101 forwards-no-answer to extension 102.
001,OR,,<MON100>,97032,100,,I,101,C,22
002,DE,,<MON101>,97032,101,,I,100,,,,,I,101,,,A,22
003,DE,,<MON100>,97032,101,,I,100,,,,,,I,101,,,C,22
004,DI,,<MON101>,97032,101,102,,N,08
005,DI,,<MON100>,97032,101,102,,C,08
006,DE,,<MON102>,97032,102,,I,100,,,,,I,101,101,,A,09
007,DE,,<MON100>,97032,102,,I,100,,,,,I,101,101,,C,09
Extension 100 calls extension 101, and extension 101 forwards immediately to extension 102.
001,DI,,<MON101>,97032,101,102,,N,09
002,DI,,<MON101>,97032,101,102,,C,09
003,DE,,<MON102>,97032,102,,I,100,,,,,I,101,101,,A,09
004,DE,,<MON100>,97032,102,,I,100,,,,,I,101,101,,C,09
Extension 100 calls extension 101, and extension 102 reverse transfers the call from extension
101.
001,OR,,<MON100>,97032,100,,I,101,C,22
002,DE,,<MON101>,97032,101,,I,100,,,,,I,101,,,A,22
003,DE,,<MON100>,97032,101,,I,100,,,,,,I,101,,,C,22
004,DI,,<MON101>,97032,101,102,,N,11
005,DI,,<MON100>,97032,101,102,,C,11
006,DI,,<MON102>,97032,101,102,,C,11
007,ES,,<MON100>,97032,102,,I,100,,,I,101,,C,35
008,ES,,<MON102>,97032,102,,I,100,,,I,101,,C,35

 */

public class Diverted {

}
