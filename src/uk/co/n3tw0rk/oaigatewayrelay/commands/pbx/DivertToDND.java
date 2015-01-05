package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

DIVERT TO DND – _DD
NOTE: This command is available only in protocol versions 03.10 and later.
USE: Diverts a call, which is presently alerting the <Affected_Ext>, to DND, moving the call away
from the phone. This command bumps the call to the specific DND message without putting
the station itself into DND.
NOTE: Applications cannot divert CO calls to DND. If an application attempts to divert a CO
call, a failure outcome of Invalid_Call_Identifier (8) is generated.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _DD,<InvokeID>,<Affected_Ext>,<Call_ID>,
<Canned_DND_Msg_Index>,<Custom_Text><CR>
Where:
• Affected_Ext: Indicates a keyset, single-line set, or modem (Axxess only).
• Canned_DND_Msg_Index: (Optional) Specifies the number of the DND message (1-
20). If blank, the system uses DND MSG #01 by default.
• Custom_Text: (Optional) Specifies the custom DND text string, up to 16 characters, for
the DND message. The text must be delimited on both sides with a vertical slash (|).
CONFIRMATION: <Sequence_Number>,CF,_DD,<InvokeID>,<Outcome><CR><LF>
COMMON FAILURE
OUTCOME VALUES:
Generic_Unspecified (1): The DND message index or custom text contains invalid characters.
Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command.
Invalid_Call_Identifier (8): The <Call_ID> parameter is blank or invalid, or the call cannot
be diverted to DND.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
Generic_State_Incompatibility (15): The specified call is not present at the <Affected_Ext>,
the <Affected_Ext> is not allowed to access the DND feature, or the call is not in a ringing
state.
Value_Out_Of_Range (31): The DND message index is not within the valid range (1-20).
DESKTOP OAI: _G
EXAMPLE: Divert call @003 from extension 111 to DND.
_DD, <InvokeID>,111,@003,2,| FOREVER |
001,CF,_DD,<InvokeID>,0

 */
public class DivertToDND {

}
