package uk.co.n3tw0rk.oaigatewayrelay.websocket.abstraction;

public class FactoryResponse
{
	protected String mAction;
	protected Object mData;
	protected String mSession;
	
	public FactoryResponse( String action, Object data, String session )
	{
		this.mAction = action;
		this.mData = data;
		this.mSession = session;
	}

}
