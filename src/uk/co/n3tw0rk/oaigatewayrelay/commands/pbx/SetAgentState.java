package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

SET AGENT STATE – _SA
USE: Manipulates the agent mode of the specified agent ID at the <Affected_Ext>.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _SA,<InvokeID>,<Affected_Ext>,<Agent_ID>,<Agent_State>,
<ACD_Group><CR>
Where:
• Affected_Ext: Indicates a keyset or single-line set.
• Agent_State: Identifies the new state for the agent. The options are:
0 = Log Out
1 = Log In
2 = Ready – Cancels wrap up mode (agent must already be idle)
3 = Not Ready – Puts agent into wrap up mode indefinitely
4 = Work Ready – Same as Ready
5 = Work Not Ready – Same as Not Ready
NOTE: An agent in DND (see page 189) cannot be placed into wrap up mode (Not
Ready or Work Not Ready).
• ACD_Group: Includes the extension number of the ACD group containing the affected
agent ID. If blank, the command affects all of the ACD groups to which the agent ID
belongs.
NOTE: When the Hunt Group ID field is left blank and the Agent State specified is
Login, the command will return a return code of success immediately. The application
will be required to use a Monitor on the device specified by the affected ID to determine
into which hunt groups (if any) that the device has been logged into. The Success
return code is only an indication that the command is syntactically correct but does not
indicate the status of the affected id being logged into any hunt group.
CONFIRMATION: <Sequence_Number>,CF,_SA,<InvokeID>,<Outcome><CR><LF>
COMMON FAILURE
OUTCOME VALUES: Generic_Unspecified (1): The <Agent_State> parameter is blank or invalid, or it contains
invalid characters. This failure notification is also returned if the agent is currently logged in to
another extension.
Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command, or the <Affected_Ext> is not a member of any ACD group.
Invalid_Device_Identifier (9): The <Affected_Ext>, <Agent_ID>, or <ACD_Group> parameter
is blank or invalid.
Invalid_Destination (11): The <Affected_Ext> is not a member of the <ACD_Group>.
Generic_State_Incompatibility (15): The <Agent_State> parameter is not compatible with
the current state of the <Affected_Ext>.
DESKTOP OAI: None
EXAMPLE: Log ACD agent 100 into ACD group 261 at extension 100.
_SA,<InvokeID>,100,100,1,261
001,CF,_SA,<InvokeID>,0

 */
public class SetAgentState {

}
