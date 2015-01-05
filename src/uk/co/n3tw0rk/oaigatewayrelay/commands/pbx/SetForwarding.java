package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

SET FORWARDING – _SF
USE: Sets the forwarding feature ON or OFF at the <Affected_Ext>. The Extension Feature
(_EF) command can also be used to perform this function (see page 120).
PREMIUM FEATURE: Third-Party Call Control
SYNTAX
(V < 03.10):
_SF,<InvokeID>,<Affected_Ext>,<Forward_Type>,
<Forward_Destination><CR>
SYNTAX
(V >= 03.10):
_SF,<InvokeID>,<Affected_Ext>,<Forward_Type>,
<Forward_Destination>,<On/Off><CR>
Where:
• Affected_Ext: Indicates a keyset or single-line set.
• Forward_Type: Specifies the forward type desired (see Table 6 on page 15). In protocol
versions prior to 03.10, all forward types are enabled on the station device. No Forward
cancels any active manual forward at the station.
• Forward_Destination: Identifies the destination device for the forward and consists of a
string of 1-24 characters. If forwarding to an outside number, the trunk access code
must precede the outside number. This field is a digit string may include the following:
VALUE INDICATION
0-9, *, # Keypad Digits
P Pause
F Hookflash
! (Exclamation) SPCL Key
- (Hyphen) Ignored
( ) (Parentheses) Ignored
; (Semicolon) Ignored
Space Ignored
• On/Off: Turns ON or OFF the specified forward type (0 = Disable; 1 = Enable). If the
<Forward_Type> is None, this is ignored and any enabled manual forward on the station
is disabled. The default is Enable (1).
CONFIRMATION: <Sequence_Number>,CF,_SF,<InvokeID>,<Outcome><CR><LF>
COMMON FAILURE
OUTCOME VALUES:
Generic_Unspecified (1): The <Forward_Type> or <On/Off> parameter is blank, invalid, or
contains an invalid character.
Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
Invalid_Forwarding_Destination (11): The <Forward_Destination> parameter is invalid.
Value_Out_Of_Range (31): The <On/Off> parameter is not 0 or 1.
DESKTOP OAI: None
EXAMPLES: Forward-no-answer extension 100 to extension 101.
_SF,<InvokeID>,100,NA,101
001,CF,_SF,<InvokeID>,0
Extension 100 disables forwarding.
_SF,<InvokeID>,100,N
001,CF,_SF,<InvokeID>,0
Extension 100 forward-no-answers to 961-9000.
_SF,<InvokeID>,100,NA,92019619000
001,CF,_SF,<InvokeID>,0
 */
public class SetForwarding {

}
