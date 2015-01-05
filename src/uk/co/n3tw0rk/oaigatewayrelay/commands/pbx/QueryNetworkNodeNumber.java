package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

QUERY NETWORK NODE NUMBER – _QN
NOTE: This command is available only in protocol versions 05.00 and later.
 USE: Returns the node number of the system. A non-networked system will always return Node 1.
PREMIUM FEATURE: System OAI Events or Third-Party Call Control
SYNTAX: _QN,<InvokeID>,<Affected_Ext><CR>
Where the <Affected_Ext> may specify the system node, using the Node: format or any valid
extension on the system node, or it can be blank. When sent to a Gateway with a blank
<Affected_Ext>, the Gateway queries every node and returns a list of all phone system connections.
NOTE: Only protocol versions 05.10 and later support the node number followed by a colon.
CONFIRMATION: <Sequence_Number>,CF,_QN,<InvokeID>,<Outcome>,
<Number_Of_Nodes_To_Report>,<Node_Data 1>,<Node_Data N><CR><LF>
Where:
• Number_Of_Nodes_To_Report: Indicates the total number of nodes reporting. If the
command was sent to a single node or specified an <Affected_Ext>, this value is “1”;
otherwise, it is the number of nodes that the Gateway queried.
• <Node_Data>: Includes the following:
— Node_Number: Identifies the number of the node configured with the Gateway.
— PC_Description: Provides a brief description of the node’s PC (<|Description|>).
EXAMPLES: _QN,<InvokeID>,1000
001,CF,_QN,<InvokeID>,0,1,4,|Node 4|
The command is sent to a Gateway that is communicating with two nodes.
_QN,<InvokeID>
001,CF,_QN,<InvokdeID>,0,2,1,|Node 1|,2,|Node 2|

 */
public class QueryNetworkNodeNumber {

}
