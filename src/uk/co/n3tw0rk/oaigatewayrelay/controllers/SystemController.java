package uk.co.n3tw0rk.oaigatewayrelay.controllers;

import uk.co.n3tw0rk.oaigatewayrelay.data.Devices;
import uk.co.n3tw0rk.oaigatewayrelay.data.Nodes;

public class SystemController
{
	protected static SystemController mInstance;
	
	protected Devices mDevices;
	
	protected Nodes mNodes;
	
	public static SystemController instance()
	{
		if( null == mInstance )
		{
			mInstance = new SystemController();
		}
		
		return mInstance;
	}
	
	protected SystemController()
	{
		this.mDevices = new Devices();
		this.mNodes = new Nodes();
	}
	
	public synchronized Devices getDevices()
	{
		return this.mDevices;
	}
	
	public synchronized Nodes getNodes()
	{
		return this.mNodes;
	}
}
