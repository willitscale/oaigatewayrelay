package uk.co.n3tw0rk.oaigatewayrelay.events.acknowledgement;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Event;

public class Confirmation extends Event
{
	public static final String EVENT = "CF";
	
	protected String mCommand;
	
	protected int mInvokeID;
	
	public Confirmation( String[] eventParts )
	{
		super( eventParts );
	}
	
	public Confirmation( String eventString )
	{
		super( eventString );
	}

	/**
	 * 002,CF,_NA,1,0,1
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <COMMAND>
	 * 3 <INVOKE_ID>
	 * 4 <OUTCOME>
	 */
	@Override
	protected void parseEvent()
	{
		this.setSequence( this.getIntPart( 0 ) );
		this.setEvent( this.getStringPart( 1 ) );
		this.setCommand( this.getStringPart( 2 ) );
		this.setInvokeID( this.getIntPart( 3 ) );
	}
	
	public Confirmation setInvokeID( int invokeID )
	{
		this.mInvokeID = invokeID;
		return this;
	}
	
	public int getInvokeID()
	{
		return this.mInvokeID;
	}
	
	public Confirmation setCommand( String command )
	{
		this.mCommand = command;
		return this;
	}
	
	public String getCommand()
	{
		return this.mCommand;
	}
	
}
