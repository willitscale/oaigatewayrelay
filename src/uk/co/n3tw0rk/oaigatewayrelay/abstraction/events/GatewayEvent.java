package uk.co.n3tw0rk.oaigatewayrelay.abstraction.events;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Event;

public abstract class GatewayEvent extends Event
{
	protected int mResyncCode;

	public GatewayEvent( String event )
	{
		super( event );
	}

	public GatewayEvent( String[] eventParts )
	{
		super( eventParts );
	}
	
	public GatewayEvent setResyncCode( int resyncCode )
	{
		this.mResyncCode = resyncCode;
		return this;
	}
	
	public int getResyncCode()
	{
		return this.mResyncCode;
	}

	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>
	 */
	@Override
	protected void parseEvent()
	{
		this.setResyncCode( this.getIntPart( 2 ) );
	}
}
