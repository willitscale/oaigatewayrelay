package uk.co.n3tw0rk.oaigatewayrelay.events.call;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.CallID;
import uk.co.n3tw0rk.oaigatewayrelay.controllers.SystemController;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Call;

/**
 * <strong>Call Cleared Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 07-02-2014
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 27
 * 
 * 	CALL CLEARED – CC
 * 
 * 	USE: 
 * 		Occurs when a call that was on a device is now terminating and clearing out of the phone system.
 * 		This event is sent only for calls that are being monitored. If the devices involved in the
 * 		call are being monitored but the call is not, Connection Cleared (XC) events (see
 * 		page 29) are the only events sent. In protocol versions 05.00 and above, the phone system also
 * 		generates Call Cleared events for every call in the system, on a per-system OAI serial
 * 		port basis, if a specific monitor type is specified in a Monitor Start (_MS) command (see
 * 		page 128). This allows the application to receive Call Cleared events for every call in the
 * 		system without having to initiate a call monitor on each and every call.
 * 	
 * 	MONITOR TYPE: 
 * 		Call, Call Termination, Call via Device
 * 
 * 	SYNTAX (V < 08.00):
 * 		CC,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,<Event_Cause><CR><LF>
 * 
 * 	SYNTAX (V >= 08.00):
 * 		CC,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,<Event_Cause>,
 * 		<Transferred_Call_ID>,<Transfer_Destination><CR><LF>
 * 
 * 	Where:
 * 		• Transferred_Call_ID: If <Event_Cause> is 32 (Transfer), specifies the call ID of the
 * 			call that was transferred. If <Event_Cause> is any value other than 32, this field is
 * 			blank.
 * 		• Transfer_Destination: If <Event_Cause> is 32 (Transfer), specifies the destination
 * 			extension. If <Event_Cause> is any value other than 32, this field is blank.
 * 
 * 	EXAMPLES: 
 * 		Extension 105 hangs up call 562.
 * 		001,CC,,<MON562>,562,36
 * 		Extension 105 hangs up on call 561 to complete a transfer to extension 106.
 * 		001,CC,,<MON561>,561,36,560,106
 * 		Extension 105 terminates call 563.
 * 		001,CC,,<MON561>,563,36,,
 */
public class CallCleared extends CallID
{
	public final static String EVENT = "CC";

	/** Event Cause */
	protected int mEventCause;

	/** Transferred Call ID */
	protected int mTransferredCallID;

	/** Transfer Destination */
	protected int mTransferDestination;
	
	public CallCleared( String[] eventParts )
	{
		super( eventParts );
	}

	public CallCleared( String eventString )
	{
		super( eventString );
	}
	
	public CallCleared setEventCause( int eventCause )
	{
		this.mEventCause = eventCause;
		return this;
	}
	
	public int getEventCause()
	{
		return this.mEventCause;
	}
	
	public CallCleared setTransferredCallID( int transferredCallID )
	{
		this.mTransferredCallID = transferredCallID;
		return this;
	}
	
	public int getTransferredCallID()
	{
		return this.mTransferredCallID;
	}
	
	public CallCleared setTransferDestination( int transferDestination )
	{
		this.mTransferDestination = transferDestination;
		return this;
	}

	public int getTransferDestination()
	{
		return this.mTransferDestination;
	}

	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>,
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <Call_ID>
	 * 5 <Event_Cause>
	 * 6 <Transferred_Call_ID>
	 * 7 <Transfer_Destination>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setCallID( this.getStringPart( 4 ) );
		this.setTransferredCallID( this.getIntPart( 5 ) );
		this.setTransferDestination( this.getIntPart( 6 ) );
	}

	@Override
	public void process()
	{
		super.process();

		Call call = SystemController.instance().getCalls().getStructure( this.getCallID() );
	}
}
