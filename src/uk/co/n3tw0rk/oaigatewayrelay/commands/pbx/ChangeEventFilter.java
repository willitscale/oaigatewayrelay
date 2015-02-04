package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.commands.Command;

/**
 * <strong>Change Event Filter Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 04-02-2015
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 95
 * 
 * 	CHANGE EVENT FILTER – _CE
 * 
 * 	NOTE: 
 * 		This command is available only in protocol versions 05.00 and later.
 * 
 * 	USE: 
 * 		Changes the event filters associated with a monitor. Typically a monitor is started by the user
 * 		to monitor some or all devices. When the Monitor Start command (_MS) is invoked, a set
 * 		of filter values can be optionally specified (see page 128). The _CE command allows the filter
 * 		values to be changed at any time during the time of the monitor session.
 * 	
 * 	PREMIUM FEATURE: 
 * 		System OAI Events or Third-Party Call Control
 * 
 * 	SYNTAX: 
 * 		_CE,<InvokeID>,<Mon_Cross_Ref_ID>,<Filter_List><CR>
 * 		Where <Filter_List> is the new filter list for this cross-reference ID (see page 13) and must be
 * 		specified.
 * 
 * 	CONFIRMATION: 
 * 		<Sequence_Number>,CF,_CE,<InvokeID>,<Outcome>,<Agent_Filter_Mask>,
 * 		<Call_Filter_Mask>,<Feature_Filter_Mask><CR><LF>
 * 
 * 	SYSTEM MONITOR CONFIRMATION:
 * 		<Sequence_Number>,CF,_CE,<InvokeID>,<Outcome>,<System_Filter_Mask>
 * 		<CR><LF>
 * 
 * 	NOTE: 
 * 		This confirmation applies to protocol versions 05.20 and later.
 * 		Where:
 * 		• Agent_Filter_Mask: Indicates the Agent Event Filters for Monitor.
 * 		• Call_Filter_Mask: Identifies Call Event Filters for Monitor
 * 		• Feature_Filter_Mask: Displays Feature Event Filters for Monitor
 * 		• System_Filter_Mask: Indicates System Event Filters for Monitor
 * 	
 * 	COMMON FAILURE OUTCOME VALUES:
 * 		Invalid_Mon_Cross_Ref_ID (12): The <Mon_Cross_Ref_ID> parameter is blank or invalid.
 * 		Invalid_Filter_Type (34): The specified <Filter_List> is not A, C, F, or S.
 * 		Invalid_Agent_Filter (35): The <Agent_Filter_Mask> value in the <Filter_List> specifies
 * 		invalid flags.
 * 		Invalid_Call_Filter (36): The <Call_Filter_Mask> value in the <Filter_List> specifies invalid
 * 		flags.
 * 		Invalid_Feature_Filter (37): The <Feature_Filter_Mask> value in the <Filter_List> specifies
 * 		invalid flags.
 * 		Missing Filter Type (38): One of the required filter types has not been specified.
 * 		Invalid_System_Filter (43): The <System_Filter_Mask> value in the <Filter_List> specifies
 * 		invalid flags.
 * 
 * 	DESKTOP OAI: 
 * 		None
 * 
 * 	EXAMPLES: 
 * 		Disable all events on monitor 100.
 * 		_CE,<InvokeID>,100,A:0,C:0,F:0
 * 		001,CF,_CE,<InvokeID>,0,A:0000,C:0000,F:0000
 * 		Enable Login and Logoff events for Agent events on monitor 100. Leave all other events
 * 		enabled (using defaults).
 * 		_CE,<InvokeID>,100,A:00,,
 * 		001,CF,_CE,<InvokeID>,0,A:00C0,C:FFFC,F:00F0
 * 		Disable all events on system monitor 100.
 * 		_CE,<InvokeID>,100,S:0
 * 		001,CF,_CE,<InvokeID>,0,S:0000
 * 		Enable all events on system monitor 101.
 * 		_CE,<InvokeID>,101,S:00FC
 * 		001,CF,_CE,<InvokeID>,0,S:00FC
 */
public class ChangeEventFilter extends Command
{
	public static final String COMMAND = "_CE";

	protected int mMonCrossRefID;
	protected String mFilterList;

	public Command setMonCrossRefID( int monCrossRefID )
	{
		this.mMonCrossRefID = monCrossRefID;
		return this;
	}
	
	public int getMonCrossRefID()
	{
		return this.mMonCrossRefID;
	}

	public Command setFilterList( String filterList )
	{
		this.mFilterList = filterList;
		return this;
	}
	
	public String getFilterList()
	{
		return this.mFilterList;
	}

	@Override
	public String buildCommand()
	{
		return COMMAND + "," + this.getInvokeID() + 
			this.mMonCrossRefID + "," + this.mFilterList;
	}

	@Override
	public void confirmation() {}
}
