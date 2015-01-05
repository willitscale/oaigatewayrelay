package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

PICKUP CALL – _PC
USE: Moves a call that is currently ringing or holding at a specific destination to the device specified
by <Affected_Ext>. This command forces the invoking device to answer the call (i.e., performs
the same function as the invoking device answering the call). The Extension Feature
(_EF) command can also be used to perform this function (see page 120).
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _PC,<InvokeID>,<Affected_Ext>,<Call_ID_to_Pickup>,
<Current_Dest_Ext><CR>
Where:
• Affected_Ext: Indicates a keyset (online), single-line set (online and off-hook), or
modem (Axxess only).
• Call_ID_To_Pickup: Specifies the ID of the call to pick up. This parameter is required.
• Current_Dest_Ext: Specifies the internal extension number where the call is currently
ringing.
CONFIRMATION: <Sequence_Number>,CF,_PC,<InvokeID>,<Outcome><CR><LF>
COMMON FAILURE
OUTCOME VALUES:
Request_Incompatible_With_Object (3): The <Affected_Ext>’s device does not support this
command.
Invalid_Call_Identifier (8): The <Call_ID> parameter is blank or invalid.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
Invalid_Destination (11): The <Current_Dest_Ext> is not a valid extension.
Generic_State_Incompatibility (15): The <Current_Dest_Ext> will not allow the
<Affected_Ext> to pick up the call, the call is not on hold or ringing at the
<Current_Dest_Ext>, or the <Affected_Ext> is an on-hook single-line set.
Resource_Busy (24): The <Affected_Ext> cannot pick up the call because it cannot allocate a
voice channel.
DESKTOP OAI: None
EXAMPLE: Extension 100 wishes to pick up call @001 from extension 101.
_PC,<InvokeID>,100,@001,101
001,CF,_PC,<InvokeID>,0
 */
public class PickupCall {

}
