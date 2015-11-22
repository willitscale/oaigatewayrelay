package uk.co.n3tw0rk.oaigatewayrelay.data.structures;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Structure;

public class Agent extends Structure {

	/** */
	protected String mAgentID;

	/** */
	protected String mDescription;

	public Agent(String key) {
		super(key);
		this.mAgentID = key;
	}

	/**
	 * 
	 */
	@Override
	public String getKey() {
		return this.mAgentID;
	}

	/**
	 * 
	 * @param agentID
	 * @return
	 */
	public Agent setAgentID(String agentID) {
		this.mAgentID = agentID;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getAgentID() {
		return this.mAgentID;
	}

	/**
	 * 
	 * @param description
	 * @return
	 */
	public Agent setDescription(String description) {
		this.mDescription = description;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getDescription() {
		return this.mDescription;
	}
}
