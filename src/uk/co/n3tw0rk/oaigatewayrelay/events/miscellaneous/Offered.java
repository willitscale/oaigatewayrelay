package uk.co.n3tw0rk.oaigatewayrelay.events.miscellaneous;

/**
 * 
 * @author M00SEMARKTWO

OFFERED – OF
NOTE: This event is available only in protocol versions 07.00 and later.
USE: Allows an application to redirect calls that arrive at a specific station (keyset or single-line)
before the call rings the station or follows any programmed forwards or DND.
When a call arrives at the controlled station device, the phone system generates this event to
allow the application to change the call’s destination before the station device rings. An application
must gain offering control over the station to enable this mode, and only one application
can have offering control at each station.
NOTE: To avoid conflict and a potentially unpredictable situation, two applications should never
attempt to control the same type of calls at the same device.
ALSO: The system allows station users to disable offering control (routing). To disable this
mode, users must enter the Routing Off feature code (304 at default), followed by a password.
Station users, however, cannot enable offering control once it is disabled.
Calls in the offering mode are in a pre-delivery state at the target station. While in this state,
the controlling application can redirect the call, using one of the following commands:
• Deflect Call (_DF); see page 105
• Divert to DND (_DD); see page 118
• Clear Connection (_CX); see page 100
• Accept Offered Call (_AOC); see page 91
• Move Call (_MO); see page 137
NOTES: The following information applies to the Offered event:
• This event does not show up in the filter list of the monitor for the station device. The
only way for an application to receive this event is by sending Offering Request
Control (_ORC) command (see page 141) over the station device.
• This event is generated under the <Mon_Cross_Ref_ID> of the device monitor on the
station device.
• Once this event is generated, the _ORC command timer (<Timeout>; see page 142) is
started, and the system waits for the application to send one of the commands listed
above. If the timer expires (three seconds at default), Call Processing routes the call as
if the application issued the _AOC command. If the application fails to respond to two
sequential offered events for a device, System OAI terminates the application’s offering
control and issues an Offering Ended (OE) event (see page 54), indicating that System
OAI terminated control due to timeout failures.
• This event contains the same information as the Delivered (DE) event (see page 30).
• Although this event is generated during a resync, only the application that maintains
offering sees this event during a resync.
In versions 08.10 and later, this event may not properly reflect the cause for the called device.
This inconsistency occurs when using the override functionality of the _MC, _CS, _DF, _TO,
or _MO command to call a keyset on a node that is not running protocol version 08.10. In this
case, the cause value for this device will differ depending on the command.
• For the _MC and _CS, and commands, the cause value is OVERRIDE (24), whether or
not the device is in DND.
• For the _MO, _TO, and _DF commands, the cause value is CALL FORWARD (09),
whether or not the device is in DND. If, however, the “moved to,” “deflected to,” or
“transferred to” device is in DND and on a node running version 08.10, the cause value
is OVERRIDE (24).
SYNTAX: OF,<Resync_Code>,<Mon_Cross_Ref_ID >,<Call_ID>,
<Alerting_Internal_Ext>,<Alerting_Outside_Number>,
<Alerting_Device_Type>,<Internal_Calling_Ext>,
<Outside_Caller_Name>,<Outside_Caller_Number>,
<Trunk_Name>,<Trunk_Outside_Number>,<Calling_Device_Type>,
<Originally_Called_Dev>,<Last_Redirection_Ext>,<Account_Code>,
<Local_Cnx_State>,<Event_Cause>,<Hunt_Group_ID><CR><LF>
See page 30 (Delivered event) for information about each parameter.
GATEWAY IMPACT: This event is available only in CT Gateway versions 3.0 and later.
 */
public class Offered {

}
