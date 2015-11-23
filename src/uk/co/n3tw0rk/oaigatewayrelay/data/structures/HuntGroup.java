package uk.co.n3tw0rk.oaigatewayrelay.data.structures;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Structure;

/**
 * <strong>HuntGroup</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 23-11-2015
 */
public class HuntGroup extends Structure {

	protected String mID;

	protected String mUsername;
	protected String mDescription;

	protected int mGroupType;
	protected int mNumberOfMembers;
	protected int mMailboxNodeNumber;

	/**
	 * 
	 * @param key
	 */
	public HuntGroup(String key) {
		super(key);
		mID = key;
	}

	/**
	 * 
	 */
	@Override
	public String getKey() {
		return mID;
	}

	/**
	 * 
	 * @return
	 */
	public String getID() {
		return mID;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public HuntGroup setID(String id) {
		mID = id;
		return this;
	}

	/**
	 * 
	 * @param username
	 * @return
	 */
	public HuntGroup setUsername(String username) {
		this.mUsername = username;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getUsername() {
		return mUsername;
	}

	/**
	 * 
	 * @param description
	 * @return
	 */
	public HuntGroup setDescription(String description) {
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
	 * @param groupType
	 * @return
	 */
	public HuntGroup setGroupType(String groupType) {
		if (null == groupType) {
			return this;
		}

		return setGroupType(Integer.parseInt(groupType));
	}

	/**
	 * 
	 * @param groupType
	 * @return
	 */
	public HuntGroup setGroupType(int groupType) {
		mGroupType = groupType;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public int mGroupType() {
		return mGroupType;
	}

	/**
	 * 
	 * @param numberOfMembers
	 * @return
	 */
	public HuntGroup setNumberOfMembers(String numberOfMembers) {
		if (null == numberOfMembers) {
			return this;
		}

		return setNumberOfMembers(Integer.parseInt(numberOfMembers));
	}

	/**
	 * 
	 * @param numberOfMembers
	 * @return
	 */
	public HuntGroup setNumberOfMembers(int numberOfMembers) {
		mNumberOfMembers = numberOfMembers;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public int getNumberOfMembers() {
		return mNumberOfMembers;
	}

	/**
	 * 
	 * @param mailboxNodeNumber
	 * @return
	 */
	public HuntGroup setMailboxNodeNumber(String mailboxNodeNumber) {
		if (null == mailboxNodeNumber) {
			return this;
		}

		return setMailboxNodeNumber(Integer.parseInt(mailboxNodeNumber));
	}

	/**
	 * 
	 * @param mailboxNodeNumber
	 * @return
	 */
	public HuntGroup setMailboxNodeNumber(int mailboxNodeNumber) {
		mMailboxNodeNumber = mailboxNodeNumber;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public int getMailboxNodeNumber() {
		return mMailboxNodeNumber;
	}
}
