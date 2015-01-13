package uk.co.n3tw0rk.oaigatewayrelay.abstraction;

import java.util.HashMap;
import java.util.LinkedList;

public abstract class Information<T extends Structure>
{
	protected HashMap<Integer,T> mStructures = new HashMap<Integer,T>();
	protected LinkedList<Integer> mKeys = new LinkedList<Integer>();
	
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
	
	public LinkedList<Integer> getKeys()
	{
		return this.mKeys;
	}
}