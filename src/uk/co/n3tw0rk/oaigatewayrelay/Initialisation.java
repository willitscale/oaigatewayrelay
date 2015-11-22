package uk.co.n3tw0rk.oaigatewayrelay;

import uk.co.n3tw0rk.oaigatewayrelay.database.mysql.MySQLConnection;
import uk.co.n3tw0rk.oaigatewayrelay.threads.OAIApplication;
import uk.co.n3tw0rk.oaigatewayrelay.utils.Config;
import uk.co.n3tw0rk.oaigatewayrelay.websocket.events.WebSocketEvents;
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
		new Initialisation();
	}
	
	private Initialisation()
	{
		this.setup();
		this.init();
	}
	
	public void setup()
	{
		Config.read();
		Events.setEvent( new WebSocketEvents() );
		//MySQLConnection.instance();
	}
	
	public void init()
	{
		( new Thread( new OAIApplication() ) ).start();
	}
}
