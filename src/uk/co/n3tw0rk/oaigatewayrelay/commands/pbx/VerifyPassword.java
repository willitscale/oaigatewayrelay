package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

VERIFY PASSWORD – _VP
NOTE: This command is available only in protocol versions 05.10 and later.
USE: Verifies two types of passwords: those for individual stations and those for keyset-based database
programming. This command returns a boolean parameter (1 = Password is Correct; 0 =
Password is Incorrect).
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _VP,<InvokeID>,<Affected_Ext>,<Password_Type>,<Password><CR>
Where:
• Affected_Ext: Indicates keyset or single-line set if <Password_Type> is set to “1” (individual
station password). Otherwise, this is optional.
• Password_Type: Indicates whether <Password> is the keyset-based database programming
password or an individual station password (0 = Keyset-Based Database Programming;
1 = Individual Station). This parameter must be specified.
• Password: Specifies the password that is being verified, delimited by vertical slashes
 (|).
CONFIRMATION
(NON-GATEWAY):
<Sequence_Number>,CF,_VP,<InvokeID>,<Outcome>,
<Password_Correct><CR><LF>
CONFIRMATION
(GATEWAY):
<Sequence_Number>,CF,_VP,<InvokeID>,<Outcome>,
<All_Nodes_Password_Correct>,<Num_Nodes>,<Node_Data1>,...,<Node_DataN>
<CR><LF>
Where:
• Password_Correct: Indicates whether or not the password is correct (1 = Correct; 0 =
Incorrect).
• All_Nodes_Password_Correct: Displays a “1” only if all nodes have the correct password;
otherwise, this is “0.”
• Num_Nodes: Specifies the total number of nodes connected to the Gateway.
• Node_Data: Displays the node number and whether or not the password is correct.
<Node_Data> uses the format:
<Node_Num>,<Password_Correct>
This is displayed for all nodes connected to the Gateway.
NOTE: If the CT Gateway is running in Node Aware mode, an all-node _VP command is sent
only to the nodes that are connected.
COMMON FAILURE
OUTCOME VALUES:
Generic_Unspecified (1): The <Password_Type> or <Password> parameter contains invalid
characters.
Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
Value_Out_Of_Range (31): The <Password_Type> parameter is not valid.
DESKTOP OAI: None
EXAMPLES: The password “101245” at extension 1000 is valid.
_VP, <InvokeID>,1000,1,|101245|
001,CF,_VP,<InvokeID>,0,1
The password “7645983 at extension 1000 is invalid.
_VP,<InvokeID>,1000,1,|7645983|
001,CF,_VP,<InvokeID>,0,0
The keyset database programming password is valid.
_VP,<InvokeID>,,0,|12345678|
001,CF,_VP,<InvokeID>,0,1
The keyset database programming password is invalid.
_VP,<InvokeID>,,0,|5674832|
001,CF,_VP,<InvokeID>,0,0

 */
public class VerifyPassword {

}
