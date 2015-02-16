package uk.co.n3tw0rk.oaigatewayrelay.abstraction;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class Information<T extends Structure>
{
	protected ConcurrentHashMap<Integer,T> mStructures = new ConcurrentHashMap<Integer,T>();
	protected ConcurrentLinkedQueue<Integer> mKeys = new ConcurrentLinkedQueue<Integer>();
	
	public void addStructure( int key, T struct )
	{
		this.mKeys.add( key );
		this.mStructures.put( key, struct );
	}
	
	public T getStructure( int key )
	{
		return this.mStructures.get( key );
	}
	
	public int size()
	{
		return this.mStructures.size();
	}
	
	public ConcurrentLinkedQueue<Integer> getKeys()
	{
		return this.mKeys;
	}
}
