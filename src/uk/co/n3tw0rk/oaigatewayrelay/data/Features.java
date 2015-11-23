package uk.co.n3tw0rk.oaigatewayrelay.data;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Information;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Feature;

/**
 * <strong>Features</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 23-11-2015
 */
public class Features extends Information<Feature> {

	/**
	 * 
	 */
	@Override
	public Feature getNew(Object key) {
		return new Feature(key.toString());
	}
}