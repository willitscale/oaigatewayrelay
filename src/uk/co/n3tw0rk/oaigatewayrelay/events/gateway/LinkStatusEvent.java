package uk.co.n3tw0rk.oaigatewayrelay.events.gateway;

/**
 * 
 * @author M00SEMARKTWO

LINK STATUS EVENT – LS
USE: Generates link status messages to the application. These messages allow the application to
inform users that connections to various OAI ports have been lost.
SYNTAX: LS,<Resync_Code>,<Node_Number>,<Link_Status>,<Reason_Code><CR><LF>
Where:
• Node_Number: Indicates the number of the node reporting the status.
NOTE: If an application connects directly to a Switch Transceiver, the
<Node_Number> field could be empty.
• Link_Status: Indicates if the link is up (1) or down (0).
• Reason_Code: Identifies why the connection state changed. This code can be one of the
following:
0 = Unknown
1 = RS232 Connection Failure (Axxess only)
2 = RS232 Reconnect (Axxess only)
3 = TCP/IP Connection Failure
4 = TCP/IP Reconnect
5 = Added Node
6 = Deleted Node
7 = Timed Out

 */

public class LinkStatusEvent {

}
