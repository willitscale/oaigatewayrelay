package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

REQUEST CALLBACK – _RCB
NOTE: This command is available only in protocol versions 08.10 and later.
USE: Requests a callback when the target device becomes available. To request a callback, the
<Affected_Ext> (requestor) must be in the local connection state of connected (C). In addition,
the called device (target) must be a station, hunt group, trunk, or trunk group in the busy state.
If successful, this command terminates the connection to the call, disconnecting the requestor
from the designated call. If desired, you can also use the Extension Feature (_EF) command
to dial the message feature code (365) and terminate the call (see page 120).
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: __RCB,<InvokeID>,<Affected_Ext>,<Call_ID><CR>
Where the <Affected_Ext> indicates a keyset or a single-line set.
CONFIRMATION: <Sequence_Number>,CF,_RCB,<InvokeID>,<Outcome><CR><LF>
COMMON FAILURE
OUTCOME VALUES:
Request_Incompatible_With_Object (3): The <Affected_Ext> device type does not support
this command.
Invalid_Call_Identifier (8): The <Call_ID> parameter is blank or invalid.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
Generic_State_Incompatibility (15): The specified call is not present at the <Affected_Ext>,
or the <Affected_Ext> is not in a connected state. This outcome is also issued if the target
device is not busy or does not support callbacks.
EXAMPLE: Extension 100 calls 101, but 101 is in DND. Extension 100 requests a callback.
001,SI,,<MON100>,57301,100,I,22,
002,OR,,<MON100>,57301,100,,I,1002,,C,22
003,FA,,<MON100>,57301,101,101,C,14
_RCB,<InvokeID>,100,57301
004,CF,_RCB,<InvokeID>,0
005,XC,,<MON100>,57301,100,100,N,04
006,CB,,<MON100>,1,100,101,|USER101|,|101Description|,,

 */
public class RequestCallback {

}
