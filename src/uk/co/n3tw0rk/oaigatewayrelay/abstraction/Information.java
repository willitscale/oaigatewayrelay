package uk.co.n3tw0rk.oaigatewayrelay.abstraction;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class Information<T extends Structure>
{
	protected ConcurrentHashMap<Object,T> mStructures = new ConcurrentHashMap<Object,T>();
	protected ConcurrentLinkedQueue<Object> mKeys = new ConcurrentLinkedQueue<Object>();
	
	public void addStructure( Object key, T struct )
	{
		this.mKeys.add( key );
		this.mStructures.put( key, struct );
	}
	
	public T getStructure( Object key )
	{
		return this.mStructures.get( key );
	}
	
	public int size()
	{
		return this.mStructures.size();
	}
	
	public ConcurrentLinkedQueue<Object> getKeys()
	{
		return this.mKeys;
	}
	
	public boolean exists( String key )
	{
		return this.mStructures.containsKey( key );
	}
}
