package uk.co.n3tw0rk.oaigatewayrelay.events.call;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.CallID;
import uk.co.n3tw0rk.oaigatewayrelay.controllers.SystemController;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Call;

/**
 * <strong>Transferred Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 17-02-2014
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Pages 40-42
 * 
 * 	TRANSFERRED – TR
 * 
 * 	USE: 
 * 		Occurs when a station transfers a call to another device. This does not include the reverse
 * 		transfer feature (call pick-up). (See the Diverted event on page 32 for details about call pickup.)
 * 
 * 	MONITOR TYPE: 
 * 		Device, Call, Call via Device
 * 
 * 	SYNTAX: 
 * 		TR,<Resync_Code>,<Mon_Cross_Ref_ID>,<Transferred_Call_ID>,
 * 		<Transferring_Ext>,<Transferred_Ext>,<Announcement_Call_ID>,
 * 		<Destination_Ext>,<Outside_Caller_Name>,<Outside_Caller_Number>,
 * 		<Trunk_Name>,<Trunk_Outside_Number>,<Local_Cnx_State>,
 * 		<Event_Cause><CR><LF>
 * 
 * 	Where:
 * 		• Transferred_Call_ID: Specifies the <Call_ID> (see page 11) of the transferred call. For
 * 			supervised transfers, this is the <Call_ID> that the transferring extension put on transfer-hold.
 * 		• Transferring_Ext: Indicates the extension of the device performing the transfer.
 * 		• Transferred_Ext: Specifies the extension of the device that was transferred to the
 * 			<Destination_Ext>. This may be blank if the transferred call is a conference call.
 * 		• Announcement_Call_ID: Displays the <Call_ID> (see page 11) of the transfer
 * 			announcement call. This field is blank if the transferred event is sent on behalf of the
 * 			device being transferred because it never had any knowledge of the announcement call.
 * 		• Destination_Ext: Indicates the extension of the transfer destination device.
 * 		• Outside_Caller_Name: Identifies the outside caller’s Caller ID/ANI name for the transferred
 * 			device. This can be added/modified with the Modify Call (_MD) command
 * 			in the System OAI (_M in Desktop OAI) but cannot be deleted. This text field is always
 * 			blank for IC calls.
 * 		• Outside_Caller_Number: Indicates the outside caller’s Caller ID/ANI number, if available,
 * 			of the transferred device. This can be added/modified with the Modify Call
 * 			(_MD) command in System OAI (_M in Desktop OAI) but cannot be deleted. This field
 * 			is always blank for IC calls.
 * 		• Trunk_Name: Displays the name associated with the transferred trunk, if applicable
 * 			(e.g., the name programmed in the system’s call routing table for the incoming number
 * 			dialed [DNIS/DID]). If there is no DID/DNIS number, this field displays the trunk
 * 			description programmed in the phone system. This can be added/modified with the
 * 			Modify Call (_MD) command in the System OAI (_M in Desktop OAI) but cannot
 * 			be deleted. This text field is always blank for IC calls.
 * 		• Trunk_Outside_Number: Indicates the DNIS or DID outside number associated with
 * 			the transferred trunk, if applicable. This can be added/modified with the Modify
 * 			Call (_MD) command in the System OAI (_M in Desktop OAI) but cannot be deleted.
 * 			This field is always blank for IC calls.
 * 
 * 	EXAMPLES: 
 * 		Extension 100 calls extension 101.
 * 		001,OR,,<MON100>,18532,100,,I,101,,C,22
 * 		002,DE,,<MON101>,18532,101,,I,100,,,,,I,101,,,A,22
 * 		003,DE,,<MON100>,18532,101,,I,100,,,,,I,101,,,C,22
 * 		Extension 101 answers, and extension 100 puts the call on transfer-hold.
 * 		004,ES,,<MON100>,18532,101,,I,100,,,I,101,,C,35
 * 		005,ES,,<MON101>,18532,101,,I,100,,,I,101,,C,35
 * 		006,HE,,<MON101>,18532,100,C,38
 * 		007,HE,,<MON100>,18532,100,H,38
 * 		Extension 100 calls extension 102 and completes the transfer to extension 102.
 * 		008,OR,,<MON100>,18533,100,,I,102,,C,22
 * 		009,DE,,<MON102>,18533,102,,I,100,,,,,I,102,,,A,40
 * 		010,DE,,<MON100>,18533,102,,I,100,,,,,I,102,,,C,40
 * 		011,TR,,<MON100>,18532,100,101,@002,102,,,,,N,32
 * 		012,XC,,<MON100>,18533,100,100,N,36
 * 		013,TR,,<MON101>,18532,100,101,,102,,,,,C,32
 * 		014,TR,,<MON102>,18532,100,101,@002,102,,,,,A,32
 * 		015,XC,,<MON102>,18533,100,100,,36
 * 		016,XC,,<MON102>,18532,102,100,N,36
 * 		017,DE,,<MON102>,18532,102,,I,101,,,,,I,102,100,,A,32
 * 		018,DE,,<MON101>,18532,102,,I,101,,,,,I,102,100,,C,32
 * 
 * 	NOTE: 
 * 		Transferred messages are not guaranteed to be followed by a Delivered, Held, or
 * 		Established event message to indicate the state of the call after the transfer.
 */
public class Transferred extends CallID
{
	public final static String EVENT = "TR";

	protected String mTransferredCallID;
	protected int mTransferringExt;
	protected int mTransferredExt;

	protected String mAnnouncementCallID;
	protected int mDestinationExt;
	
	protected String mOutsideCallerName;
	protected String mOutsideCallerNumber;
	protected String mTrunkName;
	protected String mTrunkOutsideNumber;
	
	public Transferred( String[] eventParts )
	{
		super( eventParts );
	}

	public Transferred( String eventString )
	{
		super( eventString );
	}
	
	public Transferred setTransferredCallID( String transferredCallID )
	{
		this.mTransferredCallID = transferredCallID;
		return this;
	}
	
	public String getTransferredCallID()
	{
		return this.mTransferredCallID;
	}
	
	public Transferred setTransferringExt( int transferringExt )
	{
		this.mTransferringExt = transferringExt;
		return this;
	}
	
	public int getTransferringExt()
	{
		return this.mTransferringExt;
	}
	
	public Transferred setTransferredExt( int transferredExt )
	{
		this.mTransferredExt = transferredExt;
		return this;
	}
	
	public int getTransferredExt()
	{
		return this.mTransferredExt;
	}

	public Transferred setAnnouncementCallID( String announcementCallID )
	{
		this.mAnnouncementCallID = announcementCallID;
		return this;
	}
	
	public String getAnnouncementCallID()
	{
		return this.mAnnouncementCallID;
	}
	
	public Transferred setDestinationExt( int destinationExt )
	{
		this.mDestinationExt = destinationExt;
		return this;
	}
	
	public int getDestinationExt()
	{
		return this.mDestinationExt;
	}

	public Transferred setOutsideCallerName( String outsideCallerName )
	{
		this.mOutsideCallerName = outsideCallerName;
		return this;
	}
	
	public String getOutsideCallerName()
	{
		return this.mOutsideCallerName;
	}

	public Transferred setOutsideCallerNumber( String outsideCallerNumber )
	{
		this.mOutsideCallerNumber = outsideCallerNumber;
		return this;
	}
	
	public String getOutsideCallerNumber()
	{
		return this.mOutsideCallerNumber;
	}

	public Transferred setTrunkName( String trunkName )
	{
		this.mTrunkName = trunkName;
		return this;
	}
	
	public String getTrunkName()
	{
		return this.mTrunkName;
	}

	public Transferred setTrunkOutsideNumber( String trunkOutsideNumber )
	{
		this.mTrunkOutsideNumber = trunkOutsideNumber;
		return this;
	}
	
	public String getTrunkOutsideNumber()
	{
		return this.mTrunkOutsideNumber;
	}
	
	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>,
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <Transferred_Call_ID>
	 * 5 <Transferring_Ext>
	 * 6 <Transferred_Ext>
	 * 7 <Announcement_Call_ID>
	 * 8 <Destination_Ext>
	 * 9 <Outside_Caller_Name>
	 * 10 <Outside_Caller_Number>
	 * 11 <Trunk_Name>
	 * 12 <Trunk_Outside_Number>
	 * 13 <Local_Cnx_State>
	 * 14 <Event_Cause>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setTransferredCallID( this.getStringPart( 4 ) );
		this.setTransferringExt( this.getIntPart( 5 ) );
		this.setTransferredExt( this.getIntPart( 6 ) );
		this.setAnnouncementCallID( this.getStringPart( 7 ) );
		this.setDestinationExt( this.getIntPart( 8 ) );
		this.setOutsideCallerName( this.getStringPart( 9 ) );
		this.setOutsideCallerNumber( this.getStringPart( 10 ) );
		this.setTrunkName( this.getStringPart( 11 ) );
		this.setTrunkOutsideNumber( this.getStringPart( 12 ) );
		this.setLocalCnxState( this.getStringPart( 13 ) );
		this.setEventCause( this.getIntPart( 14 ) );
	}

	@Override
	public void process()
	{
		super.process();

		Call call = SystemController.instance().getCalls().getStructure( this.getCallID() );

		//call.setCallID( this.getCallID() );
	}
}
