package uk.co.n3tw0rk.oaigatewayrelay.abstraction.commands;

public abstract class AffectedExt extends Command
{
	protected int mAffectedExt;
	
	public Command setAffectedExt( int affectedExt )
	{
		this.mAffectedExt = affectedExt;
		return this;
	}
	
	public int getAffectedExt()
	{
		return this.mAffectedExt;
	}
}
