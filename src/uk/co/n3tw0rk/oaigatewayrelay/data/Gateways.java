package uk.co.n3tw0rk.oaigatewayrelay.data;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Information;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Gateway;

/**
 * <strong>Gateways</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 23-11-2015
 */
public class Gateways extends Information<Gateway> {

	/**
	 * 
	 */
	@Override
	public Gateway getNew(Object key) {
		return new Gateway(key.toString());
	}
}