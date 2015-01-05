package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

DISPLAY TRANSPARENT DISPLAY – _DTD
NOTE: This command is available only in protocol versions 08.00 and later.
USE: Changes the keyset display.
NOTE: The application must have Display Control before it can issue this command.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _DTD,<InvokeID>,<Affected_Ext>,<Display_Control_Type>,
<Info_Display_String>,<Menu_Display_String>,<Display_Option>,
<Display_Type>,<Display_Echo>,<Prompt_Option>,
<Immediate_Prompt_Response><CR>
Where:
• Affected_Ext: Indicates a keyset (online) or a single-line set (online).
• Display_Control_Type: Specifies the type of Display Control requested (1 = full connected
control, which is the only value currently available).
• Info_Display_String: Specifies the text, delimited by vertical slashes ( | ), to be displayed
on lines 1 and 2 of the keyset display (see the illustration on page 114). This text
can include special formatting tokens and other display options such as counters and
prompts. (Refer to page 211 for more information on available display tokens.)
• Menu_Display_String: Specifies the text, delimited by vertical slashes ( | ), to be displayed
on lines 3 and 4 of an M64 or an M160 or on lines 3, 4, 5, and 6 of an Executive
or Professional Display keyset. This text can also include special formatting tokens.
NOTE: The menu region does not support all display tokens. See page 114 for details.
• Display_Option: Indicates the parts of the display to update. Possible values include:
0 = Info Region Only
1 = Menu Region Only
2 = Info and Menu Regions
• Display_Type: Indicates the type of display. This can be one of the following:
— Prompt (0): Indicates a custom prompt or one of the generic system prompts, such
as PROMPT_EXTENSION.
NOTE: The system prompts provide extension validation and do not give the application
control until either a valid or invalid extension is entered.
— Information (1): Indicates a static display containing the application-provided
text.
— Warning (2): Indicates a transient display with a reorder burst tone.
— Error (3): Indicates a static display with either a standard system busy error tone
or a reorder tone.
— Acknowledge (4): Indicates a transient display (if it is not restricted) with a confirmation
burst tone.
— Banner (5): Indicates a static display with a confirmation burst tone.
• Display_Echo: Specifies the duplex mode for the prompt. Possible values include:
0 = Full Duplex
1 = Half Duplex
2 = None
If this is set to full duplex (0) for the prompt, all subsequent prompt response commands
that the application sends are displayed just as they are sent. For example, if the
application sends “1,” a “1” is shown on the display. If the echo is set to half duplex, all
subsequent prompt response commands that the application sends are displayed as an
asterisk (*). For example, if the application sends a “2,” an “*” is shown on the display.
If the echo is set to none, nothing from the prompt response command is shown on the
station display.
• Prompt_Option: (Optional) Indicates the type of prompt requested. This can be one that
the application creates (0), or a prompt, such as PROMPT EXTENSION or DIALPAD,
that validates the entered extension before returning control to the application (1). For
example, if the application builds a prompt display, all inputs are directed to the application
and are only displayed based on the <Immediate_Prompt_Response> flag. If,
however, the application requests a PROMPT EXTENSION prompt, the system issues
the prompt, collects digits, and validates the input before returning the input to the
application.
• Immediate_Prompt_Response: (Optional) Indicates whether or not the input is immediately
displayed on the station before the input is sent to the application (0 = Off; 1 =
On). If disabled (set to 0), the input is sent to the application before it is displayed on
the station. If enabled (set to 1), the input is displayed on the station before the application
is notified.
CONFIRMATION: <Sequence_Number>,CF,_DTD,<InvokeID>,<Outcome>,
<Affected_ID>,<Display_Control_Type><CR><LF>
COMMON FAILURE
OUTCOME VALUES:
Invalid_Device_Identifier (9): The <Affected_Ext> device is invalid or blank.
Value_Out_Of_Range (31): The <Display_Type> or <Display_Echo> parameter is invalid.
Not_Owner_Of_Resource (49): The application does not have Display Control over the
<Affected_Ext>, the <Affected_Ext> is either offline or not in a state that accepts this command,
or the <Affected_Ext> does not support Display Control.
DESKTOP OAI: None
EXAMPLES: Change the display on extension 1000 (where 1000 is a station) to read APRIL FOOLS using
an INFORMATION display.
_DTD,<InvokeID>,1000,1,|APRIL FOOLS|,|DAY|,2,1,0
001,CF,_DTD,<InvokeID>,1000,1
Put up a PROMPT_EXTENSION display. Because this is a system prompt, the menu region
text provided does not appear on the display. Only the custom information region text is used.
_DTD,<InvokeID>,1000,1,|EXT NUMBER|,,2,0,0,1
001,CF,_DTD,<InvokeID>,0,1000,1

 */
public class DisplayTransparentDisplay {

}
