package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

CLEAR CALL – _CC
USE: Terminates a call and all connections to that call. On a normal two-party call, this is equivalent
to one party (<Affected_Ext>) hanging up. On a multi-party conference, this breaks up the
conference and hangs up on all parties.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _CC,<InvokeID>,<Affected_Ext>,<Call_ID><CR>
Where all device types are valid for <Affected_Ext>, and the <Affected_Ext> must be
involved in the call.
CONFIRMATION: <Sequence_Number>,CF,_CC,<InvokeID>,<Outcome><CR><LF>
COMMON FAILURE
OUTCOME VALUES: Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command.
Invalid_Call_Identifier (8): The <Call_ID> parameter is blank, invalid, or the call is already
idle.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank, invalid, or not
allowed to clear this call.
No_Call_to_Clear (18): The specified call is not currently present in the system.
Invalid_InvokeID (41): The <InvokeID> parameter is blank or invalid.
DESKTOP OAI: None
EXAMPLE: Terminate a call (@103) on extension 109.
_CC,<InvokeID>,109,@103
001,CF,_CC,<InvokeID>,0

 */
public class ClearCall {

}
