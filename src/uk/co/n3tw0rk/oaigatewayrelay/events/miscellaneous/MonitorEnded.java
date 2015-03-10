package uk.co.n3tw0rk.oaigatewayrelay.events.miscellaneous;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Miscellaneous;

/**
 * <strong>Monitor Ended Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 10-03-2015
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 70
 *
 *	MONITOR ENDED – ME
 *  
 *  USE: 
 * 		Occurs when the system can no longer provide the requested events associated with the specified
 * 		<Mon_Cross_Ref_ID>. This event is unsolicited.
 * 
 * 	MONITOR TYPE: 
 * 		Call, Call via Device, Device
 * 
 * 	SYNTAX: 
 * 		ME,<Resync_Code>,<Mon_Cross_Ref_ID>,<Event_Cause><CR><LF>
 * 
 * 	EXAMPLE: 
 * 		A monitor session (Cross-Reference ID 1) associated with extension 100 can no longer be
 * 		provided because extension 100 becomes unequipped.
 * 		001,ME,,001,36
 */
public class MonitorEnded extends Miscellaneous
{
	protected int mEventCause;
	
	public MonitorEnded( String eventParts )
	{
		super( eventParts );
	}

	public MonitorEnded( String[] eventParts )
	{
		super( eventParts );
	}
	
	public MonitorEnded setEventCause( int eventCause )
	{
		this.mEventCause = eventCause;
		return this;
	}
	
	public int getEventCause()
	{
		return this.mEventCause;
	}
	
	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <Event_Cause>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setEventCause( this.getIntPart( 4 ) );
	}

	@Override
	public void process()
	{
	}

}
