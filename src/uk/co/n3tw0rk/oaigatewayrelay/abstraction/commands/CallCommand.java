package uk.co.n3tw0rk.oaigatewayrelay.abstraction.commands;

public abstract class CallCommand extends AffectedExt
{
	protected String mCallID;

	public Command setCallID( String callID )
	{
		this.mCallID = callID;
		return this;
	}
	
	public String getCallID()
	{
		return this.mCallID;
	}
}
