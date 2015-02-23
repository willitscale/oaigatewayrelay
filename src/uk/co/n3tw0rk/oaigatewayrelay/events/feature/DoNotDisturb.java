package uk.co.n3tw0rk.oaigatewayrelay.events.feature;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Feature;

/**
 * <strong>Do Not Disturb Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 30-01-2015
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 50
 * 
 * 	DO-NOT-DISTURB – DND
 * 
 * 	USE: 
 * 		Occurs when a device enables or disables the do-not-disturb (DND) feature. When the
 * 		<DND_Message> field is blank, the device is disabling DND.
 * 
 * 	MONITOR TYPE: 
 * 		Device
 * 
 * 	SYNTAX: 
 * 		DND,<Resync_Code>,<Mon_Cross_Ref_ID>,<DND_Ext>,<DND_Message>,
 * 		<DND_Text><CR><LF>
 * 
 * 	Where:
 * 		• DND_Ext: Identifies the extension number of the device changing its DND status.
 * 		• DND_Message: Displays the text string, up to 16 characters, of the system-programmed
 * 			DND message.
 * 		• DND_Text: Displays the text string, up to 16 characters, of the user-programmable message.
 * 		
 * 		NOTE: Text strings are delimited by vertical slashes (|).
 * 
 * 	EXAMPLES: 
 * 		Extension 105 goes into DND with a message of “OUT TO LUNCH UNTIL 1 PM.”
 * 		001,DND,,<MON105>,105,|OUT TO LUNCH|,|UNTIL 1PM|
 * 		Extension 105 returns from lunch and removes his phone from DND.
 * 		001,DND,<MON105>,105
 * 		Extension 105 goes into DND with “OUT TO LUNCH” (no custom text).
 * 		001,DND,<MON105>,105|OUT TO LUNCH|
 * 
 */
public class DoNotDisturb extends Feature
{
	public final static String EVENT = "DND";

	protected int mDNDExt;
	
	protected String mDNDMessage;
	
	protected String mDNDText;
	
	public DoNotDisturb( String event )
	{
		super( event );
	}

	public DoNotDisturb( String[] eventParts )
	{
		super( eventParts );
	}

	public DoNotDisturb setDNDExt( int dndExt )
	{
		this.mDNDExt = dndExt;
		return this;
	}
	
	public int getDNDExt()
	{
		return this.mDNDExt;
	}
	
	public DoNotDisturb setDNDMessage( String dndMessage )
	{
		this.mDNDMessage = dndMessage;
		return this;
	}
	
	public String getmDNDMessage()
	{
		return this.mDNDMessage;
	}
	
	public DoNotDisturb setDNDText( String dndText )
	{
		this.mDNDText = dndText;
		return this;
	}
	
	public String getDNDText()
	{
		return this.mDNDText;
	}
	

	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <DND_Ext>
	 * 5 <DND_Message>
	 * 6 <DND_Text>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setDNDExt( this.getIntPart( 4 ) );
		this.setDNDMessage( this.getStringPart( 5 ) );
		this.setDNDText( this.getStringPart( 6 ) );
	}

	@Override
	public void process()
	{
	}
}
