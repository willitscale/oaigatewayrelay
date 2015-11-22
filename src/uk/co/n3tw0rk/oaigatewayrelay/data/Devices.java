package uk.co.n3tw0rk.oaigatewayrelay.data;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Information;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Device;

/**
 * 
 * @author M00SEMARKTWO
 *
 */
public class Devices extends Information<Device> {

	/**
	 * 
	 */
	@Override
	public Device getNew(Object key) {
		return new Device(key.toString());
	}
}