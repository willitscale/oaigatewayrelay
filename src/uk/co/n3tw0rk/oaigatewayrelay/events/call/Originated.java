package uk.co.n3tw0rk.oaigatewayrelay.events.call;

/**
 * 
 * 
 * @author M00SEMARKTWO

ORIGINATED – OR
USE: Informs the application that the phone system is attempting to establish a call as a result of a
manual attempt or a completed request from the application. The application should check for
additional events to determine the status of the call as it proceeds either through the phone system
or out to a public network. This event is not sent when the device initiates a feature.
MONITOR TYPE: Device, Call, Call via Device
SYNTAX: OR,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,
<Internal_Calling_Ext>,<Outside_Caller_Number>,<Calling_Device_Type>,
<Dialed_Number>,<Account_Code>,<Local_Cnx_State>,<Event_Cause><CR><LF>
Where:
• Internal_Calling_Ext: Identifies the extension of the internal originator of the call. For
internal calls and outgoing CO calls, this is the calling party’s extension. For incoming
CO calls, this is the trunk extension.
• Outside_Caller_Number: Identifies the outside caller’s Caller ID/ANI number for
incoming CO calls. This can be added/modified with the Modify Call (_MD) command
but cannot be deleted. This field is always blank for IC calls.
• Calling_Device_Type: Indicates the type of the calling device (I = Internal Party; E =
External Party).
• Dialed_Number: Identifies the number dialed to make the call (internal or external). For
incoming CO calls, this is either the DNIS information or the internal extension number
where the call is routed. For manual outgoing CO calls, this field is only the trunk
access code, unless a speed-dial key or the Make Call (_MC) command was used to
make the call, because the dialed digits are not collected before the call connects to the
trunk.
• Account Code: Indicates the account code used to make the call. This field is blank for
IC calls and CO calls that did not use an account code.
EXAMPLES: Extension 100 calls extension 101.
001,OR,,<MON100>,744,100,,I,101,,C,22
002,DE,,<MON101>,744,101,,I,100,,,,,I,101,,,A,22
003,DE,,<MON100>,744,101,,I,100,,,,,I,101,,,C,22
Extension 100 makes an outgoing CO call to 9619000 using speed dial or the Make Call
command.
001,OR,,<MON100>,744,100,,I,9619000,,C,22
Extension 100 makes a manual outgoing CO call to 9619000 using ARS (92000).
001,OR,,<MON100>,744,100,,I,92000,C,22
Incoming CO call from 602-555-1212 to 800-222-5555 rings directly to extension 105.
001,OR,,<MON97061>,744,97061,6025551212,E,8002225555,,C,22
002,DE,,<MON105>,744,105,,I,97061,,6025551212,,8002225555,E,105,,,
A,22
003,DE,,<MON97061>,744,105,,I,97061,,6025551212,,8002225555,E,105,,,
C,22
Incoming CO call on trunk 97061 without any DNIS or ANI information is ringing extension
101 directly.
001,OR,,<MON97061>,744,97061,,E,101,,C,22
002,DE,,<MON101>,744,101,,I,97061,,,,,E,101,,,A,22
003,DE,,<MON97061>,744,101,,I,97061,,,,,E,101,,,C,22
Extension 100 makes an outgoing call to 9619000 using the Make Call command with an
account code of 1234.
001,OR,,<MON100>,744,100,,I,9619000,1234,C,22

 */

public class Originated {

}
