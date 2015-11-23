package uk.co.n3tw0rk.oaigatewayrelay.data;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Information;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Agent;

/**
 * <strong>Agents</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 23-11-2015
 */
public class Agents extends Information<Agent> {

	/**
	 * 
	 */
	@Override
	public Agent getNew(Object key) {
		return new Agent(key.toString());
	}
}