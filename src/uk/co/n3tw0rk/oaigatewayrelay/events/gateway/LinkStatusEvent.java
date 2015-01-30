package uk.co.n3tw0rk.oaigatewayrelay.events.gateway;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.GatewayEvent;

/**
 * <strong>Link Status Event Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 29-01-2015
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 81
 * 
 * 	LINK STATUS EVENT – LS
 * 
 * 	USE: 
 * 		Generates link status messages to the application. These messages allow the application to
 * 		inform users that connections to various OAI ports have been lost.
 * 
 * 	SYNTAX: 
 * 		LS,<Resync_Code>,<Node_Number>,<Link_Status>,<Reason_Code><CR><LF>
 * 
 * 	Where:
 * 		• Node_Number: Indicates the number of the node reporting the status.
 * 
 * 		NOTE: 
 * 			If an application connects directly to a Switch Transceiver, the
 * 			<Node_Number> field could be empty.
 *
 * 		• Link_Status: Indicates if the link is up (1) or down (0).
 * 		• Reason_Code: Identifies why the connection state changed. This code can be one of the
 * 			following:
 * 			0 = Unknown
 *			1 = RS232 Connection Failure (Axxess only)
 *			2 = RS232 Reconnect (Axxess only)
 *			3 = TCP/IP Connection Failure
 *			4 = TCP/IP Reconnect
 *			5 = Added Node
 *			6 = Deleted Node
 *			7 = Timed Out
 */
public class LinkStatusEvent extends GatewayEvent
{
	public final static String EVENT = "LS";

	/** Node_Number */
	protected int mNodeNumber;

	/** Link_Status */
	protected int mLinkStatus;

	/** Reason_Code */
	protected int mReasonCode;

	public LinkStatusEvent( String event )
	{
		super( event );
	}

	public LinkStatusEvent( String[] eventParts )
	{
		super( eventParts );
	}
	
	public LinkStatusEvent setNodeNumber( int nodeNumber )
	{
		this.mNodeNumber = nodeNumber;
		return this;
	}
	
	public int getNodeNumber()
	{
		return this.mNodeNumber;
	}
	
	public LinkStatusEvent setLinkStatus( int linkStatus )
	{
		this.mLinkStatus = linkStatus;
		return this;
	}
	
	public int getLinkStatus()
	{
		return this.mLinkStatus;
	}
	
	public LinkStatusEvent setReasonCode( int reasonCode )
	{
		this.mReasonCode = reasonCode;
		return this;
	}
	
	public int getReasonCode()
	{
		return this.mReasonCode;
	}

	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>
	 * 3 <Node_Number>
	 * 4 <Link_Status>
	 * 5 <Reason_Code>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setNodeNumber( this.getIntPart( 3 ) );
		this.setLinkStatus( this.getIntPart( 4 ) );
		this.setReasonCode( this.getIntPart( 5 ) );
	}
}
