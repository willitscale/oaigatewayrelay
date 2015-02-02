package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.commands.Command;
import uk.co.n3tw0rk.oaigatewayrelay.events.acknowledgement.Confirmation;

/**
 * <strong>Query Hunt Group Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 27-01-2015
 * 
 * QUERY HUNT GROUP – _QH
 * 
 * NOTE: 
 * 		This command is available only in protocol versions 03.10 and later.
 * 
 * USE: 
 * 		Provides the current mode of every ACD/UCD agent who is a member of the specified ACD/
 * 		UCD hunt group.
 * 
 * PREMIUM FEATURE: 
 * 		Third-Party Call Control
 * 
 * SYNTAX: 
 * 		_QH,<InvokeID>,<Affected_Ext><CR>
 * 
 * Where the valid device type for <Affected_Ext> is an ACD or UCD hunt group pilot number.
 * 
 * CONFIRMATION: 
 * 		<Sequence_Number>,CF,_QH,<InvokeID>,<Outcome>,<Number_of_Entries>,
 * 		<Agent_ID>,<Device_Ext>,<ACD/UCD_Mode>,.....<CR><LF>
 * 
 * Where:
 * 		• Number_of_Entries: Identifies the number of <Agent_ID> entries that follow this
 * 		parameter. If this field is zero, no other fields follow.
 * 		• Agent_ID: Identifies the ACD agent.
 * 		• Device_Ext: Indicates the station associated with the ACD agent represented by
 * 		<Agent_ID>. This is the extension of the station where <Agent_ID> logged into the
 * 		hunt group if the agent is logged in. If the agent is currently logged out of the hunt
 * 		group, this field is blank.
 * 
 * NOTE: 
 * 		Extension lists are not counted individually, however, each extension in the list
 * 		is counted as a member. Therefore, if a hunt group has members of 1000 and PP001
 * 		and PP001 has 5 members and 1000 is not a member of PP001, _QH reports the hunt
 * 		group has six members (1000 plus the five members of PP001). Extensions are
 * 		counted only once. If 1000 is a member in more than one place, it counts only once.
 * 
 * 		• ACD/UCD_Mode: Indicates the Agent ID’s current mode in the ACD or UCD Hunt
 * 		Group. The options for the <ACD_Mode> field are as follows:
 * 			0 = Not Logged In
 * 			1 = Logged In and Ready
 * 			2 = Logged In and Not Ready
 * 			3 = Logged In and Work Not Ready
 * 
 * 		The options for the <UCD_Mode> field are:
 * 			4 = UCD Ready
 * 			5 = UCD Busy
 * 
 * 	COMMON FAILURE
 * 
 * 	OUTCOME VALUES:
 * 		Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
 * 		Invalid_Destination (11): The specified <Affected_Ext> or <Agent_ID> is not an ACD/UCD
 * 		hunt group pilot.
 * 
 * 	DESKTOP OAI: 
 * 		None
 * 
 * 	EXAMPLE: 
 * 		Agent 100 is logged into ACD group 261 at extension 200 and is ready to receive calls, and
 * 		Agent 101 is logged out of hunt group 261.
 * 		_QH,<InvokeID>,261
 * 		001,CF,_QH,<InvokeID>,0,1,100,200,1,101,,0
 */
public class QueryHuntGroup extends Command
{
	/** */
	public static final String COMMAND = "_QH";
	
	/** */
	protected int mAffectedExt;

	/**
	 * 
	 * @param affectedExt
	 * @return
	 */
	public QueryHuntGroup setAffectedExt( int affectedExt )
	{
		this.mAffectedExt = affectedExt;
		return this;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getAffectedExt()
	{
		return this.mAffectedExt;
	}

	/**
	 * 
	 */
	@Override
	public String buildCommand()
	{
		return COMMAND + "," + this.getInvokeID() + "," + this.getAffectedExt();
	}

	/**
	 * <strong>Confirmation Method</strong>
	 * 
	 * @return void
	 */
	@Override
	public void confirmation()
	{
		if( !( this.mEvent instanceof Confirmation ) )
		{
			return;
		}

		int partsSize = this.mEvent.getPartsSize();
		
		if( 0 == partsSize )
		{
			return;
		}
		
	}
}
