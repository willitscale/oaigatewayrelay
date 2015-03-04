package uk.co.n3tw0rk.oaigatewayrelay.events.feature;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Feature;

/**
 * <strong>General Information Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 04-03-2015
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Pages 54-55
 * 
 * 	OFFERING ENDED – OE
 * 
 * 	NOTE: 
 * 		This event is available only in protocol versions 07.00 and later.
 * 
 * 	USE: 
 * 		Occurs when offering control is terminated at the device (see page 71 for information about the
 * 		Offered event). This event indicates that the application has lost control of the device due to
 * 		one of the following:
 * 			• The application failed to respond to an Offered (OF) event, and the <Affected_Ext>
 * 				had reached its limit of failures.
 * 			• The application terminated the device monitor it has on the station device.
 * 			• System OAI terminated the device monitor.
 * 			• The station user manually terminated offering control over the device.
 * 
 * 	NOTES: 
 * 		The following items apply to the Offering Ended event:
 * 			• This event is generated under the <Mon_Cross_Ref_ID> of the device monitor on the
 * 				<Affected_Ext>.
 * 			• The application that maintains offering control receives this event regardless of whether
 * 				or not it enables the OE bit in the monitor filter (see page 14 for details).
 * 			• All applications that are monitoring the station with the Offering Event feature
 * 				event bit set receive this event. This event notifies waiting applications when the device
 * 				is free from offering control.
 * 			• Because this event is not generated during a resync, the <Resync_Code> parameter is
 * 				always blank.
 * 
 * 	SYNTAX: 
 * 		OE,<Resync_Code>,<Mon_Cross_Ref_ID>,<Affected_Ext>,
 * 		<Reason><CR><LF>
 * 
 * 	Where:
 * 		• Affected_Ext: Indicates the station where the application lost offering control.
 * 		• Reason: Indicates the reason that the application lost control. Possible values include:
 * 			0 = The application terminated control either by issuing the Offering Eliminate
 * 				Control (_OEC) command or by terminating the device monitor.
 * 			2 = System OAI stopped the device monitor for the <Affected_Ext> (i.e., an extension
 * 				change, unequip, or application failed to issue a command within the valid command
 * 				timer interval, which defaults to 4.5 minutes; see page 3 for details).
 * 			3 = There was a network communication failure. This occurs if the CT Gateway loses
 * 				communication with the telephone system node.
 * 			4 = The application exceeded the number of allowed failures (see page 71 for details).
 * 			5 = The station user manually terminated control by entering the Routing Off feature
 * 				code (default code is 304; logical number is 125).
 * 
 * 	GATEWAY IMPACT: 
 * 		This event is available only in CT Gateway versions 3.0 and later.
 * 
 * 	EXAMPLES: 
 * 		The application exceeded the allowed number of failures.
 * 		006,OE,,<MON100>,100,4
 * 		Device monitor was stopped via the _MP command.
 * 		010,OE,,<MON100>,100,0 		
 */
public class OfferingEnded extends Feature
{
	public final static String EVENT = "OE";

	protected int mAffectedExt;
	
	protected int mReason;

	public OfferingEnded( String event )
	{
		super( event );
	}

	public OfferingEnded( String[] eventParts )
	{
		super( eventParts );
	}
	
	public OfferingEnded setAffectedExt( int affectedExt )
	{
		this.mAffectedExt = affectedExt;
		return this;
	}
	
	public int getAffectedExt()
	{
		return this.mAffectedExt;
	}
	

	public OfferingEnded setReason( int reason )
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
	 * 5 <Reason>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setAffectedExt( this.getIntPart( 4 ) );
		this.setReason( this.getIntPart( 5 ) );
	}

	@Override
	public void process()
	{
	}
}
