package uk.co.n3tw0rk.oaigatewayrelay.data;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Information;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Device;

/**
 * <strong>Devices</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 23-11-2015
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