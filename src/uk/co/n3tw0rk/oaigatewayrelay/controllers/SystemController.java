package uk.co.n3tw0rk.oaigatewayrelay.controllers;

import uk.co.n3tw0rk.oaigatewayrelay.data.*;

public class SystemController {
	protected static SystemController mInstance;

	protected Agents mAgents;
	protected Calls mCalls;
	protected Devices mDevices;
	protected Gateways mGateways;
	protected HuntGroups mHuntGroups;
	protected Nodes mNodes;
	protected Trunks mTrunks;
	protected Features mFeatures;
	protected DNDs mDNDs;

	public static SystemController instance() {
		if (null == mInstance) {
			mInstance = new SystemController();
		}

		return mInstance;
	}

	protected SystemController() {
		this.mAgents = new Agents();
		this.mCalls = new Calls();
		this.mDevices = new Devices();
		this.mGateways = new Gateways();
		this.mHuntGroups = new HuntGroups();
		this.mNodes = new Nodes();
		this.mTrunks = new Trunks();
		this.mFeatures = new Features();
		this.mDNDs = new DNDs();
	}

	public Agents getAgents() {
		return this.mAgents;
	}

	public Calls getCalls() {
		return this.mCalls;
	}

	public Devices getDevices() {
		return this.mDevices;
	}

	public Gateways getGateways() {
		return this.mGateways;
	}

	public HuntGroups getHuntGroups() {
		return this.mHuntGroups;
	}

	public Nodes getNodes() {
		return this.mNodes;
	}

	public Trunks getTrunks() {
		return this.mTrunks;
	}

	public Features getFeatures() {
		return this.mFeatures;
	}

	public DNDs getDNDs() {
		return this.mDNDs;
	}
}
