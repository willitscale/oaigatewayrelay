package uk.co.n3tw0rk.oaigatewayrelay;

import uk.co.n3tw0rk.oaigatewayrelay.threads.OAIApplication;
import uk.co.n3tw0rk.oaigatewayrelay.utils.Config;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.WebSocketEvents;
import uk.co.n3tw0rk.websocketregistration.listeners.Events;

/**
 * Initialisation Class
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 0.1
 * @since 28-12-2014
 * @see Runnable
 */
public class Initialisation
{
	public static void main( String[] args )
	{
		Config.read();
		Events.setEvent( new WebSocketEvents() );
		( new Thread( new OAIApplication() ) ).start();
	}
}
