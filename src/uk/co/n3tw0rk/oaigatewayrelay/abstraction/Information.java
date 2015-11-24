package uk.co.n3tw0rk.oaigatewayrelay.abstraction;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 
 * @author M00SEMARKTWO
 *
 * @param <T>
 */
public abstract class Information<T extends Structure> {
	/** */
	protected ConcurrentHashMap<Object, T> mStructures = new ConcurrentHashMap<Object, T>();
	/** */
	protected ConcurrentLinkedQueue<Object> mKeys = new ConcurrentLinkedQueue<Object>();

	/**
	 * 
	 * @param key
	 * @param struct
	 */
	public void addStructure(Object key, T struct) {
		this.mKeys.add(key);
		this.mStructures.put(key, struct);
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public T getStructure(Object key) {
		T struct = this.mStructures.get(key);

		if (null == struct) {
			struct = getNew(key);
			addStructure(key, struct);
		}

		return struct;
	}

	/**
	 * 
	 * @return
	 */
	public int size() {
		return this.mStructures.size();
	}

	/**
	 * 
	 * @return
	 */
	public ConcurrentLinkedQueue<Object> getKeys() {
		return this.mKeys;
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public boolean exists(Object key) {
		return this.mStructures.containsKey(key);
	}

	/**
	 * 
	 * @param key
	 */
	public T pop(Object key) {
		return this.mStructures.remove(key);
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public abstract T getNew(Object key);
}
