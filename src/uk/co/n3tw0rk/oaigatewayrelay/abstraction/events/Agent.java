package uk.co.n3tw0rk.oaigatewayrelay.abstraction.events;


public abstract class Agent extends Event
{
	protected int mDeviceExt;
	protected int mAgentID;
	
	public Agent( String event )
	{
		super( event );
	}
	
	public Agent( String[] eventParts )
	{
		super( eventParts );
	}
	
	public Agent setDeviceExt( int deviceExt )
	{
		this.mDeviceExt = deviceExt;
		return this;
	}
	
	public int getDeviceExt()
	{
		return this.mDeviceExt;
	}
	
	public Agent setAgentID( int agentID )
	{
		this.mAgentID = agentID;
		return this;
	}
	
	public int getAgentID()
	{
		return this.mAgentID;
	}

	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <Device_Ext>
	 * 5 <Agent_ID>
	 */
	@Override
	protected void parseEvent()
	{
		this.setResyncCode( this.getIntPart( 2 ) );
		this.setMonCrossRefID( this.getIntPart( 3 ) );
		this.setDeviceExt( this.getIntPart( 4 ) );
		this.setAgentID( this.getIntPart( 5 ) );
	}
}
