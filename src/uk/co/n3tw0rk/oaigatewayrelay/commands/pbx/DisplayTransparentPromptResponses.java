package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

DISPLAY TRANSPARENT PROMPT RESPONSES – _DPR
NOTE: This command is available only in protocol versions 08.00 and later.
USE: Displays the prompt response on the station display. If a prompt display is NOT currently
showing on the display, this command does nothing.
NOTE: The application must have Display Control before it can issue this command.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _DPR,<InvokeID>,<Affected_Ext>,<Display_Control_Type>,
<Prompt_Responses_String>,<Cursor_Status><CR>
Where:
• Affected_Ext: Indicates a keyset (online) or a single-line set (online).
• Display_Control_Type: Specifies the type of Display Control requested (1 = full connected
control, which is the only value currently available).
• Prompt_Responses_String: Specifies the input from the user. This is placed on the display
according to the prompt format token in the initial transparent display for the
prompt. This parameter is delimited by vertical slashes ( | ).
• Cursor_Status: Indicates whether a cursor should be placed on the display following the
end of the prompt response. If disabled (set to 0), the cursor is not displayed. If enabled
(set to 1), the cursor is displayed.
CONFIRMATION: <Sequence_Number>,CF,_DPR,<InvokeID>,<Outcome>,
<Affected_Ext>,<Display_Control_Type><CR><LF>
COMMON FAILURE
OUTCOME VALUES:
Invalid_Device_Identifier (9): The <Affected_Ext> device is invalid or blank.
Generic_State_Incompatibility (15): The <Affected_Ext> device is either offline or not in a
state that accepts this command.
Not_Owner_Of_Resource (49): The application does not have Display Control over the
<Affected_Ext>, the <Affected_Ext> is either offline or not in a state that accepts this command,
or the <Affected_Ext> does not support Display Control.
DESKTOP OAI: None
EXAMPLE: To receive a prompt response, the initial prompt display must contain the proper token which
is %_.
Put up an “Enter Extension Number:” prompt on extension 1000 (where 1000 is a station).
_DTD,<InvokeID>,1000,,1,|Enter Extension%ENumber: %_|,,0,0,0
001,CF,_DTD,<InvokeID>,0,1000,1
Now, issue a response to this prompt, such as 12345 and include the cursor.
_DPR,<InvokeID>,1000,1,|12345|,1
001,CF,_DPR,<InvokeID>,0,1000,1

 */
public class DisplayTransparentPromptResponses {

}
