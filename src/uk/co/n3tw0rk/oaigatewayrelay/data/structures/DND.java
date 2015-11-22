package uk.co.n3tw0rk.oaigatewayrelay.data.structures;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Structure;

/**
 * 
 * @author M00SEMARKTWO
 *
 */
public class DND extends Structure {

	/** */
	protected String mCode;

	protected String mMessageText;

	/**
	 * 
	 * @param key
	 */
	public DND(String key) {
		super(key);
		mCode = key;
	}

	/**
	 * 
	 */
	@Override
	public String getKey() {
		return mCode;
	}

	/**
	 * 
	 * @param code
	 * @return
	 */
	public DND setCode(String code) {
		mCode = code;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getCode() {
		return mCode;
	}

	/**
	 * 
	 * @param messageText
	 * @return
	 */
	public DND setMessageText(String messageText) {
		mMessageText = messageText;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getMessageText() {
		return mMessageText;
	}
}
