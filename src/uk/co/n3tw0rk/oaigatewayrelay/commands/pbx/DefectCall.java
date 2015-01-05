package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

DEFLECT CALL – _DF
USE: Deflects a call that is presently alerting the <Affected_Ext>, moving the call to another
device or outside phone. This is useful when sending a call to voice mail or another person if
the current destination is too busy to take the call. If this command is successful, the
Diverted event is sent (see page 32), if monitoring is enabled.
NOTE: If the <Affected_Ext> is a hunt group, the deflected call is like a new call rather than a
forwarded call because it gets translated into a Move Call command (see page 137).
PREMIUM FEATURE: Third-Party Call Control
SYNTAX
(V < 07.00):
_DF,<InvokeID>,<Affected_Ext>,<Call_ID>,<Destination_Dev>,
<Mailbox_Number><CR>
SYNTAX
(07.00 <= V <
08.10):
_DF,<InvokeID>,<Affected_Ext>,<Call_ID>,<Destination_Dev>,
<Mailbox_Number>,<Station_For_Toll_Restrict>,<CR>
SYNTAX
(08.10 <= V >=
09.00):
_DF,<InvokeID>,<Affected_Ext>,<Call_ID>,<Destination_Dev>,
<Mailbox_Number>,<Station_For_Toll_Restrict>,<Override_DND><CR>
SYNTAX
(V >= 09.00):
_DF,<InvokeID>,<Affected_Ext>,<Call_ID>,<Destination_Dev>,
<Mailbox_Number>,<Station_For_Toll_Restrict>,<Override_DND>,
<Account_Code><CR>
Where:
• Affected_Ext: Indicates a keyset, single-line set, modem (Axxess only), trunk, or hunt
group.
• Destination_Dev: Identifies the device that will receive the call. This field is a digit
string, which may be up to 48 digits including the following:

VALUE INDICATION
0-9, *, # Keypad Digits
P Pause
F Hookflash
! (Exclamation) SPCL Key
- (Hyphen) Ignored
( ) (Parentheses) Ignored
; (Semicolon) Ignored
Space Ignored

NOTE: If the application wants to dial an outside number, it must specify a trunk
access code followed by the outside number to dial. If an account code is required, you
cannot use this command.
• Mailbox_Number: (Optional) Identifies the mailbox device that <Destination_Dev>
should use if its device supports mailboxes.
• Station_For_Toll_Restrict: (Optional) Indicates the station extension (keyset or singleline)
to use for toll restrictions, if other than <Affected_Ext>. Some feature codes and
extensions resolve to different devices depending on which device dials the number.
The station extension specified in this field is used when determining if the call should
be routed to a specified destination. This station extension is also the device used to
resolve the digit string in <Destination_Dev> to an actual destination. For example, a
call from a trunk is deflected to an operator or attendant station by dialing the digit 0.
NOTE: The <Station_For_Toll_Restrict> field is required for deflecting calls from a hunt
group or trunk to an outside number or operator/attendant station.
ALSO: If the <Affected_Ext> is a trunk device, the <Station_For_Toll_Restrict> field is
required when the< Destination_Dev> field involves a feature code.
• Override_DND: (Optional) Indicates whether or not the call should override DND if
the <Affected_Ext> is in DND (0 = Do NOT Override; 1 = Override). If blank, the
default value of Do NOT Override (0) is used.
NOTE: Calls deflected to a device that has handsfree enabled and is in DND do not
come in handsfree. This is the same way that DND override works when requested via
a feature code.
• Account_Code: Is used as if it had been entered by either the Affected Extension or the
Toll Restrict ID for diverting the call to the public network.
NOTE: The call may still be restricted if the account code supplied is determined to
be not valid and the ID associated with the call diversion has forced account codes
enabled and validation required.
CONFIRMATION: <Sequence_Number>,CF,_DF,<InvokeID>,<Outcome><CR><LF>
COMMON FAILURE
OUTCOME VALUES:
Generic_Unspecified (1): The <Mailbox_Number> parameter is specified but invalid.
Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command.
Invalid_Call_Identifier (8): The <Call_ID> parameter is blank or invalid.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
Invalid_Destination (11): The <Destination_Dev> parameter is blank or invalid.
Generic_State_Incompatibility (15): The specified call is not present at <Affected_Ext> or is
not in a ringing state.
Value_Out_of_Range (31): The value entered for a field is not in the valid range. For example,
the <Override_DND> value specified is neither “0” nor “1.”
Invalid_Call_Identifier_ID_Changed (51): The <Call_ID> value has changed because the
call was transferred before the command could be executed.
DESKTOP OAI: _V
EXAMPLES: Deflect call @003 from extension 111 to extension 100.
_DF, <InvokeID>,111,@003,100,
001,CF,_DF,<InvokeID>,0
Deflect call @005 from extension 111 to an outside number.
_DF,<InvokeID>,111,@005,99619000,
001,CF,_DF,<InvokeID>,0
Deflect call @003 from extension 111 to extension 100. Override DND.
_DF, <InvokeID>,111,@003,100,,1
001,CF,_DF,<InvokeID>,0
Deflect call @003 from trunk 94100 to extension 100
_DF, <InvokeID>,94100,@003,100,,111
001,CF,_DF,<InvokeID>,0
Deflect call @005 from extension trunk 94100 to an outside number. Use toll restrict ID of
111.
_DF,<InvokeID>,94100,@005,899619000,,111
001,CF,_DF,<InvokeID>,0
Deflect call @003 from extension 94100 to extension 100. Override DND.
_DF, <InvokeID>,94100,@003,100,,1
001,CF,_DF,<InvokeID>,0
 */
public class DefectCall {

}
