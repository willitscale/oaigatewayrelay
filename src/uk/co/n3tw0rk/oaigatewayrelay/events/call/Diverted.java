package uk.co.n3tw0rk.oaigatewayrelay.events.call;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.CallID;

/**
 * <strong>Diverted Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 08-02-2014
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 32
 * 
 * 	DIVERTED – DI
 * 
 * 	USE: 
 * 		Occurs when the system delivers or attempts to deliver a call to a device that redirects the call
 * 		to another device. The call may be redirected immediately (e.g., immediate forward) or after it
 * 		has already rung at the redirecting device (e.g., delayed manual forward, transfer recall, etc.).
 * 
 * 	MONITOR TYPE: 
 * 		Device, Call, Call via Device
 * 
 * 	SYNTAX: 
 * 		DI,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,<Diverted_From_Ext>,
 * 		<New_Dest_Ext>,<Diverted_To_Outside_Number>,<Local_Cnx_State>,
 * 		<Event_Cause><CR><LF>
 * 
 * 	Where:
 * 		• Diverted_From_Ext: Identifies the extension number of the station ringing before the
 * 			call was diverted.
 * 		• New_Dest_Ext: Indicates the extension number of the call’s new destination (i.e., where
 * 			the call rings after being diverted). If the call is diverted to a public network, this is the
 * 			extension number of the trunk.
 * 		• Diverted_To_Outside_Number: Indicates the outside number if the call was diverted to
 * 			the public network.
 * 
 * 	EXAMPLES: 
 * 		Extension 100 calls extension 101, and extension 101 forwards-no-answer to extension 102.
 * 		001,OR,,<MON100>,97032,100,,I,101,C,22
 * 		002,DE,,<MON101>,97032,101,,I,100,,,,,I,101,,,A,22
 * 		003,DE,,<MON100>,97032,101,,I,100,,,,,,I,101,,,C,22
 * 		004,DI,,<MON101>,97032,101,102,,N,08
 * 		005,DI,,<MON100>,97032,101,102,,C,08
 * 		006,DE,,<MON102>,97032,102,,I,100,,,,,I,101,101,,A,09
 * 		007,DE,,<MON100>,97032,102,,I,100,,,,,I,101,101,,C,09
 * 		Extension 100 calls extension 101, and extension 101 forwards immediately to extension 102.
 * 		001,DI,,<MON101>,97032,101,102,,N,09
 * 		002,DI,,<MON101>,97032,101,102,,C,09
 * 		003,DE,,<MON102>,97032,102,,I,100,,,,,I,101,101,,A,09
 * 		004,DE,,<MON100>,97032,102,,I,100,,,,,I,101,101,,C,09
 * 		Extension 100 calls extension 101, and extension 102 reverse transfers the call from extension
 * 		101.
 * 		001,OR,,<MON100>,97032,100,,I,101,C,22
 * 		002,DE,,<MON101>,97032,101,,I,100,,,,,I,101,,,A,22
 * 		003,DE,,<MON100>,97032,101,,I,100,,,,,,I,101,,,C,22
 * 		004,DI,,<MON101>,97032,101,102,,N,11
 * 		005,DI,,<MON100>,97032,101,102,,C,11
 * 		006,DI,,<MON102>,97032,101,102,,C,11
 * 		007,ES,,<MON100>,97032,102,,I,100,,,I,101,,C,35
 * 		008,ES,,<MON102>,97032,102,,I,100,,,I,101,,C,35
 */
public class Diverted extends CallID
{
	public final static String EVENT = "DI";

	/** Diverted From Ext */
	protected int mDivertedFromExt;
	
	/** New Dest Ext */
	protected int mNewDestExt;
	
	/** Diverted To Outside Number */
	protected int mDivertedToOutsideNumber;
	
	public Diverted( String[] eventParts )
	{
		super( eventParts );
	}

	public Diverted( String eventString )
	{
		super( eventString );
	}
	
	public Diverted setDivertedFromExt( int divertedFromExt )
	{
		this.mDivertedFromExt = divertedFromExt;
		return this;
	}
	
	public int getDivertedFromExt()
	{
		return this.mDivertedFromExt;
	}
	
	public Diverted setNewDestExt( int newDestExt )
	{
		this.mNewDestExt = newDestExt;
		return this;
	}
	
	public int getNewDestExt()
	{
		return this.mNewDestExt;
	}
	
	public Diverted setDivertedToOutsideNumber( int divertedToOutsideNumber )
	{
		this.mDivertedToOutsideNumber = divertedToOutsideNumber;
		return this;
	}
	
	public int getDivertedToOutsideNumber()
	{
		return this.mDivertedToOutsideNumber;
	}

	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <Call_ID>
	 * 5 <Diverted_From_Ext>
	 * 6 <New_Dest_Ext>
	 * 7 <Diverted_To_Outside_Number>
	 * 8 <Local_Cnx_State>
	 * 9 <Event_Cause>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setCallID( this.getStringPart( 4 ) );
		this.setDivertedFromExt( this.getIntPart( 5 ) );
		this.setNewDestExt( this.getIntPart( 6 ) );
		this.setDivertedToOutsideNumber( this.getIntPart( 7 ) );
		this.setLocalCnxState( this.getStringPart( 8 ) );
		this.setEventCause( this.getIntPart( 9 ) );
	}

	@Override
	public void process()
	{
	}
}
