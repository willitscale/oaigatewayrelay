package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

CONFERENCE CALL – _CN
USE: Sets up a conference when a call is already on hold and another call is connected to the
<Affected_Ext>.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _CN,<InvokeID>,<Affected_Ext>,<Held_Call_ID>,
<Active_Call_ID><CR>
Where:
• Affected_Ext: Indicates a keyset (online) or a single-line set (off-hook and online).
• Held_Call_ID: Indicates the ID of the call on hold.
• Active_Call_ID: Indicates the ID of the active (connected) call.
CONFIRMATION: <Sequence_Number>,CF,_CN,<InvokeID>,<Outcome>,<Cnf_Controller_Ext>,
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
OUTCOME VALUES: Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command.
Invalid_Call_Identifier (8): Either the <Held_Call_ID> or the <Active_Call_ID> parameter
is blank or invalid.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
Generic_State_Incompatibility (15): The specified calls are not in the necessary state, or the
system was unable to put the active call on hold.
Resource_Busy (24): The phone system could not allocate a conference circuit, or there are no
conference circuits available.
Conference_Member_Limit_Exceeded (27): This command is attempting to conference too
many parties (more than four).
DESKTOP OAI: None
EXAMPLE: Extension 100 has extension 101 on conference-wait hold (@001) and is connected to
extension 102 (@002).
_CN,<InvokeID>,100,@001,@002
001,CF,_CN,<InvokeID>,0,100,@003,3,100,@003,101,@001,102,@002

 */
public class ConferenceCall {

}
