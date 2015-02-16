package uk.co.n3tw0rk.oaigatewayrelay.data.structures;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Structure;

public class Call extends Structure
{
	protected String mCallID;
	
	protected int mAlertingAgent;
	protected int mCallingAgent;
	
	protected int mAlertingDevice;
	protected int mCallingDevice;
	
	protected int mAlertingTrunk;
	protected int mCallingTrunk;

	protected int mAlertingNumber;
	protected int mCallingNumber;
	
	public Call setCallID( String callID )
	{
		this.mCallID = callID;
		return this;
	}
	
	public String getCallID()
	{
		return this.mCallID;
	}
	
	public Call setAlertingAgent( int alertingAgent )
	{
		this.mAlertingAgent = alertingAgent;
		return this;
	}
	
	public int getAlertingAgent()
	{
		return this.mAlertingAgent;
	}
	
	public Call setCallingAgent( int callingAgent )
	{
		this.mCallingAgent = callingAgent;
		return this;
	}
	
	public int getCallingAgent()
	{
		return this.mCallingAgent;
	}
}
