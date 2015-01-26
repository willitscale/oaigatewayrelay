package uk.co.n3tw0rk.oaigatewayrelay.websocket.abstraction;

public class FactoryResponse
{
	public String mAction;
	public Object mData;
	public String mSession;
	public int mStatus;
	
	
	public FactoryResponse( String action, Object data, 
		String session )
	{
		this.mAction = action;
		this.mData = data;
		this.mSession = session;
	}

}
