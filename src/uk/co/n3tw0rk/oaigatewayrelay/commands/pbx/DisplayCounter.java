package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

DISPLAY COUNTER – _DCR
NOTE: This command is available only in protocol versions 08.00 and later.
USE: Sets up a counter on the display, which can be initialized to a value and then count up or count
down. If the device does not support a counter, the command returns error code 3
(Request_Incompatible_With_Object). To increment the counter, use the display token %w. To
decrease the counter, use the display token %d. To initialize the counter, the counter init command
must precede the transparent display command with the counter token. If the counter init
command is omitted, the timer is not shown on the display. If a counter start command is
issued after the timer is already running or if a counter stop command is issued after the timer
has already stopped, the command is ignored.
NOTES: All timers must be initialized before they are placed on the display. A counter will not be reinitialized
unless another counter init command, followed by another _DTD timer command, is
sent. In addition, the counter can only be placed in the information region of the display, and
the counter always requires the entire line.
NOTE: The application must have Display Control before it can issue this command.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _DCR,<InvokeID>,<Affected_Ext>,<Display_Control_Type>,<Counter_State>,
<Init_Minutes>,<Init_Seconds><CR>
Where:
• Affected_Ext: Indicates a keyset (online) or a single-line set (online).
• Display_Control_Type: Specifies the type of Display Control the application has (1 =
full connected control, which is the only value currently available).
• Counter_State: Specifies the action that the counter will perform. Possible values
include:
0 = Initialize
1 = Start
2 = Stop
• Init_Minutes: Indicates the number of minutes the counter initially displays. The valid
range for this parameter is 0-1439.
• Init_Seconds: Indicates the number of seconds the counter initially displays. The valid
range for this parameter is 0-59.
CONFIRMATION: <Sequence_Number>,CF,_DCR,<InvokeID>,<Outcome>,
<Affected_Ext>,<Display_Control_Type><CR><LF>
COMMON FAILURE
OUTCOME VALUES: Invalid_Device_Identifier (9): The <Affected_Ext> device type does not support this command.
Generic_State_Incompatibility (15): The <Affected_Ext> device is either offline or not in a
state that accepts this command.
Value_Out_Of_Range (31): The <Init_Minutes> or <Init_Seconds> parameter is invalid.
Not_Owner_Of_Resource (49): The application does not have Display Control over the
<Affected_Ext>, the <Affected_Ext> is either offline or not in a state that accepts this command,
or the <Affected_Ext> does not support Display Control.
DESKTOP OAI: None
EXAMPLES: Initialize a counter on extension 1000 (where 1000 is a station) for 10:15.
_DCR,<InvokeID>,1000,1,0,10,15
001,CF,_DCR,<InvokeID>,0,1000,1
Include the timer on line 2 of the display with line 1 indicating TIMER BEGIN.
_DTD,<InvokeID>,1000,1,|TIMER BEGIN: %E%d|,0,0,0
001,CF,_DTD,<InvokeID>,0,1000,1
Start the counter on station 1000.
_DCR,<InvokeID>,1000,1,1,0,0
001,CF,_DCR,<InvokeID>,0,1000,1
Stop the counter on station 1000.
_DCR,<InvokeID>,1000,1,2,0,0
001,CF,_DCR,<InvokeID>,0,1000,1

 */
public class DisplayCounter {

}
