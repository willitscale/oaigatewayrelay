package uk.co.n3tw0rk.oaigatewayrelay.data.structures;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Structure;

/**
 * <strong>Network</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 23-11-2015
 */
public class Network extends Structure {

	protected String mNodeNumber;

	public Network(String key) {
		super(key);
		mNodeNumber = key;
	}

	@Override
	public String getKey() {
		return mNodeNumber;
	}

}
