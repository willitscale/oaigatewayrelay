package uk.co.n3tw0rk.oaigatewayrelay.events.agent;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Agent;

/**
 * <strong>Work Not Ready Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 28-12-2014
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 27
 * 
 * WORK NOT READY – WNR
 * 
 * USE: 
 * 		Occurs when an agent at a device is busy serving the previous ACD call and is not yet available
 * 		to receive further ACD calls.
 * 
 * MONITOR TYPE: 
 * 		Device
 * 
 * SYNTAX: 
 * 		WNR,<Resync_Code>,<Mon_Cross_Ref_ID>,<Device_Ext>,<Agent_ID><CR><LF>
 * 
 * Where:
 * 		• Device_Ext: Identifies the extension number where the agent is logged in.
 * 		• Agent_ID: Indicates the ID of the agent moving into the Work Not Ready state.
 * 
 * EXAMPLE: 
 * 		Agent number 2003 at extension 105 is now “wrapping up” work from the previous call.
 * 		001,WNR,,<MON105>,105,2003
 */
public class WorkNotReady extends Agent
{
	public final static String EVENT = "WNR";
	
	public WorkNotReady( String[] eventParts )
	{
		super( eventParts );
	}
	
	public WorkNotReady( String event )
	{
		super( event );
	}
}