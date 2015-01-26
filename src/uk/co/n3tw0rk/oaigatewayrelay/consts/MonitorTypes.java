package uk.co.n3tw0rk.oaigatewayrelay.consts;

public class MonitorTypes
{
	/**
	 * 0 - Call
	 **/
	public static final int MONITOR_TYPE_CALL = 0x00;
	
	/**
	 * 1 - Device
	 **/
	public static final int MONITOR_TYPE_DEVICE = 0x01;

	/** 
	 * 2 - Calls Via Device
	 **/
	public static final int MONITOR_TYPE_CALLS_VIA_DEVICE = 0x02;

	/** 
	 * 3 - All Stations (Device-Type Monitoring)
	 * */
	public static final int MONITOR_TYPE_ALL_STATIONS = 0x03;

	/** 
	 * 4 - All Trunks (Device-Type Monitoring). This does NOT include T1
	 * trunks used for transparent networking in system version 05.00 or
	 * later.
	 **/
	public static final int MONITOR_TYPE_ALL_TRUNKS = 0x04;

	/** 
	 * 5 - Device with an automatic Resync Request on the specified device.
	 * The resync will occur only for stations and voice mail applications.
	 **/
	public static final int MONITOR_TYPE_DEVICE_RESYNC = 0x05;

	/**
	 * 6 - All Stations (Device-Type Monitoring) with an automatic Resync
	 * Request on the monitored stations.
	 */
	public static final int MONITOR_TYPE_ALL_STATIONS_RESYNC = 0x06;

	/**
	 * 7 - Agent ID Monitoring where a specific agent ID is being monitored.
	 */
	public static final int MONITOR_TYPE_AGENT = 0x07;

	/**
	 * 8 - Call Termination. Creates a system-wide call termination monitor.
	 */
	public static final int MONITOR_TYPE_CALL_TERMINATION = 0x08;

	/**
	 * 9 - All voice mail applications. Creates device monitors on all voice mail
	 * applications.
	 */
	public static final int MONITOR_TYPE_VOICE_MAIL = 0x09;

	/**
	 *	10 - (Future Enhancement) All Private Network Trunks (Device-Type
	 *	Monitoring). Creates a device monitor on all private network trunks.
	 */
	public static final int MONITOR_TYPE_PRIVATE_NETWORK = 0x0A;

	/**
	 *	11 - (System versions 05.10 and Later) System (System-Type Monitoring).
	 *	Creates a system monitor.
	 */
	public static final int MONITOR_TYPE_SYSTEM = 0x0B;
}
