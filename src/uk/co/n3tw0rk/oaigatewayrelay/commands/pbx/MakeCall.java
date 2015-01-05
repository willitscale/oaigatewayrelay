package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

MAKE CALL – _MC
USE: Instructs the device to dial the specified string. Although it is intended to originate a call
between two devices, it can be used to dial anything at the device. If the dialed string is a valid
device on the phone system or a valid trunk access code and outside number, the service
attempts to create a new call and establish a connection with the originating device. If the calling
device (<Affected_Ext>) cannot be forced to dialtone and is not already at dialtone, the
system rejects the command. This command also fails if the calling device (<Affected_Ext>) is
already connected on a call or is in any other state that does not allow calls to be made.
Prior to version 08.10, the Make Call command would fail if the <Affected_Ext> was an
on-hook single-line set. As of V08.10, the <Affected_Ext> can be an on-hook single-line set
provided the requirements specified below are met.
NOTES: The following notes apply to the _MC command when issued from a single-line set:
• The single-line set must be online. An offline single-line set cannot make calls.
• The system allocates all of the normal resources for calls from the single-line set,
including DTMF receivers and voice channels. If the system lacks resources for the
call, the call fails.
• If the single-line set transitions off-hook while a call is in progress, the voice path is
connected through the single-line set. If the single-line set returns to the on-hook state,
the call is disconnected.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX
(V < 05.10):
_MC,<InvokeID>,<Affected_Ext>,<Digit_String>,<Account_Code><CR>
SYNTAX
(05.10 <= V <
05.15):
_MC,<InvokeID>,<Affected_Ext>,<Digit_String>,<Account_Code>,
<Is_Call_Return_Message><CR>
SYNTAX
(05.15 <= V <
05.30):
_MC,<InvokeID>,<Affected_Ext>,<Digit_String>,<Account_Code>,
<Is_Call_Return_Message>,<Call_ID_Of_Call_To_Transfer><CR>
SYNTAX
(05.30 <= V <
08.10):
_MC,<InvokeID>,<Affected_Ext>,<Digit_String>,<Account_Code>,
<Is_Call_Return_Message>,<Call_ID_Of_Call_To_Transfer>,<Mailbox>,<CR>
SYNTAX
(V >= 08.10):
_MC,<InvokeID>,<Affected_Ext>,<Digit_String>,<Account_Code>,
<Is_Call_Return_Message>,<Call_ID_Of_Call_To_Transfer>,<Mailbox>,
<Override_DND><CR>
Where:
• Affected_Ext: Indicates a keyset (online) or single-line set (online).
NOTE: In versions prior to 08.10, the single-line set must also be off-hook; otherwise,
this command will fail.
• Digit_String: Indicates the digits to be dialed, which may be up to 48 digits and may
include:
NOTE: If the application wants to dial an outside number, it must specify a trunk
access code followed by the outside number to dial. An account code cannot be
entered in this field.
• Account_Code: (Optional) Identifies the account code the system should use for this
call. This field is ignored if the call is an internal call.
• Is_Call_Return_Message: (Optional) Indicates whether or not the call being made is
returning a station message (0 = Is NOT a Return Message; 1 = Is a Return Message).
If blank, the default value of Is NOT a Return Message (0) is used.
• Call_ID_Of_Call_To_Transfer: (Optional) Indicates the Call ID of a call to transfer. If
this parameter is specified, the Make Call command makes a transfer announce call
to the destination. The specified call must already be on some type of hold (i.e., system,
individual, or transfer hold).
• Mailbox: (Optional) Specifies the mailbox the voice mail application should use. This
field is used only when the destination for the command is voice mail.
• Override_DND: (Optional) Indicates whether or not the call should override DND if
the destination extension (associated with <Digit_String>) is in DND (0 = Do NOT
Override; 1 = Override). If blank, the default value of Do NOT Override (0) is used.
NOTE: Calls made to a device that has handsfree enabled and is in DND do not come
in handsfree. This is the same way that DND override works when requested via a feature
code.
CONFIRMATION: <Sequence_Number>,CF,_MC,<InvokeID>,<Outcome>,<Call_ID>,
<Affected_Ext><CR><LF>
COMMON FAILURE
OUTCOME VALUES: Generic_Unspecified (1): The <Is_Call_Return_Message> is specified but contains invalid
characters.
Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command.
Invalid_Called_Device (7): The <Digit_String> parameter is missing or invalid.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
Generic_State_Incompatibility (15): The <Affected_Ext> went offline while trying to process
this command, or it could not place the call for some other reason.
Value_Out_of_Range (31): The station identified by <Affected_Ext> requires a forced
account code to make a call, but the <Account_Code> field was blank or invalid. Or, the
<Is_Call_Return_Message> or <Override_DND> field was not a “1” or a “0.”
DESKTOP OAI: ATDT
EXAMPLES: Place an IC call to 122 from extension 111.
_MC,<InvokeID>,111,122
001,CF,_MC,<InvokeID>,0,@001,111
Place an outside call to 961-9000, using the outgoing feature (8), from extension 111.
_MC, <InvokeID>,111,89619000
001,CF,_MC,<InvokeID>,0,@001,111
The application wants 100 to call 101 and override 101’s DND, if enabled.
_MC,245,100,101,,,,,1
003,CF,_MC,245,0,100,*01
The application wants 100 to call 101 without overriding 101’s DND, if enabled.
_MC,246,100,101
004,CF,_MC,246,0,100,#01
 */
public class MakeCall {

}
