package uk.co.n3tw0rk.oaigatewayrelay.events.call;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.CallID;
import uk.co.n3tw0rk.oaigatewayrelay.controllers.SystemController;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Call;

/**
 * <strong>Failed Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 17-02-2014
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 34
 * 
 * 	FAILED – FA
 * 
 * 	USE: 
 * 		Occurs whenever a call cannot be completed. Examples include dialing an invalid extension,
 * 		dialing a restricted outside number, dialing a busy device that does not allow camp ons, dialing
 * 		a device in DND, attempting to forward to an invalid destination, etc.
 * 
 * 	MONITOR TYPE: 
 * 		Device, Call, Call via Device
 * 
 * 	SYNTAX: 
 * 		FA,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,<Failed_Ext>,
 * 		<Called_Number>,<Local_Cnx_State>,<Event_Cause><CR><LF>
 * 	
 * 	Where:
 * 		• Failed_Ext: Identifies the station that caused the call to fail (e.g., the busy station, the
 * 		toll-restricted station, etc.).
 * 		• Called_Number: Indicates the intended destination of the call. For an outgoing CO call,
 * 		this is the outside number.
 * 
 * 	EXAMPLES: 
 * 		Extension 1000 calls 1001, who is in DND, and hangs up.
 * 		001,SI,,<MON1000>,301,1000,I,22,
 * 		002,OR,,<MON1000>,301,1000,,I,1001,,C,22
 * 		003,FA,,<MON1001>,301,1001,1001,F,14
 * 		004,FA,,<MON1000>,301,1001,1001,C,14
 * 		005,XC,,<MON1000>,301,1000,1000,N,36
 * 		006,XC,,<MON1001>,301,1000,1000,,36
 * 		007,XC,,<MON1001>,301,1001,1000,N,36
 * 		Extension 100 attempts to dial a restricted outside number and then hangs up.
 * 		001,OR,,<MON100>,86415,100,,I,97061,,C,22
 * 		002,FA,,<MON100>,86415,100,9619000,C,13
 * 		003,XC,,<MON100>,86415,100,100,N,36
 * 		Extension 1000 calls hunt group 2001, which is busy and does not allow camp ons.
 * 		001,SI,,<MON1000>,701,1000,I,22,
 * 		002,OR,,<MON1000>,701,1000,,I,2001,,C,22
 * 		003,FA,,<MON1000>,701,2001,2001,C,3
 * 		004,XC,,<MON1000>,701,1000,1000,N,36
 * 		Extension 1000 calls an invalid extension.
 * 		001,FA,,<MON1000>,,1000,1234,N,29
 */
public class Failed extends CallID
{
	public final static String EVENT = "FA";

	protected int mFailedExt;
	
	protected String mCalledNumber;
	
	public Failed( String[] eventParts )
	{
		super( eventParts );
	}

	public Failed( String eventString )
	{
		super( eventString );
	}
	
	public Failed setFailedExt( int failedExt )
	{
		this.mFailedExt = failedExt;
		return this;
	}
	
	public int getFailedExt()
	{
		return this.mFailedExt;
	}
	
	public Failed setCalledNumber( String calledNumber )
	{
		this.mCalledNumber = calledNumber;
		return this;
	}
	
	public String getCalledNumber()
	{
		return this.mCalledNumber;
	}
	
	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>,
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <Call_ID>
	 * 5 <Failed_Ext>
	 * 6 <Called_Number>
	 * 7 <Local_Cnx_State>
	 * 8 <Event_Cause>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setCallID( this.getStringPart( 4 ) );
		this.setFailedExt( this.getIntPart( 5 ) );
		this.setCalledNumber( this.getStringPart( 6 ) );
		this.setLocalCnxState( this.getStringPart( 7 ) );
		this.setEventCause( this.getIntPart( 8 ) );
	}

	@Override
	public void process()
	{
		super.process();

		Call call = SystemController.instance().getCalls().getStructure( this.getCallID() );

		call.setCallID( this.getCallID() );
	}
}
