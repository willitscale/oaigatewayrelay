package uk.co.n3tw0rk.oaigatewayrelay.events.miscellaneous;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.DisplayMiscellaneous;
import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Miscellaneous;

/**
 * <strong>Display Entered Extension Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 05-03-2015
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 70
 * 
 * 	DISPLAY ENTERED EXTENSION – DEE
 * 
 * 	NOTE: 
 * 		This event is available only in protocol versions 08.00 and later.
 * 
 * 	USE: 
 * 		Occurs whenever an extension is entered as a result of a PROMPT_EXTENSION prompt,
 * 		regardless of the validity of the extension.
 * 
 * 	NOTE: 
 * 		This note is sent only to the node that is controlled by the device state.
 * 
 * 	MONITOR TYPE: 
 * 		Device
 * 
 * 	SYNTAX: 
 * 		DEE,<Resync_Code>,<Mon_Cross_Ref_ID>,<Subject_Ext>,
 * 		<Display_Control_Type>,<Extension_Entered>,<Extension_Valid><CR><LF>
 * 
 * 	Where:
 * 		• Subject_Ext: Specifies the device sending the event.
 * 		• Display_Control_Type: Specifies the type of Display Control the application has (1 =
 * 			full connected control, which is the only value currently available).
 * 		• Extension_Entered: Specifies the extension entered at the station as a response to the
 * 			PROMPT_EXTENSION prompt.
 * 		• Extension_Valid: Indicates whether the extension number is valid (1) or invalid (0) in
 * 			the phone system.
 * 
 * 	EXAMPLES: 
 * 		A PROMPT_EXTENSION prompt was issued, and the user entered the valid extension 1100.
 * 		001,DEE,,<MON1000>,1000,1,1100,1
 * 		A PROMPT_EXTENSION prompt was issued, and the user entered the invalid extension 999.
 * 		001,DEE,,<MON1000>,1000,1,999,0
 */
public class DisplayEnteredExtension extends DisplayMiscellaneous
{
	public final static String EVENT = "DEE";

	protected int mExtensionEntered;
	protected int mExtensionValid;
	
	public DisplayEnteredExtension( String eventParts )
	{
		super( eventParts );
	}

	public DisplayEnteredExtension( String[] eventParts )
	{
		super( eventParts );
	}

	public DisplayEnteredExtension setExtensionEntered( int extensionEntered )
	{
		this.mExtensionEntered = extensionEntered;
		return this;
	}
	
	public int getExtensionEntered()
	{
		return this.mExtensionEntered;
	}

	public DisplayEnteredExtension setExtensionValid( int extensionValid )
	{
		this.mExtensionValid = extensionValid;
		return this;
	}
	
	public int getExtensionValid()
	{
		return this.mExtensionValid;
	}
	
	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <Subject_Ext>
	 * 5 <Display_Control_Type>
	 * 6 <Extension_Entered>
	 * 7 <Extension_Valid>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setExtensionEntered( this.getIntPart( 6 ) );
		this.setExtensionValid( this.getIntPart( 7 ) );
	}

	@Override
	public void process()
	{
	}
}
