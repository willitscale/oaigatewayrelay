package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

QUERY EVENT FILTER – _QE
NOTE: This command is available only in protocol versions 05.00 and later.
USE: Queries the event filters associated with a monitor. Typically, the user starts a monitor to monitor
some or all devices. When the Monitor Start command (_MS) is invoked, a set of filter
values can optionally be specified and can be altered using the Change Event Filter
(_CE) command (see page 93).
SYNTAX: _QE,<InvokeID>,<Mon_Cross_Ref_ID><CR>
PREMIUM FEATURE: System OAI Events or Third-Party Call Control
CONFIRMATION
(V < 05.10):
<Sequence_Number>,CF,_QE,<InvokeID>,<Outcome>,<Agent_Filter_Mask>,
<Call_Filter_Mask>,<Feature_Filter_Mask><CR><LF>
CONFIRMATION
(V >= 05.10): <Sequence_Number>,CF,_QE,<InvokeID>,<Outcome>,<System_Filter_Mask>
<CR><LF>
NOTE: This confirmation applies only if the <Mon_Cross_Ref_ID> specifies the system monitor;
otherwise, the confirmation is the same for protocol versions prior to 05.10.
ALSO: If using protocol version 05.10, the confirmation for V < 05.10 may be returned,
depending on the monitor type.
Where <Agent_>, <Call_>, <Feature_>, and <System_Event_Filter_Mask> values indicate
those filter maps after command completion.
COMMON FAILURE
OUTCOME VALUE:
Invalid_Mon_Cross_Ref_ID (12): The <Mon_Cross_Ref_ID> parameter is blank or invalid.
DESKTOP OAI: None
EXAMPLE: Display events on monitor 100.
_QE,<InvokeID>,100
001,CF,_QE,<InvokeID>,0,A:0040,C:FFF0,F:0030
Query event filter on system monitor 101.
_QE,<InvokeID>,101
001,CF,_QE,<InvokeID>,0,S:00FC

 */
public class QueryEventFilter {

}
