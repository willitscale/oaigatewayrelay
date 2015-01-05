package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

QUERY AGENT STATE – _QA
USE: Indicates the current agent mode of every ACD agent present at the specified device
(<Affected_Ext>) unless the <Agent_ID> field contains a value. If the <Agent_ID> field specifies
an agent, this command provides information about that agent only. Because an ACD
agent can be a member of multiple ACD groups at the specified device, this command provides
information on all ACD groups the agent belongs to unless the optional
<ACD_Hunt_Group> parameter contains a value. If the <ACD_Hunt_Group> field specifies a
hunt group, this command provides information about that ACD hunt group only.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _QA,<InvokeID>,<Affected_Ext>,<ACD_Agent_ID>,<ACD_Hunt_Group><CR>
Where valid device types for <Affected_Ext> include keysets or single-line sets.
CONFIRMATION: <Sequence_Number>,CF,_QA,<InvokeID>,<Outcome>,<Number_of_Entries>,
<Agent_ID>,<ACD_Group>,<Agent_Mode>,.....<CR><LF>
Where:
• Number_of_Entries: Identifies the number of <Agent_ID> entries that follow this
parameter. If this field is zero, no other fields follow.
• Agent_Mode: Indicates the agent ID’s current mode in the <ACD_Hunt_Group>. The
options for this field are as follows:
0 = Not Logged In
1 = Logged In and Ready
2 = Logged In and Not Ready
3 = Logged In and Work Not Ready
COMMON FAILURE
OUTCOME VALUES: Generic_Unspecified (1): The agent is not a member of any hunt groups.
Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command, or the <Affected_Ext> is not a member of any ACD groups.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid, or the
<ACD_Agent_ID> or <ACD_Hunt_Group> parameter is invalid.
Invalid_Destination (11): The specified <Affected_Ext> or <ACD_Agent_ID> is not a member
of the specified <ACD_Hunt_Group>.
DESKTOP OAI: None
EXAMPLES: Agent 100 is logged into ACD group 261 and is ready to receive calls at device 100.
_QA,<InvokeID>,100
001,CF,_QA,<InvokeID>,0,1,100,261,1
Agent 100 is logged into ACD groups 261 and 262 and is ready to receive calls at device 100.
_QA,<InvokeID>,100,100,
001,CF,_QA,<InvokeID>,0,2,100,261,1,100,262,1
Agent 100 is not a member of any ACD hunt group.
_QA,<InvokeID>,100,,
001,CF,_QA,<InvokeID>,0,0

 */
public class QueryAgentState {

}
