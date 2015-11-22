package uk.co.n3tw0rk.oaigatewayrelay.data;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Information;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Gateway;

/**
 * 
 * @author M00SEMARKTWO
 *
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