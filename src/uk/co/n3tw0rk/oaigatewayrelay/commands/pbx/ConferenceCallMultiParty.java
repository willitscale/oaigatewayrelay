package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

CONFERENCE CALL (MULTI-PARTY) – _CM
USE: Sets up a multi-party conference call with a single command. The calls that form the conference
must already be on hold or connected (i.e., in a talking state), and a maximum of three
calls can be pulled together.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _CM,<InvokeID>,<Affected_Ext>,<Number_Of_Parties>,
<Call_ID #1>,.....,<Call_ID #n><CR>
Where:
• Affected_Ext: Indicates a keyset (online) or a single-line set (online).
• Number_Of_Parties: Indicates the number of Call IDs (the number of devices in the
conference) that follow. If zero, no other fields follow.
• Call_ID #1: Shows the Call ID of the first call to connect to the conference.
• Call_ID #n: Indicates the Call ID of the nth call to connect to the conference.
CONFIRMATION: <Sequence_Number>,CF,_CM,<InvokeID>,<Outcome>,<Cnf_Controller_Ext>,
<Cnf_Call_ID>,<Number_Of_Devices>,<Device_Ext #1>,
<Call_ID #1>.....<CR><LF>
Where:
• Cnf_Controller_Ext: Identifies the extension of the device that formed the conference.
This is the same as the <Affected_Ext>.
• Cnf_Call_ID: Indicates the ID of the resulting call at the <Cnf_Controller_Ext>.
• Number_Of_Devices: Displays the number of devices in the conference. If zero, no
other fields follow.
• Device_Ext #1: Identifies the extension number of the first device involved in the conference.
• Call_ID #1: Indicates the ID of the call that connects <Device_Ext #1> to the conference.
• Device_Ext #n: Identifies the extension number of the nth device involved in the conference.
• Call_ID #n: Indicates the ID of the nth call that connects the nth device to the conference.
COMMON FAILURE
OUTCOME VALUES:
Generic_Unspecified (1): The <Number_Of_Parties> parameter is invalid.
Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command.
Invalid_Call_Identifier (8): The correct number of <Call_ID> parameters are not present, or
they are invalid.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
Generic_State_Incompatibility (15): The specified calls are not in the necessary state.
Resource_Busy (24): There are no conference circuits available in the system.
Conference_Member_Limit_Exceeded (27): This command is attempting to conference too
many parties (more than four).
DESKTOP OAI: _O
EXAMPLE: Set up a conference call with three other parties on extension 107.
_CM,<InvokeID>,107,3,@103,@137,@199
001,CF,_CM,<InvokeID>,0,107,@005,4,100,@005,101,@103,102,@137,107,
@199

 */
public class ConferenceCallMultiParty {

}
