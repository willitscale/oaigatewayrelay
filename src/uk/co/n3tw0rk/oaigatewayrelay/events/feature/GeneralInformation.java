package uk.co.n3tw0rk.oaigatewayrelay.events.feature;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Feature;

/**
 * <strong>General Information Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 04-03-2015
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 53
 * 
 * 	GENERAL INFORMATION – GI
 * 
 * 	USE: 
 * 		Occurs when a station is on a transfer announcement call and is waiting at voice mail.
 * 
 * 	MONITOR TYPE: 
 * 		Device
 * 
 * 	SYNTAX (V >= 5.15):
 * 		GI,<Resync_Code>,<Mon_Cross_Ref_ID>,<Affected_Ext>,<Call_ID>,
 * 		<Dest_Extension>,<Reason><CR><LF>
 * 
 * 	Where:
 * 		• Dest_Extension: Identifies the extension number of the device where the
 * 			<Affected_Ext> is waiting.
 * 		• Reason: Indicates why the event occurred (1 = Prompting for Mailbox; 2 = Waiting to
 * 			Complete Transfer).
 * 
 * 	EXAMPLE: 
 * 		Extension 1000 is waiting to complete a transfer to voice mail.
 * 		001,GI,,<MON1000>,1000,4101,2504,2
 */
public class GeneralInformation extends Feature
{
	public final static String EVENT = "GI";

	protected int mAffectedExt;

	protected int mCallID;

	protected int mDestExtension;
	
	protected int mReason;
	
	public GeneralInformation( String event )
	{
		super( event );
	}

	public GeneralInformation( String[] eventParts )
	{
		super( eventParts );
	}
	
	public GeneralInformation setAffectedExt( int affectedExt )
	{
		this.mAffectedExt = affectedExt;
		return this;
	}
	
	public int getAffectedExt()
	{
		return this.mAffectedExt;
	}
	
	public GeneralInformation setCallID( int callID )
	{
		this.mCallID = callID;
		return this;
	}
	
	public int getCallID()
	{
		return this.mCallID;
	}
	
	public GeneralInformation setDestExtension( int destExtension )
	{
		this.mDestExtension = destExtension;
		return this;
	}
	
	public int getDestExtension()
	{
		return this.mDestExtension;
	}
	
	public GeneralInformation setReason( int reason )
	{
		this.mReason = reason;
		return this;
	}
	
	public int getReason()
	{
		return this.mReason;
	}

	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <Affected_Ext>
	 * 5 <Call_ID>
	 * 6 <Dest_Extension>
	 * 7 <Reason>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setAffectedExt( this.getIntPart( 4 ) );
		this.setCallID( this.getIntPart( 5 ) );
		this.setDestExtension( this.getIntPart( 6 ) );
		this.setReason( this.getIntPart( 7 ) );
	}

	@Override
	public void process()
	{
	}
}
