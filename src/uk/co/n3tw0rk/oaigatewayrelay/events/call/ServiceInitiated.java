package uk.co.n3tw0rk.oaigatewayrelay.events.call;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.CallID;
import uk.co.n3tw0rk.oaigatewayrelay.controllers.SystemController;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Call;

/**
 * <strong>Service Initiated Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 17-02-2014
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 40
 * 
 * 	SERVICE INITIATED – SI
 * 
 * 	USE: 
 * 		Indicates that a device requested dialtone or that a callback is prompting the user to take a
 * 		phone off hook.
 * 
 * 	MONITOR TYPE: 
 * 		Device
 * 
 * 	SYNTAX (V < 08.10):
 * 		SI,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,<Initiating_Ext>,
 * 		<Local_Cnx_State>,<Event_Cause><CR><LF>
 * 
 * 	SYNTAX (V >= 08.10):
 * 		SI,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,<Initiating_Ext>,
 * 		<Local_Cnx_State>,<Event_Cause>,<Callback_Target_Ext><CR><LF>
 * 
 * 	Where:
 * 		• Call_ID: Identifies the initiated call.
 * 		• Initiating_Ext: Identifies the extension of the device initiating the service.
 * 		• Callback_Target_Ext: Indicates the device for which the <Initiating_Ext> requested a
 * 			callback. This field is populated only if <Event_Cause> is Callback (4).
 * 
 * 	EXAMPLES: 
 * 		Extension 105 calls extension 101 by hot-dialing (dialing without lifting the receiver).
 * 		001,SI,,<MON105>,507,105,I,22,
 * 		002,OR,,<MON105>,507,105,,I,101,,C,22,
 * 		003,DE,,<MON101>,507,101,,I,105,,,,,I,101,,,A,22,
 * 		004,DE,,<MON105>,507,101,,I,105,,,,,I,101,,,C,22,
 * 		Extension 105 comes off-hook and is connected to dialtone prior to dialing anything.
 * 		001,SI,,<MON105>,507,105,I,22,
 * 		Extension 1001 receives a callback prompt indicating extension 1002 is now available.
 * 		001,SI,,<MON1001>,1F01,1001,I,4,1002,
 */
public class ServiceInitiated extends CallID
{
	public final static String EVENT = "SI";

	protected int mInitiatingExt;
	protected int mCallbackTargetExt;
	
	public ServiceInitiated( String[] eventParts )
	{
		super( eventParts );
	}

	public ServiceInitiated( String eventString )
	{
		super( eventString );
	}

	public ServiceInitiated setInitiatingExt( int initiatingExt )
	{
		this.mInitiatingExt = initiatingExt;
		return this;
	}

	public int getInitiatingExt()
	{
		return this.mInitiatingExt;
	}

	public ServiceInitiated setCallbackTargetExt( int callbackTargetExt )
	{
		this.mCallbackTargetExt = callbackTargetExt;
		return this;
	}

	public int getCallbackTargetExt()
	{
		return this.mCallbackTargetExt;
	}
	
	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>,
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <Call_ID>
	 * 5 <Initiating_Ext>
	 * 6 <Local_Cnx_State>
	 * 7 <Event_Cause>
	 * 8 <Callback_Target_Ext>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setCallID( this.getStringPart( 4 ) );
		this.setInitiatingExt( this.getIntPart( 5 ) );
		this.setLocalCnxState( this.getStringPart( 6 ) );
		this.setEventCause( this.getIntPart( 7 ) );
		this.setCallbackTargetExt( this.getIntPart( 8 ) );
	}

	@Override
	public void process()
	{
		super.process();

		Call call = SystemController.instance().getCalls().getStructure( this.getCallID() );

		call.setCallID( this.getCallID() );
	}
}
