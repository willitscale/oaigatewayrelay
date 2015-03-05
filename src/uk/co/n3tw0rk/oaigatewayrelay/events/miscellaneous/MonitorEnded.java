package uk.co.n3tw0rk.oaigatewayrelay.events.miscellaneous;

/**
 * 
 * @author M00SEMARKTWO
 *
 *
 *
 * 		MONITOR ENDED – ME
 *  	USE: 
 * 		Occurs when the system can no longer provide the requested events associated with the specified
 * 		<Mon_Cross_Ref_ID>. This event is unsolicited.
MONITOR TYPE: Call, Call via Device, Device
SYNTAX: ME,<Resync_Code>,<Mon_Cross_Ref_ID>,<Event_Cause><CR><LF>
EXAMPLE: A monitor session (Cross-Reference ID 1) associated with extension 100 can no longer be
provided because extension 100 becomes unequipped.
001,ME,,001,36
 */

public class MonitorEnded
{

}
