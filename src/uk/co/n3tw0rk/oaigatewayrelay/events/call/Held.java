package uk.co.n3tw0rk.oaigatewayrelay.events.call;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.CallID;
import uk.co.n3tw0rk.oaigatewayrelay.controllers.SystemController;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Call;

/**
 * <strong>Held Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 17-02-2014
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 35
 * 
 * 	HELD – HE
 * 
 * 	USE: 
 * 		Occurs when a call that was established on a device is now on hold at that device or another
 * 		device (transfer-to-hold).
 * 
 * 	MONITOR TYPE: 
 * 		Device, Call, Call via Device
 * 
 * 	SYNTAX: 
 * 		HE,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,<Activate_Hold_Ext>,
 * 		<Local_Cnx_State>,<Event_Cause><CR><LF>
 * 
 * 	Where:
 * 		• Call_ID: Identifies the call being put on hold.
 * 		• Activate_Hold_Ext: Identifies the station that placed the call on hold.
 * 	
 * 	EXAMPLES: 
 * 		Extension 100 calls extension 101.
 * 		001,OR,,<MON100>,86415,100,,I,101,,C,22
 * 		002,DE,,<MON101>,86415,101,,I,100,,,,,I,101,,,A,22
 * 		003,DE,,<MON100>,86415,101,,I,100,,,,,I,101,,,C,22
 * 		Extension 101 answers, and extension 100 puts the call onto hold.
 * 		004,ES,,<MON100>,86415,101,,I,100,,,I,101,,C,35
 * 		005,ES,,<MON101>,86415,101,,I,100,,,I,101,,C,35
 * 		006,HE,,<MON101>,86415,100,C,42
 * 		007,HE,,<MON100>,86415,100,H,42
 * 		Or, extension 101 answers, and extension 100 puts the call on transfer-hold.
 * 		004,ES,,<MON100>,86415,101,,I,100,,,I,101,,C,35
 * 		005,ES,,<MON101>,86415,101,,I,100,,,I,101,,C,35
 * 		006,HE,,<MON101>,86415,100,C,38
 * 		007,HE,,<MON100>,86415,100,H,38
 */
public class Held extends CallID
{
	public final static String EVENT = "HE";

	protected int mActivateHoldExt;
	
	public Held( String[] eventParts )
	{
		super( eventParts );
	}

	public Held( String eventString )
	{
		super( eventString );
	}
	
	public Held setActivateHoldExt( int activateHoldExt )
	{
		this.mActivateHoldExt = activateHoldExt;
		return this;
	}
	
	public int getActivateHoldExt()
	{
		return this.mActivateHoldExt;
	}
	
	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>,
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <Call_ID>
	 * 5 <Activate_Hold_Ext>
	 * 6 <Local_Cnx_State>
	 * 7 <Event_Cause>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setCallID( this.getStringPart( 4 ) );
		this.setActivateHoldExt( this.getIntPart( 5 ) );
		this.setLocalCnxState( this.getStringPart( 6 ) );
		this.setEventCause( this.getIntPart( 7 ) );
	}

	@Override
	public void process()
	{
		super.process();

		Call call = SystemController.instance().getCalls().getStructure( this.getCallID() );

		call.setCallID( this.getCallID() );
	}
}
