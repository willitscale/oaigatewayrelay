package uk.co.n3tw0rk.oaigatewayrelay.data.structures;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Structure;

public class Device extends Structure
{
	protected int mExtension;
	
	public Device setExtension( int extension )
	{
		this.mExtension = extension;
		return this;
	}
	
	public Device setExtension( String extension )
	{
		if( null == extension )
		{
			return this;
		}
		return this.setExtension( Integer.parseInt( extension ) );
	}
	
	public int getExtension()
	{
		return this.mExtension;
	}
}
