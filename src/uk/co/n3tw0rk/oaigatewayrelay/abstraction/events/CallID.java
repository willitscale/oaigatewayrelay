package uk.co.n3tw0rk.oaigatewayrelay.abstraction.events;

public abstract class CallID extends Event
{
	/** Call ID */
	protected String mCallID;
	
	/** 
	 * 	Local Cnx State
	 *  
	 *	VALUE 	MEANING 	DESCRIPTION
	 *	  N 	Null 		No connection to the call
	 *	  I 	Initiate 	Dialtone connection
	 *	  A 	Alerting 	Call is ringing at the device
	 *	  C 	Connected 	Call is active at the device
	 *	  H 	Hold 		Call is on-hold at the device
	 *	  F 	Failed 		Device is listening to reorder tones
	 *	  Q 	Queued 		Call is camped on to the device 
	 */
	protected String mLocalCnxState;
	
	/** Event Cause */
	protected int mEventCause;
	
	public CallID( String eventParts )
	{
		super( eventParts );
	}

	public CallID( String[] eventParts )
	{
		super( eventParts );
	}
	
	public CallID setCallID( String callID )
	{
		this.mCallID = callID;
		return this;
	}
	
	public String getCallID()
	{
		return this.mCallID;
	}
	
	public CallID setLocalCnxState( String localCnxState )
	{
		this.mLocalCnxState = localCnxState;
		return this;
	}
	
	public String getLocalCnxState()
	{
		return this.mLocalCnxState;
	}
	
	public CallID setEventCause( int eventCause )
	{
		this.mEventCause = eventCause;
		return this;
	}
	
	public int getEventCause()
	{
		return this.mEventCause;
	}

	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>,
	 * 3 <Mon_Cross_Ref_ID>
	 */
	@Override
	protected void parseEvent()
	{
		this.setSequence( this.getIntPart( 0 ) );
		this.setEvent( this.getStringPart( 1 ) );
		this.setResyncCode( this.getIntPart( 2 ) );
		this.setMonCrossRefID( this.getIntPart( 3 ) );
	}

}
