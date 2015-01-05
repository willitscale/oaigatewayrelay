package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

SNAPSHOT DEVICE – _SP
USE: Returns information about a device object on the phone system, including a list of calls associated
with the specified device and the connection state of each of those calls at the device.
NOTE: As of version 08.10, this command reports callback prompts. For example, a snapshot
of station A while the station is issuing a callback prompt shows that station A has initiated service
(i.e., the callback service is initiated). A snapshot of the target device, however, provides no
indication of the prompt at station A.
PREMIUM FEATURE: Third-Party Call Control prior to V05.20; System OAI Events or Third-Party Call Control
V05.20 and later
SYNTAX: _SP,<InvokeID>,<Affected_Ext><CR>
Where valid device types for <Affected_Ext> include a keyset, single-line set, modem
(Axxess only), Hunt/ACD Group, voice mail application, and trunk.
CONFIRMATION: <Sequence_Number>,CF,_SP,<InvokeID>,<Outcome>,<Number_of_Calls>,
<Call_ID_1>,<Local_Cnx_State_1>,...<CR><LF>
Where:
• Number_Of_Calls: Identifies the number of calls currently present at the device. If this
field is zero, no other fields follow.
• Call_ID 1: Specifies the ID of the first call currently present at the device.
• Local_Cnx_State 1: Identifies the local connection state of Call ID 1 at the device.
• Call_ID n: Specifies the ID of call n currently present at the device.
• Local_Cnx_State n: Identifies the local connection state of Call ID n at the device.
COMMON FAILURE
OUTCOME VALUES:
Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
DESKTOP OAI: None
EXAMPLES: Extension 1233 has one call ringing and one call on hold.
_SP,<InvokeID>,1233
001,CF,_SP,<InvokeID>,0,2,@001,A,@002,H
Extension 1233 is completely idle.
_SP,<InvokeID>,1233
001,CF,_SP,<InvokeID>,0,0
Extension 1001 receives a callback prompt. Snapshot Device commands are then issued.
001,SI,,<MON1001>,1F01,1001,I,04,1002
_SP,1,1001
002,CF,_SP,1,0,1,1F01,I
_SP,2,1002
003,CF,_SP,2,0,0
 */
public class SnapshotDevice {

}
