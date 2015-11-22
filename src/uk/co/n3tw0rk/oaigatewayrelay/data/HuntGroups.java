package uk.co.n3tw0rk.oaigatewayrelay.data;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Information;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.HuntGroup;

public class HuntGroups extends Information<HuntGroup> {

	/**
	 * 
	 */
	@Override
	public HuntGroup getNew(Object key) {
		return new HuntGroup(key.toString());
	}
}