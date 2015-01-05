package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

RESYNC REQUEST – RR
NOTE: This command will eventually be phased out and replaced by the _RR command.
ALSO: Do not issue another command until the resync completes.
USE: Resynchronizes the phone system and the application. This should be sent whenever the application
suspects that it may have missed some events and is out of synchronization with the
phone system. In response, the phone system will send a Resync Response event (see
page 73), followed by numerous other events, to provide a complete refresh of the status of all
stations monitored by the application.
During a global system resync, the Gateway will not process any incoming command requests.
These command requests will be “queued” and handled when the Resync Ended is generated
(see page 73). Also, if there are many monitors active on the switching nodes, the Resync
will cause a large amount of data to be sent, which may take several minutes, prior to the
Resync Ended. After the Resync Ended is sent, any events that had occurred while
waiting for the resync data to be output are generated. These events may not be usable for
third-party call control because they were delayed for some period of time.
With systems prior to protocol version 05.10 (the RD event was added in V05.10), the CTI
application will have to monitor the data it is receiving and not send another command. The
application must not send another command until it either receives a non-resync-generated
event, or it times out waiting for a resync-generated event that was not received.
NOTE: To avoid being overloaded by an errant attached application, the system will honor
requests without a <Specific_Extension> only if they are at least three minutes apart.
PREMIUM FEATURE: System OAI Events or Third-Party Call Control
SYNTAX: RR,<Specific_Extension><CR>
NOTE: The <InvokeID> and <Affected_Ext> parameters are not required and not allowed.
Where <Specific_Extension> is required only to receive resync information on a specific station.
If blank, the system will send resync information on all devices being monitored by the
attached computer. If this field specifies the system node, the system sends resync information
on all monitored devices on the specified node.
EXAMPLES: Request resynchronization of all monitored devices.
RR
000,RS,1,05:25,012400,V05.20,V05.200,3,1,1,1
(Followed by current status of all monitored devices.)
Request resynchronization of a specific device.
RR,100
000,RS,1,05:25,012400,V05.20,V05.200,3,1,1,1
(Followed by current status of Extension 100.)
Request resynchronization of all node 2 monitors (Gateway only).
RR,2:
000,RS,1,05:25,012400,V05.20,V05.200,3,2,1,1

 */
public class ResyncRequest {

}
