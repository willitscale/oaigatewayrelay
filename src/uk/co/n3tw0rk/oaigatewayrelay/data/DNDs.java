package uk.co.n3tw0rk.oaigatewayrelay.data;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Information;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.DND;

/**
 * 
 * @author M00SEMARKTWO
 *
 */
public class DNDs extends Information<DND> {

	/**
	 * 
	 */
	@Override
	public DND getNew(Object key) {
		return new DND(key.toString());
	}
}