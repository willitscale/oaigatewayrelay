package uk.co.n3tw0rk.oaigatewayrelay.events.gateway;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.GatewayEvent;

/**
 * <strong>Connection Status Event Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 29-01-2015
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 79
 * 
 * 	CONNECTION STATUS EVENT – CS
 * 
 * 	NOTE: 
 * 		This event applies to Gateway V2.0 and later only.
 * 
 * 	USE: 
 * 		Informs connecting applications that the specified phone system node is not connected to the
 * 		Gateway. When a CT Gateway initially starts up, it may not be able to communicate with all
 * 		phone system nodes. For CT Gateway versions prior to 2.0, applications could connect only
 * 		once all phone system nodes were connected. For CT Gateway versions 2.0 and later, however,
 * 		the CT Gateway waits for 60 seconds while the phone system nodes respond with a Power
 * 		Up Resync Response. The CT Gateway then allows applications to connect either when
 * 		it has received successful responses from all phone system nodes or when the 60 second timer
 * 		has expired. If the CT Gateway has not received successful responses from the phone system
 * 		nodes (i.e., the 60 seconds has expired), a CS event is sent for every connection that has not
 * 		responded. This event is applicable when the CT Gateway is first starting up and accessing
 * 		node configurations from the registry. Once the node has connected, any subsequent connection
 * 		failures are sent using the Link Status (LS) event.
 * 
 * 	SYNTAX: 
 * 		CS,<Resync_Code>,<Connection_Number>,<Connection_State>,<Previous_Node_Number>,
 * 		<Current_Node_Number><CR><LF>
 * 
 * 	Where:
 * 		• Connection_Number: Indicates the CT Gateway connection number of the uninitialized
 * 			phone system node.
 * 		• Connection_State: Indicates the state of the connection. Possible values are:
 * 			0 = Connection Down
 * 			1 = Connection Up
 * 			2 = Connection Duplicate
 * 			3 = Connection Delete
 * 		• Previous_Node_Number: Specifies the node number received from a previous successful
 * 			connection to the CT Gateway. The value of this field may differ, based on the following:
 * 			— If the CT Gateway was never able to communicate with this node, this field is left blank.
 * 			— If a previous instance of the CT Gateway successfully communicated with the node,
 * 				this field contains the node number associated with that connection.
 * 			— If the CT Gateway had been previously connected to the node, but the connection
 * 				was failing and another connection was established with this node, this field is left
 * 				blank.
 * 			— If the CT Gateway had been previously connected to this node (and the connection
 * 				was successful) but another connection was established with this node, this field
 * 				displays the old node number. The <Connection_State> field also displays a value
 * 				of 3 (Connection Duplicate).
 * 		• Current_Node_Number: Indicates the node with which the CT Gateway is communicating.
 * 			If blank, the CT Gateway is not communicating with the node.
 * 
 * 	EXAMPLES: 
 * 		Connection 3 failed. The Gateway does not yet know the node number.
 * 		CS,,3,0,
 * 		Connection 3 has connected to node 2.
 * 		CS,,3,1,2
 * 		Connection 2 failed. This was previously connected to node 1.
 * 		CS,,2,0,1
 * 		Connection 2 has connected to node 1.
 * 		CS,,2,1,1,1
 * 		
 * 		Connection 5 failed. This was previously connected to node 6.
 * 		CS,,5,0,6
 * 		Connection 5 has connected to node 7. This was previously connected to node 6.
 * 		CS,,5,1,6,7
 * 		Connection 5 was deleted. The previous node number is unknown.
 * 		CS,,5,4,,
 * 		Connection 5 was deleted. This was previously connected to node 6.
 * 		CS,,5,4,6,
 * 		Connection 5 is a duplicate. This was previously connected to node 6. The connection is
 * 		currently a duplicate of node 7.
 * 		CS,,5,3,6,7
 * 		Connection 5 is a duplicate. The previous node number is unknown. The connection is
 * 		currently a duplicate of node 7.
 * 		CS,,5,3,,7
 */
public class ConnectionStatusEvent extends GatewayEvent
{
	public final static String EVENT = "CS";

	protected int mConnectionNumber;
	protected int mConnectionState;
	protected int mPreviousNodeNumber;
	protected int mCurrentNodeNumber;

	public ConnectionStatusEvent( String event )
	{
		super( event );
	}

	public ConnectionStatusEvent( String[] eventParts )
	{
		super( eventParts );
	}
	
	public ConnectionStatusEvent setConnectionNumber( int connectionNumber )
	{
		this.mConnectionNumber = connectionNumber;
		return this;
	}
	
	public int getConnectionNumber()
	{
		return this.mConnectionNumber;
	}
	
	public ConnectionStatusEvent setConnectionState( int connectionState )
	{
		this.mConnectionState = connectionState;
		return this;
	}
	
	public int getConnectionState()
	{
		return this.mConnectionState;
	}
	
	public ConnectionStatusEvent setPreviousNodeNumber( int previousNodeNumber )
	{
		this.mPreviousNodeNumber = previousNodeNumber;
		return this;
	}
	
	public int getPreviousNodeNumber()
	{
		return this.mPreviousNodeNumber;
	}
	
	public ConnectionStatusEvent setCurrentNodeNumber( int currentNodeNumber )
	{
		this.mCurrentNodeNumber = currentNodeNumber;
		return this;
	}
	
	public int getCurrentNodeNumber()
	{
		return this.mCurrentNodeNumber;
	}

	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>
	 * 3 <Connection_Number>
	 * 4 <Connection_State>
	 * 5 <Previous_Node_Number>
	 * 6 <Current_Node_Number>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setConnectionNumber( this.getIntPart( 3 ) );
		this.setConnectionState( this.getIntPart( 4 ) );
		this.setPreviousNodeNumber( this.getIntPart( 5 ) );
		this.setCurrentNodeNumber( this.getIntPart( 6 ) );
	}

	@Override
	public void process()
	{
	}
}
