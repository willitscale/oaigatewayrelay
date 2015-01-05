package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

MOVE CALL – _MO
USE: Moves a call that is presently alerting the <Affected_Ext> to another device or outside phone,
and the call is represented at the destination as a new direct ring-in. This command does not
create a manual forward on the phone system, such as Deflect (_DF on page 105), and cannot
be used to move hunting calls from individual hunt group members. If you want to move a
call ringing at a hunt group, the <Affected_Ext> must specify the hunt group itself. If this command
is sent to a call already ringing in a system forward path, the call gets removed from the
system forward path entirely and moved to the new destination; it will not advance to the next
system forward point.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX
(V < 07.00):
_MO,<InvokeID>,<Affected_Ext>,<Call_ID>,<Destination_Dev>,
<Mailbox_Number><CR>
SYNTAX
(07.00 <= V <
08.10):
_MO,<InvokeID>,<Affected_Ext>,<Call_ID>,<Destination_Dev>,
<Mailbox_Number>,<Station_For_Toll_Restrict><CR>
SYNTAX
(V >= 08.10):
_MO,<InvokeID>,<Affected_Ext>,<Call_ID>,<Destination_Dev>,
<Mailbox_Number>,<Station_For_Toll_Restrict>,<Override_DND><CR>
Where:
• Affected_Ext: Indicates a keyset, single-line set, modem (Axxess only), or hunt group.
• Destination_Dev: Identifies the device that will receive the call. This field is a digit
string, which may be up to 48 digits and may include the following:

VALUE INDICATION
0-9, *, # Keypad Digits
P Pause
F Hookflash
! (Exclamation) SPCL Key
- (Hyphen) Ignored
( ) (Parentheses) Ignored
; (Semicolon) Ignored
Space Ignored

NOTE: In V07.00 and later, if you prepend <Destination_Dev> with the pound sign (#),
the system forces the destination to ring if the caller presses # before dialing the extension.
For example: _MO,1,1000,1*01,#1001 moves call 1*01 to 1001 and forces the
call to ring rather than going through handsfree (immediate answer). Prior to V07.00,
<Destination_Dev> could not begin with the pound sign (#).
• Mailbox_Number: (Optional) Identifies the mailbox device that <Destination_Dev>
should use if its device supports mailboxes. 
• Station_For_Toll_Restrict: (Optional) Indicates the station extension (keyset or singleline)
to use for toll restrictions, if other than <Affected_Ext>. Some feature codes and
extensions resolve to different devices depending on which device dials the number.
The station extension specified in this field is used when determining if the call should
be routed to a specified destination. This station extension is also the device used to
resolve the digit string in <Destination_Dev> to an actual destination.
NOTE: The <Station_For_Toll_Restrict> field is required to move calls to an outside
number from a hunt group.
• Override_DND: (Optional) Indicates whether or not the call should override DND if
the <Affected_Ext> is in DND (0 = Do NOT Override; 1 = Override). If blank, the
default value of Do NOT Override (0) is used.
NOTE: Calls moved to a device that has handsfree enabled and is in DND do not
come in handsfree. This is the same way that DND override works when requested via
a feature code.
CONFIRMATION: <Sequence_Number>,CF,_MO,<InvokeID>,<Outcome><CR><LF>
COMMON FAILURE
OUTCOME VALUES:
Generic_Unspecified (1): The <Mailbox_Number> parameter is invalid.
Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command.
Invalid_Call_Identifier (8): The <Call_ID> parameter is blank or invalid.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
Invalid_Destination (11): The <Destination_Dev> parameter is blank or invalid.
Generic_State_Incompatibility (15): The specified call is not present at the <Affected_Ext>
or is not in a ringing state.
Value_Out_of_Range (31): The value entered for a field is not in the valid range. For example,
the <Override_DND> value specified is neither “0” nor “1.”
Invalid_Call_Identifier_ID_Changed (51): The <Call_ID> value has changed because the
call was transferred before the command could be executed.
DESKTOP OAI: _N
EXAMPLES: Move call @003 from extension 111 to extension 100.
_MO, <InvokeID>,111,@003,100
001,CF,_MO,<InvokeID>,0
Move call @005 from extension 111 to an outside number.
_MO,<InvokeID>,111,@005,99619000
001,CF,_MO,<InvokeID>,0
Move call @003 from extension 111 to extension 100. Override DND.
_MO, <InvokeID>,111,@003,100,,1
001,CF,_MO,<InvokeID>,0
Move call @003 from Trunk 94100 to extension 100.
_MO, <InvokeID>,94100,@003,100
001,CF,_MO,<InvokeID>,0
Move call @005 from Trunk 94100 to an outside number. Use 111 toll restriction.
_MO,<InvokeID>,94100,@005,99619000,111,
001,CF,_MO,<InvokeID>,0
Move call @003 from Trunk 94100 to extension 100. Override DND.
_MO, <InvokeID>,94100,@003,100,,1
001,CF,_MO,<InvokeID>,0
 */
public class MoveCall {

}
