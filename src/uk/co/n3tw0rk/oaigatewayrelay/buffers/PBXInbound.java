package uk.co.n3tw0rk.oaigatewayrelay.buffers;

import java.util.LinkedList;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Event;
import uk.co.n3tw0rk.oaigatewayrelay.threads.OAIApplication;

public class PBXInbound
{
	protected static LinkedList<Event> mEventQueue = new LinkedList<Event>();

	protected PBXInbound(){}
	
	public static synchronized Event addEvent( Event event )
	{
		mEventQueue.add( event );
		// Wake up our processing thread
		OAIApplication.mEventProcessorThread.newEvent();
		return event;
	}
	
	public static synchronized Event getNextEvent()
	{
		if( 0 >= mEventQueue.size() )
		{
			return null;
		}
		
		return mEventQueue.pop();
	}
	
	public static synchronized int size()
	{
		return mEventQueue.size();
	}
	
	public static synchronized boolean hasNext()
	{
		return ( 0 < size() );
	}
}
