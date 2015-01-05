package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

DISPLAY ELIMINATE CONTROL – _DEC
NOTE: This command is available only in protocol versions 08.00 and later.
USE: Removes Display Control over a station device (e.g., keyset, single-line set, etc.).
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _DEC,<InvokeID>,<Affected_Ext>,<Display_Control_Type><CR>
Where:
• Affected_Ext: Indicates a keyset (online) or a single-line set (online).
• Display_Control_Type: Type of Display Control requested (1 = full connected control,
which is the only value currently available).
CONFIRMATION: <Sequence_Number>,CF,_DEC,<InvokeID>,<Outcome>,
<Affected_Ext>,<Display_Control_Type><CR><LF>
COMMON FAILURE
OUTCOME VALUES:
Invalid_Device_Identifier (9): The <Affected_Ext> device is not valid.
Value_Out_Of_Range (31): The <Display_Control_Type> parameter is invalid.
Not_Owner_Of_Resource (49): The application does not have Display Control over the
<Affected_Ext>.
DESKTOP OAI: None
EXAMPLE: Eliminate Display Control on extension 1000 (where 1000 is a station).
_DEC,<InvokeID>,1000,1
001,CF,_DEC,<InvokeID>,0,1000,1

 */
public class DisplayEliminateControl {

}
