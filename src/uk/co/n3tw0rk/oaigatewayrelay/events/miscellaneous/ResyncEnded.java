package uk.co.n3tw0rk.oaigatewayrelay.events.miscellaneous;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Event;

/**
 * 
 * @author M00SEMARKTWO

RESYNC ENDED – RD
USE: Sent when a resync is completed, including resync requests, a monitor start on all stations with
a resync request, a monitor start on a single device with a resync request, and power-up
resyncs. This does NOT include the Resync Time (RT) command.
MONITOR TYPE: No monitor required.
SYNTAX
(V >= 5.10):
RD,<Resync_Code>,<Specific_Extension><CR><LF>
Where <Specific_Extension> identifies the device that has just completed a resync request. If
blank, the resync request was a global system resync.
EXAMPLES: A Resync Request for the device specified by extension 1000 has just completed.
RR,1000
000,RS,1,<Time>,<Date>,<Protocol_Version>,<KSU_Software_Version>,
<Premium_Feature_Status>,<Node_Number>,
<Networking_Enabled/Disabled>,<Country_Code>
001,DND,1,<Mon_Cross_Ref_ID>,1000,,
002,FW,1,<Mon_Cross_Ref_ID>,1000,,,N
003,RD,1,1000
A Resync Request for the entire system has just completed.
RR
000,RS,1,<Time>,<Date>,<Protocol_Version>,<KSU_Software_Version>,
Premium_Feature_Status>,<Node_Number>,
<Networking_Enabled/Disabled>,<Country_Code>
001,RD,1,
A monitor start with a resync command for extension 1000 has just completed.
_MS,1,1000,5
001,CF,_MS,1,0,1,<Mon_Cross_Ref_ID>
002,DND,1,<Mon_Cross_Ref_ID>,1000,,
003,FW,1,<Mon_Cross_Ref_ID>,1000,,,N
004,RD,1,1000

 */
public class ResyncEnded extends Event
{
	public static final String EVENT = "RD";
	
	public ResyncEnded( String[] eventString )
	{
		super( eventString );
	}

	@Override
	protected void parseEvent()
	{
	}

	@Override
	public void process()
	{
	}
}
