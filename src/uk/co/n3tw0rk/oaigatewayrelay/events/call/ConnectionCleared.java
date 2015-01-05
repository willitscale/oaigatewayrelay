package uk.co.n3tw0rk.oaigatewayrelay.events.call;

/**
 * 
CONNECTION CLEARED – XC
USE: Occurs when a connection that was on a device terminates. These events are sent any time a
monitored device hangs up or otherwise drops out of a call. The <Call_ID> and call may still
be alive in the system at other extension(s), but the connection to the specified extension
(<Cleared_Ext>) is terminated (e.g., one device drops out of a conference).
NOTE: A Connection Cleared event does not necessarily mean that a handset has been
replaced.
MONITOR TYPE: Device, Call via Device, Call (generated only when a device clears from a call, but the call
itself is not clearing)
SYNTAX: XC,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,<Cleared_Ext>,
<Terminating_Ext>,<Local_Cnx_State>,<Event_Cause><CR><LF>
Where:
• Cleared_Ext: Identifies the device that is no longer involved in the call. For CO calls,
this in the internal trunk extension used for the call.
• Terminating_Ext: Indicates the device that initiated the termination of this connection.
For example, in a two-party call, this is the device that went on-hook first. For CO calls,
this is the trunk extension used for the call.
EXAMPLES: Extension 100 initiates clearing a connection established to extension 101.
001,XC,,<MON100>,65789,100,100,N,36
002,XC,,<MON101>,65789,100,100,,36
003,XC,,<MON101>,65789,101,100,N,36
Extension 101 initiates clearing a connection established to extension 100.
001,XC,,<MON101>,65789,101,101,N,36
002,XC,,<MON100>,65789,101,101,,36
003,XC,,<MON100>,65789,100,101,N,36
 */

public class ConnectionCleared {

}
