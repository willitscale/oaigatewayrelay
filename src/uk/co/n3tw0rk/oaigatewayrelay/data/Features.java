package uk.co.n3tw0rk.oaigatewayrelay.data;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Information;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Feature;

/**
 * 
 * @author M00SEMARKTWO
 *
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