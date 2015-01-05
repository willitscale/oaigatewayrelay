package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

EXPANDED EXTENSION – _XE
NOTE: This command is available only in protocol versions 05.00 and later.
USE: Alters the way all extensions are handled in Level 2 System OAI. Rather than using the normal
format of an extension (up to seven digits), the expanded extension format is <Node>:<Extension>.
<Node> denotes the node number within the system, and <Extension> is the original
extension format.
PREMIUM FEATURE: System OAI Events or Third-Party Call Control
SYNTAX: _XE,<InvokeID>,<Format_Setting><CR>
Where <Format_Setting> defines whether or not the expanded format is used (0 = Off; 1 =
On).
CONFIRMATION: <Sequence_Number>,CF,_XE,<InvokeID>,<Outcome>,<Format_Setting>,
<CR><LF>
Where <Format_Setting> indicates the value associated with the format after the command is
completed (0 = Normal Format; 1 = Expanded Format).
COMMON FAILURE
OUTCOME VALUE:
Value_Out_Of_Range (31): The Format_Setting specified was not “0” or “1.”
DESKTOP OAI: None
INTERACTIONS: If enabled, the system will send all extension parameters in the expanded format. This format
affects all event reports, Level 2 commands, and Level 2 command confirmations.
EXAMPLES: Turn on expanded formatting.
_XE,<InvokeID>,1
001,CF,_XE,<InvokeID>,0,1
Turn off expanded formatting.
_XE,<InvokeID>,0
001,CF,_XE,<InvokeID>,0,0

 */
public class ExpandedExtension {

}
