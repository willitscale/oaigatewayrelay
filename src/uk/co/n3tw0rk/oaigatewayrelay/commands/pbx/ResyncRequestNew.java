package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

RESYNC REQUEST – _RR
NOTE: This command is available only on versions 6.0 and later.
ALSO: Do not issue another command until the resync completes.
USE: Resynchronizes the phone system and the application. This should be sent whenever the application
suspects that it may have missed some events and is out of synchronization with the
phone system. In response, the phone system will send the Resync Request confirmation, followed
by numerous other events, to provide a complete refresh of the status of all stations
monitored (or one specific monitor if <Affected_Ext> is not blank) by the application. After all
of the resync-generated events are issued, the phone system sends a Resync Ended (RD)
event (see page 73) to indicate that the resync has completed.
After initiating a system resync of all device monitors, applications should avoid sending any
further commands until receiving the Resync Ended event. Depending on the number of
monitors, it could take the telephone system several minutes to send all of the events that
resulted from the resync. In addition, the telephone system does not send any events until the
Resync Ended event is generated. Applications, therefore, may not receive some events
until several minutes after the event occurred.
NOTES: This command replaces the RR resync command (in versions prior to 6.0). All applications
should use this new command because support for the RR command will eventually be discontinued.
To avoid being overloaded by an errant attached application, the system will honor requests
without a <Specific_Extension> only if they are at least three minutes apart. This timer is configurable
in the phone system’s Database Programming (online monitor mode only) and in the
CT Gateway (Application Resync Interval, which is programmable in the Application Settings
screen).
The events that are generated as a result of this command contain the <InvokeID> in the
<Resync_Code> field, providing a tracking mechanism for determining which command generated
which event(s).
The sequence number is not reset with this command. In addition, this command does not generate
a Resync Response (RS).
PREMIUM FEATURE: System OAI Events or Third-Party Call Control
SYNTAX: _RR,<InvokeID>,<Affected_Ext><CR>
Where <Affected_Ext> is required only to receive resync information on a specific device. If
blank, the system will send resync information on all devices being monitored by the attached
computer. If <Affected_Ext> specifies the system node, the system will send resync information
on all monitored devices on the specified node.
CONFIRMATION: <Sequence_Number>,CF,_RR,<InvokeID>,<Outcome>,<Affected_Ext><CR>
Where <Affected_Ext> is required only to receive resync information on a specific device. If
blank, the system will send resync information on all devices being monitored by the attached
computer. If <Affected_Ext> specifies the system node, the system will send resync information
on all monitored devices on the specified node.
COMMON FAILURE
OUTCOME VALUES:
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is invalid.
Invalid_Object_State (14): The <Affected_Ext> parameter specifies a device that is not being
monitored. If the <Affected_Ext> is a node specified in the node-colon format, this failure
does not apply. Instead, the command will succeed with Resync Ended (RD) as the only
resync event.
GATEWAY IMPACTS: The CT Gateway versions 2.0 and later support this command and know the protocol level of
every node as well as the scope of every application. When the CT Gateway receives an _RR
command that is for a specific device or node, the CT Gateway verifies that the application is
using that node (if not, code 9 is returned to the application). The Gateway then verifies that
the protocol level of the node that will receive the command is version 6.0 or later (if not, code
45 is returned).
If the _RR command is for the entire system, the CT Gateway first verifies that the applications
is currently running at protocol level 6.0 or later. This requires all nodes in the scope of
the application to be protocol version 6.0 or later.
The CT Gateway does not convert one resync command to another; therefore, an _RR command
from an application is subject to the validation stated above. Also, RR commands may
still be used if specified by the application.
EXAMPLES: Request resynchronization of extension 100 when it is connected to a call, has a call on hold,
and is DND.
_RR,245,100
003,CF,_RR,245,0,100
004,ES,245,<MON100>,2001,101,,|,100,,,|,101,,C,35
005,HE,245,<MON100>,222,100,H,39
006,DND,245,<MON100>,100,|OUT TO LUNCH|,|UNTIL 1PM|
007,FW,245,<MON100>,,,N
008,RD,245,100
Request resynchronization of all monitored devices.
_RR,974
003,CF,_RR,974,0
[Resync Events]...
008,RD,974,
NOTE: All events have “974” in the <Resync_Code> field.
Request resynchronization of all monitored devices on node 1 when no devices are monitored.
_RR,541,1:
003,CF,_RR,541,0,1:
004,RD,541,1:
Request resynchronization of extension 100 when it is not monitored.
_RR,974,100
003,CF,_RR,974,14,100
Request resynchronization all monitored devices when no devices are monitored.
_RR,974
003,CF,_RR,974,0
004,RD,974,

 */
public class ResyncRequestNew {

}
