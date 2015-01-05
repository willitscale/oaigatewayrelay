package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Command;
import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Confirmation;

/**
 * <strong>Monitor Start Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 28-12-2014
 *
 *	MONITOR START – _MS
 *
 *	USE: 
 *		Initiates event reporting for a device, calls via a device, or a call. Once a port begins monitoring
 *		a call, it continues monitoring under the first monitor <Mon_Cross_Ref_ID> until that call
 *		clears out of the system. For example, if a call rings Device A, which is being monitored (calls
 *		via device), and is forwarded to Device B, which is also being monitored (calls via device), the
 *		events for the call will continue to be sent out under the <Mon_Cross_Ref_ID> for Device A.
 *		No events will be sent under the <Mon_Cross_Ref_ID> for Device B.
 *		There are five distinct types of monitor sessions available on the system:
 *		• Call: Provides event notification for the specified call until the call terminates from the
 *			system. This type of monitor session generates all call-related events. It does not generate
 *			feature- or agent-related events.
 *		• Device: Provides event notification for the specified device (e.g., station, hunt group,
 *			trunk group, voice mail application, agent ID, etc.). This type of monitor session generates
 *			all call events (except the Call Cleared event), agent events, and feature
 *		events.
 *		• Calls via Device: Provides event notification for the life of every call that hits a specified
 *			device.
 *		• Call Termination: Creates a system-wide monitor that generates a Call Cleared
 *			event (see page 27) for every call in the system when the call terminates.
 *			NOTE: The Call Termination monitor type is not recommended for use with the CT
 *			Gateway. It may cause the application to receive a Call Cleared event for a call
 *			that is still active in the system.
 *		• System: Creates a system-wide monitor that generates all system events.
 *			Using the Gateway, this command allows the application to specify a node format (e.g., 1: for
 *			Node 1) when performing monitor start all stations, all stations with resync, all trunks, or system.
 *	
 *	PREMIUM FEATURE: 
 *		System OAI Events or Third-Party Call Control
 *	
 *		Protocol Versions Prior to 05.00
 *
 *	SYNTAX: 
 *		_MS,<InvokeID>,<Affected_Ext>,<Monitor_Option><CR>
 *
 *	Where:
 *		• Affected_Ext: Indicates a keyset, single-line set, hunt/ACD group, trunk group, trunk, or
 *		voice mail application.
 *		• Monitor_Option: (Optional) Identifies the requested monitor type (default is 1), which
 *		can be one of the following (see page 23 for more information):
 *
 *	Table 26: MS – Monitor_Option Values (Prior to V05.00)
 *
 *		VALUE 	<MONITOR_TYPE>
 *		0 		Call – Call monitoring on specified call.
 *		1 		Device – Device monitoring on specified device.
 *		2 		Calls Via Device – Call via device monitoring on specified device.
 *		3 		All Stations (Device-Type Monitoring) on all stations.
 *		4 		All Trunks (Device-Type Monitoring) on all trunks.
 *		5* 		Device with an automatic Resync Request – Device monitoring on
 *				specified device. The resync will occur only for stations and voice
 *				mail applications.
 *		6* 		All Stations (Device-Type Monitoring) with an automatic Resync
 *				Request on the monitored stations – Device monitoring on all stations.
 *	
 *		* If a Monitor Start with a resync does not start any monitors (e.g., there are no devices to monitor),
 *		the Resync Request is not issued.
 *
 *	NOTE: 
 *		<Monitor_Types> 3-6 are available only in protocol versions 03.10 and later for
 *		the V03.x series (not V03.00) and in protocol versions 02.20 and later for the V02.x
 *		series (not V02.00 or V02.10):
 *	
 *	CONFIRMATION: 
 *		<Sequence_Number>,CF,_MS,<InvokeID>,<Outcome>,<Number_of_Monitor_Sessions>,<Mon_Cross_Ref_ID>,<Monitored_Ext><CR><LF>
 *
 *		Where <Number_Of_Monitor_Sessions> is a decimal value in the range of 0-999 indicating
 *		the number of monitor sessions started with this command. If this field is “0,” no other fields
 *		follow. If the command attempts to exceed 999 monitor sessions, the system starts as many
 *		monitors as it can (up to 999) and returns an error code of 28 (Overall Monitor Limit
 *		Exceeded).
 *
 *	COMMON FAILURE
 *
 *	OUTCOME VALUES:	
 *		Generic_Unspecified (1): The <Monitor_Option> parameter is invalid, a monitor session on
 *		all stations in the system is currently being started, or this command specified an All Stations
 *		or All Trunks monitor type when one was already in progress.
 *
 *		Invalid_Call_Identifier (8): The <Affected_Ext> parameter is blank or invalid for a Call type
 *		monitor.
 *
 *		Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid for a Device
 *		or Calls via Device type monitor.
 *
 *		Overall_Monitor_Limit_Exceeded (28): Additional monitors cannot be started on this port.
 *
 *	DESKTOP OAI: 
 *		None
 *
 *	EXAMPLE: 
 *		Start device-type monitoring on extension 101.
 *		_MS,<InvokeID>,101,1
 *		001,CF,_MS,<InvokeID>,0,1,1,101
 *		NOTE: If Extensions are changed in the database that affect an active monitor (either Device
 *		and/or Calls Via Device), the monitor will be deleted, and a Monitor Ended (ME) event will be
 *		generated (see page 70). This does not affect Call monitors
 *		Protocol Versions 05.00 and Later
 *	
 *	SYNTAX: 
 *		_MS,<InvokeID>,<Affected_ID>,<Monitor_Type>,<Filter_List><CR>
 *	
 *	Where:
 *		• Affected_ID: Indicates a keyset, single-line set, hunt/ACD group, modem (Axxess
 *			only), trunk group, trunk, voice mail application, or agent ID. This parameter depends
 *			entirely on the value of <Monitor_Type> and differs for commands going to the phone
 *			system and to the CT Gateway, as detailed in the following tables.
 *
 *	NOTE: 
 *		Agent IDs do not support the expanded format (i.e., Node:Extension).
 *
 *	Table 27: MS – System Affected_ID Values for Monitor_Type (V05.00 and Later)
 *
 *	VALUE 	<MONITOR_TYPE> VALID FORMS OF 					<AFFECTED_ID>
 *	0 		Call – Call monitoring on specified call. 		Valid Call ID (cannot use expanded format).
 *
 *	1		Device – Device monitoring on specified			Valid device (see page 11).
 *			device. 
 *
 *	2		Calls Via Device – Call via Device				Valid Hunt Group device.
 *			monitoring on specified device.

 *	3 		All Stations (Device-Type Monitoring)			Not used.
 *			on all stations. 
 *
 *	4 		All Trunks (Device-Type Monitoring)				Not used.
 *			on all trunks. 
 *
 *	5 		Device with Resync – Device monitoring			Valid device (see page 11).
 *			on specified device. 
 *
 *	6 		All Stations with Resync – Device				Not used.
 *			monitoring on all stations. 
 *
 *	7 		Agent ID – Creates a device-type				Valid Agent ID.
 *			monitor wherever the agent logs in.
 *			
 *	8 		Call Termination. 								Not used.
 *
 *	9 		All Voice Mail Applications – Devicetype		Not used.
 *			monitor. 
 *
 *	10 		All Private Network Trunks. 					Reserved for future use.
 *
 *	11 		System – System monitor. 						Not used.
 *
 *	NOTE: 
 *		The system node receiving the command must be programmed to use the
 *		expanded format if the command specifies the node number in the <Affected_ID>
 *		parameter (see page 119).

Table 28: MS – Gateway Affected_ID Values for Monitor_Type (V05.00 and Later)
VALUE <MONITOR_TYPE> VALID FORMS OF <AFFECTED_ID>
0 Call – Call monitoring on specified
call.
Valid Call ID (cannot use expanded
format).
1 Device – Device monitoring on specified
device.
Valid device (see page 11).
2 Calls Via Device – Call via Device
monitoring on specified device.
Valid Hunt Group device.
3 All Stations (Device-Type Monitoring)
on all stations.
(Optional) Valid device or possibly the
system node. If you do not specify a
system node, the command is sent to
all nodes.
4 All Trunks (Device-Type Monitoring)
on all trunks.
(Optional) Valid device or possibly the
system node. If you do not specify a
system node, the command is sent to
all nodes.
5 Device with Resync – Device monitoring
on specified device.
Valid device (see page 11).
6 All Stations with Resync – Device
monitoring on all stations.
(Optional) Valid device or possibly the
system node. If you do not specify a
system node, the command is sent to
all nodes.
7 Agent ID – Creates a device-type
monitor wherever the agent logs in.
Valid Agent ID.
8 Call Termination. Not used.
9 All Voice Mail Applications – Devicetype
monitor.
(Optional) System node. If you do not
specify a system node, the command
is sent to all nodes.
10 All Private Network Trunks. Reserved for future use.
11 System – System monitor. (Optional) System node. If you do not
specify a system node, the command
is sent to all nodes.

NOTE: The CT Gateway processes commands with or without the expanded format
specified.

• Monitor_Type: Identifies the requested monitor type (default is “1”), which can be one
of the values identified in the following table.

Table 29: MS – Monitor_Type Values (V05.00 and Later)
VALUE <MONITOR_TYPE>
0 Call.
1 Device.
2 Calls Via Device.
3 All Stations (Device-Type Monitoring).
4 All Trunks (Device-Type Monitoring). This does NOT include T1
trunks used for transparent networking in system version 05.00 or
later.
5* Device with an automatic Resync Request on the specified device.
The resync will occur only for stations and voice mail applications.
6* All Stations (Device-Type Monitoring) with an automatic Resync
Request on the monitored stations.
7 Agent ID Monitoring where a specific agent ID is being monitored.
NOTE: Any device logged into any hunt group using this agent ID
will have events reported for it. These event reports are in addition to
any other monitors for the device. Creates a device-type monitor
wherever the agent logs in. If the application starts a device-type
monitor on extension 1000 and an agent ID monitor on agent ID
2000, it will receive two (duplicate) events if agent ID 2000 logs into
extension 1000.
8 Call Termination. Creates a system-wide call termination monitor.
NOTE: The Call Termination monitor type is not recommended for
use with the CT Gateway. It may cause the application to receive a
Call Cleared event for a call that is still active in the system.
9 All voice mail applications. Creates device monitors on all voice mail
applications.
10 (Future Enhancement) All Private Network Trunks (Device-Type
Monitoring). Creates a device monitor on all private network trunks.
11 (System versions 05.10 and Later) System (System-Type Monitoring).
Creates a system monitor.

* If a Monitor Start with a resync does not start any monitors (e.g., there are no devices to
monitor), the Resync Request is not issued.
CONFIRMATION
(MONITOR = 0-10): <Sequence_Number>,CF,_MS,<InvokeID>,<Outcome>,
<Number_Of_Monitor_Sessions>,<Mon_Cross_Ref_ID>,<Monitored_Ext>,
<Agent_Filter_Mask>,<Call_Filter_Mask>,<Feature_Filter_Mask><CR><LF>

 *	CONFIRMATION (MONITOR = 11):
 *		<Sequence_Number>,CF,_MS,<InvokeID>,<Outcome>,<Number_Of_Monitor_Sessions>,<Mon_Cross_Ref_ID>,<Node_Number>,<System_Filter_Mask><CR><LF>
 *	
 *	Where:
 *		• Number_Of_Monitor_Sessions: Specifies a decimal value in the range of 0-999 indicating
 *		the number of monitor sessions started with this command. If this field is “0,” no
 *		other fields follow. If the command attempts to exceed 999 monitor sessions, the system
 *		starts as many monitors as it can (up to 999) and returns an error code of 28 (Overall
 *		Monitor Limit Exceeded).
 *		• Monitored_Ext: Indicates the extension number corresponding to the
 *		<Mon_Cross_Ref_ID>.
 *		• Agent_Filter_Mask: Identifies the agent event filters for the monitor.
 *		• Call_Filter_Mask: Indicates the call event filters for the monitor.
 *		• Feature_Filter_Mask: Specifies the feature event filters for the monitor.
 *			• Node_Number:* Indicates the node number followed by a colon (:).
 *		• System_Filter_Mask:* Identifies the system event filters for the monitor.
 *		
 *		*These parameters apply only to system versions 05.10 and later.
 *	
 *		The System Monitor command for the Gateway allows all nodes or a single node to be specified.
 *		When using all nodes, the Gateway will create a unique <Mon_Cross_Ref_ID> for each
 *		node, allowing an application to change the event filters for a system monitor on a per-node
 *		basis.
 *
 *	NOTE: 
 *		For system versions 05.10 and later, any active monitor's Event filter values can be
 *		changed by another Monitor Start command. This implies that the filters for the Monitors
 *		are changed and that the Monitor's cross-reference is left alone. For example, if a Monitor
 *		Start - All Stations is issued with the default event filter settings A:00FC, C:FFFC, and
 *		F:00FC and a monitor start station for a specific station is issued later (this station currently
 *		has an active monitor with <Mon_Cross_Ref_ID> = 5) with all agent events turned off, the specific
 *		station's monitor filters are changed to A:0000, C:FFFC, and F:00FC
 *		(<Mon_Cross_Ref_ID> is still 5). This functionality exists for all monitor types and is very similar
 *		to that of the Change Event Filter command (_CE) on page 93.
 *	
 *	COMMON FAILURE
 *	
 *	OUTCOME VALUES:
 *		Generic_Unspecified (1): The <Monitor_Option> parameter is invalid, or a monitor session
 *		on all stations in the system is being started.
 *		Invalid_Call_Identifier (8): The <Affected_Ext> parameter is blank or invalid for a Call-type
 *		monitor.
 *		Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid for a
 *		Device- or Calls via Device-type monitor.
 *		Overall_Monitor_Limit_Exceeded (28): Additional monitors cannot be started on this port.
 *		Invalid_Agent_ID (33): An invalid agent ID was specified.
 *		Invalid_Filter_Type (34): The specified <Filter_List> is not A, C, F, or S.
 *		Invalid_Agent_Filter (35): The <Agent_Filter_Mask> value in the <Filter_List> specifies
 *		invalid flags.
 *		Invalid_Call_Filter (36): The <Call_Filter_Mask> value in the <Filter_List> specifies invalid
 *		flags.
 *		Invalid_Feature_Filter (37): The <Feature_Filter_Mask> value in the <Filter_List> specifies
 *		invalid flags.
 *		Missing_Filter_Type (38): One of the three filter types was not found in the command line.
 *		Invalid_System_Filter (43): The <System_Filter_Mask> value in the <Filter_List> specifies
 *		invalid flags (system versions 05.10 and later).
 *	
 *	DESKTOP OAI: 
 *		None
 *
 *	EXAMPLES: 
 *		Start device-type monitoring on extension 101.
 *		_MS,<InvokeID>,101,1
 *		001,CF,_MS,<InvokeID>,0,1,1,101,A:00FC,C:FFFC,F:00F0
 *		Start device-type monitoring on extension 101 for Call Events only.
 *		_MS,<InvokeID>,101,1,A:0,,F:0
 *		001,CF,_MS,<InvokeID>,0,1,001,101,A:0000,C:FFFC,F:0000
 *		Start agent ID monitoring on agent ID 11.
 *		_MS,<InvokeID>,11,7
 *		001,CF,_MS,<InvokeID>,0,1,001,11,A:00FC,C:FFFC,F:00F0
 *		Start agent ID monitoring on agent ID 11 generating only Agent Logon and Logoff Events.
 *		_MS,<InvokeID>,11,7,A:C0,C:0,F:0
 *		001,CF,_MS,<InvokeID>,0,1,001,11,A:00C0,C:0000,F:0000
 *		Start system monitoring all system events.
 *		_MS,<InvokeID>,,11,S:FC
 *		001,CF,_MS,<InvokeID>,0,1,001,1:,S:00FC
 *		Connected to a CT Gateway with three nodes:
 *		Monitor all nodes with all events turned on.
 *		_MS,<InvokeID>,,11,S:FFFF
 *		001,CF,_MS,<InvokeID>,0,0003,000001,1:,000002,2:,000003,3:,S:00FC
 *		Connected to a CT Gateway with three nodes:
 *		Monitor a single node for system events.
 *		_MS,<InvokeID>,1:,11,S:00F4
 *		001,CF,_MS,<InvokeID>,0,0001,000001,1:,S:00F4
 *	
 *	NOTE: 
 *		If Extensions are changed in the database that affect an active monitor (either Device
 *		and/or Calls via Device), the monitor will be deleted, and a Monitor Ended (ME) event will
 *		be generated (see page 70). This does not affect Call monitors. If an ACD Agent ID is changed
 *		in the phone system database, the Agent ID monitor for that Agent ID is deleted and a Monitor
 *		Ended (ME) event is generated for the specific monitor session. If the extension of the
 *		device where the agent logged in has changed, however, the Agent ID monitor ceases generating
 *		events at that device, but the Agent ID monitor is still active. The phone system does not
 *		generate a Monitor Ended event for this case.
 */
public class MonitorStart extends Command
{
	public static final String COMMAND = "_MS";
	
	protected int mAffectedExt;
	
	protected String mMonitorOptions;
	
	protected int mMonitorType;

	public MonitorStart setAffectedExt( int affectedExt )
	{
		this.mAffectedExt = affectedExt;
		return this;
	}
	
	public int getAffectedExt()
	{
		return this.mAffectedExt;
	}
	
	public MonitorStart setMonitorOptions( String monitorOptions )
	{
		this.mMonitorOptions = monitorOptions;
		return this;
	}
	
	public String getMonitorOptions()
	{
		return this.mMonitorOptions;
	}
	
	public MonitorStart setMonitorType( int monitorType )
	{
		this.mMonitorType = monitorType;
		return this;
	}
	
	public int getMonitorType()
	{
		return this.mMonitorType;
	}
	
	@Override
	public String buildCommand()
	{
		String command = COMMAND + "," + this.getInvokeID() + ",";

		if( 0 < this.getAffectedExt() )
		{
			command += this.getAffectedExt();
		}
		
		command += "," + this.getMonitorType() + "," + getMonitorOptions();

		return command;
	}

	public boolean hasCompleted()
	{
		return ( this.mEvent instanceof Confirmation );
	}
}
