package uk.co.n3tw0rk.oaigatewayrelay.data.structures;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Structure;

/**
 * <strong>Call</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 23-11-2015
 */
public class Call extends Structure {

	protected String mCallID;

	protected int mAlertingAgent;
	protected int mCallingAgent;

	protected int mAlertingDevice;
	protected int mCallingDevice;

	protected int mAlertingTrunk;
	protected int mCallingTrunk;

	protected int mAlertingNumber;
	protected int mCallingNumber;

	protected int mAlertingType;
	protected int mCallingType;

	protected int mDuration;

	/**
	 * 
	 * @param key
	 */
	public Call(String key) {
		super(key);
		this.mCallID = key;
	}

	/**
	 * 
	 */
	@Override
	public String getKey() {
		return this.mCallID;
	}

	/**
	 * 
	 * @param callID
	 * @return
	 */
	public Call setCallID(String callID) {
		this.mCallID = callID;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getCallID() {
		return this.mCallID;
	}

	/**
	 * 
	 * @param alertingAgent
	 * @return
	 */
	public Call setAlertingAgent(int alertingAgent) {
		this.mAlertingAgent = alertingAgent;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public int getAlertingAgent() {
		return this.mAlertingAgent;
	}

	/**
	 * 
	 * @param callingAgent
	 * @return
	 */
	public Call setCallingAgent(int callingAgent) {
		this.mCallingAgent = callingAgent;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public int getCallingAgent() {
		return this.mCallingAgent;
	}
}
