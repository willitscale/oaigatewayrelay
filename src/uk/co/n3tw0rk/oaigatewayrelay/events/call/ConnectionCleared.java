package uk.co.n3tw0rk.oaigatewayrelay.events.call;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Call;

/**
 * <strong>Connection Cleared Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 07-02-2014
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 29
 * 
 * 	CONNECTION CLEARED – XC
 * 
 * 	USE: 
 * 		Occurs when a connection that was on a device terminates. These events are sent any time a
 * 		monitored device hangs up or otherwise drops out of a call. The <Call_ID> and call may still
 * 		be alive in the system at other extension(s), but the connection to the specified extension
 * 		(<Cleared_Ext>) is terminated (e.g., one device drops out of a conference).
 * 
 * 	NOTE: 
 * 		A Connection Cleared event does not necessarily mean that a handset has been
 * 		replaced.
 * 
 * 	MONITOR TYPE: 
 * 		Device, Call via Device, Call (generated only when a device clears from a call, but the call
 * 		itself is not clearing)
 * 
 * 	SYNTAX: 
 * 		XC,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,<Cleared_Ext>,
 * 		<Terminating_Ext>,<Local_Cnx_State>,<Event_Cause><CR><LF>
 * 
 * 	Where:
 * 		• Cleared_Ext: Identifies the device that is no longer involved in the call. For CO calls,
 * 			this in the internal trunk extension used for the call.
 * 		• Terminating_Ext: Indicates the device that initiated the termination of this connection.
 * 			For example, in a two-party call, this is the device that went on-hook first. For CO calls,
 * 			this is the trunk extension used for the call.
 * 
 * 	EXAMPLES: 
 * 		Extension 100 initiates clearing a connection established to extension 101.
 * 		001,XC,,<MON100>,65789,100,100,N,36
 * 		002,XC,,<MON101>,65789,100,100,,36
 * 		003,XC,,<MON101>,65789,101,100,N,36
 * 		Extension 101 initiates clearing a connection established to extension 100.
 * 		001,XC,,<MON101>,65789,101,101,N,36
 * 		002,XC,,<MON100>,65789,101,101,,36
 * 		003,XC,,<MON100>,65789,100,101,N,36
 */
public class ConnectionCleared extends Call
{
	public final static String EVENT = "XC";

	/** Cleared Ext */
	protected int mClearedExt;

	/** Terminating Ext */
	protected int mTerminatingExt;
	
	public ConnectionCleared( String[] eventParts )
	{
		super( eventParts );
	}

	public ConnectionCleared( String eventString )
	{
		super( eventString );
	}

	public ConnectionCleared setClearedExt( int clearedExt )
	{
		this.mClearedExt = clearedExt;
		return this;
	}
	
	public int getClearedExt()
	{
		return this.mClearedExt;
	}
	
	public ConnectionCleared setTerminatingExt( int terminatingExt )
	{
		this.mTerminatingExt = terminatingExt;
		return this;
	}
	
	public int getTerminatingExt()
	{
		return this.mTerminatingExt;
	}
	
	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>,
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <Call_ID>
	 * 5 <Cleared_Ext>
	 * 6 <Terminating_Ext>
	 * 7 <Local_Cnx_State>
	 * 8 <Event_Cause>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setCallID( this.getIntPart( 4 ) );
		this.setClearedExt( this.getIntPart( 5 ) );
		this.setTerminatingExt( this.getIntPart( 6 ) );
		this.setLocalCnxState( this.getStringPart( 7 ) );
		this.setEventCause( this.getIntPart( 8 ) );
	}

	@Override
	public void process()
	{
	}
}
