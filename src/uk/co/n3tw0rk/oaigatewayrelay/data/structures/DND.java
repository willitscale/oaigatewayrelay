package uk.co.n3tw0rk.oaigatewayrelay.data.structures;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Structure;

/**
 * <strong>DND</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 23-11-2015
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
