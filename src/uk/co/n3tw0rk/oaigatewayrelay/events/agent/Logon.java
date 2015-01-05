package uk.co.n3tw0rk.oaigatewayrelay.events.agent;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Agent;

/**
 * <strong>Logon Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 28-12-2014
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 26
 *
 *	LOGON – LN
 *
 *	USE: 
 *		Occurs when an agent logs in to a hunt group to begin receiving ACD calls at a specific device.
 *		In protocol versions prior to 04.30, the phone system generates this event only under a Devicetype
 *		monitor for the station where the ACD agent logged in. In protocol versions 04.30 and
 *		later, the phone system generates this event under a Device-type monitor for the ACD group
 *		where the ACD agent logged in (i.e., you can monitor the group instead of only the individual
 *		stations).
 *
 *	MONITOR TYPE: 
 *		Device
 *
 *	SYNTAX: 
 *		LN,<Resync_Code>,<Mon_Cross_Ref_ID>,<Device_Ext>,<Agent_ID>,<Agent_Description>,<ACD_Hunt_Group><CR><LF>
 *
 *	Where:
 *		• Device_Ext: Identifies the extension number where the agent logged in.
 *		• Agent_ID: Indicates the ID of the agent logging in to the hunt group.
 *		• Agent_Description: Specifies the name of the agent logging in.
 *		• ACD_Hunt_Group: Indicates the extension number of the ACD hunt group where the agent is logging in.
 *
 *	EXAMPLE: 
 *		Agent number 2003 logs in to ACD hunt group 237 at extension 105.
 *		001,LN,,<MON105>,105,2003,|Jones, Bob|,237
 */
public class Logon extends Agent
{
	public final static String EVENT = "LN";

	public Logon( String[] eventParts )
	{
		super( eventParts );
	}

	public Logon( String event )
	{
		super( event );
	}
}
