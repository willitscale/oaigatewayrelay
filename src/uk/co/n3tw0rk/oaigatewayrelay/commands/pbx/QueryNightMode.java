package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

QUERY NIGHT MODE – _QT
NOTE: This command is available only in protocol versions 05.10 and later.
USE: Returns the night mode status of the system.
PREMIUM FEATURE: System OAI Events or Third-Party Call Control
SYNTAX: _QT,<InvokeID>,<Affected_Ext><CR>
Where the <Affected_Ext> may specify the system node, using the Node: format, or any
valid extension on the system node, or it may be blank. If the <Affected_Ext> parameter is
blank, the Gateway will pick one node to query.
NOTE: Only protocol versions 05.10 and later support the node number followed by a colon.
CONFIRMATION: <Sequence_Number>,CF,QT,<InvokeID>,<Outcome>,<On/Off><CR><LF>
Where <On/Off> is a boolean parameter indicating that night mode is on (1) or off (0).
COMMON FAILURE
OUTCOME VALUE:
Invalid_Device_Identifier (9): The device specified by <Affected_Ext> is invalid or does not
exist.
DESKTOP OAI: None
EXAMPLES: The system is in night mode.
_QT,<InvokeID>
001,CF,_QT,<InvokeID>,0,1
The system is not is night mode.
_QT,<InvokeID>
001,CF,_Qt,<InvokeID>,0,0

 */
public class QueryNightMode {

}
