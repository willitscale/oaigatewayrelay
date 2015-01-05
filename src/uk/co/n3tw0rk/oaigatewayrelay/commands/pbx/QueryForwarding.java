package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

QUERY FORWARDING – _QF
USE: Provides the current state of the manual forwarding feature on the specified device.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _QF,<InvokeID>,<Affected_Ext><CR>
Where valid device types for the <Affected_Ext> includes keysets or single-line sets.
CONFIRMATION: <Sequence_Number>,CF,_QF,<InvokeID>,<Outcome>,<FWD_Type>,
<Destination_Ext><CR><LF>
Where:
• Destination_Ext: Indicates the destination of the manual forward. If the device is manually
forwarded to the public network, this is the trunk access code followed by the outside
number.
• FWD_Type: Indicates the type of manual forwarding enabled at <Affected_Ext> (see
Table 6 on page 15 for a list of types).
COMMON FAILURE
OUTCOME VALUES: Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
DESKTOP OAI: None
EXAMPLES: Extension 100 is manually forwarded (no-answer) to extension 101.
_QF,<InvokeID>,100
001,CF,_QF,<InvokeID>,0,NA,101
Extension 100 has manual forwarding disabled.
_QF, <InvokeID>,100
001,CF,_QF,<InvokeID>,0,N
Extension 100 is manually forwarded immediate to 961-9000.
_QF,<InvokeID>,100
001,CF,_QF,<InvokeID>,0,I,89619000

 */
public class QueryForwarding {

}
