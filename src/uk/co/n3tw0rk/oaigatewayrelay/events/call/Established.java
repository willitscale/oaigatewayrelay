package uk.co.n3tw0rk.oaigatewayrelay.events.call;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.CallID;

/**
 * <strong>Diverted Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 08-02-2014
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Pages 33-34
 * 
 *	ESTABLISHED – ES
 *
 *	USE: 
 *		Occurs when the <Answering_Internal_Ext> answers or connects to the specified call and the
 *		call is connected (i.e., in a talking state). This event is also generated when a Resync
 *		Request (RR or _RR) is sent specifically to a trunk device that is connected on a call.
 *
 *	MONITOR TYPE: 
 *		Device, Call, Call via Device
 *
 *	SYNTAX: 
 *		ES,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,
 *		<Answering_Internal_Ext>,<Answering_Outside_Number>,
 *		<Answering_Device_Type>,<Internal_Calling_Ext>,
 *		<Outside_Caller_Number>,<Trunk_Outside_Number>,<Calling_Device_Type>,
 *		<Originally_Called_Dev>,<Last_Redirection_Ext>,<Local_Cnx_State>,
 *		<Event_Cause><CR><LF>
 *
 *	Where:
 *		• Answering_Internal_Ext: Identifies the internal extension of the device answering (connecting)
 *			the call.
 *		• Answering_Outside_Number: Indicates the dialed digit string for an outgoing CO call;
 *			otherwise, this is blank. This will eventually be the “connected number” parameter
 *			from the ISDN CONNect message for PRI facilities.
 *		• Answering_Device_Type: Indicates the type of the device being alerted (I = Internal
 *			Party; E = External Party).
 *		• Internal_Calling_Ext: Identifies the extension of the internal originator of the call. For
 *			internal calls and outgoing CO calls, this is the calling party’s extension. For incoming
 *			CO calls, this is the trunk extension.
 *		• Outside_Caller_Number: Identifies the Caller ID/ANI number for incoming CO calls.
 *			This can be added/modified with the Modify Call (_MD) command but cannot be
 *			deleted. This field is always blank for IC calls.
 *		• Trunk_Outside_Number: Indicates the DNIS or DID outside number associated with
 *			the trunk used for the call. This can be added/modified with the Modify Call (_MD)
 *			command but cannot be deleted. This field is always blank for IC calls.
 *		• Calling_Device_Type: Indicates the type of calling device (I = Internal Party; E =
 *			External Party).
 *		• Originally_Called_Dev: Indicates the initial call destination if the call has never been
 *			answered. For IC and incoming CO calls, this is the originally dialed extension. For
 *			outgoing CO calls, this is the dialed digit string. The initial transfer destination for a
 *			transferred call and the initial recall destination for a recalling call become the originally
 *			called device.
 *		• Last_Redirection_Ext: Identifies the extension number of the last device that redirected
 *			(forwarded, deflected, transferred, or recalled) the call, if applicable; otherwise, this is
 *			blank.
 *
 *	EXAMPLES: 
 *		Extension 100 calls extension 101, and extension 101 answers.
 *		001,OR,,<MON100>,245,100,,I,101,,C,22
 *		002,DE,,<MON101>,245,101,,I,100,,,,,I,101,,,A,22
 *		003,DE,,<MON100>,245,101,,I,100,,,,,I,101,,,C,22
 *		004,ES,,<MON100>,245,101,,I,100,,,I,101,,C,35
 *		005,ES,,<MON101>,245,101,,I,100,,,I,101,,C,35
 *		Incoming CO call from 602-555-1212 to 800-222-5555 rings directly to extension 105, and
 *		extension 105 answers the call.
 *		001,OR,,<MON97061>,245,97061,6025551212,E,8002225555,,C,22
 *		002,DE,,<MON105>,245,105,,I,97061,,6025551212,,8002225555,E,105,,,
 *		A,22
 *		003,DE,,<MON97061>,245,105,,I,97061,,6025551212,,8002225555,E,105,,,
 *		C,22
 *		004,ES,,<MON97061>,245,105,,I,97061,6025551212,80022255555,E,105,,
 *		C,35
 *		005,ES,,<MON105>,245,105,,I,97061,6025551212,80022255555,E,105,,C,35
 *		Extension 100 calls extension 101, and extension 102 reverse transfers the call from extension
 *		101.
 *		001,OR,,<MON100>,245,100,,I,101,C,22
 *		002,DE,,<MON101>,245,101,,I,100,,,,,I,101,,,A,22
 *		003,DE,,<MON100>,245,101,,I,100,,,,,,I,101,,,C,22
 *		004,DI,,<MON101>,245,101,102,,N,11
 *		005,DI,,<MON100>,245,101,102,,C,11
 *		006,DI,,<MON102>,245,101,102,,C,11
 *		007,ES,,<MON100>,245,102,,I,100,,,I,101,,C,35
 *		008,ES,,<MON102>,245,102,,I,100,,,I,101,,C,35
 */
public class Established extends CallID
{
	public final static String EVENT = "ES";
	
	protected int mAnsweringInternalExt;
	protected String mAnsweringOutsideNumber;
	protected String mAnsweringDeviceType;
	protected int mInternalCallingExt;
	protected String mOutsideCallerNumber;
	protected int mTrunkOutsideNumber;
	protected String mCallingDeviceType;
	protected int mOriginallyCalledDev;
	protected int mLastRedirectionExt;

	public Established setAnsweringInternalExt( int answeringInternalExt )
	{
		this.mAnsweringInternalExt = answeringInternalExt;
		return this;
	}
	
	public int getAnsweringInternalExt()
	{
		return this.mAnsweringInternalExt;
	}
	
	public Established setAnsweringOutsideNumber( String answeringOutsideNumber )
	{
		this.mAnsweringOutsideNumber = answeringOutsideNumber;
		return this;
	}
	
	public String getAnsweringOutsideNumber()
	{
		return this.mAnsweringOutsideNumber;
	}
	
	public Established setAnsweringDeviceType( String answeringDeviceType )
	{
		this.mAnsweringDeviceType = answeringDeviceType;
		return this;
	}
	
	public String getAnsweringDeviceType()
	{
		return this.mAnsweringDeviceType;
	}

	public Established setInternalCallingExt( int internalCallingExt )
	{
		this.mInternalCallingExt = internalCallingExt;
		return this;
	}
	
	public int getInternalCallingExt()
	{
		return this.mInternalCallingExt;
	}

	public Established setOutsideCallerNumber( String outsideCallerNumber )
	{
		this.mOutsideCallerNumber = outsideCallerNumber;
		return this;
	}
	
	public String getOutsideCallerNumber()
	{
		return this.mOutsideCallerNumber;
	}

	public Established setTrunkOutsideNumber( int trunkOutsideNumber )
	{
		this.mTrunkOutsideNumber = trunkOutsideNumber;
		return this;
	}
	
	public int getTrunkOutsideNumber()
	{
		return this.mTrunkOutsideNumber;
	}

	public Established setCallingDeviceType( String callingDeviceType )
	{
		this.mCallingDeviceType = callingDeviceType;
		return this;
	}
	
	public String getCallingDeviceType()
	{
		return this.mCallingDeviceType;
	}

	public Established setOriginallyCalledDev( int originallyCalledDev )
	{
		this.mOriginallyCalledDev = originallyCalledDev;
		return this;
	}
	
	public int getOriginallyCalledDev()
	{
		return this.mOriginallyCalledDev;
	}

	public Established setLastRedirectionExt( int lastRedirectionExt )
	{
		this.mLastRedirectionExt = lastRedirectionExt;
		return this;
	}
	
	public int getLastRedirectionExt()
	{
		return this.mLastRedirectionExt;
	}
	
	public Established( String[] eventParts )
	{
		super( eventParts );
	}

	public Established( String eventString )
	{
		super( eventString );
	}


	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <Call_ID>
	 * 5 <Answering_Internal_Ext>
	 * 6 <Answering_Outside_Number>
	 * 7 <Answering_Device_Type>
	 * 8 <Internal_Calling_Ext>
	 * 9 <Outside_Caller_Number>
	 * 10 <Trunk_Outside_Number>
	 * 11 <Calling_Device_Type>
	 * 12 <Originally_Called_Dev>
	 * 13 <Last_Redirection_Ext>
	 * 14 <Local_Cnx_State>
	 * 15 <Event_Cause>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setCallID( this.getStringPart( 4 ) );
		this.setAnsweringInternalExt( this.getIntPart( 5 ) );
		this.setAnsweringOutsideNumber( this.getStringPart( 6 ) );
		this.setAnsweringDeviceType( this.getStringPart( 7 ) );
		this.setInternalCallingExt( this.getIntPart( 8 ) );
		this.setOutsideCallerNumber( this.getStringPart( 9 ) );
		this.setTrunkOutsideNumber( this.getIntPart( 10 ) );
		this.setCallingDeviceType( this.getStringPart( 11 ) );
		this.setOriginallyCalledDev( this.getIntPart( 12 ) );
		this.setLastRedirectionExt( this.getIntPart( 13 ) );
		this.setLocalCnxState( this.getStringPart( 14 ) );
		this.setEventCause( this.getIntPart( 15 ) );
	}

	@Override
	public void process()
	{
	}
	
}
