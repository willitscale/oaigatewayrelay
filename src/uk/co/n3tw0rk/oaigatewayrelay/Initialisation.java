package uk.co.n3tw0rk.oaigatewayrelay;

import uk.co.n3tw0rk.oaigatewayrelay.threads.OAIApplication;
import uk.co.n3tw0rk.oaigatewayrelay.utils.Config;

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
		( new Thread( new OAIApplication() ) ).start();
	}
}
