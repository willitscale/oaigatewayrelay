package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

RETRIEVE CALL – _RV
USE: Causes the specified extension to connect to a call that it previously put on hold.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _RV,<InvokeID>,<Affected_Ext>,<Call_ID><CR>
Where valid device types for <Affected_Ext> are keysets (online), single-line sets (online and
off-hook), or modems (Axxess only).
CONFIRMATION: <Sequence_Number>,CF,_RV,<InvokeID>,<Outcome><CR><LF>
COMMON FAILURE
OUTCOME VALUES:
Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command.
Invalid_Call_Identifier (8): The <Call_ID> parameter is blank or invalid.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
Invalid_Object_State (14): The <Affected_Ext> could not connect to the call.
Generic_State_Incompatibility (15): The <Affected_Ext> is an on-hook single-line set, or
the <Affected_Ext> is offline.
No_Held_Call (17): The call either does not exist or is not currently on hold at the
<Affected_Ext>.
Resource_Busy (24): The <Affected_Ext> could not allocate a voice channel.
DESKTOP OAI: None
EXAMPLE: Extension 100 wishes to retrieve call @001.
_RV, <InvokeID>,100,@001
001,CF,_RV,<InvokeID>,0

 */
public class RetrieveCall {

}
