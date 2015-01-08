package uk.co.n3tw0rk.oaigatewayrelay.controllers;

import uk.co.n3tw0rk.oaigatewayrelay.data.Devices;

public class SystemController
{
	protected static SystemController mInstance;
	
	protected Devices mDevices;
	
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
	}
	
	public Devices getDevices()
	{
		return this.mDevices;
	}
}
