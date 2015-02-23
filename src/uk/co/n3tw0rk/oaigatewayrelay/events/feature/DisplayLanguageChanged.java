package uk.co.n3tw0rk.oaigatewayrelay.events.feature;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Feature;

/**
 * <strong>Display Language Changed Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 30-01-2015
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Pages 49-50
 * 
 * 	DISPLAY LANGUAGE CHANGED – DLC
 * 
 * 	NOTE: 
 * 		This event is available only in protocol versions 08.00 and later.
 * 
 * 	USE: 
 * 		Occurs whenever the language on a station changes. The station language can be changed in
 * 		Database Programming, or the user can enter the Change Language feature code (default is
 * 		301) at the station.
 * 
 * 	MONITOR TYPE: 
 * 		Device
 * 
 * 	SYNTAX: 
 * 		DLC,<Resync_Code>,<Mon_Cross_Ref_ID>,<Subject_Ext>,<New_Language>,
 * 		<Previous_Language><CR><LF>
 * 
 * 	Where:
 * 		• Subject_Ext: Specifies the device sending the event.
 * 		• New Language: Indicates the new language assigned to the station (0 = Primary; 1 =
 * 			Secondary).
 * 		• Previous_Language: Indicates the language used at the station before the change (0 =
 * 			Primary; 1 = Secondary).
 * 
 * 	EXAMPLE: 
 * 		Station 1000 changed its language from primary to secondary.
 * 		001,DLC,,<MON1000>,1000,1,0
 */
public class DisplayLanguageChanged extends Feature
{
	public final static String EVENT = "DLC";

	protected int mSubjectExt;
	protected int mNewLanguage;
	protected int mPreviousLanguage;

	public DisplayLanguageChanged( String event )
	{
		super( event );
	}

	public DisplayLanguageChanged( String[] eventParts )
	{
		super( eventParts );
	}
	
	public DisplayLanguageChanged setSubjectExt( int subjectExt )
	{
		this.mSubjectExt = subjectExt;
		return this;
	}
	
	public int getSubjectExt()
	{
		return this.mSubjectExt;
	}
	
	public DisplayLanguageChanged setNewLanguage( int newLanguage )
	{
		this.mNewLanguage = newLanguage;
		return this;
	}
	
	public int getNewLanguage()
	{
		return this.mNewLanguage;
	}
	
	public DisplayLanguageChanged setPreviousLanguage( int previousLanguage )
	{
		this.mPreviousLanguage = previousLanguage;
		return this;
	}
	
	public int getOutsideNumber()
	{
		return this.mPreviousLanguage;
	}
	
	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <Subject_Ext>
	 * 5 <New_Language>
	 * 6 <Previous_Language>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setSubjectExt( this.getIntPart( 4 ) );
		this.setNewLanguage( this.getIntPart( 5 ) );
		this.setPreviousLanguage( this.getIntPart( 6 ) );
	}

	@Override
	public void process()
	{
	}
}
