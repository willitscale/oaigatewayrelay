package uk.co.n3tw0rk.oaigatewayrelay.abstraction;

import java.util.concurrent.ConcurrentLinkedQueue;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Event;

public abstract class Structure
{
	protected ConcurrentLinkedQueue<Event> mEvents = new ConcurrentLinkedQueue<Event>();
	
	public Structure addEvent( Event event )
	{
		this.mEvents.add( event );
		return this;
	}
}
