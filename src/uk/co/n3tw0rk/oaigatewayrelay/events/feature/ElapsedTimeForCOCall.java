package uk.co.n3tw0rk.oaigatewayrelay.events.feature;

/**
 * 
 * @author M00SEMARKTWO

ELAPSED TIME FOR CO CALL – ET
USE: Occurs when a station connects to a CO call.
MONITOR TYPE: Device
SYNTAX: ET,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,
<Affected_Ext>,<Number_of_Elapsed_Seconds><CR><LF>
Where:
• Call_ID: Identifies the connected call.
• Affected_Ext: Indicates the station connected to the CO call.
• Number_of_Elapsed_Seconds: Indicates the total number of seconds that this call has
been in the system.
EXAMPLE: Extension 1000 answers an incoming CO call that has been in the system for five minutes.
001,ET,<MON1000>,1000,@001,300

 */
public class ElapsedTimeForCOCall {

}
