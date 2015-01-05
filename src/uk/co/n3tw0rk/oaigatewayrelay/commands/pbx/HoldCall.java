package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

HOLD CALL – _HC
USE: Puts a call that is in the active (talking) state on hold at a specified device. The associated
resources for the held call are made available for other uses, depending on
<Reserve_Connection>.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX
(V < 05.10):
_HC,<InvokeID>,<Affected_Ext>,<Call_ID>,<Reserve_Connection>,
<Leave_At_Dialtone><CR>
SYNTAX
(V >= 05.10):
_HC,<InvokeID>,<Affected_Ext>,<Call_ID>,<Reserve_Connection>,
<Leave_At_Dialtone>,<Hold_Type><CR>
Where:
• Affected_Ext: Indicates a keyset (online) or single-line set (online).
• Reserve_Connection: (Reserved for future use and is currently ignored.)
• Leave_At_Dialtone: (Optional) Determines whether or not the station specified by
<Affected_Ext> will attempt to return to on-hook idle or remain at dialtone (0 =
Attempt to Return to Idle; 1 = Leave at Dialtone). If the station device is physically offhook,
this command will not be able to force the station on-hook; it will have to leave
the station at dialtone. The default value is Leave at Dialtone (1).
• Hold_Type: (Optional) Describes the type of hold used for a call (0 = Individual Hold;
1 = System Hold). The default value is Individual Hold (0).
NOTE: If the call is an internal call, Individual Hold is automatically assigned to
<Hold_Type>, regardless of the value assigned in the command.
CONFIRMATION: <Sequence_Number>,CF,_HC,<InvokeID>,<Outcome><CR><LF>
COMMON FAILURE
OUTCOME VALUES:
Generic_Unspecified (1): The <Leave_At_Dialtone>, <Hold_Type>, or
<Reserve_Connection> field is specified but invalid.
Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command.
Invalid_Call_Identifier (8): The <Call_ID> parameter is blank or invalid.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
Invalid_Object_State (14): The <Affected_Ext> is currently on hold and cannot put the specified
call on hold.
Generic_State_Incompatibility (15): The call specified by <Call_ID> cannot be put on hold.
DESKTOP OAI: _E <Hold Feature Code>
EXAMPLE: Put the call on hold at extension 110.
_HC,<InvokeID>,110,@103
001,CF,_HC,<InvokeID>,0

 */
public class HoldCall {

}
