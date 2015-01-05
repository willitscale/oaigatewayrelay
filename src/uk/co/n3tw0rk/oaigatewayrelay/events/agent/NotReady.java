package uk.co.n3tw0rk.oaigatewayrelay.events.agent;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Agent;

/**
 * <strong>Not Ready Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 28-12-2014
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 26
 * 
 * 	NOT READY – NRY
 * 
 * 	USE: 
 * 		Occurs when an agent at a device is no longer available to receive ACD calls (e.g., the agent
 * 		initiated an outgoing call, answered a call, or went off-hook).
 * 
 * 	MONITOR TYPE: 
 * 		Device
 * 
 *	SYNTAX: 
 * 		NRY,<Resync_Code>,<Mon_Cross_Ref_ID>,<Device_Ext>,<Agent_ID><CR><LF>
 * 
 *	Where:
 * 		• Device_Ext: Identifies the extension number where the agent is logged in.
 * 		• Agent_ID: Indicates the ID of the agent moving into the Not Ready state.
 * 
 * 	EXAMPLE: 
 * 		Agent number 2003 at extension 105 is no longer ready to receive calls.
 * 		001,NRY,,<MON105>,105,2003
 * 
 */
public class NotReady extends Agent
{
	public final static String EVENT = "NRY";

	public NotReady( String[] eventParts )
	{
		super( eventParts );
	}
	
	public NotReady( String event )
	{
		super( event );
	}
}