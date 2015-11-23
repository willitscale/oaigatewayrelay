package uk.co.n3tw0rk.oaigatewayrelay.data.structures;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Structure;

/**
 * <strong>Trunk</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 23-11-2015
 */
public class Trunk extends Structure {

	/** */
	public String mExtension;

	/** */
	public String mUsername;

	/** */
	public String mDescription;

	/** */
	public int mAnswerSupervisionType;

	/**
	 * 
	 * @param key
	 */
	public Trunk(String key) {
		super(key);
		mExtension = key;
	}

	/**
	 * 
	 */
	@Override
	public String getKey() {
		return mExtension;
	}

	/**
	 * 
	 * @param extension
	 * @return
	 */
	public Trunk setExtension(String extension) {
		mExtension = extension;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getExtension() {
		return mExtension;
	}

	/**
	 * 
	 * @param username
	 * @return
	 */
	public Trunk setUsername(String username) {
		mUsername = username;
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
	public Trunk setDescription(String description) {
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
	 * @param answerSupervisionType
	 * @return
	 */
	public Trunk setAnswerSupervisionType(String answerSupervisionType) {
		if (null == answerSupervisionType) {
			return this;
		}

		return setAnswerSupervisionType(Integer.parseInt(answerSupervisionType));
	}

	/**
	 * 
	 * @param answerSupervisionType
	 * @return
	 */
	public Trunk setAnswerSupervisionType(int answerSupervisionType) {
		mAnswerSupervisionType = answerSupervisionType;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public int getAnswerSupervisionType() {
		return mAnswerSupervisionType;
	}

}
