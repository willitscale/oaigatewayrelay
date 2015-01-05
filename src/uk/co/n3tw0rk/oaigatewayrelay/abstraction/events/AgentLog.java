package uk.co.n3tw0rk.oaigatewayrelay.abstraction.events;

public abstract class AgentLog extends Agent
{
	/** Agent Description */
	protected String mAgentDescription;
	
	/** ACD Hunt Group */
	protected int mACDHuntGroup;

	public AgentLog( String[] eventParts )
	{
		super( eventParts );
	}

	public AgentLog( String event )
	{
		super( event );
	}

	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <Device_Ext>
	 * 5 <Agent_ID>
	 * 6 <Agent_Description>
	 * 7 <ACD_Hunt_Group>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setAgentDescription( this.getStringPart( 6 ) );
		this.setACDHuntGroup( this.getIntPart( 7 ) );
	}
	
	public Agent setAgentDescription( String agentDescription )
	{
		this.mAgentDescription = agentDescription;
		return this;
	}
	
	public String getAgentDescription()
	{
		return this.mAgentDescription;
	}
	
	/**
	 * <strong>Set ACD Hunt Group</strong>
	 * 
	 * @param acdHuntGroup
	 * @return
	 */
	public Agent setACDHuntGroup( int acdHuntGroup )
	{
		this.mACDHuntGroup = acdHuntGroup;
		return this;
	}
	
	/**
	 * <strong>Get ACD Hunt Group</strong>
	 * 
	 * @return int
	 */
	public int getACDHuntGroup()
	{
		return this.mACDHuntGroup;
	}
}
