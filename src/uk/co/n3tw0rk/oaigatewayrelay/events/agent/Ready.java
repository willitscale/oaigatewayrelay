package uk.co.n3tw0rk.oaigatewayrelay.events.agent;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Agent;

/**
 * <strong>Ready Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 28-12-2014
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 26
 * 
 * READY – RY
 * 
 * USE: 
 * 		Occurs when an agent is now available to receive ACD calls after previously being not ready.
 * 		This means that the phone is not involved in another call nor initiating a call. Other events
 * 		must also be considered when determining if this device is really available for an ACD call
 * 		(e.g., the agent may be in do-not-disturb mode).
 * 
 * MONITOR TYPE: 
 * 		Device
 * 
 * SYNTAX: 
 * 		RY,<Resync_Code>,<Mon_Cross_Ref_ID>,<Device_Ext>,<Agent_ID><CR><LF>
 * 
 * Where:
 * 		• Device_Ext: Identifies the extension number where the agent is logged in.
 * 		• Agent_ID: Indicates the ID of the agent moving into the Ready state.
 * 
 * EXAMPLE: 
 * 		Agent number 2003 at extension 105 is now ready to receive calls again.
 * 		001,RY,,<MON105>,105,2003
 */
public class Ready extends Agent
{
	public final static String EVENT = "RY";

	public Ready( String[] eventParts )
	{
		super( eventParts );
	}
	
	public Ready( String event )
	{
		super( event );
	}
	
}