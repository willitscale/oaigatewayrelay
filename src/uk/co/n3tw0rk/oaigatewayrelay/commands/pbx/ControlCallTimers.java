package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

CONTROL CALL TIMERS – _CCT
NOTE: This command is available only in protocol versions 08.00 and later.
USE: Controls the recall and system forwarding functionalities of the phone system.
NOTES: The following notes apply to this command:
• Call Processing maintains the <Disable_Transfer_Recall> and
<Disable_System_Forwards> settings for the life of the call (subject to the restriction in
the next note). The <Clear_Offering_Timer> setting, however, clears only the pending
offering timer at the <Affected_Ext> for the call.
• In a multi-node network, each system node might support a different System OAI protocol
version. The node controlling the call’s functionality can change as the call moves
through the system. If the node controlling the call does not support protocol version
8.00 or later, Call Processing loses the <Disable_Transfer_Recall> and
<Disable_System_Forwards> functionalities, and System OAI does not indicate this
loss. For the best results, all telephone system nodes should support protocol version
8.00 or later.
• To re-enable the default system forward or transfer recall functionalities, the application
must issue the _CCT command. This command should indicate normal functionality.
• Call Processing does not retroactively start or change the transfer recall timers when the
application requests normal functionality. Call Processing does, however, retroactively
stop or change the transfer recall timer if the command specifies a non-zero value for
<Disable_Transfer_Recall>.
• When the command specifies to follow the normal system forward functionality, Call
Processing does not immediately follow system forwards, nor does it immediately post
a timer to follow a delayed system forward. Call Processing does not retroactively follow
system forwards nor retroactively enable system-forward timers. Setting the
<Disable_System_Forwards> timer to zero merely instructs the call to follow system
forwards in the future.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _CCT,<InvokeID>,<Affected_Ext>,<Call_ID>,<Disable_Transfer_Recall>,
<Disable_System_Forwards>,<Clear_Offering_Timer>
Where:
• Affected_Ext: Identifies a trunk, keyset, or single-line device involved in the call.
• Call_ID: Specifies the ID of the call associated with the timers that the application will
control.
• Disable_Transfer_Recall: Indicates how Call Processing should handle transfer recalls.
Possible values include the following:
1 = Call Processing clears any pending transfer recall timers for this call and prevents
registering further recall timers for the call.
0 = Call Processing allows normal transfer recalls.
• Disable_System_Forwards: Determines whether the call ignores or follows system forwards.
Possible values include:
1 = System forwards, including any in-progress forward paths, are ignored.
0 = System forwards are followed.
• Clear_Offering_Timer: Specifies if the offering timer for the call is cleared. If the call is
currently offered at the <Affected_Ext>, setting this parameter to 1 clears the offering
timer for this call, giving the application more time to move the call from offering
mode. If the call is not in offering mode or if this parameter is zero, the offering timer is
not cleared.
CONFIRMATION: <Sequence_Number>,CF,_CCT,<InvokeID>,<Outcome>,<Affected_Ext>,
<Call_ID>
COMMON FAILURE
OUTCOME VALUES:
Request_Incompatible_With_Object (3): The <Affected_Ext> device type does not support
this command.
Invalid_Call_Identifier (8): The <Call_ID> parameter is blank or invalid.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
Invalid_Object_State (14): The specified call does not exist at the <Affected_Ext>.
Network_Out_Of_Service (25): The telephone system node controlling the call does not support
protocol version 8.00 or later.
Value_Out_Of_Range (31): The <Disable_Transfer_Recall>, <Disable_System_Forwards>,
or <Clear_Offering_Timer> parameter is invalid.
DESKTOP OAI: None
EXAMPLES: Route call 5482 at extension 101 without transfer recalls and while ignoring system forwards.
001,DE,,<MON101>,5482,101,,I,100,,,,,I,101,,,A,22,
_CCT,<InvokeID>,101,5482,1,1,
0002,CF,_CCT,<InvokeID>,0,101,5482
When the application moves the call from 101 to 102, the call does not follow system forwards
at 102.
_MO, <InvokeID>,101,5482,102
003,CF,_MO,<InvokeID>,0
004,DI,,<MON101>,5482,101,102,,N,28
005,DE,,<MON102>,5482,102,,I,100,,,,,I,102,,,A,22,
NOTE: If the application transfers the call 5482 from 102 to 103, Call Processing does not register
a transfer recall timer based on the parameters defined in the _CCT command.
Route announcement call 5484 at extension 101 without transfer recalls and while ignoring
system forwards. In addition, clear the offering timer for call 5484 at extension 101.
006,OF,,<MON101>,5484,101,,I,100,,,,,I,101,,,A,40,
_CCT,<InvokeID>,101,5484,1,1,1
007,CF,_CCT,<InvokeID>,0,101,5484
Deflect the call from 101 to 102. (The announcement call remembers its transfer-recall and
system-forward settings.)
_DF,1,<InvokeID>,101,5484,102
008,CF,_DF,<InvokeID>,0
009,DI,,<MON101>,5484,101,102,,N,28
010,DE,,<MON102>,5484,102,,I,100,,,,,I,101,101,,A,40,
If extension 101 now hangs up to complete the transfer, the transferred call does not follow an
immediate system forward because Call Processing does not allow transferred calls to follow
immediate forwards. Call Processing does, however, initiate a recall timer on the transferred
call (8483). The application must send a _CCT command on the transferred call to control the
call timers on device 102.
011,TR,,<MON102>,5483,100,106,5484,102,,,,,A,32
012,XC,,<MON102>,5484,100,100,,36
013,XC,,<MON102>,5484,102,100,N,36
014,DE,,<MON102>,5483,102,,I,106,,,,,I,101,101,,A,9,
_CCT,<InvokeID>,102,5483,1,1,0
015,CF,_CCT,<InvokeID>,0,102,5483
 */
public class ControlCallTimers {

}
