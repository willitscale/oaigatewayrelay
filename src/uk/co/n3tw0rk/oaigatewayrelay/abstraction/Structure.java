package uk.co.n3tw0rk.oaigatewayrelay.abstraction;

import java.util.concurrent.ConcurrentLinkedQueue;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Event;

/**
 * 
 * @author M00SEMARKTWO
 *
 */
public abstract class Structure {
	/**
	 * 
	 * @param key
	 */
	public Structure(String key) {
	}

	/**
	 * 
	 */
	protected ConcurrentLinkedQueue<Event> mEvents = new ConcurrentLinkedQueue<Event>();

	/**
	 * 
	 * @param event
	 * @return
	 */
	public Structure addEvent(Event event) {
		this.mEvents.add(event);
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public abstract String getKey();
}
