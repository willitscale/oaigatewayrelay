package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

HUNT GROUP MERGE OUT – _HM
USE: Directly connects the announcement/overflow station to the device that called the hunt group
(i.e., the call is no longer hunting) instead of allowing the call to ring the hunt group while it is
listening to the announcement/overflow station. This command also terminates the ring indication
on the hunt group members. The call must be connected to the announcement/overflow
station.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _HM,<InvokeID>,<Hunt_Group>,<Announcement/Overflow_Extension>,
<Call_ID><CR>
Where <Announcement/Overflow_Extension> is the active extension of the hunt group
announcement/overflow station.
CONFIRMATION: <Sequence_Number>,CF,_HM,<InvokeID>,<Outcome><CR><LF>
COMMON FAILURE
OUTCOME VALUES:
Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command.
Invalid_Call_Identifier (8): The <Call_ID> parameter is blank or invalid.
Invalid_Device_Identifier (9): The <Hunt_Group> parameter is blank or invalid.
Generic_State_Incompatibility (15): The station specified by <Announcement/
Overflow_Extension> is offline.
DESKTOP OAI: None
EXAMPLE: Call ID 11*01 rings in HG2001 with announcement/overflow station 1001.
_HM,<InvokeID>,2001,1001,11*01
001,CF,_HM,<InvokeID>,0

 */
public class HuntGroupMergeOut {

}
