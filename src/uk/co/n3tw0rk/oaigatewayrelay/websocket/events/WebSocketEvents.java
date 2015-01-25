package uk.co.n3tw0rk.oaigatewayrelay.websocket.events;

import com.google.gson.Gson;

import uk.co.n3tw0rk.oaigatewayrelay.websocket.error.JsonError;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.factories.WebSocketOperation;
import uk.co.n3tw0rk.websocketregistration.events.Event;

public class WebSocketEvents extends Event
{
	protected String mThread;
	
	@Override
	public String event( String data )
	{
		return this.event( data, null );
	}
	
	@Override
	public String event( String data, String session )
	{
		Gson gson = new Gson();
		WebSocketOperation operation = null;

		try
		{
			System.out.println( "session:" + session );
			System.out.println( "data:" + data );
			operation = gson.fromJson( data, WebSocketOperation.class );
		}
		catch( Exception exception )
		{
			
		}
		
		if( null == operation )
		{
			return gson.toJson( new JsonError( "Invalid JSON", 0x01 ) );
		}

		return gson.toJson( operation.process( session ) );
	}
}
