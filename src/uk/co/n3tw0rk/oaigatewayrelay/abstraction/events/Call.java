package uk.co.n3tw0rk.oaigatewayrelay.abstraction.events;

public abstract class Call extends Event
{
	/** Call ID */
	protected int mCallID;
	
	public Call( String eventParts )
	{
		super( eventParts );
	}

	public Call( String[] eventParts )
	{
		super( eventParts );
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
	
	public Call setCallID( int callID )
	{
		this.mCallID = callID;
		return this;
	}
	
	public int getCallID()
	{
		return this.mCallID;
	}

}
