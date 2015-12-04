package uk.co.n3tw0rk.oaigatewayrelay.data.structures;

import java.util.LinkedList;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Structure;
import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Event;

/**
 * <strong>Call</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 23-11-2015
 */
public class Call extends Structure {

	/** */
	protected String mCallID;
	
	/** */
	protected String mCallingAgent;

	/** */
	protected String mCallingDevice;

	/** */
	protected String mCallingTrunk;

	/** */
	protected String mCallingNumber;

	/** */
	protected String mCallingType;

	/** */
	protected String mCallingHuntGroup;
	
	/** */
	protected String mAlertingAgent;

	/** */
	protected String mAlertingDevice;

	/** */
	protected String mAlertingTrunk;

	/** */
	protected String mAlertingNumber;

	/** */
	protected String mAlertingType;

	/** */
	protected String mAlertingHuntGroup;

	/** */
	protected int mDuration;

	/** */
	protected int mDirection;
	
	/** */
	protected LinkedList<Event> mEvents = new LinkedList<Event>();

	/**
	 * 
	 * @param key
	 */
	public Call(String key) {
		super(key);
		this.mCallID = key;
	}

	/**
	 * 
	 */
	@Override
	public String getKey() {
		return this.mCallID;
	}

	/**
	 * 
	 * @param callID
	 * @return
	 */
	public Call setCallID(String callID) {
		this.mCallID = callID;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getCallID() {
		return this.mCallID;
	}

	/**
	 * 
	 * @param alertingAgent
	 * @return
	 */
	public Call setAlertingAgent(String alertingAgent) {
		mAlertingAgent = alertingAgent;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getAlertingAgent() {
		return mAlertingAgent;
	}

	/**
	 * 
	 * @param callingAgent
	 * @return
	 */
	public Call setCallingAgent(String callingAgent) {
		mCallingAgent = callingAgent;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getCallingAgent() {
		return mCallingAgent;
	}

	/**
	 * 
	 * @param alertingDevice
	 * @return
	 */
	public Call setAlertingDevice(String alertingDevice) {
		mAlertingDevice = alertingDevice;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getAlertingDevice() {
		return mAlertingDevice;
	}

	/**
	 * 
	 * @param callingDevice
	 * @return
	 */
	public Call setCallingDevice(String callingDevice) {
		mCallingDevice = callingDevice;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getCallingDevice() {
		return mCallingDevice;
	}

	/**
	 * 
	 * @param mAlertingTrunk
	 * @return
	 */
	public Call setAlertingTrunk(String alertingTrunk) {
		mAlertingTrunk = alertingTrunk;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getAlertingTrunk() {
		return mAlertingTrunk;
	}

	/**
	 * 
	 * @param callingTrunk
	 * @return
	 */
	public Call setCallingTrunk(String callingTrunk) {
		mCallingTrunk = callingTrunk;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getCallingTrunk() {
		return mCallingTrunk;
	}

	/**
	 * 
	 * @param alertingNumber
	 * @return
	 */
	public Call setAlertingNumber(String alertingNumber) {
		mAlertingNumber = alertingNumber;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getAlertingNumber() {
		return mAlertingNumber;
	}

	/**
	 * 
	 * @param callingNumber
	 * @return
	 */
	public Call setCallingNumber(String callingNumber) {
		mCallingNumber = callingNumber;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getCallingNumber() {
		return mCallingNumber;
	}

	/**
	 * 
	 * @param alertingType
	 * @return
	 */
	public Call setAlertingType(String alertingType) {
		mAlertingType = alertingType;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getAlertingType() {
		return mAlertingType;
	}

	/**
	 * 
	 * @param callingType
	 * @return
	 */
	public Call setCallingType(String callingType) {
		mCallingType = callingType;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getCallingType() {
		return mCallingType;
	}

	/**
	 * 
	 * @param huntGroup
	 * @return
	 */
	public Call setCallingHuntGroup(String huntGroup)
	{
		this.mCallingHuntGroup = huntGroup;
		return this;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getCallingHuntGroup()
	{
		return this.mCallingHuntGroup;
	}

	/**
	 * 
	 * @param huntGroup
	 * @return
	 */
	public Call setAlertingHuntGroup(String huntGroup)
	{
		this.mAlertingHuntGroup = huntGroup;
		return this;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAlertingHuntGroup()
	{
		return this.mAlertingHuntGroup;
	}
	
	/**
	 * 
	 * @param duration
	 * @return
	 */
	public Call setDuration(String duration) {
		if (null == duration) {
			return this;
		}
		return setDuration(Integer.parseInt(duration));
	}

	/**
	 * 
	 * @param duration
	 * @return
	 */
	public Call setDuration(int duration) {
		mDuration = duration;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public int getDuration() {
		return mDuration;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getDirection() {
		return this.mDirection;
	}
	
	/**
	 * 
	 * @param direction
	 * @return
	 */
	public Call setDirection(int direction) {
		this.mDirection = direction;
		return this;
	}

	/**
	 * 
	 */
	public Call addEvent(Event evt) {
		mEvents.add(evt);
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public LinkedList<Event> getEvents() {
		return mEvents;
	}
}
