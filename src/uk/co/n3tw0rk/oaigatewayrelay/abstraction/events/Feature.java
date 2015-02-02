package uk.co.n3tw0rk.oaigatewayrelay.abstraction.events;


public abstract class Feature extends Event
{
	protected int mResyncCode;
	protected int mMonCrossRefID;
	
	public Feature( String event )
	{
		super( event );
	}
	
	public Feature( String[] eventParts )
	{
		super( eventParts );
	}
	
	public Feature setResyncCode( int resyncCode )
	{
		this.mResyncCode = resyncCode;
		return this;
	}
	
	public int getResyncCode()
	{
		return this.mResyncCode;
	}
	
	public Feature setMonCrossRefID( int monCrossRefID )
	{
		this.mMonCrossRefID = monCrossRefID;
		return this;
	}

	public int setMonCrossRefID()
	{
		return this.mMonCrossRefID;
	}

	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>
	 * 3 <Mon_Cross_Ref_ID>
	 */
	@Override
	protected void parseEvent()
	{
		this.setResyncCode( this.getIntPart( 2 ) );
		this.setMonCrossRefID( this.getIntPart( 3 ) );
	}
}
