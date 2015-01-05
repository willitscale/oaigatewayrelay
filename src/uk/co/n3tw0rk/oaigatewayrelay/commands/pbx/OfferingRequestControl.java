package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

OFFERING REQUEST CONTROL – _ORC
NOTE: This command is available only in protocol versions 07.00 and later.
USE: Allows an application to redirect calls before they actually ring a station (see page 141 for
types of calls that cannot be redirected). The application receives an Offered event (see
page 71) when the station device receives a ringing call. Once the application gains control
over a station device, the application can then redirect the ringing call to another destination
(IC or CO). When offering control is enabled at a station, the phone displays ROUTING
ENABLED for a few seconds.
In V09.00 and later, an application can query the offering state of a specific device using the
_ORC command and specifying a timeout value of 0.
NOTE: To avoid conflict and a potentially unpredictable situation, two applications should never
attempt to control the same type of calls at the same device.
ALSO: The system allows station users to disable offering control (routing). To disable this
mode, users must enter the Routing Off feature code (304 at default), followed by a password.
There is no feature code to enable routing.
Offering control is available only on calls that are permitted to follow manual call forwarding.
Calls that cannot follow manual call forwarding are handled by Call Processing.
For example, the following call types do not follow manual forwards and, therefore, bypass
offering:
• Queue callbacks
• Unified Messaging calls
• Calls recalling from hold
• Transfer recalls
• Calls that were forwarded to or deflected from an invalid destination (including toll
restriction violations, unreachable destinations, invalid destinations, destinations in
DND, and forward loops)
• Unanswered hunt group calls forwarded to voice mail
• Announced transfer calls (the announcement call can follow forwards, but not the transferred
call)
• Transfer-to-hold calls (these calls do not actually ring the station device)
NOTES: The following items apply to the Offering Request Control command:
• A device monitor must already be started for the <Affected_Ext> before this command
is issued or the command will fail. If the application stops the monitor on the
<Affected_Ext>, System OAI terminates offering control.
• The controlling application can issue the Deflect Call (see page 105), Divert
to DND (see page 118), Clear Connection (see page 100), Accept Offered
Call (see page 91), or Move Call (see page 137) commands to any call in the offering
state. The Move Call command will succeed only if the device that originated the
call is on a node that supports protocol versions 07.00 or later. Attempts to move an
offered call that originated on a node running a version earlier than 07.00 with an
Invalid_Destination outcome code (11).
• The Snapshot Device (_SP) command (see page 192) does not list a call in the
offering mode.
• If the timer specified by the <Timeout> parameter expires, Call Processing handles the
call as if the application issued the _AOC (Accept Offered Call) command. If
the application fails to respond to two sequential Offered Events for a station, System
OAI terminates the application’s offering control and issues an Offering Ended
(OE) event (see page 54), indicating System OAI terminated control due to timeout failures.
PREMIUM FEATURE: System OAI Third-Party Call Control
SYNTAX
(07.00 = V <
08.00):
_ORC,<InvokeID>,<Affected_Ext>,<Timeout><CR>
SYNTAX
(V >= 08.00):
_ORC,<InvokeID>,<Affected_Ext>,<Timeout>,<Offer_Transferred_Calls><CR>
Where:
• Affected_Ext: Indicates a keyset, single-line station, or modem (Axxess only).
• Timeout: (Optional) Indicates how long (in tenths of a second) the system will wait for
the application to issue a routing command to an eligible call. The valid range is 1 - 50.
The default value is 30 (three seconds).
• Offer_Transferred_Calls: (Optional) Indicates the type of transferred calls offered at
the <Affected_Ext>. If enabled (set to 1), both announcement and transferred calls are
offered at the <Affected_Ext>. If disabled (set to 0), only announcement calls are
offered, unless the calls are transferred via an announcement or Auto Attendant.
NOTE: One-step transfers are always offered.
CONFIRMATION
(V<=8.10):
<Sequence_Number>,CF,_ORC,<InvokeID>,<Outcome>,<Affected_Ext><CR><LF>
CONFIRMATION
(V > 08.10):
If <Affected_Ext> is in offering for this application:
CF,_ORC,<InvokeId>,0,<Affected_Ext>
If <Affected_Ext> is in offering, just not by this application:
CF,_ORC,<InvokeID>,48,<Affected_Ext>,|PortThatHasControl|
where
PortThatHasControl is a | delimited field and will contain either the
serial port identifier when the application that has control is using
a serial port, or the IP address of the remote end of a TCP/IP Level
two OAI socket connection where the application has offering control
of the device. This field is only reported if the return code specified
is 48. This value is also reported in the event that a true
offering request returns a return code of 48 as well (for consistency).
If <Affected_Ext> is not presently under offering control:
CF,_ORC,<InvokeId>,10,<Affected_Ext>
COMMON FAILURE
OUTCOME VALUES:
Request_Incompatible_With_Object (3): The <Affected_Ext> parameter is a valid extension
but is not a keyset, single-line set, or modem (Axxess only).
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is invalid.
Value Out of Range (31): The <Timeout> parameter is not within the allowed range.
Other_App_Has_Control (48): Another application already has offering control over the
specified device.
Invalid_Device_Monitor (50): The <Affected_Ext> parameter specifies a device that is not
being monitored.
DESKTOP OAI: None
GATEWAY IMPACT: This command is available only in CT Gateway versions 3.0 and later.
EXAMPLES: Request offering control over station 100.
_ORC,245,100
003,CF,_ORC,245,0,100
Request offering control over station 101 with a 0.5 second timeout.
_ORC,3,101,5
005,CF,_ORC,3,0,101
Request offering control over station 101 with a 0.5 second timeout, and allow transferred
calls.
_ORC,3,101,5,1
005,CF,_ORC,3,0,101

TROUBLESHOOTING
TIP:

SYMPTOM PROBABLE CAUSE RESOLUTION
The Offering command fails
with a return code indicating
value out of range.
Either the node does not
have the proper Axxess/
Inter-Tel 5000 version, or the
CT Gateway is not the
proper version (4.200).
Verify versions of nodes and
CT Gateway.
 */
public class OfferingRequestControl {

}
