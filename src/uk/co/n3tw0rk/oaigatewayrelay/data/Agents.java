package uk.co.n3tw0rk.oaigatewayrelay.data;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Information;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Agent;

/**
 * 
 * @author M00SEMARKTWO
 *
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