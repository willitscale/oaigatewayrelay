package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.commands.CallCommand;
import uk.co.n3tw0rk.oaigatewayrelay.abstraction.commands.Command;

/**
 * <strong>Change Timer Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 05-02-2015
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 98
 * 
 * 	CHANGE TIMER – _CT
 * 
 * 	USE: 
 * 		Changes a telephone system timer value. Currently this command supports changing the Unsupervised
 * 		CO Call timer only. This timer limits the duration of outside calls transferred or forwarded
 * 		to outside telephone numbers before recalling the primary attendant. Applications send
 * 		this command to change the Unsupervised CO Call timer only after a trunk-to-trunk call is in
 * 		the established state.
 * 
 * 	NOTE: 
 * 		This command will fail unless every node in the entire telephone system network supports
 * 		protocol versions 6.0 and later. If Node Route Groups exist in Database Programming but
 * 		the telephone system is not networked, a technician must change the network protocol version
 * 		through the Online Monitor.
 * 
 * 	PREMIUM FEATURE: 
 * 		Third-Party Call Control
 * 
 * 	SYNTAX: 
 * 		_CT,<InvokeID>,<Affected_Ext>,<Call_ID>,<Timer>,<New_Duration><CR>
 * 
 * 	Where:
 * 		• Affected_Ext: Identifies one of the trunk devices involved in the <Call_ID> trunk-totrunk
 * 			call.
 * 		• Call_ID: Indicates the Call ID of a trunk-to-trunk call whose timer should change. This
 * 			call must be connected.
 * 		• Timer: Identifies the timer that should change. Currently, this value should always be
 * 			“1.”
 * 		• New_Duration: Indicates the new value (1-255) of the Unsupervised CO timer for the
 * 			call. This value represents the number of minutes the Unsupervised CO timer will wait
 * 			before timing out.
 *
 *	CONFIRMATION: 
 *		<Sequence_Number>,CF,_CT,<InvokeID>,<Outcome><CR><LF>
 *
 *	COMMON FAILURE OUTCOME VALUES:
 *		Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
 *		this command.
 *		Invalid_Call_Identifier (8): The <Call_ID> parameter is blank or invalid.
 *		Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
 *		Invalid_Object_State (14): The specified call is not in a trunk-to-trunk connected state or
 *		does not exist at the <Affected_Ext>.
 *		Network_Out_Of_Service (25): At least one node in the telephone system network does not
 *		support protocol V06.00 or later.
 *		Value_Out_Of_Range (31): The <Timer> or <New_Duration> parameter is not valid.
 *	
 *	DESKTOP OAI: 
 *		None
 *
 *	GATEWAY IMPACTS: 
 *		If an application sends this command to a node whose protocol is V06.00 or later, the CT Gateway
 *		will send the command to that node and allow the application to receive the confirmation.
 *		If the CT Gateway receives this command for a node whose protocol is prior to V06.00, the CT
 *		Gateway will fail the command with an outcome of Invalid_Command (45).
 *	
 *	NOTE: 
 *		This command is available only in CT Gateway versions 2.0 and later.
 *	
 *	EXAMPLE: 
 *		A CT application wants to change the Unsupervised CO timer for trunk-to-trunk call 201 to
 *		be 50 minutes. To see the established trunk-to-trunk call, the application must be monitoring
 *		one of the trunks or the call (or any combination). In this example, call 201 is connected to
 *		trunks 94161 and 94162. The application is monitoring the call and both trunks. Therefore,
 *		when the trunk-to-trunk call is established, the application receives three established events:
 *		001,ES,,<MON94161>,201,94162,,E,94161,9619000,,E,94162,1000,C,35
 *		002,ES,,<MON94162>,201,94162,9610756,E,94161,9619000,,E,94162,1000,
 *		C,35
 *		003,ES,,<MON201>,201,94162,9610756,E,94161,9619000,,E,941962,1000,C,35
 *		The application knows that the call is trunk-to-trunk because both devices are external (E). To
 *		change the Unsupervised CO timer, the application must specify one of the trunks connected
 *		to the call. Therefore, the application can specify either 94161 or 94162.
 *		_CT,<InvokeID>,94161,201,1,50
 *		004,CF,_CT,<InvokeID>,0
 *		OR
 *		_CT,<InvokeID>,94162,201,1,50
 *		004,CF,_CT,<InvokeID>,0
 */
public class ChangeTimer extends CallCommand
{
	public static final String COMMAND = "_CT";

	protected int mTimer;
	protected int mNewDuration;
	
	public Command setTimer( int timer )
	{
		this.mTimer = timer;
		return this;
	}
	
	public int getTimer()
	{
		return this.mTimer;
	}
	
	public Command setNewDuration( int newDuration )
	{
		this.mNewDuration = newDuration;
		return this;
	}
	
	public int getNewDuration()
	{
		return this.mNewDuration;
	}
	
	@Override
	public String buildCommand()
	{
		return COMMAND + "," + this.getInvokeID() + 
			this.mCallID + "," + this.mTimer + "," + this.mNewDuration;
	}

	@Override
	public void confirmation() {}
}
