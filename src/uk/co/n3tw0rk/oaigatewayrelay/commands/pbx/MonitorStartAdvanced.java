package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

MONITOR START ADVANCED – _MA
USE: Reduces the size of the Monitor Start command confirmation because the number of the
devices on a system keeps increasing. The current Monitor Start command (_MS) returns
all information in a single confirmation. This command breaks the confirmation into multiple
messages. The application must use the message indicator (<MSG_Indicator>) flag to determine
if there are more messages pending.
PREMIUM FEATURE: System OAI Events or Third-Party Call Control
SYNTAX: _MA,<InvokeID>,<Affected_ID>,<Monitor_Type_Advanced>,<Filter_List>
<CR>
Where:
• Affected_ID: Indicates a node number, device, or other entity. This field depends on the
<Monitor_Type_Advanced> and can be one of the following:
— If the <Monitor_Type_Advanced> is 0, 1, 2, or 7, the <Affected_ID> is the entity
to be monitored. This value is verified.
— If the <Monitor_Type_Advanced> is 3, 4, 8, 9, or 11, the <Affected_ID> can be a
node number (when using a CT Gateway), a relative device (when using a CT
Gateway), or blank. All non-blank values are validated by the Gateway but are
ignored by the phone system.
• Monitor_Type_Advanced: Indicates the entity being monitored. Possible values include
(see page 132 for detailed descriptions):
0 – Call
1 – Device
2 – Call Via Device
3 – All Stations
4 – All Trunks
5 – Reserved
6 – Reserved
7 – Agent ID
8 – Call Termination
9 – All Voice Mail Applications
10 – Reserved
11 – System
12 – All UCD Hunt Groups
13 – All ACD Hunt Groups
• Filter_List: Takes the form of S:xxxx for <Monitor_Type_Advanced> value 11 and
A:xxxx, C:xxxx, F:xxxx for all other <Monitor_Type_Advanced> values.
NOTE: The Call Termination <Monitor_Type_Advanced> entity (8) does not accept the
<Filter_List> parameter.
CONFIRMATION: <Sequence_Number>,CF,_MA,<InvokeID>,<Outcome>,<MSG_Indicator>,
<Monitor_Type_Advanced>,<Number_of_Monitor_Sessions>,[<Monitor_Data1>,
[...,<Monitor_DataN>],<Filter_List>]<CR><LF>
Where:
• MSG_Indicator: Indicates whether or not more messages will follow (0 = More Messages
to Follow; 1 = Last Message for the Command).
• Number_of_Monitor_Sessions: Specifies the total number of monitor sessions returned
in the message.
• Monitor_Data: Displays different information depending on the <Monitor_Type>. Possible
information includes:
— If the <Monitor_Type_Advanced> is 0, 1, 2, 3, 4, 7, 9, 12, or 13 the
<Mon_Cross_Ref_ID> and <Monitored_Ext> are displayed.
— If the <Monitor_Type_Advanced> is 8, the <Mon_Cross_Ref_ID> is displayed.
— If the <Monitor_Type_Advanced> is 11, the <Mon_Cross_Ref_ID> and
<Node_Number> are displayed.
COMMON FAILURE
OUTCOME VALUES:
Generic_Unspecified (1): The <Monitor_Type_Advanced> parameter is invalid, a monitor
session on all stations in the system is currently being started, or this command specified an All
Stations or All Trunks monitor type when one was already in progress.
Invalid_Call_Identifier (8): The <Affected_ID> parameter is blank or invalid for a Call type
monitor.
Invalid_Device_Identifier (9): The <Affected_ID> parameter is blank or invalid for a Device
or Calls via Device type monitor.
Overall_Monitor_Limit_Exceeded (28): Additional monitors cannot be started on this port.
DESKTOP OAI: None
GATEWAY IMPACTS: CT Gateway supports the command in the same way, but it has the following requirements:
• In the event a phone system does not support the _MA command, the Gateway uses the
_MS command and takes the response data and changes it to make it look like an _MA
response. This does not, however, occur for monitor types 12 and 13 because they fail.
• Each response from each node is left intact. This allows each node to have different filter
masks. This also allows applications to take advantage of certain events when
present on a subset of the phone system nodes only.
• The CT Gateway allows for a node to be specified in Node: format for monitor types 3,
4, 6, 8, 9, 10, 11, 12, and 13.
• This command is supported in Gateway versions 2.0 and later.
 */

public class MonitorStartAdvanced {

}
