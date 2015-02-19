package uk.co.n3tw0rk.oaigatewayrelay.events.call;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.CallID;
import uk.co.n3tw0rk.oaigatewayrelay.controllers.SystemController;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Call;

/**
 * <strong>Retrieved Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 19-02-2014
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Pages 39-40
 * 
 * 	RETRIEVED – RE
 * 
 * 	USE: 
 * 		Occurs when a call that was held on a device is now being re-established at that device (i.e.,
 * 		the call is connected – in a talking state – again).
 * 
 * 	MONITOR TYPE: 
 * 		Device, Call, Call via Device
 * 
 * 	SYNTAX (V >= 02.20):
 * 		RE,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,<Retrieving_Ext>,
 * 		<Local_Cnx_State>,<Event_Cause>,<Internal_Retrieved_Ext>,
 * 		<Retrieved_Device_Outside_Number>,<Retrieved_Device_Trunk_Number>,
 * 		<Retrieved_Device_Type><CR><LF>
 * 	
 * 	Where:
 * 		• Retrieving_Ext: Identifies the device that retrieved the call from hold.
 * 		• Internal_Retrieved_Ext: Identifies the internal extension of the device that was on hold
 * 			at <Retrieving_Ext>. This field may be blank if the retrieved call is a conference call.
 * 		• Retrieved_Device_Outside_Number: Indicates the outside caller’s Caller ID/ANI number
 * 			for an incoming CO call, if available. This can be added/modified with the Modify
 * 			Call (_MD) command but cannot be deleted. This field is always blank for IC
 * 			calls.
 * 		• Retrieved_Device_Trunk_Number: Identifies the outside number of the trunk used for
 * 			the call (e.g., the number received in DNIS or DID information). This information can
 * 			be added/modified with the Modify Call (_MD) command but cannot be deleted.
 * 			This field is always blank for IC calls.
 * 		• Retrieved_Device_Type: Indicates the type of device that is retrieving the call on hold (I
 * 			= Internal Party; E = External Party).
 * 
 * 	EXAMPLES: 
 * 		Extension 105 calls extension 101.
 * 		001,OR,,<MON105>,0014,105,,I,101,,C,22
 * 		002,DE,,<MON101>,0014,101,,I,105,,,,,I,101,,,A,22
 * 		003,DE,,<MON105>,0014,101,,I,105,,,,,I,101,,,C,22
 * 		Extension 101 answers, and extension 105 puts the call on hold.
 * 		004,ES,,<MON105>,0014,101,,I,105,,,I,101,,C,35
 * 		005,ES,,<MON101>,0014,101,,I,105,,,I,101,,C,35
 * 		006,HE,,<MON101>,0014,105,C,22
 * 		007,HE,,<MON105>,0014,105,H,22
 * 		Extension 105 retrieves the call from hold.
 * 		008,RE,,<MON101>,0014,105,C,35,101,,,I
 * 		009,RE,,<MON105>,0014,105,C,35,101,,,I
 */
public class Retrieved extends CallID
{
	public final static String EVENT = "RE";
	
	protected int mRetrievingExt;
	protected int mInternalRetrievedExt;
	protected String mRetrievedDeviceOutsideNumber;
	protected int mRetrievedDeviceTrunkNumber;
	protected String mRetrievedDeviceType;
	
	public Retrieved( String[] eventParts )
	{
		super( eventParts );
	}

	public Retrieved( String eventString )
	{
		super( eventString );
	}

	public Retrieved setRetrievingExt( int retrievingExt )
	{
		this.mRetrievingExt = retrievingExt;
		return this;
	}

	public int getRetrievingExt()
	{
		return this.mRetrievingExt;
	}

	public Retrieved setInternalRetrievedExt( int internalRetrievedExt )
	{
		this.mInternalRetrievedExt = internalRetrievedExt;
		return this;
	}

	public int getInternalRetrievedExt()
	{
		return this.mInternalRetrievedExt;
	}

	public Retrieved setRetrievedDeviceOutsideNumber( String retrievedDeviceOutsideNumber )
	{
		this.mRetrievedDeviceOutsideNumber = retrievedDeviceOutsideNumber;
		return this;
	}

	public String getRetrievedDeviceOutsideNumber()
	{
		return this.mRetrievedDeviceOutsideNumber;
	}

	public Retrieved setRetrievedDeviceTrunkNumber( int retrievedDeviceTrunkNumber )
	{
		this.mRetrievedDeviceTrunkNumber = retrievedDeviceTrunkNumber;
		return this;
	}

	public int getRetrievedDeviceTrunkNumber()
	{
		return this.mRetrievedDeviceTrunkNumber;
	}

	public Retrieved setRetrievedDeviceType( String retrievedDeviceType )
	{
		this.mRetrievedDeviceType = retrievedDeviceType;
		return this;
	}

	public String getRetrievedDeviceType()
	{
		return this.mRetrievedDeviceType;
	}

	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>,
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <Call_ID>
	 * 5 <Retrieving_Ext>
	 * 6 <Local_Cnx_State>
	 * 7 <Event_Cause>
	 * 8 <Internal_Retrieved_Ext>
	 * 9 <Retrieved_Device_Outside_Number>
	 * 10 <Retrieved_Device_Trunk_Number>
	 * 11 <Retrieved_Device_Type>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setCallID( this.getStringPart( 4 ) );
		this.setRetrievingExt( this.getIntPart( 5 ) );
		this.setLocalCnxState( this.getStringPart( 6 ) );
		this.setEventCause( this.getIntPart( 7 ) );
		this.setInternalRetrievedExt( this.getIntPart( 8 ) );
		this.setRetrievedDeviceOutsideNumber( this.getStringPart( 9 ) );
		this.setRetrievedDeviceTrunkNumber( this.getIntPart( 10 ) );
		this.setRetrievedDeviceType( this.getStringPart( 11 ) );
	}

	@Override
	public void process()
	{
		super.process();

		Call call = SystemController.instance().getCalls().getStructure( this.getCallID() );

		call.setCallID( this.getCallID() );
	}
}
