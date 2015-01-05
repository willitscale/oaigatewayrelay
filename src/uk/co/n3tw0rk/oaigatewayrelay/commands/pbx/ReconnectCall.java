package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

RECONNECT CALL – _RC
NOTE: This command is available only in protocol versions 03.00 and later.
USE: Combines the Clear Connection (_CX) and the Retrieve Call (_RV) commands
(see pages 100 and 187 respectively). This clears an existing connection and then retrieves a
previously held connection at the same device.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _RC,<InvokeID>,<Affected_Ext>,<Call_to_Clear>,<Held_Call><CR>
Where:
• Affected_Ext: Indicates a keyset (online), single-line set (online), or modem (Axxess
only).
• Call_To_Clear: Identifies the active call. This is the call that will be cleared.
• Held_Call: Indicates the holding call. This is the call that will be retrieved.
CONFIRMATION: <Sequence_Number>,CF,_RC,<InvokeID>,<Outcome><CR><LF>
COMMON FAILURE
OUTCOME VALUES:
Generic_Unspecified (1): The system was unable to terminate the active call.
Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command.
Invalid_Call_Identifier (8): One or both of the <Call_ID> parameters are blank or invalid.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
Invalid_Object_State (14): The <Affected_Ext> was unable to reconnect to the <Held_Call>,
or the device on the other end of <Held_Call> refused the connection.
Generic_State_Incompatibility (15): The <Affected_Ext> is offline.
No_Held_Call (17): The call specified by <Held_Call> is not on hold at the <Affected_Ext>.
No_Connection_To_Clear (19): Either the <Call_To_Clear> does not exist at the
<Affected_Ext>, or the call is not in a clearable state.
Resource_Busy (24): The <Affected_Ext> cannot reconnect to the <Held_Call> because it
cannot allocate a voice channel.
DESKTOP OAI: None
EXAMPLE: Extension 100 wishes to clear connection to call @001 and retrieve call @003.
_RC,<InvokeID>,100,@001,@003
001,CF,_RC,<InvokeID>,0

 */
public class ReconnectCall {

}
