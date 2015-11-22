package uk.co.n3tw0rk.oaigatewayrelay.data;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Information;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Call;

/**
 * 
 * @author M00SEMARKTWO
 *
 */
public class Calls extends Information<Call> {

	/**
	 * 
	 */
	@Override
	public Call getNew(Object key) {
		return new Call(key.toString());
	}
}