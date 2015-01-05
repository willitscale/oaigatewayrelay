package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

SET DO-NOT-DISTURB – _SD
USE: Manipulates the do-not-disturb mode of the <Affected_Ext>. The Extension Feature
(_EF) command can also be used for this function (see page 120).
NOTE: Changing the DND status using System OAI may reset the ring tone volumes (to
default) for the <Affected_Ext>.
PHANTOM
USE:
When this command is used to disable a phantom’s DND, the confirmation returns a
Generic_State_Incompatibility (15) as an error code.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _SD,<InvokeID>,<Affected_Ext>,<On/Off>,<Message_Index>,
<Custom_Text><CR>
Where:
• Affected_Ext: Indicates the extension of a keyset or single-line set.
• On/Off: Indicates the DND state (1 = Enabled; 0 = Disabled).
• Message_Index: Identifies the system-programmed DND message number (1-20).
• Custom_Text: Includes the user-programmed DND text, which can be up to 16 characters
in length and is delimited by vertical slashes (|).
CONFIRMATION: <Sequence_Number>,CF,_SD,<InvokeID>,<Outcome><CR><LF>
COMMON FAILURE
OUTCOME VALUES:
Generic_Unspecified (1): The <On/Off>, <Message_Index>, or <Custom_Text> parameter
contains invalid characters.
Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
Generic_State_Incompatibility (15): The <Affected_Ext> is not allowed to enable DND or
disable a phantom’s DND.
Value_Out_Of_Range (31): The <Message_Index> parameter is not valid.
DESKTOP OAI: _D
EXAMPLES: Extension 100 enables DND message number 19 without any custom text.
_SD,<InvokeID>,100,1,19
001,CF,_SD,<InvokeID>,0
Extension 100 enables DND without specifying a message number.
_SD,<InvokeID>,100,1
001,CF,_SD,<InvokeID>,0
Extension 100 disables DND.
_SD,<InvokeID>,100,0
CF,_SD,<InvokeID>,0
Extension 100 enables DND message number 19 with custom text.
_SD,<InvokeID>,100,1,19,|Until 10/19|
001,SD,<InvokeID>,0

 */
public class SetDoNotDisturb {

}
