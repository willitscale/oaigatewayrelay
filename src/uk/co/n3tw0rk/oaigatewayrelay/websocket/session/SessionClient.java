package uk.co.n3tw0rk.oaigatewayrelay.websocket.session;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import uk.co.n3tw0rk.oaigatewayrelay.websocket.threads.EventThread;

public class SessionClient
{
	protected String mSession;

	protected ConcurrentMap<String,EventThread> mEvents = new ConcurrentHashMap<String,EventThread>();

	public synchronized void addEvent( String eventKey, EventThread eventValue )
	{
		this.mEvents.containsValue( eventValue );
	}

	public synchronized EventThread getEvent( String eventKey )
	{
		return this.mEvents.get( eventKey );
	}
}
