package uk.co.n3tw0rk.oaigatewayrelay.events.call;

/**
 * 
 * @author M00SEMARKTWO

NETWORK REACHED – NT
USE: Occurs when a call reaches a trunk, indicating that further call progress events may not be possible
for this call. Once a call reaches an outgoing trunk, the phone system sends a Network
Reached event which may or may not be followed by Delivered (see page 30) and
Established (see page 33) events.
MONITOR TYPE: Device, Call, Call via Device
SYNTAX: NT,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,<Trunk_Used>,
<Dialed_Number>,<Local_Cnx_State>,<Event_Cause><CR><LF>
Where:
• Trunk_Used: Identifies the extension number of the trunk receiving the call.
• Dialed_Number: Indicates the outside number dialed, if known. A Network Reached
event sent on behalf of a station device will complete this field only when a call is forwarded
or transferred to the public network. When this event gets sent on behalf of the
network device (trunk) or the call itself, this field is complete for these cases (i.e., when
a call is forwarded or transferred to the public network) and for when the call originates
through ARS. If the Make Call (_MC) command (see page 123) is used to make the
call, this field is complete for all parties.
EXAMPLE: Extension 100 dials 961-9000 on trunk 97061, and an outside party answers the call.
001,OR,,<MON100>,123,100,,I,97061,,C,22
002,NT,,<MON100>,123,97061,,C,22
003,NT,,<MON97061>,123,97061,9619000,A,22
004,DE,,<MON97061>,123,97061,9619000,E,100,,,,,I,9619000,,,A,22
005,DE,,<MON100>,123,97061,9619000,E,100,,,,,I,9619000,,,C,22
006,ES,,<MON97061>,123,94161,9619000,E,100,,,I,9619000,,C,35
007,ES,,<MON100>,123,94161,9619000,E,100,,,I,9619000,,C,35

 */

public class NetworkReached {

}
