package uk.co.n3tw0rk.oaigatewayrelay.events.call;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.CallID;
import uk.co.n3tw0rk.oaigatewayrelay.controllers.SystemController;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Call;

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
public class Delivered extends CallID
{
	public final static String EVENT = "DE";

	protected int mAlertingInternalExt;
	protected int mAlertingOutsideNumber;
	protected String mAlertingDeviceType;

	protected int mInternalCallingExt;
	protected String mOutsideCallerName;
	protected int mOutsideCallerNumber;

	protected String mTrunkName;
	protected int mTrunkOutsideNumber;
	protected String mCallingDeviceType;

	protected int mOriginallyCalledDev;
	protected int mLastRedirectionExt;
	protected int mAccountCode;
	protected int mACDUCDGroup;
	
	public Delivered setAlertingInternalExt( int alertingInternalExt )
	{
		this.mAlertingInternalExt = alertingInternalExt;
		return this;
	}
	
	public int getAlertingInternalExt()
	{
		return this.mAlertingInternalExt;
	}
	
	public Delivered setAlertingOutsideNumber( int alertingOutsideNumber )
	{
		this.mAlertingOutsideNumber = alertingOutsideNumber;
		return this;
	}
	
	public int setAlertingOutsideNumber()
	{
		return this.mAlertingOutsideNumber;
	}
	
	public Delivered setAlertingDeviceType( String alertingDeviceType )
	{
		this.mAlertingDeviceType = alertingDeviceType;
		return this;
	}
	
	public String setAlertingDeviceType()
	{
		return this.mAlertingDeviceType;
	}

	public Delivered setInternalCallingExt( int internalCallingExt )
	{
		this.mInternalCallingExt = internalCallingExt;
		return this;
	}
	
	public int getInternalCallingExt()
	{
		return this.mInternalCallingExt;
	}

	public Delivered setOutsideCallerName( String outsideCallerName )
	{
		this.mOutsideCallerName = outsideCallerName;
		return this;
	}
	
	public String getOutsideCallerName()
	{
		return this.mOutsideCallerName;
	}

	public Delivered setOutsideCallerNumber( int outsideCallerNumber )
	{
		this.mOutsideCallerNumber = outsideCallerNumber;
		return this;
	}
	
	public int getOutsideCallerNumber()
	{
		return this.mOutsideCallerNumber;
	}

	public Delivered setTrunkName( String trunkName )
	{
		this.mTrunkName = trunkName;
		return this;
	}
	
	public String getTrunkName()
	{
		return this.mTrunkName;
	}

	public Delivered setTrunkOutsideNumber( int trunkOutsideNumber )
	{
		this.mTrunkOutsideNumber = trunkOutsideNumber;
		return this;
	}
	
	public int getTrunkOutsideNumber()
	{
		return this.mTrunkOutsideNumber;
	}

	public Delivered setCallingDeviceType( String callingDeviceType )
	{
		this.mCallingDeviceType = callingDeviceType;
		return this;
	}
	
	public String getCallingDeviceType()
	{
		return this.mCallingDeviceType;
	}

	public Delivered setOriginallyCalledDev( int originallyCalledDev )
	{
		this.mOriginallyCalledDev = originallyCalledDev;
		return this;
	}
	
	public int getOriginallyCalledDev()
	{
		return this.mOriginallyCalledDev;
	}


	public Delivered setLastRedirectionExt( int lastRedirectionExt )
	{
		this.mLastRedirectionExt = lastRedirectionExt;
		return this;
	}
	
	public int getLastRedirectionExt()
	{
		return this.mLastRedirectionExt;
	}


	public Delivered setAccountCode( int accountCode )
	{
		this.mAccountCode = accountCode;
		return this;
	}
	
	public int getAccountCode()
	{
		return this.mAccountCode;
	}


	public Delivered setACDUCDGroup( int aCDUCDGroup )
	{
		this.mACDUCDGroup = aCDUCDGroup;
		return this;
	}
	
	public int getACDUCDGroup()
	{
		return this.mACDUCDGroup;
	}

	public Delivered( String[] eventParts )
	{
		super( eventParts );
	}

	public Delivered( String eventString )
	{
		super( eventString );
	}

	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>,
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <Call_ID>
	 * 5 <Alerting_Internal_Ext>
	 * 6 <Alerting_Outside_Number>
	 * 7 <Alerting_Device_Type>
	 * 8 <Internal_Calling_Ext>
	 * 9 <Outside_Caller_Name>
	 * 10 <Outside_Caller_Number>
	 * 11 <Trunk_Name>
	 * 12 <Trunk_Outside_Number>
	 * 13 <Calling_Device_Type>
	 * 14 <Originally_Called_Dev>
	 * 15 <Last_Redirection_Ext>
	 * 16 <Account_Code>
	 * 17 <Local_Cnx_State>
	 * 18 <Event_Cause>
	 * 19 <ACD/UCD_Group>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setCallID( this.getStringPart( 4 ) );
		this.setAlertingInternalExt( this.getIntPart( 5 ) );
		this.setAlertingOutsideNumber( this.getIntPart( 6 ) );
		this.setAlertingDeviceType( this.getStringPart( 7 ) );
		this.setInternalCallingExt( this.getIntPart( 8 ) );
		this.setOutsideCallerName( this.getStringPart( 9 ) );
		this.setTrunkName( this.getStringPart( 10 ) );
		this.setTrunkOutsideNumber( this.getIntPart( 11 ) );
		this.setCallingDeviceType( this.getStringPart( 12 ) );
		this.setOriginallyCalledDev( this.getIntPart( 13 ) );
		this.setLastRedirectionExt( this.getIntPart( 14 ) );
		this.setAccountCode( this.getIntPart( 15 ) );
		this.setLocalCnxState( this.getStringPart( 16 ) );
		this.setEventCause( this.getIntPart( 17 ) );
		this.setACDUCDGroup( this.getIntPart( 18 ) );
	}

	@Override
	public void process()
	{
		super.process();

		Call call = SystemController.instance().getCalls().getStructure( this.getCallID() );
		
		call.setCallID( this.getCallID() );
	}
}
