package uk.co.n3tw0rk.oaigatewayrelay.events.feature;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Feature;

/**
 * <strong>Forwarded Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 04-03-2015
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Pages 52-53
 * 
 * 	FORWARDED – FW
 * 
 * 	USE: 
 * 		Occurs when a station enables or disables manual call forwarding. This does not include system
 * 		forwards.
 * 
 * 	MONITOR TYPE: 
 * 		Device
 * 
 * 	SYNTAX: 
 * 		FW,<Resync_Code>,<Mon_Cross_Ref_ID>,<Forwarding_Ext>,
 * 		<Destination_Ext>,<Outside_Number>,<Forward_Type><CR><LF>
 * 
 * 	Where:
 * 		• Forwarding_Ext: Identifies the extension number of the device that changed its manual
 *	 		forwarding type.
 * 		• Destination_Ext: Indicates the new manual forward’s internal destination. For a manual
 *	 		forward to the public network, this is the extension number of the trunk access code
 *			used (i.e., ARS, the trunk, or trunk group extension). This field is blank when this event
 *			indicates that manual forwarding is disabled.
 *		• Outside_Number: Identifies the outside number if manually forwarding to the public
 *			network; otherwise, this is blank.
 *		• Forward_Type: Indicates the type of manual forward being enabled (see page 15).
 *
 *	EXAMPLES: 
 *		Extension 106 forwards all calls to extension 200.
 *		001,FW,,<MON106>,106,200,,I
 *		Extension 106 turns off forwarding.
 *		001,FW,,<MON106>,106,,,N
 *		Extension 106 forwards if-busy to trunk 97061, phone number 961-9000.
 *		001,FW,,<MON106>,106,97061,9619000,B
 */
public class Forwarded extends Feature
{
	public final static String EVENT = "FW";

	protected int mForwardingExt;
	
	protected int mDestinationExt;
	
	protected int mOutsideNumber;
	
	protected String mForwardType;
	
	public Forwarded( String event )
	{
		super( event );
	}

	public Forwarded( String[] eventParts )
	{
		super( eventParts );
	}
	
	public Forwarded setForwardingExt( int forwardingExt )
	{
		this.mForwardingExt = forwardingExt;
		return this;
	}
	
	public int getForwardingExt()
	{
		return this.mForwardingExt;
	}
	
	public Forwarded setDestinationExt( int destinationExt )
	{
		this.mDestinationExt = destinationExt;
		return this;
	}
	
	public int getDestinationExt()
	{
		return this.mDestinationExt;
	}
	
	public Forwarded setOutsideNumber( int outsideNumber )
	{
		this.mOutsideNumber = outsideNumber;
		return this;
	}
	
	public int getOutsideNumber()
	{
		return this.mOutsideNumber;
	}
	
	public Forwarded setForwardType( String forwardType )
	{
		this.mForwardType = forwardType;
		return this;
	}
	
	public String getForwardType()
	{
		return this.mForwardType;
	}

	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <Forwarding_Ext>
	 * 5 <Destination_Ext>
	 * 6 <Outside_Number>
	 * 7 <Forward_Type>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setForwardingExt( this.getIntPart( 4 ) );
		this.setDestinationExt( this.getIntPart( 5 ) );
		this.setOutsideNumber( this.getIntPart( 6 ) );
		this.setForwardType( this.getStringPart( 7 ) );
	}

	@Override
	public void process()
	{
	}
}
