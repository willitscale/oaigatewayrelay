package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

MONITOR STOP – _MP
USE: Terminates the monitor session specified by <Mon_Cross_Ref_ID>.
PREMIUM FEATURE: System OAI Events or Third-Party Call Control
SYNTAX: _MP,<InvokeID>,<Mon_Cross_Ref_ID><CR>
Where <Mon_Cross_Ref_ID> is optional. If blank, the command stops all monitors.
CONFIRMATION: <Sequence_Number>,CF,_MP,<InvokeID>,<Outcome><CR><LF>
COMMON FAILURE
OUTCOME VALUES:
Generic_Unspecified (1): The phone system was unable to process the command.
Invalid_Mon_Cross_Ref_ID (12): The <Mon_Cross_Ref_ID> is specified but invalid.
DESKTOP OAI: None
EXAMPLE: Terminate the event reporting on Monitor Cross-Reference ID 1.
_MP,<InvokeID>,1
001,CF,_MP,<InvokeID>,0

 */
public class MonitorStop {

}
