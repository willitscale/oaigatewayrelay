package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

CONSULTATION CALL – _CS
USE: Combines the Hold Call (_HC) command (page 121) and the Make Call (_MC) command
(page 123). It places an existing active (connected) call on hold and initiates a new call
from the same device. If the system successfully places the active call on hold but cannot make
the new call, the active call remains on hold.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX
(V <= 08.00):
_CS,<InvokeID>,<Affected_Ext>,<Call_ID>,<Call_Destination>,
<Account_Code><CR>
SYNTAX
(V >= 08.10):
_CS,<InvokeID>,<Affected_Ext>,<Call_ID>,<Call_Destination>,
<Account_Code>,<Override_DND><CR>
Where:
• Affected_Ext: Indicates a keyset (online) or a single-line set (online).
• Call_Destination: Identifies the digit string to be dialed, which can be up to 48 digits
and may include:

VALUE INDICATION
0-9, *, # Keypad Digits
P Pause
F Hookflash
! (Exclamation) SPCL Key
- (Hyphen) Ignored
( ) (Parentheses) Ignored
; (Semicolon) Ignored
Space Ignored

NOTE: If the application wishes to dial an outside number, it must specify a trunk
access code followed by the outside number to dial. An account code cannot be
entered in this field.
• Account_Code: (Optional) Identifies the account code the system should use for this
call. This is ignored if the call is an internal call.
• Override_DND: (Optional) Indicates whether or not the call should override DND if
the <Affected_Ext> is in DND (0 = Do NOT Override; 1 = Override). If blank, the
default value of Do NOT Override (0) is used.
CONFIRMATION: <Sequence_Number>,CF,_CS,<InvokeID>,<Outcome>,<Affected_Ext>,
<Call_ID><CR><LF>

OUTCOME VALUES:
Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command.
Invalid_Called_Device (7): The <Call_Destination> parameter is blank or invalid.
Invalid_Call_Identifier (8): The <Call_ID> parameter is blank or invalid.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
Generic_State_Incompatibility (15): The device specified by <Affected_Ext> is offline.
Value_Out_Of_Range (31): The <Account_Code> parameter is invalid.
Invalid_Connection_ID_For_Active_Call (32): The call specified by <Call_ID> is not active
at the <Affected_Ext>.
Value_Out_of_Range (31): The value entered for a field is not in the valid range. For example,
the <Override_DND> value specified is neither “0” nor “1.”
DESKTOP OAI: None
EXAMPLES: Extension 100 is active on call @001. Cause extension 100 to place @001 on hold and dial
961-9000 using account code 1234.
_CS,<InvokeID>,100,@001,89619000,1234
001,CF,_CS,<InvokeID>,0,@002,100
Extension 100 is active on call @001. Cause extension 100 to place @001 on hold, dial 101
using account code 1234, and override any DND present at 101.
_CS,<InvokeID>,100,@001,101,1234,1
001,CF,_CS,<InvokeID>,0,@002,100
 */
public class ConsultationCall {

}
