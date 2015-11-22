package uk.co.n3tw0rk.oaigatewayrelay.data.structures;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Structure;

/**
 * 
 * @author M00SEMARKTWO
 *
 */
public class Node extends Structure {

	protected String mNodeNumber;

	protected int mMonCrossRefID;

	/**
	 * 
	 * @param key
	 */
	public Node(String key) {
		super(key);
		mNodeNumber = key;
	}

	/**
	 * 
	 */
	@Override
	public String getKey() {
		return mNodeNumber;
	}

	/**
	 * 
	 * @param nodeNumber
	 * @return
	 */
	public Node setNodeNumber(String nodeNumber) {
		mNodeNumber = nodeNumber;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getNodeNumber() {
		return mNodeNumber;
	}

	/**
	 * 
	 * @param monCrossRefID
	 * @return
	 */
	public Node setMonCrossRefID(String monCrossRefID) {
		if (null == monCrossRefID) {
			return this;
		}

		return setMonCrossRefID(Integer.parseInt(monCrossRefID));
	}

	/**
	 * 
	 * @param monCrossRefID
	 * @return
	 */
	public Node setMonCrossRefID(int monCrossRefID) {
		mMonCrossRefID = monCrossRefID;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public int getMonCrossRefID() {
		return mMonCrossRefID;
	}
}
