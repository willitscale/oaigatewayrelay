package uk.co.n3tw0rk.oaigatewayrelay.events.feature;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Feature;

/**
 * <strong>Device Offline Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 30-01-2015
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Pages 46-48
 * 
 * 	DEVICE OFFLINE – OL
 * 
 * 	USE: 
 * 		Occurs when a station, trunk, hunt group, trunk group, or voice mail application goes offline or
 * 		online. This event also occurs with the resync of a station, trunk, hunt group, trunk group, or
 * 		voice mail application if the device is offline. The following table lists some conditions that
 * 		indicate when a device is offline.
 * 
 * 	Table 11: 
 * 		Device Offline Conditions
 * 
 * 	DEVICE 					OFFLINE IF
 * 
 * 	Keyset 					The keyset or keyset card is unplugged.
 * 
 * 	Single-Line 			Set The SLC is unplugged.
 * 
 * 	Trunk					The trunk card is unplugged or Call Processing knows
 * 							the trunk is offline. Note that
 * 							Call Processing cannot detect the offline states of
 * 							some trunk types; so, these trunks
 * 							report offline conditions only if the card is unplugged.
 * 
 * 	Trunk Group 			All of the trunk group members are offline or the trunk
 * 							group has no members.
 * 	
 * 	Hunt Group				The hunt group has no available members, no
 * 							unavailable members, and no members in
 * 							ACD wrap-up. In other words, the hunt group either
 * 							has no members, or all of the
 * 							members are logged out (ACD), removed (UCD), in
 * 							DND, or offline.
 * 	
 * 	Voice Mail Application 	Call Processing cannot communicate with voice mail.
 * 
 * 
 * 	NOTES: 
 * 		(Applies to all versions.) During a resync, the system issues this event only if the device is
 * 		offline. If the device is online, the system does not issue the OL event for that device.
 * 		(Applies to versions 08.10 and later only.) The online sequence for some phones will generate
 * 		two OL events, indicating the device is online. The first OL will indicate that the device has
 * 		come online, and the second event will be generated when the actual phone sends auxiliary
 * 		data to the phone system to distinguish the physical type of phone. For example, a Model 8500
 * 		phone will initially generate an OL event that has the online flag enabled and the
 * 		<Physical_Device_Type> set to 13. Then, once the phone sends the auxiliary bytes, another OL
 * 		event is sent with the online flag enabled and the <Physical_Device_Type> set to 40.
 * 	
 * 	MONITOR TYPE: 
 * 		Device (Requires the offline <filter_list> bit enabled [bit 0])
 * 
 * 	SYNTAX (V < 08.10): 
 * 		OL,<Resync_Code>,<Mon_Cross_Ref_ID>,<Extension>,
 * 		<Online/Offline><CR><LF>
 * 
 * 	SYNTAX (V >= 8.10):
 * 		OL,<Resync_Code>,<Mon_Cross_Ref_ID>,<Extension>,<Online/Offline>,
 * 		<Device_Type>,<Physical_Device_Type><CR><LF>
 * 
 * 	Where:
 * 		• Extension: Identifies the extension number of the device.
 * 		• Online/Offline: Indicates whether the device is currently online (1) or offline (0).
 * 		• Device_Type: Identifies the device type of the <Affected_Ext>, which includes the
 * 			options defined in the following table.
 * 
 * 	Table 12: 
 * 		OL – Device_Type Values
 * 
 * 		VALUE 	<DEVICE_TYPE>
 * 		0 		Keyset Station Device
 * 		1 		Single-Line Station Device
 * 		2 		ACD/Hunt Group
 * 		3 		Loop Start Trunk
 * 		4 		Loop Start Trunk w/Caller ID
 * 		5 		Ground Start Trunk
 * 		6 		Ground Start Trunk w/Caller ID
 * 		7 		DID Trunk
 * 		8 		E&M Trunk
 * 		9 		ISDN Trunk – Basic or Primary Rate
 * 		10 		Trunk Group
 * 		11 		Operator
 * 		12 		Voice Mail
 * 		13 		Other
 * 		26 		B-Channel Station
 * 		28 		MFC/R2 Trunk
 * 		29 		Modem*
 * 		31 		MGCP Endpoint
 * 		32 		MGCP Gateway and Endpoint
 * 		33 		SIP Trunk
 * 				* Axxess only
 * 
 * 	• Physical_Device_Type: Indicates the physical device connected to the phone system. if
 * 		the device is offline, this field is 0 (Unknown). Once the device goes online, this field
 * 		changes to reflect the device type. See Table 31 on page 153 for a list of possible values.
 * 	
 * 	EXAMPLES: 
 * 		Trunk 94017 transitions to online.
 * 		001,OL,,<MON94017>,94017,1,3,0
 * 		During a resync, the system issues the offline event only if the station is offline. If the station
 * 		is online, the system does not issue the OL event.
 * 		001,OL,,<MON1001>,1001,0,0,0
 * 		Keyset 1001, which is a Model 8560 Phone, transitions to offline.
 * 		001,OL,,<MON1001>,1001,0,0,0
 * 		Keyset 1001 transitions to offline.
 * 		001,OL,,<MON1001>,1001,0,0,0
 * 		Keyset 1001, which is an Executive Display Phone, transitions to online.
 * 		001,OL,,<MON1001>,1001,1,0,15
 * 		Keyset 1001, which is a Basic Digital Phone, transitions to online.
 * 		001,OL,,<MON1001>,1001,1,0,13
 * 	
 * 	GATEWAY IMPACTS: 
 * 		The CT Gateway allows an application to enable the OL status bit through the Monitor
 * 		Start (_MS) or Change Event Filter (_CE) command if all of the affected devices are on
 * 		a node with protocol V06.00 or later. Otherwise, the CT Gateway strips the OL bit from the
 * 		command.
 * 
 * 		The CT Gateway allows an application to enable the OL status bit through the Monitor
 * 		Start Advanced (_MA) command on the nodes that support it even if some nodes in the network
 * 		do not support it (i.e., pre V06.00). For those nodes that do not support the command, the
 * 		filter bit list in the confirmation indicates that the event was not enabled. Because the Monitor
 * 		Start Advanced (_MA) command returns multiple confirmation messages, the CT Gateway
 * 		can return a different filter list for the monitors started on each node.
 */
public class DeviceOffline extends Feature
{
	public final static String EVENT = "OL";

	protected int mExtension;
	
	protected int mOnlineOffline;
	
	protected int mDeviceType;
	
	protected int mPhysicalDeviceType;
	
	
	public DeviceOffline( String event )
	{
		super( event );
	}

	public DeviceOffline( String[] eventParts )
	{
		super( eventParts );
	}
	
	public DeviceOffline setExtension( int extension )
	{
		this.mExtension = extension;
		return this;
	}
	
	public int getExtension()
	{
		return this.mExtension;
	}
	
	public DeviceOffline setOnlineOffline( int onlineOffline )
	{
		this.mOnlineOffline = onlineOffline;
		return this;
	}
	
	public int getOnlineOffline()
	{
		return this.mOnlineOffline;
	}
	
	public DeviceOffline setDeviceType( int deviceType )
	{
		this.mDeviceType = deviceType;
		return this;
	}
	
	public int getDeviceType()
	{
		return this.mDeviceType;
	}
	
	public DeviceOffline setPhysicalDeviceType( int physicalDeviceType )
	{
		this.mPhysicalDeviceType = physicalDeviceType;
		return this;
	}
	
	public int getPhysicalDeviceType()
	{
		return this.mPhysicalDeviceType;
	}

	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <Extension>
	 * 5 <Online/Offline>
	 * 6 <Device_Type>
	 * 7 <Physical_Device_Type>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setExtension( this.getIntPart( 4 ) );
		this.setOnlineOffline( this.getIntPart( 5 ) );
		this.setDeviceType( this.getIntPart( 6 ) );
		this.setPhysicalDeviceType( this.getIntPart( 7 ) );
		
	}

	@Override
	public void process()
	{
	}

}
