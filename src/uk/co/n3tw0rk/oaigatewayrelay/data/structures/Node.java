package uk.co.n3tw0rk.oaigatewayrelay.data.structures;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Structure;

/**
 * <strong>Node</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 23-11-2015
 */
public class Node extends Structure {

	/** */
	protected String mNodeNumber;

	/** */
	protected int mMonCrossRefID;

	/** */
	protected String mDescription;

	/** */
	protected int mNetworkingEnabledDisabled;

	/** */
	protected String mProtocolVersion;

	/** */
	protected String mKSUSWVersion;

	/** */
	protected int mPremiumFeatureStatus;

	/** */
	protected int mCountryCode;

	/** */
	protected int mTCPIPIndicator;

	/** */
	protected int mVoiceMailStatus;

	/** */
	protected int mMaxPartiesInConference;

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

	/**
	 * 
	 * @param description
	 * @return
	 */
	public Node setDescription(String description) {
		mDescription = description;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getDescription() {
		return mDescription;
	}

	/**
	 * 
	 * @param networkingEnabledDisabled
	 * @return
	 */
	public Node setNetworkingEnabledDisabled(String networkingEnabledDisabled) {
		if (null == networkingEnabledDisabled) {
			return this;
		}

		return setNetworkingEnabledDisabled(Integer
				.parseInt(networkingEnabledDisabled));
	}

	/**
	 * 
	 * @param networkingEnabledDisabled
	 * @return
	 */
	public Node setNetworkingEnabledDisabled(int networkingEnabledDisabled) {
		mNetworkingEnabledDisabled = networkingEnabledDisabled;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public int getNetworkingEnabledDisabled() {
		return mNetworkingEnabledDisabled;
	}

	/**
	 * 
	 * @param protocolVersion
	 * @return
	 */
	public Node setProtocolVersion(String protocolVersion) {
		mProtocolVersion = protocolVersion;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getProtocolVersion() {
		return mProtocolVersion;
	}

	/**
	 * 
	 * @param ksuSWVersion
	 * @return
	 */
	public Node setKSUSWVersion(String ksuSWVersion) {
		mKSUSWVersion = ksuSWVersion;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getKSUSWVersion() {
		return mKSUSWVersion;
	}

	/**
	 * 
	 * @param premiumFeatureStatus
	 * @return
	 */
	public Node setPremiumFeatureStatus(String premiumFeatureStatus) {
		if (null == premiumFeatureStatus) {
			return this;
		}

		return setPremiumFeatureStatus(Integer.parseInt(premiumFeatureStatus));
	}

	/**
	 * 
	 * @param premiumFeatureStatus
	 * @return
	 */
	public Node setPremiumFeatureStatus(int premiumFeatureStatus) {
		mPremiumFeatureStatus = premiumFeatureStatus;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public int getPremiumFeatureStatus() {
		return mPremiumFeatureStatus;
	}

	/**
	 * 
	 * @param countryCode
	 * @return
	 */
	public Node setCountryCode(String countryCode) {
		if (null == countryCode) {
			return this;
		}

		return setCountryCode(Integer.parseInt(countryCode));
	}

	/**
	 * 
	 * @param countryCode
	 * @return
	 */
	public Node setCountryCode(int countryCode) {
		mCountryCode = countryCode;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public int getCountryCode() {
		return mCountryCode;
	}

	/**
	 * 
	 * @param tcpIPIndicator
	 * @return
	 */
	public Node setTCPIPIndicator(String tcpIPIndicator) {
		if (null == tcpIPIndicator) {
			return this;
		}

		return setTCPIPIndicator(Integer.parseInt(tcpIPIndicator));
	}

	/**
	 * 
	 * @param tcpIPIndicator
	 * @return
	 */
	public Node setTCPIPIndicator(int tcpIPIndicator) {
		mTCPIPIndicator = tcpIPIndicator;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public int getTCPIPIndicator() {
		return mTCPIPIndicator;
	}

	/**
	 * 
	 * @param voiceMailStatus
	 * @return
	 */
	public Node setVoiceMailStatus(String voiceMailStatus) {
		if (null == voiceMailStatus) {
			return this;
		}

		return setVoiceMailStatus(Integer.parseInt(voiceMailStatus));
	}

	/**
	 * 
	 * @param voiceMailStatus
	 * @return
	 */
	public Node setVoiceMailStatus(int voiceMailStatus) {
		mVoiceMailStatus = voiceMailStatus;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public int getVoiceMailStatus() {
		return mVoiceMailStatus;
	}

	/**
	 * 
	 * @param maxPartiesInConference
	 * @return
	 */
	public Node setMaxPartiesInConference(String maxPartiesInConference) {
		if (null == maxPartiesInConference) {
			return this;
		}

		return setMaxPartiesInConference(Integer
				.parseInt(maxPartiesInConference));
	}

	/**
	 * 
	 * @param maxPartiesInConference
	 * @return
	 */
	public Node setMaxPartiesInConference(int maxPartiesInConference) {
		mMaxPartiesInConference = maxPartiesInConference;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public int getMaxPartiesInConference() {
		return mMaxPartiesInConference;
	}
}
