package uk.co.n3tw0rk.oaigatewayrelay.events.feature;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Feature;

/**
 * <strong>Display Control Eliminated Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 30-01-2015
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 49
 * 
 * 	DISPLAY CONTROL ELIMINATED – DCE
 * 
 * 	NOTE: 
 * 		This event is available only in protocol versions 08.00 and later.
 * 
 * 	USE: 
 * 		Occurs whenever a station loses Display Control.
 * 
 * 	MONITOR TYPE: 
 * 		Device
 * 
 * 	SYNTAX: 
 * 		DCE,<Resync_Code>,<Mon_Cross_Ref_ID>,<Subject_Ext>,<Reason>,
 * 		<Display_Control_Type><CR><LF>
 * 
 * 	Where:
 * 		• Subject_Ext: Specifies the device sending the event.
 * 		• Reason: Indicates why the device is losing Display Control. Possible values include:
 * 			0 = Application stopped control
 * 			1 = Call changed state
 * 			2 = Switch stopped monitor
 * 			3 = Network communication failure
 * 			4 = Max allowed features
 * 			5 = Feature code used
 * 		• Display_Control_Type: Specifies the type of Display Control the application has (1 =
 * 			full connected control, which is the only value currently available).
 * 	
 * 	EXAMPLE: 
 * 		Device monitor at 1000 was stopped using the _MP command.
 * 		001,DCE,,<MON1000>,1000,0,1
 * 
 */
public class DisplayControlEliminated extends Feature
{
	public final static String EVENT = "DCE";

	protected int mSubjectExt;
	protected int mReason;
	protected int mDisplayControlType;
	
	public DisplayControlEliminated( String event )
	{
		super( event );
	}

	public DisplayControlEliminated( String[] eventParts )
	{
		super( eventParts );
	}
	
	public DisplayControlEliminated setSubjectExt( int subjectExt )
	{
		this.mSubjectExt = subjectExt;
		return this;
	}
	
	public int getSubjectExt()
	{
		return this.mSubjectExt;
	}
	
	public DisplayControlEliminated setReason( int reason )
	{
		this.mReason = reason;
		return this;
	}
	
	public int getReason()
	{
		return this.mReason;
	}
	
	public DisplayControlEliminated setDisplayControlType( int displayControlType )
	{
		this.mDisplayControlType = displayControlType;
		return this;
	}
	
	public int getDisplayControlType()
	{
		return this.mDisplayControlType;
	}

	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <Subject_Ext>
	 * 5 <Reason>
	 * 6 <Display_Control_Type>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setSubjectExt( this.getIntPart( 4 ) );
		this.setReason( this.getIntPart( 5 ) );
		this.setDisplayControlType( this.getIntPart( 6 ) );
	}

	@Override
	public void process()
	{
	}

}
