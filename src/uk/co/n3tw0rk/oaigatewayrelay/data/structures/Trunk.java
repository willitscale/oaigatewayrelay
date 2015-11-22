package uk.co.n3tw0rk.oaigatewayrelay.data.structures;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Structure;

public class Trunk extends Structure {

	public String mExtension;
	
	/**
	 * 
	 * @param key
	 */
	public Trunk(String key) {
		super(key);
		mExtension = key;
	}

	/**
	 * 
	 */
	@Override
	public String getKey() {
		return mExtension;
	}
	
	public Trunk setTrunk(String extension)
	{
		mExtension = extension;
		return this;
	}
	
	public String getExtension()
	{
		return mExtension;
	}
	
}
