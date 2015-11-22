package uk.co.n3tw0rk.oaigatewayrelay.data;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Information;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Node;

public class Nodes extends Information<Node> {

	/**
	 * 
	 */
	@Override
	public Node getNew(Object key) {
		return new Node(key.toString());
	}
}
