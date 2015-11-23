package uk.co.n3tw0rk.oaigatewayrelay.data;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Information;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Trunk;

/**
 * <strong>Trunks</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 23-11-2015
 */
public class Trunks extends Information<Trunk> {

	/**
	 * 
	 */
	@Override
	public Trunk getNew(Object key) {
		return new Trunk(key.toString());
	}
}