package uk.co.n3tw0rk.oaigatewayrelay.data.structures;

import java.util.LinkedList;
import java.util.List;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Structure;

/**
 * <strong>Device</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 23-11-2015
 */
public class Device extends Structure {

	/** */
	protected String mExtension;

	/**
	 * @see DeviceTypes
	 */
	protected int mDeviceType;

	/** */
	protected int mDeviceClass;

	/** */
	protected int mMonCrossRefID;

	/** */
	protected String mDescription;

	/** */
	protected String mUsername;

	/** */
	protected boolean mIsAdministrator;

	/** */
	protected boolean mIsAttendant;

	/** */
	protected int mAttendantExtension;

	/** */
	protected int mDayCOSFlags;

	/** */
	protected int mNightCOSFlags;

	/** */
	protected int mVoiceMailExt;

	/** */
	protected int mMailboxNodeNumber;

	/** */
	protected int mStnSpeedDialBinData;

	/** */
	protected int mPhysicalDeviceType;

	/** */
	protected int mAccountCodeType;

	/** */
	protected int mAccountCodeValidatedFlag;

	/** */
	protected List<String> mCalls = new LinkedList<String>();

	/** */
	protected String mCall;
	
	/**
	 * 
	 * @param key
	 */
	public Device(String key) {
		super(key);
		this.mExtension = key;
	}

	/**
	 * 
	 */
	@Override
	public String getKey() {
		return this.mExtension;
	}

	/**
	 * 
	 * @param monCrossRefID
	 * @return
	 */
	public Device setMonCrossRefID(String monCrossRefID) {
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
	public Device setMonCrossRefID(int monCrossRefID) {
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
	 * @param extension
	 * @return
	 */
	public Device setExtension(String extension) {
		this.mExtension = extension;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getExtension() {
		return this.mExtension;
	}

	/**
	 * 
	 * @param deviceType
	 * @return
	 */
	public Device setDeviceType(int deviceType) {
		this.mDeviceType = deviceType;
		return this;
	}

	/**
	 * 
	 * @param deviceType
	 * @return
	 */
	public Device setDeviceType(String deviceType) {
		if (null == deviceType) {
			return this;
		}

		return this.setDeviceType(deviceType);
	}

	/**
	 * 
	 * @return
	 */
	public int getDeviceType() {
		return this.mDeviceType;
	}

	/**
	 * 
	 * @param deviceClass
	 * @return
	 */
	public Device setDeviceClass(int deviceClass) {
		this.mDeviceClass = deviceClass;
		return this;
	}

	/**
	 * 
	 * @param deviceClass
	 * @return
	 */
	public Device setDeviceClass(String deviceClass) {
		if (null == deviceClass) {
			return this;
		}

		return this.setDeviceType(deviceClass);
	}

	/**
	 * 
	 * @return
	 */
	public int getDeviceClass() {
		return this.mDeviceClass;
	}

	/**
	 * 
	 * @param description
	 * @return
	 */
	public Device setDescription(String description) {
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

	/**
	 * 
	 * @param username
	 * @return
	 */
	public Device setUsername(String username) {
		this.mUsername = username;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getUsername() {
		return this.mUsername;
	}

	/**
	 * 
	 * @param isAdministrator
	 * @return
	 */
	public Device setIsAdministrator(boolean isAdministrator) {
		this.mIsAdministrator = isAdministrator;
		return this;
	}

	/**
	 * 
	 * @param isAdministrator
	 * @return
	 */
	public Device setIsAdministrator(int isAdministrator) {
		return this.setIsAdministrator(1 == isAdministrator);
	}

	/**
	 * 
	 * @param isAdministrator
	 * @return
	 */
	public Device setIsAdministrator(String isAdministrator) {
		if (null == isAdministrator) {
			return this;
		}

		return this.setIsAdministrator(0 == "1".compareTo(isAdministrator));
	}

	/**
	 * 
	 * @return
	 */
	public boolean getIsAdministrator() {
		return this.mIsAdministrator;
	}

	/**
	 * 
	 * @param isAttendant
	 * @return
	 */
	public Device setIsAttendant(boolean isAttendant) {
		this.mIsAttendant = isAttendant;
		return this;
	}

	/**
	 * 
	 * @param isAttendant
	 * @return
	 */
	public Device setIsAttendant(int isAttendant) {
		return this.setIsAttendant(1 == isAttendant);
	}

	/**
	 * 
	 * @param isAttendant
	 * @return
	 */
	public Device setIsAttendant(String isAttendant) {
		if (null == isAttendant) {
			return this;
		}

		return this.setIsAttendant(0 == "1".compareTo(isAttendant));
	}

	/**
	 * 
	 * @return
	 */
	public boolean getIsAttendant() {
		return this.mIsAttendant;
	}

	/**
	 * 
	 * @param attendantExtension
	 * @return
	 */
	public Device setAttendantExtension(int attendantExtension) {
		this.mAttendantExtension = attendantExtension;
		return this;
	}

	/**
	 * 
	 * @param attendantExtension
	 * @return
	 */
	public Device setAttendantExtension(String attendantExtension) {
		if (null == attendantExtension) {
			return this;
		}

		return this.setAttendantExtension(Integer.parseInt(attendantExtension));
	}

	/**
	 * 
	 * @return
	 */
	public int getAttendantExtension() {
		return this.mAttendantExtension;
	}

	/**
	 * 
	 * @param dayCOSFlags
	 * @return
	 */
	public Device setDayCOSFlags(int dayCOSFlags) {
		this.mDayCOSFlags = dayCOSFlags;
		return this;
	}

	/**
	 * 
	 * @param dayCOSFlags
	 * @return
	 */
	public Device setDayCOSFlags(String dayCOSFlags) {
		if (null == dayCOSFlags) {
			return this;
		}

		return this.setDayCOSFlags(Integer.parseInt(dayCOSFlags));
	}

	/**
	 * 
	 * @return
	 */
	public int getDayCOSFlags() {
		return this.mDayCOSFlags;
	}

	/**
	 * 
	 * @param nightCOSFlags
	 * @return
	 */
	public Device setNightCOSFlags(int nightCOSFlags) {
		this.mNightCOSFlags = nightCOSFlags;
		return this;
	}

	/**
	 * 
	 * @param nightCOSFlags
	 * @return
	 */
	public Device setNightCOSFlags(String nightCOSFlags) {
		if (null == nightCOSFlags) {
			return this;
		}

		return this.setNightCOSFlags(Integer.parseInt(nightCOSFlags));
	}

	/**
	 * 
	 * @return
	 */
	public int getNightCOSFlags() {
		return this.mNightCOSFlags;
	}

	/**
	 * 
	 * @param voiceMailExt
	 * @return
	 */
	public Device setVoiceMailExt(int voiceMailExt) {
		this.mVoiceMailExt = voiceMailExt;
		return this;
	}

	/**
	 * 
	 * @param voiceMailExt
	 * @return
	 */
	public Device setVoiceMailExt(String voiceMailExt) {
		if (null == voiceMailExt) {
			return this;
		}

		return this.setVoiceMailExt(Integer.parseInt(voiceMailExt));
	}

	/**
	 * 
	 * @return
	 */
	public int getVoiceMailExt() {
		return this.mVoiceMailExt;
	}

	/**
	 * 
	 * @param mailboxNodeNumber
	 * @return
	 */
	public Device setMailboxNodeNumber(int mailboxNodeNumber) {
		this.mMailboxNodeNumber = mailboxNodeNumber;
		return this;
	}

	/**
	 * 
	 * @param mailboxNodeNumber
	 * @return
	 */
	public Device setMailboxNodeNumber(String mailboxNodeNumber) {
		if (null == mailboxNodeNumber) {
			return this;
		}

		return this.setMailboxNodeNumber(Integer.parseInt(mailboxNodeNumber));
	}

	/**
	 * 
	 * @return
	 */
	public int getMailboxNodeNumber() {
		return this.mMailboxNodeNumber;
	}

	/**
	 * 
	 * @param stnSpeedDialBinData
	 * @return
	 */
	public Device setStnSpeedDialBinData(int stnSpeedDialBinData) {
		this.mStnSpeedDialBinData = stnSpeedDialBinData;
		return this;
	}

	/**
	 * 
	 * @param stnSpeedDialBinData
	 * @return
	 */
	public Device setStnSpeedDialBinData(String stnSpeedDialBinData) {
		if (null == stnSpeedDialBinData) {
			return this;
		}

		return this.setStnSpeedDialBinData(Integer
				.parseInt(stnSpeedDialBinData));
	}

	/**
	 * 
	 * @return
	 */
	public int getStnSpeedDialBinData() {
		return this.mStnSpeedDialBinData;
	}

	/**
	 * 
	 * @param physicalDeviceType
	 * @return
	 */
	public Device setPhysicalDeviceType(int physicalDeviceType) {
		this.mPhysicalDeviceType = physicalDeviceType;
		return this;
	}

	/**
	 * 
	 * @param physicalDeviceType
	 * @return
	 */
	public Device setPhysicalDeviceType(String physicalDeviceType) {
		if (null == physicalDeviceType) {
			return this;
		}

		return this.setPhysicalDeviceType(Integer.parseInt(physicalDeviceType));
	}

	/**
	 * 
	 * @return
	 */
	public int getPhysicalDeviceType() {
		return this.mPhysicalDeviceType;
	}

	/**
	 * 
	 * @param accountCodeType
	 * @return
	 */
	public Device setAccountCodeType(int accountCodeType) {
		this.mAccountCodeType = accountCodeType;
		return this;
	}

	/**
	 * 
	 * @param accountCodeType
	 * @return
	 */
	public Device setAccountCodeType(String accountCodeType) {
		if (null == accountCodeType) {
			return this;
		}

		return this.setAccountCodeType(Integer.parseInt(accountCodeType));
	}

	/**
	 * 
	 * @return
	 */
	public int getAccountCodeType() {
		return this.mAccountCodeType;
	}

	/**
	 * 
	 * @param accountCodeValidatedFlag
	 * @return
	 */
	public Device setAccountCodeValidatedFlag(int accountCodeValidatedFlag) {
		this.mAccountCodeValidatedFlag = accountCodeValidatedFlag;
		return this;
	}

	/**
	 * 
	 * @param accountCodeValidatedFlag
	 * @return
	 */
	public Device setAccountCodeValidatedFlag(String accountCodeValidatedFlag) {
		if (null == accountCodeValidatedFlag) {
			return this;
		}

		return this.setAccountCodeValidatedFlag(Integer
				.parseInt(accountCodeValidatedFlag));
	}

	/**
	 * 
	 * @return
	 */
	public int getAccountCodeValidatedFlag() {
		return this.mAccountCodeValidatedFlag;
	}

	public Device addCall(String call) {
		if (!this.mCalls.contains(call)) {
			this.mCalls.add(call);
		}
		return this;
	}

	/**
	 * 
	 * @param call
	 * @return
	 */
	public Device removeCall(String call) {
		if (this.mCalls.contains(call)) {
			this.mCalls.remove(call);
		}
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public List<String> getCalls() {
		return this.mCalls;
	}

	/**
	 * 
	 * @param call
	 * @return
	 */
	public Device setCall(String call) {
		this.mCall = call;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getCall() {
		return this.mCall;
	}
}
