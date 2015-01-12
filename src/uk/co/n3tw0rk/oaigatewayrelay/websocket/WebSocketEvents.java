package uk.co.n3tw0rk.oaigatewayrelay.websocket;

import com.google.gson.Gson;

import uk.co.n3tw0rk.oaigatewayrelay.factories.WebSocketOperation;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.error.JsonError;
import uk.co.n3tw0rk.websocketregistration.events.Event;

public class WebSocketEvents extends Event
{
	@Override
	public String event( String data )
	{
		Gson gson = new Gson();
		WebSocketOperation operation = null;

		try
		{
			operation = gson.fromJson( data, WebSocketOperation.class );
		}
		catch( Exception exception )
		{
			
		}
		
		if( null == operation )
		{
			return gson.toJson( new JsonError( "Invalid JSON", 0x01 ) );
		}

		return gson.toJson( operation.process() );
	}
	

}
