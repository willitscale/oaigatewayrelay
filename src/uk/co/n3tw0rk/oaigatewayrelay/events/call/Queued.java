package uk.co.n3tw0rk.oaigatewayrelay.events.call;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.CallID;
import uk.co.n3tw0rk.oaigatewayrelay.controllers.SystemController;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Call;

/**
 * <strong>Failed Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 17-02-2014
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Pages 38-39
 * 
 * 	QUEUED – QU
 * 
 * 	USE: 
 * 		Indicates that a call has been delivered or redirected to a trunk group or hunt/ACD group, and
 * 		the call queues (“camps on” in the Inter-Tel telephone system family).
 * 
 * 	MONITOR TYPE: 
 * 		Device, Call, Call via Device
 * 
 * 	SYNTAX: 
 * 		QU,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,<Queued_Ext>,
 * 		<Internal_Calling_Ext>,<Outside_Caller_Name>,<Outside_Caller_Number>,
 * 		<Trunk_Name>,<Trunk_Outside_Number>,<Calling_Device_Type>,
 * 		<Originally_Called_Dev>,<Last_Redirection_Ext>,<Number_Queued>,
 * 		<Account_Code>,<Local_Cnx_State>,<Event_Cause><CR><LF>
 * 
 * 	Where:
 * 		• Queued_Ext: Indicates the device where the call is queued.
 * 		• Internal_Calling_Ext: Indicates the extension number of the internal call originator. For
 * 			internal calls and outgoing CO calls, this is the calling party’s extension. For incoming
 * 			CO calls, this is the trunk extension.
 * 		• Outside_Caller_Name: Identifies the Caller ID/ANI name for incoming CO calls. This
 * 			can be added/modified with the Modify Call (_MD) command but cannot be
 * 			deleted. This text field is always blank for IC calls.
 * 		• Outside_Caller_Number: Indicates the outside caller’s Caller ID/ANI number, if available.
 * 			This can be added/modified with the Modify Call (_MD) command but cannot
 * 			be deleted. This field is always blank for IC calls.
 * 		• Trunk_Name: Displays the name associated with the trunk used for the call (e.g., the
 * 			name programmed in the system’s call routing table for the incoming number dialed
 * 			[DNIS/DID]). This can be added/modified with the Modify Call (_MD) command
 *			but cannot be deleted. This text field is always blank for IC calls.
 *		• Trunk_Outside_Number: Indicates the DNIS or DID outside number associated with
 *			the trunk used for the call. This can be added/modified with the Modify Call (_MD)
 *			command but cannot be deleted. This field is always blank for IC calls.
 *		• Calling_Device_Type: Indicates the type of the calling device (I = Internal Party; E =
 *			External Party).
 *		• Originally_Called_Dev: Indicates the initial call destination if the call has never been
 *			answered. For IC and incoming CO calls, this is the originally dialed extension. For
 *			outgoing CO calls, this is the dialed digit string. The initial transfer destination for a
 *			transferred call and the initial recall destination for a recalling call become the originally
 *			called device.
 *		• Last_Redirection_Ext: Identifies the extension number of the last device that redirected
 *			(forwarded, deflected, transferred, or recalled) the call, if applicable; otherwise, this is
 *			blank.
 *		• Number_Queued: Indicates the call’s position in the queue (1-65535), where a “1” indicates
 *			that the call is the first call waiting for an available device to ring.
 *		• Event_Cause: Indicates why the event occurred. The only possible values for this field
 *			are as follows:
 *			23 = No available agents
 *			30 = Some resource is not available
 *			33 = Trunks busy
 *			40 = Transfer announcement (takes precedence over the other two)
 *	
 *	EXAMPLE: 
 *		Incoming CO call from 602-555-1212 to 800-222-5555 (using trunk 97061) rings directly to a
 *		busy ACD group (273).
 *		001,QU,,<MON273>,18532,273,,I,97061,,6025551212,,8002225555,E,273,,1,,
 *		Q,23
 *		002,QU,,<MON97061>,18532,273,,I,97061,,6025551212,,8002225555,E,273,,
 *		1,,C,23
 */
public class Queued extends CallID
{
	public final static String EVENT = "QU";
	
	protected int mQueuedExt;
	protected int mInternalCallingExt;
	protected String mOutsideCallerName;
	protected String mOutsideCallerNumber;
	protected String mTrunkName;
	protected String mTrunkOutsideNumber;
	protected String mCallingDeviceType;
	protected int mOriginallyCalledDev;
	protected int mLastRedirectionExt;
	protected int mNumberQueued;
	protected int mAccountCode;
	
	public Queued( String[] eventParts )
	{
		super( eventParts );
	}

	public Queued( String eventString )
	{
		super( eventString );
	}
	
	public Queued setQueuedExt( int queuedExt )
	{
		this.mQueuedExt = queuedExt;
		return this;
	}
	
	public int getQueuedExt()
	{
		return this.mQueuedExt;
	}
	
	public Queued setInternalCallingExt( int internalCallingExt )
	{
		this.mInternalCallingExt = internalCallingExt;
		return this;
	}
	
	public int getInternalCallingExt()
	{
		return this.mInternalCallingExt;
	}
	
	public Queued setOutsideCallerName( String outsideCallerName )
	{
		this.mOutsideCallerName = outsideCallerName;
		return this;
	}
	
	public String getOutsideCallerName()
	{
		return this.mOutsideCallerName;
	}
	
	public Queued setOutsideCallerNumber( String outsideCallerNumber )
	{
		this.mOutsideCallerNumber = outsideCallerNumber;
		return this;
	}
	
	public String getOutsideCallerNumber()
	{
		return this.mOutsideCallerNumber;
	}
	
	public Queued setTrunkName( String trunkName )
	{
		this.mTrunkName = trunkName;
		return this;
	}
	
	public String getTrunkName()
	{
		return this.mTrunkName;
	}
	
	public Queued setTrunkOutsideNumber( String trunkOutsideNumber )
	{
		this.mTrunkOutsideNumber = trunkOutsideNumber;
		return this;
	}
	
	public String getTrunkOutsideNumber()
	{
		return this.mTrunkOutsideNumber;
	}
	
	public Queued setCallingDeviceType( String callingDeviceType )
	{
		this.mCallingDeviceType = callingDeviceType;
		return this;
	}
	
	public String getCallingDeviceType()
	{
		return this.mCallingDeviceType;
	}
	
	public Queued setOriginallyCalledDev( int originallyCalledDev )
	{
		this.mOriginallyCalledDev = originallyCalledDev;
		return this;
	}
	
	public int getOriginallyCalledDev()
	{
		return this.mOriginallyCalledDev;
	}
	
	public Queued setLastRedirectionExt( int lastRedirectionExt )
	{
		this.mLastRedirectionExt = lastRedirectionExt;
		return this;
	}
	
	public int getLastRedirectionExt()
	{
		return this.mLastRedirectionExt;
	}
	
	public Queued setNumberQueued( int numberQueued )
	{
		this.mNumberQueued = numberQueued;
		return this;
	}
	
	public int getNumberQueued()
	{
		return this.mNumberQueued;
	}
	
	public Queued setAccountCode( int accountCode )
	{
		this.mAccountCode = accountCode;
		return this;
	}
	
	public int getAccountCode()
	{
		return this.mAccountCode;
	}
	
	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>,
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <Call_ID>
	 * 5 <Queued_Ext>
	 * 6 <Internal_Calling_Ext>
	 * 7 <Outside_Caller_Name>
	 * 8 <Outside_Caller_Number>
	 * 9 <Trunk_Name>
	 * 10 <Trunk_Outside_Number>
	 * 11 <Calling_Device_Type>
	 * 12 <Originally_Called_Dev>
	 * 13 <Last_Redirection_Ext>
	 * 14 <Number_Queued>
	 * 15 <Account_Code>
	 * 16 <Local_Cnx_State>
	 * 17 <Event_Cause>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setCallID( this.getStringPart( 4 ) );
		this.setQueuedExt( this.getIntPart( 5 ) );
		this.setInternalCallingExt( this.getIntPart( 6 ) );
		this.setOutsideCallerName( this.getStringPart( 7 ) );
		this.setOutsideCallerNumber( this.getStringPart( 8 ) );
		this.setTrunkName( this.getStringPart( 9 ) );
		this.setTrunkOutsideNumber( this.getStringPart( 10 ) );
		this.setCallingDeviceType( this.getStringPart( 11 ) );
		this.setOriginallyCalledDev( this.getIntPart( 12 ) );
		this.setLastRedirectionExt( this.getIntPart( 13 ) );
		this.setNumberQueued( this.getIntPart( 14 ) );
		this.setAccountCode( this.getIntPart( 15 ) );
		this.setLocalCnxState( this.getStringPart( 16 ) );
		this.setEventCause( this.getIntPart( 17 ) );
	}

	@Override
	public void process()
	{
		super.process();

		Call call = SystemController.instance().getCalls().getStructure( this.getCallID() );

		call.setCallID( this.getCallID() );
	}
}
