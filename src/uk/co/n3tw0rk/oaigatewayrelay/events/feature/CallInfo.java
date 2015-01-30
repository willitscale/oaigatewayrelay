package uk.co.n3tw0rk.oaigatewayrelay.events.feature;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Feature;

/**
 * <strong>Call Info Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 30-01-2015
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 45
 * 
 * 	CALL INFO – CI
 * 
 * 	USE: 
 * 		Occurs when a user account code is collected for a party on the call. This includes all account
 * 		code types (e.g., forced, standard, optional, etc.).
 * 
 * 	MONITOR TYPE: 
 * 		Device, Call, Call via Device
 * 
 * 	SYNTAX: 
 * 		CI,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,<Device_Ext>,
 * 		<Account_Code><CR><LF>
 * 
 * 	Where:
 * 		• Device_Ext: Displays the extension of the station that entered the account code.
 * 		• Account_Code: Identifies the account code for the call.
 * 	
 * 	EXAMPLES: 
 * 		Extension 100 enters account code 12345 on call 037.
 * 		001,CI,,<MON100>,037,100,12345
 * 		The Make Call command is used to make an outgoing CO call from extension 1000 to
 * 		9619000 using account code 1234.
 * 		001,OR,,<MON1000>,037,1000,,I,9619000,1234,C,22
 * 		002,CI,,<MON1000>,037,1000,1234
 * 		A call with an attached account code is transferred from extension 1000 to extension 1002.
 * 		014,TR,,<MON102>,037,100,101,@002,102,,,,,A,32
 * 		015,XC,,<MON102>,038,100,100,,36
 * 		016,XC,,<MON102>,037,102,100,N,36
 * 		017,CI,<MON1002>,037,1002,1234
 */
public class CallInfo extends Feature
{
	public final static String EVENT = "CI";

	/** Call_ID */
	protected int mCallID;
	/** Device_Ext */
	protected int mDeviceExt;
	/** Account_Code */
	protected int mAccountCode;

	public CallInfo( String event )
	{
		super( event );
	}

	public CallInfo( String[] eventParts )
	{
		super( eventParts );
	}
	
	public CallInfo setCallID( int callID )
	{
		this.mCallID = callID;
		return this;
	}
	
	public int getCallID()
	{
		return this.mCallID;
	}

	public CallInfo setDeviceExt( int deviceExt )
	{
		this.mDeviceExt = deviceExt;
		return this;
	}
	
	public int getDeviceExt()
	{
		return this.mDeviceExt;
	}
	
	public CallInfo setAccountCode( int accountCode )
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
	 * 2 <Resync_Code>
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <Call_ID>
	 * 5 <Device_Ext>
	 * 6 <Account_Code>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setCallID( this.getIntPart( 4 ) );
		this.setDeviceExt( this.getIntPart( 5 ) );
		this.setAccountCode( this.getIntPart( 6 ) );
	}
}
