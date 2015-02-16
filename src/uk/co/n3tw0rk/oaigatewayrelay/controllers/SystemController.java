package uk.co.n3tw0rk.oaigatewayrelay.controllers;

import uk.co.n3tw0rk.oaigatewayrelay.data.Agents;
import uk.co.n3tw0rk.oaigatewayrelay.data.Calls;
import uk.co.n3tw0rk.oaigatewayrelay.data.Devices;
import uk.co.n3tw0rk.oaigatewayrelay.data.Gateways;
import uk.co.n3tw0rk.oaigatewayrelay.data.HuntGroups;
import uk.co.n3tw0rk.oaigatewayrelay.data.Nodes;
import uk.co.n3tw0rk.oaigatewayrelay.data.Trunks;

public class SystemController
{
	protected static SystemController mInstance;

	protected Agents mAgents;
	protected Calls mCalls;
	protected Devices mDevices;
	protected Gateways mGateways;
	protected HuntGroups mHuntGroups;
	protected Nodes mNodes;
	protected Trunks mTrunks;

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
		this.mAgents = new Agents();
		this.mCalls = new Calls();
		this.mDevices = new Devices();
		this.mGateways = new Gateways();
		this.mHuntGroups = new HuntGroups();
		this.mNodes = new Nodes();
		this.mTrunks = new Trunks();
	}
	
	public Agents getAgents()
	{
		return this.mAgents;
	}
	
	public Calls getCalls()
	{
		return this.mCalls;
	}
	
	public Devices getDevices()
	{
		return this.mDevices;
	}
	
	public Gateways getGateways()
	{
		return this.mGateways;
	}
	
	public HuntGroups getHuntGroups()
	{
		return this.mHuntGroups;
	}
	
	public Nodes getNodes()
	{
		return this.mNodes;
	}
	
	public Trunks getTrunks()
	{
		return this.mTrunks;
	}
}
