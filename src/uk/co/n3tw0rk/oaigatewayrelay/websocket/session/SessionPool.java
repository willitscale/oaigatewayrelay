package uk.co.n3tw0rk.oaigatewayrelay.websocket.session;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public class SessionPool
{
	protected String mSession;

	protected ConcurrentMap<String,Boolean> mMonitor = new ConcurrentHashMap<String,Boolean>();

	public synchronized void addAlive( String session, String key, boolean value )
	{
		key = session + "__" + key;
		
		if( this.mMonitor.containsKey( key ) )
		{
			this.mMonitor.replace(key, value);
		}
		else
		{
			this.mMonitor.put(key, value);
		}
	}

	public synchronized Boolean getAlive( String session, String key )
	{
		key = session + "__" + key;
		
		return this.mMonitor.get( key );
	}
}
