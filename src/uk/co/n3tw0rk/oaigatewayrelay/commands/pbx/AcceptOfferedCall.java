package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.commands.AffectedExt;
import uk.co.n3tw0rk.oaigatewayrelay.abstraction.commands.Command;

/**
 * 
 * <strong>Accept Offered Call Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 01-02-2015
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 91
 * 
 * 	ACCEPT OFFERED CALL – _AOC
 * 
 * 	NOTE: 
 * 		This command is available only in protocol versions 07.00 and later.
 * 
 * 	USE: 
 * 		Allows an application to indicate that it will not re-route an offered call and that the call will
 * 		follow normal call processing functionality (see page 141 for information about the Offering
 * 		Request command). The call is delivered to the device as if there were no applications
 * 		involved.
 * 
 * 	PREMIUM FEATURE: 
 * 		System OAI Third-Party Call Control
 * 
 * 	SYNTAX (V = 07.00):
 * 		_AOC,<InvokeID>,<Affected_Ext>,<Call_ID><CR>
 * 
 * 	SYNTAX(07.00 < V < 08.10):
 * 		_AOC,<InvokeID>,<Affected_Ext>,<Call_ID>,<Prohibit_Immediate_Connect><CR>
 * 	
 * 	SYNTAX (V >= 08.10):
 * 		_AOC,<InvokeID>,<Affected_Ext>,<Call_ID>,<Prohibit_Immediate_Connect>,<Override_DND><CR>
 * 
 * 	Where:
 * 		• Affected_Ext: Indicates the keyset or a single-line station where the offered call is waiting.
 * 		• Call_ID: Indicates the call ID of the offered call.
 * 		• Prohibit_Immediate_Connect: (Optional) Determines if the call immediately connects
 * 		at the device. If enabled (set to 1), the call does not automatically connect at the
 * 		<Affected_Ext> and rings the device, even if the call is handsfree. If disabled (set to 0),
 * 		the call behaves normally.
 * 			
 * 		NOTE: 
 * 			This parameter does not override DND or forward settings.
 * 	
 * 		• Override_DND: (Optional) Indicates whether or not the call should override DND if
 * 		the <Affected_Ext> is in DND (0 = Do NOT Override; 1 = Override). If blank, the
 * 		default value of Do NOT Override (0) is used.
 * 		
 * 		NOTE: 
 * 			Calls accepted at a device that has handsfree enabled and is in DND do not
 * 			come in handsfree. This is the same way that DND override works when requested via
 * 			a feature code.
 * 
 * 		CONFIRMATION: 
 * 			<Sequence_Number>,CF,_AOC,<InvokeID>,<Outcome>,<Affected_Ext>,<Call_ID><CR><LF>
 * 
 * 		COMMON FAILURE OUTCOME VALUES:
 * 			Invalid Call ID (8): The <Call_ID> parameter is blank or invalid.
 * 			Invalid Device ID (9): The <Affected_Ext> parameter is blank or invalid.
 * 			Generic State Incompatibility (15): The call is either not present at the station or is not in the
 * 			offering state.
 * 			Value_Out_of_Range (31): The value entered for a field is not in the valid range. For example,
 * 			the <Override_DND> value specified is neither “0” nor “1.”
 * 
 * 		DESKTOP OAI: 
 * 			None
 * 
 * 		GATEWAY IMPACT: 
 * 			This command is available only in CT Gateway versions 3.0 and later.
 * 
 * 		EXAMPLES: 
 * 			The application indicates that the phone system should deliver the call.
 * 			_AOC,245,100,*01
 * 			003,CF,_AOC,245,0,100,*01
 * 			The application indicates that the phone system should deliver the call and ring extension
 * 			100.
 * 			_AOC,245,100,*01,1
 * 			003,CF,_AOC,245,0,100,*01
 * 			The application indicates that the phone system should deliver the call.
 * 			Accept offered call (Call_ID *01) at device 100. Do not disable handsfree and do not override
 * 			DND.
 * 			_AOC,245,100,*01
 * 			003,CF,_AOC,245,0,100,*01
 * 			Accept offered call (Call_ID *01) at device 100. Do not disable handsfree but override DND.
 * 			_AOC,246,100,*01,,1
 * 			003,CF,_AOC,246,0,100,*01
 * 			Accept offered call (Call_ID *01) at device 100. Disable handsfree but do not override DND.
 * 			_AOC,247,100,*01,1
 * 			003,CF,_AOC,247,0,100,*01
 * 			Accept offered call (Call_ID *01) at device 100. Do not disable handsfree and do not override
 * 			DND.
 * 			_AOC,248,100,*01,,
 * 			003,CF,_AOC,248,0,100,*01
 * 			Accept offered call (Call_ID *01) at device 100. Disable handsfree and override DND.
 * 			_AOC,249,100,*01,1,1
 * 			003,CF,_AOC,249,0,100,*01
 */
public class AcceptOfferedCall extends AffectedExt
{
	public static final String COMMAND = "_AOC";

	protected String mCallID;
	protected int mProhibitImmediateConnect;
	protected int mOverrideDND;
	
	public Command setCallID( String callID )
	{
		this.mCallID = callID;
		return this;
	}
	
	public String getCallID()
	{
		return this.mCallID;
	}
	
	public Command setProhibitImmediateConnect( int prohibitImmediateConnect )
	{
		this.mProhibitImmediateConnect = prohibitImmediateConnect;
		return this;
	}
	
	public int getProhibitImmediateConnect()
	{
		return this.mProhibitImmediateConnect;
	}
	
	public Command setOverrideDND( int overrideDND )
	{
		this.mOverrideDND = overrideDND;
		return this;
	}
	
	public int getOverrideDND()
	{
		return this.mOverrideDND;
	}
	

	@Override
	public String buildCommand()
	{
		String command = COMMAND + "," + this.getInvokeID() + 
			this.mCallID + ",";

		if( 0 < this.getProhibitImmediateConnect() )
		{
			command += this.getProhibitImmediateConnect();
		}

		command += ",";

		if( 0 < this.getOverrideDND() )
		{
			command += this.getOverrideDND();
		}

		return command;
	}

	@Override
	public void confirmation()
	{
		/* Not sure if it's a good idea to use this as a node checking
		 mechanism or simply relay on the Link Status Events */
	}
}

