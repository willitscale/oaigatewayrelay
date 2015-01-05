package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

TRANSFER CALL (ONE STEP) – _TO
USE: Transfers a call that is presently connected at the <Affected_Ext>, thus moving the call to
another device or to an outside phone.
NOTE: This command works on connected calls only, while the Deflect (_DF) command
(see page 105) works on ringing calls.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX
(V < 07.00):
_TO,<InvokeID>,<Affected_Ext>,<Call_ID>,<Destination_Number>,
<Mailbox_Number><CR>
Where:
• Affected_Ext: Indicates a keyset or single-line set (online).
• Call_ID: Specifies the ID of the call to be transferred.
• Destination_Number: Identifies the number of the transfer destination that will receive
the call. If the application wishes to dial an outside number, it must specify a trunk
access code followed by the outside number. This field is a digit string, which may be
up to 48 digits and may include the following:

VALUE INDICATION
0-9, *, # Keypad Digits
P Pause
F Hookflash
! (Exclamation) SPCL Key
- (Hyphen) Ignored
( ) (Parentheses) Ignored
; (Semicolon) Ignored
Space Ignored

• Mailbox_Number: (Optional) Identifies the mailbox device that <Destination_Number>
should use if its device supports mailboxes.
SYNTAX
(07.00 <= V <
08.10):
_TO,<InvokeID>,<Affected_Ext>,<Call_ID>,<Destination_Number>,
<Mailbox_Number>,<CR>
SYNTAX
(V >= 08.10):
_TO,<InvokeID>,<Affected_Ext>,<Call_ID>,<Destination_Number>,
<Mailbox_Number>,<Station_For_Toll_Restrict>,<Override_DND><CR>
Where:
• Affected_Ext: Indicates a keyset or single-line set (online), or a trunk device.
• Station_For_Toll_Restrict: (Optional) Indicates the station extension to use for toll
restriction (if other than <Affected_Ext>). This station extension must be a station
device. Some feature codes and extensions resolve to different devices depending on
which device dials the number. The station extension specified in this field is used when
determining if the call should be routed to a specified destination. This station extension
is also the device used to resolve the digit string in <Destination_Dev> to an actual destination.

NOTE: The <Station_For_Toll_Restrict> field is required if the <Affected_Ext> is a
trunk and the <Destination_Number> is an outside number. 
• Override_DND: (Optional) Indicates whether or not the call should override DND if
the <Affected_Ext> is in DND (0 = Do NOT Override; 1 = Override). If blank, the
default value of Do NOT Override (0) is used.
NOTE: Calls transferred to a device that has handsfree enabled and is in DND do not
come in handsfree. This is the same way that DND override works when requested via
a feature code.
CONFIRMATION: <Sequence_Number>,CF,_TO,<InvokeID>,<Outcome>,<New_Call_ID>,
<Destination_Ext>,<Transferred_Ext>,<Outside_Caller_Name>,
<Outside_Caller_Number>,<Trunk_Name>,<Trunk_Outside_Number><CR><LF>
Where:
• New_Call_ID: Specifies the Call ID of the resulting call.
• Destination_Ext: Indicates the transfer destination extension (internal extension). If
transferred to the public network, this is the extension of the trunk used.
• Outside_Caller_Name: Indicates the outside caller’s name of the transferred device
(e.g., Caller ID/ANI name, if available). This information can be added/modified with
the Modify Call (_MD) command in System OAI (_M in Desktop OAI) but cannot
be deleted. This field is always blank for IC calls.
• Outside_Caller_Number: Identifies the outside caller’s Caller ID/ANI number for an
incoming CO call, if available. This can be added/modified with the Modify Call
(_MD) command in System OAI (_M in Desktop OAI) but cannot be deleted. This
field is always blank for IC calls.
• Trunk_Name: Specifies the name associated with the transferred device if it is a trunk
(e.g., the name programmed in the system’s call routing table for the incoming number
dialed [DID/DNIS]). If there is no DID/DNIS number, this field displays the trunk
description programmed in the phone system. This information can be added/modified
with the Modify Call (_MD) command is System OAI but cannot be deleted. This
field is always blank for IC calls.
• Trunk_Outside_Number: Identifies the DNIS or DID information associated with the
transferred trunk, if applicable. This can be added/modified with the Modify Call
(_MD) command in System OAI (_M in Desktop OAI) but cannot be deleted. This field
is always blank for IC calls.
COMMON FAILURE
OUTCOME VALUES:
Generic_Unspecified (1): The <Mailbox_Number> parameter is invalid or contains invalid
characters.
Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command.
Invalid_Call_Identifier (8): The <Call_ID> parameter is blank or invalid.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
Invalid_Destination (11): The <Destination_Number> parameter is invalid.
Generic_State_Incompatibility (15): The <Affected_Ext> cannot complete the transfer (e.g.,
the <Affected_Ext> has a call other than <Call_ID> on transfer-hold).
No_Active_Call (16): The <Affected_Ext> is not active on any call, or it is connected to a call
other than the one specified by <Call_ID>.
Value_Out_of_Range (31): The value entered for a field is not in the valid range. For example,
the <Override_DND> value specified is neither “0” nor “1.”
Invalid_Call_Identifier_ID_Changed (51): The <Call_ID> value has changed because the
call was transferred before the command could be executed.
DESKTOP OAI: _T
EXAMPLES: Transfer present call (on extension 101) from extension 111 to extension 100.
_TO,<InvokeID>,111,,100
001,CF,_TO,<InvokeID>,0,@002,100,101,,,,
Transfer present call (on extension 101) from extension 111 to an outside number. Trunk
97061 is used for the call.
_TO,<InvokeID>,111,,89619000
001,CF,_TO,<InvokeID>,0,@002,97061,101,,,,
Transfer an active (“talking”) call (@103 on extension 101) from extension 111 to extension
120.
_TO,<InvokeID>,111,@103,120
001,CF,_TO,<InvokeID>,0,@103,120,101,,,,
Transfer an active (“talking”) call (@103 on extension 101) from extension 111 to extension
120.
_TO,<InvokeID>,111,@103,120
001,CF,_TO,<InvokeID>,0,@103,120,101,,,,
Transfer present call (on extension 101) from extension 111 to extension 100. Override DND.
_TO,<InvokeID>,111,,100,,1
001,CF,_TO,<InvokeID>,0,@002,100,101,,,,

 */
public class TransferCallOneStep {

}
