package uk.co.n3tw0rk.oaigatewayrelay.events.miscellaneous;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.DisplayMiscellaneous;
import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Miscellaneous;

/**
 * <strong>Display Station Change Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 05-03-2015
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 69
 * 
 * 	DISPLAY STATION CHANGE – DSC
 * 
 * 	NOTE: 
 * 		This event is available only in protocol versions 08.00 and later.
 * 
 * 	USE: 
 * 		Returns the input entered at the station over which the application currently has full control.
 * 		This is dependent on the station state at any particular time.
 * 
 * 	NOTE: 
 * 		This event goes only to the node that is in control based on the device state.
 * 
 * 	MONITOR TYPE: 
 * 		Device
 * 
 * 	SYNTAX: 
 * 		DSC,<Resync_Code>,<Mon_Cross_Ref_ID>,<Subject_Ext>,
 * 		<Display_Control_Type>,<Display_Event_Type>,<Display_Event_Action>,
 * 		<Input><CR><LF>
 * 
 * 	Where:
 * 		• Subject_Ext: Specifies the device sending the event.
 * 		• Display_Control_Type: Specifies the type of Display Control the application has (1 =
 * 			full connected control, which is the only value currently available).
 * 		• Display_Event_Type: Specifies the type of display event that was generated. Possible
 * 			values include:
 * 			0 = Keypad digit
 * 			1 = Menu key
 * 			2 = Action
 * 		• Display_Event_Action: Specifies the action that occurred. This is only returned if
 * 			<Display_Event_Type> is Action (2). Possible values include:
 * 			0 = Terminate
 * 			1 = Cursor Left
 * 			2 = Cursor Right
 * 			3 = Next
 * 			4 = Previous
 * 			5 = Clear
 * 			6 = Cancel
 * 		• Input: Indicates the input generated at the station.
 * 
 * 	EXAMPLES: 
 * 		The user at station 1000 pressed keypad digit 5.
 * 		001,DSC,,<MON1000>,1000,1,0,5
 * 		The user at station 1000 pressed menu key 3.
 * 		001,DSC,,<MON1000>,1000,1,1,3
 */
public class DisplayStationChange extends DisplayMiscellaneous
{
	public final static String EVENT = "DSC";

	protected int mDisplayEventType;
	protected int mDisplayEventAction;
	protected int mInput;
	
	public DisplayStationChange( String eventParts )
	{
		super( eventParts );
	}

	public DisplayStationChange( String[] eventParts )
	{
		super( eventParts );
	}

	public DisplayStationChange setDisplayEventType( int displayEventType )
	{
		this.mDisplayEventType = displayEventType;
		return this;
	}
	
	public int getDisplayEventType()
	{
		return this.mDisplayEventType;
	}

	public DisplayStationChange setDisplayEventAction( int displayEventAction )
	{
		this.mDisplayEventAction = displayEventAction;
		return this;
	}
	
	public int getDisplayEventAction()
	{
		return this.mDisplayEventAction;
	}

	public DisplayStationChange setInput( int input )
	{
		this.mInput = input;
		return this;
	}
	
	public int getInput()
	{
		return this.mInput;
	}
	
	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <Subject_Ext>
	 * 5 <Display_Control_Type>
	 * 6 <Display_Event_Type>
	 * 7 <Display_Event_Action>
	 * 8 <Input>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setDisplayEventType( this.getIntPart( 6 ) );
		this.setDisplayEventAction( this.getIntPart( 7 ) );
		this.setInput( this.getIntPart( 8 ) );
	}

	@Override
	public void process()
	{
	}
}
