package uk.co.n3tw0rk.oaigatewayrelay.abstraction.commands;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Event;
import uk.co.n3tw0rk.oaigatewayrelay.interfaces.OAIPacket;
import uk.co.n3tw0rk.oaigatewayrelay.utils.OAIToolkit;

public abstract class Command implements OAIPacket
{
	protected int mInvokeID;
	
	protected Event mEvent;

	public Command setEvent( Event event )
	{
		this.mEvent = event;
		this.confirmation();
		return this;
	}
	
	public Command setInvokeID( int invokeID )
	{
		this.mInvokeID = invokeID;
		return this;
	}
	
	public int getInvokeID()
	{
		return this.mInvokeID;
	}
	
	protected abstract String buildCommand();
	
	public String getCommand()
	{
		return OAIToolkit.buildPBXString( this.buildCommand(), true );
	}
	
	public boolean hasCompleted()
	{
		return true;
	}
	
	public abstract void confirmation();
}