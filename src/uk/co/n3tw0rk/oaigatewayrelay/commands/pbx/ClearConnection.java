package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

CLEAR CONNECTION – _CX
USE: Terminates a connection to a call, disconnecting the specified device from the designated call.
The <Affected_Ext> must have a local connection state of CONNECTED (i.e., the
<Affected_Ext> must be in a state where manually hanging up would terminate the connection).
On a normal two-party call, this performs the same action as the party hanging up. This
command, however, cannot always force a station to go on-hook, allowing the station to
remain in the off-hook idle state and listen to dialtone. On a multi-party conference, this drops
the specified device and leaves the other parties in the conference connected, if appropriate.
NOTE: As of version 08.10, you can use this command to cancel a callback request.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX
(V < 05.15):
_CX,<InvokeID>,<Affected_Ext>,<Call_ID><CR>
Where valid device types for <Affected_Ext> are keyset (off-hook), single-line set (off-hook),
and trunk.
SYNTAX
(V >= 05.15):
_CX,<InvokeID>,<Affected_Ext>,<Call_ID>,<Complete_Transfer><CR>
Where:
• Affected_Ext: Indicates a keyset (off-hook), single-line set (off-hook), modem (Axxess
only), or trunk.
• Complete_Transfer: (Optional Boolean field) Indicates whether or not disconnecting
this call should complete a transfer. The call must be a transfer announce call, and the
<Affected_Ext> must be a station for this to work.
CONFIRMATION: <Sequence_Number>,CF,_CX,<InvokeID>,<Outcome><CR><LF>
COMMON FAILURE
OUTCOME VALUES: Generic_Unspecified (1): The <Complete_Transfer> parameter is present but invalid.
Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command.
Invalid_Call_Identifier (8): The <Call_ID> parameter is blank or invalid.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
Invalid_Object_State (14): The <Affected_Ext> is a trunk, and the call specified by
<Call_ID> has not been seized.
Generic_State_Incompatibility (15): The device specified by <Affected_Ext> is offline.
No_Connection_To_Clear (19): The specified connection does not exist.
DESKTOP OAI: H3
EXAMPLES: Terminate a connection on extension 112.
_CX,<InvokeID>,112,@103
001,CF,_CX,<InvokeID>,0
Extension 1001 receives a callback prompt. The Clear Connection command is then issued to
cancel the prompt and deregister the callback.
001,SI,,<MON1001>,1F01,1001,I,04,1002
_CX,1,1001,1F01
002,CF,_CX,1,0
003,CB,,<MON1001>,0,1001,1002,|USER1002|,|1002Description|,,
004,XC,,<MON1001>,1F01,1002,1002,N,36

 */
public class ClearConnection {

}
