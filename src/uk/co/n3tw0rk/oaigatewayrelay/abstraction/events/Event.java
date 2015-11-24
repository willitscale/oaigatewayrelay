package uk.co.n3tw0rk.oaigatewayrelay.abstraction.events;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.OAIDataInterpolator;
import uk.co.n3tw0rk.oaigatewayrelay.interfaces.OAIPacket;

/**
 * <strong>Event</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 24-11-2015
 */
public abstract class Event extends OAIDataInterpolator implements OAIPacket {
	/** */
	protected String mEvent;

	/** */
	protected int mResyncCode;

	/** */
	protected int mMonCrossRefID;

	/** */
	protected int mSequence;

	/** */
	protected String[] mEventParts;

	/**
	 * 
	 * @param eventParts
	 */
	public Event(String[] eventParts) {
		this.mEventParts = eventParts;
		this.parseEvent();
	}

	/**
	 * 
	 * @param eventString
	 */
	public Event(String eventString) {
		this.mEventParts = splitEvent(eventString);
		this.parseEvent();
	}

	/**
	 * 
	 * @param sequence
	 * @return
	 */
	public Event setSequence(int sequence) {
		this.mSequence = sequence;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public int getSequence() {
		return this.mSequence;
	}

	/**
	 * 
	 * @param event
	 * @return
	 */
	public Event setEvent(String event) {
		this.mEvent = event;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getEvent() {
		return this.mEvent;
	}

	/**
	 * 
	 * @param resyncCode
	 * @return
	 */
	public Event setResyncCode(int resyncCode) {
		this.mResyncCode = resyncCode;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public int getResyncCode() {
		return this.mResyncCode;
	}

	/**
	 * 
	 * @param monCrossRefID
	 * @return
	 */
	public Event setMonCrossRefID(int monCrossRefID) {
		this.mMonCrossRefID = monCrossRefID;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public int getMonCrossRefID() {
		return this.mMonCrossRefID;
	}

	/**
	 * 
	 * @param eventString
	 * @return
	 */
	public static String[] splitEvent(String eventString) {
		if (null == eventString || eventString.trim().isEmpty()) {
			return new String[] {};
		}

		String delimiter = ",";

		// Only utilize the regexp split when we we have containing
		// operators as it's resource intensive
		if (eventString.contains("|")) {
			delimiter = ",(?=(?:(?:[^|]*[|]){2})*[^|]*$)";
		}

		return eventString.split(delimiter);
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public int getIntPart(int index) {
		if (0 <= index && this.mEventParts.length > index) {
			try {
				String part = this.mEventParts[index];
				if (null != part && !part.trim().isEmpty()) {
					return Integer.parseInt(part.trim());
				}
			} catch (Exception exception) {

			}
		}

		return -1;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public String getStringPart(int index) {
		if (0 <= index && this.mEventParts.length > index) {
			return this.mEventParts[index];
		}

		return null;
	}

	/**
	 * 
	 * @return
	 */
	public int getPartsSize() {
		return this.mEventParts.length;
	}

	/**
	 * 
	 */
	public abstract void process();

	/**
	 * 
	 */
	protected abstract void parseEvent();
}
