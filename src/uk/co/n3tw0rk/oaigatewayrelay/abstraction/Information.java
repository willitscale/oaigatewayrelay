package uk.co.n3tw0rk.oaigatewayrelay.abstraction;

import java.util.HashMap;

public abstract class Information<T extends Structure>
{
	protected HashMap<Integer,T> mStructures = new HashMap<Integer,T>();
	
	public void addStructure( int key, T struct )
	{
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
}
