package uk.co.n3tw0rk.oaigatewayrelay.events.call;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.CallID;
import uk.co.n3tw0rk.oaigatewayrelay.consts.CallDirection;
import uk.co.n3tw0rk.oaigatewayrelay.consts.CallingDeviceTypes;
import uk.co.n3tw0rk.oaigatewayrelay.controllers.SystemController;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Call;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Device;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Trunk;

/**
 * <strong>Delivered Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 08-02-2014
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 30
 * 
 * 	DELIVERED – DE
 * 
 * 	USE: 
 * 		Indicates that a call is alerting (ringing) at a specific device. Multiple delivered events can be
 * 		sent for the same call when more than one station is ringing for one call (e.g., multiple ring in
 * 		and all-ring hunt groups).
 * 
 * 	NOTE: 
 * 		As of V07.00, applications can receive the DE event for hunt group calls. If a call rings
 * 		through an ACD or UCD group, the monitor session on the hunt group member captures and
 * 		sends the <ACD/UCD_Group> extension number in the DE event.
 * 	
 * 	NOTES: 
 * 		In versions 08.10 and later, this event may not properly reflect the cause for the called device.
 * 		This inconsistency occurs when using the override functionality of the _MC, _CS, _DF, _TO,
 * 		or _MO command to call a keyset on a node that is not running protocol version 08.10. In this
 * 		case, the cause value for this device will differ depending on the command.
 * 
 * 		• For the _MC and _CS, and commands, the cause value is OVERRIDE (24), whether or
 * 		not the device is in DND.
 * 		• For the _MO, _TO, and _DF commands, the cause value is CALL FORWARD (09),
 * 		whether or not the device is in DND. If, however, the “moved to,” “deflected to,” or
 * 		“transferred to” device is in DND and on a node running version 08.10, the cause value
 * 		is OVERRIDE (24).
 * 
 * 	MONITOR TYPE: 
 * 		Device, Call, Call via Device
 * 
 * 	SYNTAX(V < 07.00):
 * 		DE,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,
 * 		<Alerting_Internal_Ext>,<Alerting_Outside_Number>,
 * 		<Alerting_Device_Type>,<Internal_Calling_Ext>,<Outside_Caller_Name>,
 * 		<Outside_Caller_Number>,<Trunk_Name>,<Trunk_Outside_Number>,
 * 		<Calling_Device_Type>,<Originally_Called_Dev>,<Last_Redirection_Ext>,
 * 		<Account_Code>,<Local_Cnx_State>,<Event_Cause><CR><LF>
 * 
 * 	SYNTAX (V >= 07.00):
 * 		DE,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,
 * 		<Alerting_Internal_Ext>,<Alerting_Outside_Number>,
 * 		<Alerting_Device_Type>,<Internal_Calling_Ext>,<Outside_Caller_Name>,
 * 		<Outside_Caller_Number>,<Trunk_Name>,<Trunk_Outside_Number>,
 * 		<Calling_Device_Type>,<Originally_Called_Dev>,<Last_Redirection_Ext>,
 * 		<Account_Code>,<Local_Cnx_State>,<Event_Cause>,<ACD/UCD_Group><CR><LF>
 * 
 * 	Where:
 * 		• Alerting_Internal_Ext: Identifies the internal extension being alerted. For internal and
 * 			incoming CO calls, this is the ringing party’s extension. For outgoing CO calls, this is
 * 			the trunk extension.
 * 		• Alerting_Outside_Number: Indicates the dialed digit string for an outgoing CO call;
 * 			otherwise, this is blank.
 * 		• Alerting_Device_Type: Indicates the type of device being alerted (I = Internal Party; E
 * 			= External Party).
 * 		• Internal_Calling_Ext: Indicates the extension of the internal call originator. For internal
 * 			calls and outgoing CO calls, this is the calling party’s extension. For incoming CO calls,
 * 			this is the trunk extension.
 * 		• Outside_Caller_Name: Identifies the Caller ID/ANI name for incoming CO calls. This
 * 			can be added/modified with the Modify Call (_MD) command but cannot be
 * 			deleted. This text field is always blank for IC calls and is delimited by vertical slashes
 * 			(|).
 * 		• Outside_Caller_Number: Indicates the Caller ID/ANI number for incoming CO calls.
 * 			This can be added/modified with the Modify Call (_MD) command but cannot be
 * 			deleted. This field is always blank for IC calls.
 * 		• Trunk_Name: Displays the name associated with the trunk used for the call (e.g., the
 * 			name programmed in the system’s call routing table for the incoming number dialed
 * 			[DNIS/DID]). If there is no DID/DNIS number, this field displays the trunk description
 * 			programmed in the phone system. This can be added/modified with the Modify
 * 			Call (_MD) command but cannot be deleted. This text field is always blank for IC
 * 			calls and is delimited by vertical slashes (|).
 * 		• Trunk_Outside_Number: Identifies the DNIS or DID outside number associated with
 * 			the trunk used for the call. This can be added/modified with the Modify Call (_MD)
 * 			command but cannot be deleted. This field is always blank for IC calls.
 * 		• Calling_Device_Type: Indicates the type of calling device (I = Internal Party; E =
 * 			External Party).
 * 		• Originally_Called_Dev: Indicates the initial call destination if the call has never been
 * 			answered. For IC and incoming CO calls, this is the originally dialed extension. For
 * 			outgoing CO calls, this is the dialed digit string. The initial transfer destination for a
 * 			transferred call and the initial recall destination for a recalling call become the originally
 * 			called device.
 * 		• Last_Redirection_Ext: Identifies the extension number of the last device that redirected
 * 			(forwarded, deflected, transferred, or recalled) the call, if applicable; otherwise, this is
 * 			blank.
 * 		• Account_Code: Indicates the account code the system should use for this call.
 * 		• ACD/UCD_Group: Identifies the ACD or UCD hunt group extension. This field is
 * 			blank if there is no ACD/UCD hunt group associated with the call.
 * 	
 * 	EXAMPLES: 
 * 		Extension 100 calls extension 101.
 * 		001,OR,,<MON100>,5484,100,,I,101,,C,22
 * 		002,DE,,<MON101>,5484,101,,I,100,,,,,I,101,,,A,22,
 * 		003,DE,,<MON100>,5484,101,,I,100,,,,,I,101,,,C,22,
 * 		Incoming CO call from 602-555-1212 to 800-222-5555 rings directly to extension 105.
 * 		001,OR,,<MON97061>,5484,97061,6025551212,E,8002225555,,C,22
 * 		002,DE,,<MON105>5484,105,,I,97061,,6025551212,,8002225555,E,105,,,
 * 		A,22,
 * 		003,DE,,<MON97061>,5484,105,,I,97061,,6025551212,,8002225555,E,105,,,
 * 		C,22,
 * 		Incoming CO call on trunk 97061 without any DNIS or ANI information is ringing extension
 * 		101 directly.
 * 		001,OR,,<MON97061>,5484,97061,,E,101,,C,22
 * 		002,DE,,<MON101>,5484,101,,I,97061,,,,,E,101,,,A,22,
 * 		003,DE,,<MON97061>,5484,101,,I,97061,,,,,E,101,,,C,22,
 * 		Outgoing call from extension 100 is made to 961-9000 on trunk 97061.
 * 		001,OR,,<MON100>,@001,100,,I,97061,,C,22
 * 		002,NT,,<MON100>,@001,97061,,C,22
 * 		003,NT,,<MON97061>,@001,97061,9619000,A,22
 * 		004,DE,,<MON97061>,@001,97061,9619000,E,100,,,,,I,9619000,,,A,22,
 * 		005,DE,,<MON100>,@001,97061,9619000,E,100,,,,,I,9619000,,,C,22,
 */
public class Delivered extends CallID {
	public final static String EVENT = "DE";

	protected String mAlertingInternalExt;
	protected String mAlertingOutsideNumber;
	protected String mAlertingDeviceType;

	protected String mInternalCallingExt;
	protected String mOutsideCallerName;
	protected String mOutsideCallerNumber;

	protected String mTrunkName;
	protected String mTrunkOutsideNumber;
	protected String mCallingDeviceType;

	protected String mOriginallyCalledDev;
	protected String mLastRedirectionExt;
	protected String mAccountCode;
	protected String mACDUCDGroup;

	/** */
	protected Call mCall;

	/**
	 * 
	 * @param alertingInternalExt
	 * @return
	 */
	public Delivered setAlertingInternalExt(String alertingInternalExt) {
		this.mAlertingInternalExt = alertingInternalExt;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getAlertingInternalExt() {
		return this.mAlertingInternalExt;
	}

	/**
	 * 
	 * @param alertingOutsideNumber
	 * @return
	 */
	public Delivered setAlertingOutsideNumber(String alertingOutsideNumber) {
		this.mAlertingOutsideNumber = alertingOutsideNumber;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getAlertingOutsideNumber() {
		return this.mAlertingOutsideNumber;
	}

	/**
	 * 
	 * @param alertingDeviceType
	 * @return
	 */
	public Delivered setAlertingDeviceType(String alertingDeviceType) {
		this.mAlertingDeviceType = alertingDeviceType;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getAlertingDeviceType() {
		return this.mAlertingDeviceType;
	}

	/**
	 * 
	 * @param internalCallingExt
	 * @return
	 */
	public Delivered setInternalCallingExt(String internalCallingExt) {
		this.mInternalCallingExt = internalCallingExt;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getInternalCallingExt() {
		return this.mInternalCallingExt;
	}

	/**
	 * 
	 * @param outsideCallerName
	 * @return
	 */
	public Delivered setOutsideCallerName(String outsideCallerName) {
		this.mOutsideCallerName = outsideCallerName;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getOutsideCallerName() {
		return this.mOutsideCallerName;
	}

	/**
	 * 
	 * @param outsideCallerNumber
	 * @return
	 */
	public Delivered setOutsideCallerNumber(String outsideCallerNumber) {
		this.mOutsideCallerNumber = outsideCallerNumber;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getOutsideCallerNumber() {
		return this.mOutsideCallerNumber;
	}

	/**
	 * 
	 * @param trunkName
	 * @return
	 */
	public Delivered setTrunkName(String trunkName) {
		this.mTrunkName = trunkName;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getTrunkName() {
		return this.mTrunkName;
	}

	/**
	 * 
	 * @param trunkOutsideNumber
	 * @return
	 */
	public Delivered setTrunkOutsideNumber(String trunkOutsideNumber) {
		this.mTrunkOutsideNumber = trunkOutsideNumber;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getTrunkOutsideNumber() {
		return this.mTrunkOutsideNumber;
	}

	/**
	 * 
	 * @param callingDeviceType
	 * @return
	 */
	public Delivered setCallingDeviceType(String callingDeviceType) {
		this.mCallingDeviceType = callingDeviceType;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getCallingDeviceType() {
		return this.mCallingDeviceType;
	}

	/**
	 * 
	 * @param originallyCalledDev
	 * @return
	 */
	public Delivered setOriginallyCalledDev(String originallyCalledDev) {
		this.mOriginallyCalledDev = originallyCalledDev;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getOriginallyCalledDev() {
		return this.mOriginallyCalledDev;
	}

	/**
	 * 
	 * @param lastRedirectionExt
	 * @return
	 */
	public Delivered setLastRedirectionExt(String lastRedirectionExt) {
		this.mLastRedirectionExt = lastRedirectionExt;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getLastRedirectionExt() {
		return this.mLastRedirectionExt;
	}

	/**
	 * 
	 * @param accountCode
	 * @return
	 */
	public Delivered setAccountCode(String accountCode) {
		this.mAccountCode = accountCode;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getAccountCode() {
		return this.mAccountCode;
	}

	/**
	 * 
	 * @param aCDUCDGroup
	 * @return
	 */
	public Delivered setACDUCDGroup(String aCDUCDGroup) {
		this.mACDUCDGroup = aCDUCDGroup;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getACDUCDGroup() {
		return this.mACDUCDGroup;
	}

	/**
	 * 
	 * @param eventParts
	 */
	public Delivered(String[] eventParts) {
		super(eventParts);
	}

	/**
	 * 
	 * @param eventString
	 */
	public Delivered(String eventString) {
		super(eventString);
	}

	/**
	 * 0 <SEQUENCE_NUMBER> 1 <EVENT> 2 <Resync_Code>, 3 <Mon_Cross_Ref_ID> 4
	 * <Call_ID> 5 <Alerting_Internal_Ext> 6 <Alerting_Outside_Number> 7
	 * <Alerting_Device_Type> 8 <Internal_Calling_Ext> 9 <Outside_Caller_Name>
	 * 10 <Outside_Caller_Number> 11 <Trunk_Name> 12 <Trunk_Outside_Number> 13
	 * <Calling_Device_Type> 14 <Originally_Called_Dev> 15
	 * <Last_Redirection_Ext> 16 <Account_Code> 17 <Local_Cnx_State> 18
	 * <Event_Cause> 19 <ACD/UCD_Group>
	 */
	@Override
	protected void parseEvent() {
		super.parseEvent();
		this.setCallID(this.getStringPart(4));

		this.setAlertingInternalExt(this.getStringPart(5));
		this.setAlertingOutsideNumber(this.getStringPart(6));
		this.setAlertingDeviceType(this.getStringPart(7));

		this.setInternalCallingExt(this.getStringPart(8));
		this.setOutsideCallerName(this.getStringPart(9));
		this.setOutsideCallerNumber(this.getStringPart(10));

		this.setTrunkName(this.getStringPart(11));
		this.setTrunkOutsideNumber(this.getStringPart(12));

		this.setCallingDeviceType(this.getStringPart(13));
		this.setOriginallyCalledDev(this.getStringPart(14));
		this.setLastRedirectionExt(this.getStringPart(15));
		this.setAccountCode(this.getStringPart(16));
		this.setLocalCnxState(this.getStringPart(17));
		this.setEventCause(this.getIntPart(18));
		this.setACDUCDGroup(this.getStringPart(19));
	}

	/**
	 * 
	 */
	@Override
	public void process() {
		super.process();

		// Get the call and bind this packet to the call
		mCall = getCall(this.getCallID()).addEvent(this);

		// Bind the call to the appropriate devices/agents
		if (0 == CallingDeviceTypes.EXTERNAL.compareTo(getAlertingDeviceType())) {
			if (0 == CallingDeviceTypes.INTERNAL
					.compareTo(getCallingDeviceType())) {
				processOutboundCall();
			} else {
				processExternalCall();
			}
		} else {
			if (0 == CallingDeviceTypes.EXTERNAL
					.compareTo(getCallingDeviceType())) {
				processInboundCall();
			} else {
				processInternalCall();
			}
		}
	}

	/**
	 * External ----> Internal
	 */
	protected void processInboundCall() {
		mCall.setDirection(CallDirection.INBOUND)
				.setAlertingDevice(getAlertingInternalExt()) // Ext
				.setAlertingHuntGroup(getACDUCDGroup()) // Hunt Group
				.setCallingNumber(getOutsideCallerNumber()) // Caller's CLI
				.setAlertingTrunk(getInternalCallingExt()) // Trunk ID
				.setAlertingNumber(getTrunkOutsideNumber()); // DDI

		// Add the call to the device
		getDevice(getAlertingInternalExt())
			.addCall(getCallID())
			.setCall(getCallID());
	}

	/**
	 * Internal ----> External
	 */
	protected void processOutboundCall() {
		mCall.setDirection(CallDirection.OUTBOUND)
				.setCallingDevice(getInternalCallingExt()) // Ext
				.setCallingTrunk(getAlertingInternalExt()) // Trunk ID
				.setAlertingNumber(getAlertingOutsideNumber()); // Caller's CLI

		// Add the call to the device
		getDevice(getInternalCallingExt())
			.addCall(getCallID())
			.setCall(getCallID());
	}

	/**
	 * Internal ----> Internal
	 */
	protected void processInternalCall() {
		// TODO
	}

	/**
	 * External ----> External
	 */
	protected void processExternalCall() {
		// TODO
	}
}
