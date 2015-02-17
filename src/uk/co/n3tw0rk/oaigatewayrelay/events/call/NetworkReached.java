package uk.co.n3tw0rk.oaigatewayrelay.events.call;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.CallID;
import uk.co.n3tw0rk.oaigatewayrelay.controllers.SystemController;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Call;

/**
 * <strong>Network Reached Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 17-02-2014
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 36
 * 
 * 	NETWORK REACHED – NT
 * 
 * 	USE: 
 * 		Occurs when a call reaches a trunk, indicating that further call progress events may not be possible
 * 		for this call. Once a call reaches an outgoing trunk, the phone system sends a Network
 * 		Reached event which may or may not be followed by Delivered (see page 30) and
 * 		Established (see page 33) events.
 * 
 * 	MONITOR TYPE: 
 * 		Device, Call, Call via Device
 * 
 * 	SYNTAX: 
 * 		NT,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,<Trunk_Used>,
 * 		<Dialed_Number>,<Local_Cnx_State>,<Event_Cause><CR><LF>
 * 
 * 	Where:
 * 		• Trunk_Used: Identifies the extension number of the trunk receiving the call.
 * 		• Dialed_Number: Indicates the outside number dialed, if known. A Network Reached
 * 			event sent on behalf of a station device will complete this field only when a call is forwarded
 * 			or transferred to the public network. When this event gets sent on behalf of the
 * 			network device (trunk) or the call itself, this field is complete for these cases (i.e., when
 * 			a call is forwarded or transferred to the public network) and for when the call originates
 * 			through ARS. If the Make Call (_MC) command (see page 123) is used to make the
 * 			call, this field is complete for all parties.
 * 
 * 	EXAMPLE: 
 * 		Extension 100 dials 961-9000 on trunk 97061, and an outside party answers the call.
 * 		001,OR,,<MON100>,123,100,,I,97061,,C,22
 * 		002,NT,,<MON100>,123,97061,,C,22
 * 		003,NT,,<MON97061>,123,97061,9619000,A,22
 * 		004,DE,,<MON97061>,123,97061,9619000,E,100,,,,,I,9619000,,,A,22
 * 		005,DE,,<MON100>,123,97061,9619000,E,100,,,,,I,9619000,,,C,22
 * 		006,ES,,<MON97061>,123,94161,9619000,E,100,,,I,9619000,,C,35
 * 		007,ES,,<MON100>,123,94161,9619000,E,100,,,I,9619000,,C,35
 */
public class NetworkReached extends CallID
{
	public final static String EVENT = "NT";

	protected int mTrunkUsed;
	
	protected String mDialedNumber;
	
	public NetworkReached( String[] eventParts )
	{
		super( eventParts );
	}

	public NetworkReached( String eventString )
	{
		super( eventString );
	}
	
	public NetworkReached setTrunkUsed( int trunkUsed )
	{
		this.mTrunkUsed = trunkUsed;
		return this;
	}
	
	public int getTrunkUsed()
	{
		return this.mTrunkUsed;
	}
	
	public NetworkReached setDialedNumber( String dialedNumber )
	{
		this.mDialedNumber = dialedNumber;
		return this;
	}
	
	public String getDialedNumber()
	{
		return this.mDialedNumber;
	}
	
	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>,
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <Call_ID>
	 * 5 <Trunk_Used>
	 * 6 <Dialed_Number>
	 * 7 <Local_Cnx_State>
	 * 8 <Event_Cause>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setCallID( this.getStringPart( 4 ) );
		this.setTrunkUsed( this.getIntPart( 5 ) );
		this.setDialedNumber( this.getStringPart( 6 ) );
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
