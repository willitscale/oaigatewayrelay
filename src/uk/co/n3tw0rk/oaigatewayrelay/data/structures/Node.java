package uk.co.n3tw0rk.oaigatewayrelay.data.structures;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Structure;

public class Node extends Structure
{
	protected int mNodeNumber;
	
	public Node setNodeNumber( int nodeNumber )
	{
		this.mNodeNumber = nodeNumber;
		return this;
	}
	
	public Node setNodeNumber( String nodeNumber )
	{
		if( null == nodeNumber )
		{
			return this;
		}
		return this.setNodeNumber( Integer.parseInt( nodeNumber ) );
	}
	
	public int getNodeNumber()
	{
		return this.mNodeNumber;
	}
}
