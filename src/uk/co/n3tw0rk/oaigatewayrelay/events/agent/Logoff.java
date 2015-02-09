package uk.co.n3tw0rk.oaigatewayrelay.events.agent;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.AgentLog;

/**
 * <strong>Logoff Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 28-12-2014
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 25
 *
 * 	LOGOFF – LF
 * 
 *	USE:
 *		Occurs when an agent logs out of an ACD hunt group. In protocol versions prior to 04.30, the
 *		phone system generates this event only under a Device-type monitor for the station where the
 *		ACD agent logged out. In protocol versions 04.30 and later, the phone system generates this
 *		event under a Device-type monitor for the ACD group where the ACD agent logged out (i.e.,
 *		you can monitor the group instead of only the individual stations).
 *
 *	MONITOR TYPE: 
 *		Device
 *
 *	SYNTAX: 
 *		LF,<Resync_Code>,<Mon_Cross_Ref_ID>,<Device_Ext>,<Agent_ID>,<Agent_Description>,<ACD_Hunt_Group><CR><LF>
 *
 *	Where:
 *		• Device_Ext: Identifies the extension number where the agent logged out.
 *		• Agent_ID: Indicates the ID of the agent logging out of the hunt group.
 *		• Agent_Description: Specifies the name of the agent logging out.
 *		• ACD_Hunt_Group: Indicates the extension number of the ACD hunt group where the agent is logging out.
 *
 *	EXAMPLES: 
 *		Agent number 2003 logs out of ACD hunt group 237 at extension 105, and device 105 is monitored.
 *		001,LF,,<MON105>,105,2003,|Jones, Bob|,237
 *		The Agent ID is also monitored.
 *		002,LF,,<MON2003>,105,2003,|Jones, Bob|,237
 *		And, the hunt group is monitored.
 *		003,LF,,<MON237>,105,2003,|Jones, Bob|,237
 */
public class Logoff extends AgentLog
{
	public final static String EVENT = "LF";
	
	public Logoff( String[] eventParts )
	{
		super( eventParts );
	}
	
	public Logoff( String event )
	{
		super( event );
	}

	@Override
	public void process()
	{
	}
}