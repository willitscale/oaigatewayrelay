package uk.co.n3tw0rk.oaigatewayrelay.events.call;

/**
 * 
 * @author M00SEMARKTWO

ESTABLISHED – ES
USE: Occurs when the <Answering_Internal_Ext> answers or connects to the specified call and the
call is connected (i.e., in a talking state). This event is also generated when a Resync
Request (RR or _RR) is sent specifically to a trunk device that is connected on a call.
MONITOR TYPE: Device, Call, Call via Device
SYNTAX: ES,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,
<Answering_Internal_Ext>,<Answering_Outside_Number>,
<Answering_Device_Type>,<Internal_Calling_Ext>,
<Outside_Caller_Number>,<Trunk_Outside_Number>,<Calling_Device_Type>,
<Originally_Called_Dev>,<Last_Redirection_Ext>,<Local_Cnx_State>,
<Event_Cause><CR><LF>
Where:
• Answering_Internal_Ext: Identifies the internal extension of the device answering (connecting)
the call.
• Answering_Outside_Number: Indicates the dialed digit string for an outgoing CO call;
otherwise, this is blank. This will eventually be the “connected number” parameter
from the ISDN CONNect message for PRI facilities.
• Answering_Device_Type: Indicates the type of the device being alerted (I = Internal
Party; E = External Party).
• Internal_Calling_Ext: Identifies the extension of the internal originator of the call. For
internal calls and outgoing CO calls, this is the calling party’s extension. For incoming
CO calls, this is the trunk extension.
• Outside_Caller_Number: Identifies the Caller ID/ANI number for incoming CO calls.
This can be added/modified with the Modify Call (_MD) command but cannot be
deleted. This field is always blank for IC calls.
• Trunk_Outside_Number: Indicates the DNIS or DID outside number associated with
the trunk used for the call. This can be added/modified with the Modify Call (_MD)
command but cannot be deleted. This field is always blank for IC calls.
• Calling_Device_Type: Indicates the type of calling device (I = Internal Party; E =
External Party).
• Originally_Called_Dev: Indicates the initial call destination if the call has never been
answered. For IC and incoming CO calls, this is the originally dialed extension. For
outgoing CO calls, this is the dialed digit string. The initial transfer destination for a
transferred call and the initial recall destination for a recalling call become the originally
called device.
• Last_Redirection_Ext: Identifies the extension number of the last device that redirected
(forwarded, deflected, transferred, or recalled) the call, if applicable; otherwise, this is
blank.
EXAMPLES: Extension 100 calls extension 101, and extension 101 answers.
001,OR,,<MON100>,245,100,,I,101,,C,22
002,DE,,<MON101>,245,101,,I,100,,,,,I,101,,,A,22
003,DE,,<MON100>,245,101,,I,100,,,,,I,101,,,C,22
004,ES,,<MON100>,245,101,,I,100,,,I,101,,C,35
005,ES,,<MON101>,245,101,,I,100,,,I,101,,C,35
Incoming CO call from 602-555-1212 to 800-222-5555 rings directly to extension 105, and
extension 105 answers the call.
001,OR,,<MON97061>,245,97061,6025551212,E,8002225555,,C,22
002,DE,,<MON105>,245,105,,I,97061,,6025551212,,8002225555,E,105,,,
A,22
003,DE,,<MON97061>,245,105,,I,97061,,6025551212,,8002225555,E,105,,,
C,22
004,ES,,<MON97061>,245,105,,I,97061,6025551212,80022255555,E,105,,
C,35
005,ES,,<MON105>,245,105,,I,97061,6025551212,80022255555,E,105,,C,35
Extension 100 calls extension 101, and extension 102 reverse transfers the call from extension
101.
001,OR,,<MON100>,245,100,,I,101,C,22
002,DE,,<MON101>,245,101,,I,100,,,,,I,101,,,A,22
003,DE,,<MON100>,245,101,,I,100,,,,,,I,101,,,C,22
004,DI,,<MON101>,245,101,102,,N,11
005,DI,,<MON100>,245,101,102,,C,11
006,DI,,<MON102>,245,101,102,,C,11
007,ES,,<MON100>,245,102,,I,100,,,I,101,,C,35
008,ES,,<MON102>,245,102,,I,100,,,I,101,,C,35

 */

public class Established {

}
