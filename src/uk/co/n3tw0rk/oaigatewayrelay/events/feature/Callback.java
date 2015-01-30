package uk.co.n3tw0rk.oaigatewayrelay.events.feature;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Feature;
import uk.co.n3tw0rk.oaigatewayrelay.events.gateway.ConnectionStatusEvent;

/**
 * <strong>Callback Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 30-01-2015
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 43
 * 
 * 	CALLBACK – CB
 * 
 * 	NOTE: 
 * 		This event is available only in protocol versions 08.10 and later.
 * 
 * 	USE: 
 * 		Occurs when a device registers or removes a register for a callback. Currently, only the device
 * 		registering or deregistering the callback request issues this event. Because future System OAI
 * 		versions, might issue this event for other devices and/or calls, applications should use all
 * 		parameters within this event to understand the event meaning.
 * 
 * 	NOTE: 
 * 		This event is issued only if bit #12 in the feature-event bit mask is enabled. By default,
 * 		this filter bit is off.
 * 
 * 	MONITOR TYPE: 
 * 		Device
 * 
 * 	SYNTAX: 
 * 		CB,<Resync_Code>,<Mon_Cross_Ref_ID>,<On/Off>,<Affected_Ext>,
 * 		<Target_Ext>,<|Target_Username|>,<|Target_PC_Description|>,
 * 		<Account_Code>,<Outside_Number><CR><LF>
 * 
 * 	Where:
 * 		• On/Off: Indicates whether the callback register was initiated (1) or removed (0).
 * 		• Affected_Ext: Specifies the device requesting the callback (i.e., the requestor).
 * 		• Target_Ext: Indicates the device extension for which the <Affected_Ext> requested a
 * 			callback.
 * 		• Target_Username: Identifies the username programmed for the <Target_Ext>. This
 * 			field is delimited by vertical slashes ( | ).
 * 		• Target_PC_Description: Indicates the <Target_Ext> PC description. This field is delimited
 * 			by vertical slashes ( | ).
 * 		• Account_Code: Specifies the account code if Call Processing collected an account code
 * 			before the callback request occurred. If no account code was collected, this field is
 * 			blank.
 * 		• Outside_Number: Indicates the outside number that Call Processing collected before
 * 			the callback request occurred. If Call Processing modified the number, this field will not
 * 			match the exact number the user dialed. If the call is an IC call or if call processing has
 * 			not collected the outside number, this field is blank.
 * 
 * 	GATEWAY IMPACTS: 
 * 		CT Gateway version 4.1 or later is required to use this event.
 * 
 * 	EXAMPLES: 
 * 		Extension 100 calls 101, but 101 is in DND. Extension 100 requests a callback.
 * 		001,SI,,<MON100>,57301,100,I,22,
 * 		002,OR,,<MON100>,57301,100,,I,1002,,C,22
 * 		003,FA,,<MON100>,57301,101,101,C,14
 * 		_RCB,<InvokeID>,100,57301
 * 		004,CF,_RCB,<InvokeID>,0
 * 		005,XC,,<MON100>,57301,100,100,N,04
 * 		006,CB,,<MON100>,1,100,101,|USER101|,|101Description|,,
 * 		Cancel a callback request where extension 100 is the requestor and extension 101 is the
 * 		target.
 * 		_CCB,<InvokeID>,100,101
 * 		001,CF,_CCB,<InvokeID>,0
 * 		002,CB,,<MON100>,0,100,101,|USER101|,|101Description|,,
 * 		Extension 1001 calls Extension 1002, but 1002 is busy. 1001 manually requests a callback.
 * 		001,SI,,<MON1001>,1P01,1001,I,22,
 * 		002,OR,,<MON1001>,1P01,1001,,I,1002,,C,22
 * 		003,DE,,<MON1002>,1P01,1002,,I,1001,,,,,I,1002,,,A,22,
 * 		004,DE,,<MON1001>,1P01,1002,,I,1001,,,,,I,1002,,,C,22,
 * 		005,XC,,<MON1001>,1P01,1001,1001,N,04
 * 		006,XC,,<MON1002>,1P01,1001,1001,,36
 * 		007,XC,,<MON1002>,1P01,1002,1001,N,36
 * 		008,CB,,<MON1001>,1,1001,1002,|USER1002|,|1002Description|,,
 * 		When 1002 becomes available, several things could happen, including one of the following
 * 		four scenarios.
 * 		1. Extension 1001 answers the callback prompt (either manually or with the Answer Call
 * 		command). The callback is automatically deregistered.
 * 		009,SI,,<MON1001>,1F01,1001,I,04,1002
 * 		_AC,1,1001,1F01
 * 		010,CF,_AC,1,0
 * 		011,CB,,<MON1001>,0,1001,1002,|USER1002|,|1002Description|,,
 * 		012,OR,,<MON1001>,1F01,1001,,I,1002,,C,04
 * 		013,DE,,<MON1002>,1F01,1002,,I,1001,,,,,I,1002,,,A,22,
 * 		014,DE,,<MON1001>,1F01,1002,,I,1001,,,,,I,1002,,,C,22,
 * 		2. Extension 1001 ignores the callback prompt. The callback times out and deregisters itself.
 * 		009,SI,,<MON1001>,1F01,1001,I,04,1002
 * 		010,CB,,<MON1001>,0,1001,1002,|USER1002|,|1002Description|,,
 * 		011,XC,,<MON1001>,1F01,1002,1002,N,36
 * 		3. Extension 1002 becomes busy before 1001 answers the prompt. The prompt stops, but the
 * 		callback is still registered.
 * 		009,SI,,<MON1001>,1F01,1001,I,04,1002
 * 		010,XC,,<MON1001>,1F01,1002,1002,N,36
 * 		4. Extension 1001 cancels the callback manually, with the Clear Connection command or
 * 		with the Cancel Callback command.
 * 		009,SI,,<MON1001>,1F01,1001,I,04,1002
 * 		_CCB,1,1001,1002
 * 		010,CF,_CCB,1,0
 * 		011,CB,,<MON1001>,0,1001,1002,|USER1002|,|1002Description|,,
 * 		012,XC,,<MON1001>,1F01,1002,10021001,1000,N,36
 */
public class Callback extends Feature
{
	/** On/Off */
	protected int mOnOff;
	/** Affected_Ext */
	protected int mAffectedExt;
	/** Target_Ext */
	protected int mTargetExt;
	/** Target_Username */
	protected String mTargetUsername;
	/** Target_PC_Description */
	protected String mTargetPCDescription;
	/** Account_Code */
	protected int mAccountCode;
	/** Outside_Number */
	protected int mOutsideNumber;

	public Callback( String event )
	{
		super( event );
	}

	public Callback( String[] eventParts )
	{
		super( eventParts );
	}
	
	public Callback setOnOff( int onOff )
	{
		this.mOnOff = onOff;
		return this;
	}
	
	public int getOnOff()
	{
		return this.mOnOff;
	}
	
	public Callback setAffectedExt( int affectedExt )
	{
		this.mAffectedExt = affectedExt;
		return this;
	}
	
	public int getAffectedExt()
	{
		return this.mAffectedExt;
	}
	
	public Callback setTargetExt( int targetExt )
	{
		this.mTargetExt = targetExt;
		return this;
	}
	
	public int getTargetExt()
	{
		return this.mTargetExt;
	}
	
	public Callback setTargetUsername( String targetUsername )
	{
		this.mTargetUsername = targetUsername;
		return this;
	}
	
	public String getTargetUsername()
	{
		return this.mTargetUsername;
	}
	
	public Callback setTargetPCDescription( String targetPCDescription )
	{
		this.mTargetPCDescription = targetPCDescription;
		return this;
	}
	
	public String getTargetPCDescription()
	{
		return this.mTargetPCDescription;
	}
	
	public Callback setAccountCode( int accountCode )
	{
		this.mAccountCode = accountCode;
		return this;
	}
	
	public int getAccountCode()
	{
		return this.mAccountCode;
	}
	
	public Callback setOutsideNumber( int outsideNumber )
	{
		this.mOutsideNumber = outsideNumber;
		return this;
	}
	
	public int getOutsideNumber()
	{
		return this.mOutsideNumber;
	}

	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <On/Off>
	 * 5 <Affected_Ext>
	 * 6 <Target_Ext>
	 * 7 <|Target_Username|>
	 * 8 <|Target_PC_Description|>
	 * 9 <Account_Code>
	 * 10 <Outside_Number>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setOnOff( this.getIntPart( 4 ) );
		this.setAffectedExt( this.getIntPart( 5 ) );
		this.setTargetExt( this.getIntPart( 6 ) );
		this.setTargetUsername( this.getStringPart( 7 ) );
		this.setTargetPCDescription( this.getStringPart( 8 ) );
		this.setAccountCode( this.getIntPart( 9 ) );
		this.setOutsideNumber( this.getIntPart( 10 ) );
	}
}
