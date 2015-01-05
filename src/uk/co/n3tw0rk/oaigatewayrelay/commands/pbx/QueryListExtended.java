package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

QUERY LIST EXTENDED – _QX
NOTE: Do not issue another command until this one completes.
ALSO: This command is available in protocol versions 05.10 and later.
USE: Provides lists of various types, depending on the specified list number.
NOTE: This command should be used sparingly as it generates a lot of data which may stress
the phone system. Currently, the phone system does not regulate how often this command can
be issued.
PREMIUM FEATURE: System OAI Events and/or Third-Party Call Control
SYNTAX: _QX,<InvokeID>,<Affected_Ext>,<List_Type>,
<Entity_Field_Mask>,<Response_Mode>,<Response_Size><CR>
Where:
• Affected_Ext: Specifies the system node, using the Node: format (e.g., 1:), any valid
extension on the system node, or it can be blank. When the <Affected_Ext> parameter
is blank and is sent to the Gateway, the Gateway either performs a query on all nodes or
queries only one node depending on the query type. The Gateway queries every node
when the <Affected_Ext> is empty and the query type is either stations (1), hunt groups
(3), page zones (5), page ports (6), or a voice mail application list (12). All other list
types query only one node.
NOTE: Only protocol versions 05.10 and later support the node number followed by a
colon.
• List_Type: Indicates the type of list being queried (see the table on the following page).
• Entity_Field_Mask: Returns a list of entities where each entity may contain several
fields of information. This hexadecimal parameter specifies which fields System OAI
includes/excludes from each entity in the list. A set bit indicates that the entity in the list
includes a particular field, while a clear bit indicates the field is excluded. If the application
does not specify this parameter, each entity will contain the default field (designated
by * in the following table).
NOTE: Default fields cannot be excluded, regardless of the <Entity_Field_Mask>
value. 

Table 34: QX – Entity_Field_Masks for List_Types
<LIST_TYPE> <ENTITY_FIELD_MASK>
VAL. DESCRIPTION BIT # FIELD HEX
1
Station List N/A <Extension>1 N/A
0 <|Username|> 1
1 <|Description|> 2
2 <Attendant> 4
3 <Is_An_Adminstrator> 8
4 <Is_An_Attendant> 10
5 <Day_COS_Flags> 20
6 <Night_COS_Flags> 40
7 <Voice_Mail_Extension> 80
8 <Device_Type> 100
9 <Mailbox_Node_Number>2 200
10 <Physical_Device_Type>3 400
2
Trunk List N/A <Extension>1 N/A
0 <|Username|> 1
1 <|Description|> 2
2 <Answer_Supervision_Type>5 4
3
Hunt Group
List
N/A <Extension>1 N/A
0 <|Username|> 1
1 <|Description|> 2
2 <Hunt_Group_Type> 4
3 <Number_Of_Members> 8
4 <Mailbox_Node_Number>2 10
4
Trunk Group
List
N/A <Extension>1 N/A
0 <|Username|> 1
1 <|Description|> 2
2 <Number_Of_Members> 4
5
Page Zone
List
N/A <Extension>1 N/A
0 <|Username|> 1
1 <|Description|> 2
2 <Number_Of_Members> 4
6
Page Port
List
N/A <Extension>1 N/A
0 <|Username|> 1
1 <|Description|> 2
7
Unassociated
Voice
Mailbox List2
N/A <Mailbox_Number>1 N/A
0 <|Username|> 1
1 <|Description|> 2

8
Feature List N/A <Feature_Code>1 N/A
0 <Feature_Number> (Logical) 1
1 <Feature_Name> 2
2 <Is_Administrator_Feature> 4
3 <Is_Directory_Feature> 8
4 <Is_Diagnostic_Feature> 10
5 <Is_Toggleable_Feature> 20
9
Speed-Dial
Bin LIst
N/A <Bin_Number>1 N/A
0 <Bin_Contents> 1
1 <|Bin_Name|> 2
10
DND Message
List
N/A <DND_Message_Number>1 N/A
0 <|DND_Message_Text|> 1
11
Reminder
Message List
N/A <Reminder_Message_
Number>1
N/A
0 <|Reminder_Message_Text|> 1
12
Voice Mail
Application
List
N/A <Extension>1 N/A
0 <|Username|> 1
1 <|Description|> 2
2 <Application_Type> 4
13
Private Networking

Trunk List
N/A <Extension>1 N/A
0 <|Username|> 1
1 <|Description|> 2
14
Private Networking

Trunk Group
List
N/A <Extension>1 N/A
0 <|Username|> 1
1 <|Description|> 2
2 <Number_Of_Members> 4
15
Off-Node
Device List
N/A <Node: Extension>1 N/A
0 <Device_Type> 1
1 <|Username|> 2
2 <|Description|> 4
3 <Mailbox_Node_Number> 8
16 System COS
Flag
N/A <Flag_Number>1 N/A
0 <|Description|> 1
17 ACD Agent N/A <Agent_ID>1 N/A
0 <|Description|> 1

18
Node Data4 N/A <Network_Node_Number> N/A
0 <|Description|> 1
1 <Networking_Enabled/Disabled> 2
2 <Protocol_Version> 4
3 <KSU_SW_Version> 8
4 <Premium_Feature_Status> 10
5 <Country_Code> 20
6 <TCPIP_Indicator> 40
7 <Voice_Mail_Status> 80
8 <Max_Parties_in_Conference> 100
19
Network
Information6 N/A <Network_Node_Number> N/A
0 <|Node_Description|> 1
1 <|IP_Address|> 2
2 <TCP_Port> 4
3 <|Redundant_IP_Address|> 8
4 <Redundant_TCP_Port> 10
5 <System_OAI_Sockets_Enabled> 20
6 <Max_Supported_System_OAI_Soc
kets>
40
7 <Protocol_Version> 80
8 <KSU_SW_Version> 100
9 <Premium_Feature_Status> 200

1 Indicates the default value.
2 Available in protocol V05.20 and later.
3 Available in protocol V08.10 and later.
4 Available in protocol V06.00 and later.
5 Available in protocol V07.00 and later.
6 Available in protocol V08.00 and later.
NOTE: The list entity for each list type will always contain fields according to the order
as shown in the table above and as described below in the specification of the entity
parameter of the confirmation. For instance, the table above yields the ordering of the
fields for a station list entity as follows: <Extension>, <Username>, <Description>,
<Attendant>, <Is_An_Administrator>, <Is_An_Attendant>, <Day_COS_Flags>,
<Night_COS_Flags>, <Voice_Mail_Extension>, <Device_Type>, and
<Mailbox_Node_Number>. If certain fields are omitted from the entity, the order of the
remaining fields is still maintained.

• Response_Mode: Indicates how the queried information is returned. The options are:
— Single Message Mode (1): The entire list is sent in a single message. This is useful
when the amount of information is fairly small (e.g., DND and Reminder Messages
have a small system limit).
NOTE: Off-node device queries require Multiple Message Mode.
— Multiple Message Mode (2): The list is generated in item groups. Each message
will contain, at most, the number of items specified in <Response_Size> per message.
Each item is dependent upon the type of list being generated.
• Response_Size: Defines the maximum number of elements, up to the maximum number
of system extensions, to be included in a response. This is required only when the
<Response_Mode> has been specified as Multiple Message Mode.
CONFIRMATION: <Sequence_Number>,CF,_QX,<InvokeID>,<Outcome>,<List_Type>,
<Entity_Field_Mask>,<MSG_Indicator>,<Entity_Count>,<Entity 1>,
<Entity 2>,...,<Entity N> <CR><LF>
Where:
• Entity_Field_Mask: Specifies which fields are contained in each list entity. See the previous
table.
NOTE: This field may or may not reflect the <Entity_Field_Mask> parameter specified
in the command. If the <Entity_Field_Mask> parameter specifies extra bits (i.e., more
bits than are defined for a particular list type), then this field is a truncated version of
what was specified in the command (i.e., the extra bits are cleared).
• MSG_Indicator: Indicates if this is the last message to expect (1 = Last Message; 0 =
More To Follow).
• Entity_Count: Specifies the number of entities to follow in the message, if the Multiple
Message format is being used. This value is not larger than <Response_Size>.
• Entity: Indicates information on the type of item being listed and is dependent upon the
type of item listed, as detailed in the table on the following page.
NOTE: Unless specified, all Extension fields (shown in Table 35) may be in normal format
or, if enabled using the Expanded Extension (_XE) command (see
page 119), the expanded extension format.

Table 35: QX – Entity Values for List_Types
<LIST_TYPE> [PROGRAM_LIST]
VAL. DESCRIPTION FIELD(S) INDICATES
1
Station List <Extension> Extension of the station.
<|Username|> Username assigned to the station.
<|Description|> Description assigned to the station.
<Attendant> Extension of the station’s attendant.
<Is_An_Administrator> 0 = Station is NOT an administrator station.
1 = Station is an administrator station.
<Is_An_Attendant> 0 = Station is NOT an attendant.
1 = Station is an attendant.
<Day_COS_Flags> This value is in the form XXXX, where X is a hexadecimal
number in the range 0-F. The least significant bit represents
Day COS flag 1, and the most significant bit represents Day
COS flag 16. A set bit indicates that the corresponding flag is
enabled.
<Night_COS_Flags> This value is in the form XXXX, where X is a hexadecimal
number in the range 0-F. The least significant bit represents
Night COS flag 1, and the most significant bit represents
Night COS flag 16. A set bit indicates that the corresponding
flag is enabled.
<Voice_Mail_Extension> Voice mail extension of the station. If blank, the station has
no voice mail extension.
<Device_Type> 0 = Keyset
1 = Single-Line Set
11 = Operator
26 = B-Channel Station Device
29 = Modem*
<Mailbox_Node_Number> (Available in protocol versions 05.20 and later.) The node
containing the station’s associated mailbox. If zero, the station
does not have an associated mailbox on any node.
<Physical_Device_Type> (Available in protocol versions 08.10 and later.) The physical
device connected to the phone system. See Table 31 on
page 153 for a list of possible values.
2
Trunk List <Extension> Extension of the trunk.
<|Username|> Username assigned to the trunk’s trunk group.
<|Description|> PC description assigned to the trunk’s trunk group.
<Answer_Supervision_Type> (Available in protocol versions 07.00 and later.)
0 = No Answer Supervision Defined (DID)
1 = Valid Call Timer
2 = Polarity Reversal
3 = Valid Call Timer with Polarity Reversal
4 = Answer Recognition Timer
5 = Off-Hook Debounce Timer
6 = ISDN


3
Hunt Group
List
<Extension> Extension of the hunt group.
<|Username|> Username assigned to the hunt group.
<|Description|> Description assigned to the hunt group.
<Hunt_Group_Type> 0 = UCD Hunt Group
1 = ACD Hunt Group without ACD Agent IDs
2 = ACD Hunt Group with ACD Agent IDs
<Number_Of_Members> Total number of members or agent IDs for the Hunt Group.
<Mailbox_Node_Number> (Available in protocol versions 05.20 and later.) The node
containing the hunt group’s associated mailbox. If zero, the
hunt group does not have an associated mailbox on any
node.
Extension lists count as one member, regardless of how
many extensions are in the list.
Each time an extension occurs in the hunt path, it counts as a
member (e.g., if the hunt group has members of 1000, 1001,
and 1000 again, they are counted as three members)
4
Trunk Group
List
<Extension> Extension of the trunk group pilot.
<|Username|> Username assigned to the trunk group.
<|Description|> Description assigned to the trunk group.
<Number_Of_Members> Total number of members in the trunk group.
5
Page Zone
List
<Extension> Extension of the Page Zone.
<|Username|> Username assigned to the Page Zone.
<|Description|> Description assigned to the Page Zone.
<Number_Of_Members> Total number of Page Zone members.
6
Page Port List <Extension> Extension of the Page Port.
<|Username|> Username assigned to the Page Port.
<|Description|> Description assigned to the Page Port.
7
Unassociated
Voice Mailbox
List
<Extension> Mailbox number of the unassociated mailbox.
<|Username|> Username assigned to the mailbox.
<|Description|> Description assigned to the mailbox.
8
Feature List <Feature_Code> Access code for the feature.
<Feature_Number> Logical number of the feature.
<|Feature_Name|> Description assigned to the feature.
<Is_Administrator_
Feature>
1 = Is an Administrator-Only Feature
0 = Is NOT an Administrator-Only Feature
<Is_Directory_Feature> 1 = Is a Directory Feature
0 = Is NOT a Directory Feature
<Is_Diagnostic_Feature> 1 = Is a Diagnostic Feature
0 = Is NOT a Diagnostic Feature
<Is_Toggleable_Feature> 1 = Is a Toggleable Feature
0 = Is NOT a Toggleable Feature

9
Speed-Dial
Bin List
<Bin_Number> Number assigned to System Speed-Dial bin.
<Bin_Contents> Number dialed as a result of speed-dial activation.
<|Bin_Name|> Description given to the Speed-Dial bin.
NOTE: If a speed-dial bin is empty (i.e., not programmed),
the entry will not be sent. This prevents sending many empty
entries to the application. Also, if the contents of the bin is a
private number, only the bin number and bin name will actually
be sent (i.e., the contents are not displayed). This keeps
private numbers confidential.
10
DND Message
List
<DND_Message_Number> Number (1-20) assigned to the DND message.
<|DND_Message_Text|> Text assigned to the DND message number.
11
Reminder
Message List
<Reminder_Message_ Number>
Number (1-20) assigned to the Reminder message.
<|Reminder_Message_ Text|> Text assigned to the Reminder message number.
12
Voice Mail
Application
List
<Extension> Extension of the application.
<|Username|> Username assigned to the application.
<|Description|> Description assigned to the application.
<Application_Type> 0 = Non-Subscriber Voice Mail
1 = Message Notification Retrieval
2 = Scheduled Timed-Based Application Routing (STAR)
3 = Reserved
4 = Reserved
5 = Call Routing Announcement
6 = Auto Attendant
7 = Auto Attendant Recall
8 = Record-A-Call
13
Private Networking
Trunk
List
<Extension> Extension of the trunk.
<|Username|> Username assigned to the trunk’s trunk group.
<|Description|> PC description assigned to the trunk’s trunk group.
14
Private Networking
Trunk
Group List
<Extension> Extension of the trunk group.
<|Username|> Username assigned to the trunk group.
<|Description|> Description assigned to the trunk group.
<Number_Of_Members> Total number of members in the trunk group.

15
Off-Node
Device List
<Node:Extension> The off-node device number in expanded extension format.
NOTE: This field is always in expanded extension format,
regardless of the _XE command setting.
<Device_Type> 0 = Non-Subscriber Voice Mail
1 = Message Notification Retrieval
2 = Scheduled Timed-Based Application Routing (STAR)
3 = Reserved
4 = Reserved
5 = Call Routing Announcement
6 = Auto Attendant
7 = Auto Attendant Recall
8 = Record-A-Call
9 = Station
10 = Hunt Group
11 = Page Port
12 = Page Zone
13 = Unassociated Mailbox*
99 = Unknown
<|Username|> Username assigned to the station.
<|Description|> PC description of the off-node device.
<Mailbox_Node_Number> (Available in protocol versions 05.20 and later.) Indicates the
node containing the device’s associated mailbox. If zero, the
device does not have an associated mailbox on any node.
16 System COS
Flags
<Flag_Number> The number of the system COS flag.
<|Description|> Description assigned to the system COS flag.
17 ACD Agent
List
<Agent_ID> The ID of the agent.
<|Description|> Description assigned to the agent

18
Node Data* <Network_Node_Number> The number of the affected node.
<|Description|> Description of the node.
<Networking_Enabled/Disabled>
0 = Networking is not enabled.
1 = Networking is enabled.
<Protocol_Version> The version of the protocol running on the node. This is in the
form Vxx.yy where xx is the major version and yy is the revision
number.
<KSU_SW_Version> The software version running on the node. This is in the form
Vxx.yy where xx is the major version and yy is the revision
number.
<Premium_Feature_
Status>
1 = Only System OAI events are enabled.
2 = Only System OAI Third-Party Call Control commands are
enabled.
3 = Both System OAI events and Third-Party Call Control
commands are enabled.
<Country_Code> 1 = USA
2 = Japan
3 = United Kingdom
4 = Indonesia
5 = Mexico
<TCPIP_Indicator> 0 = Node is communicating via RS232 (Axxess only) .
1 = Node is communicating via TCP/IP.
<Voice_Mail_Status> 0 = Not programmed
1 = Programmed but down
2 = Programmed and up

19 Network
Information**
<Network_Node_Number> The node number to which the information applies.
<|Node_Description|> The description assigned to the node. Note that this description
is of the node responding to the query; so, it will not
always match the description the node has programmed in
Database Programming.
<|IP_Address|> The IP address or hostname of the responding server. If
blank, the node does not support direct TCP/IP.
<TCP_Port> The TCP Port of the responding server. If blank, the server
does not support direct TCP/IP, or the node responding to the
query lacks the information.
<|Redundant_IP_Address|> The IP address or hostname of the redundant CP Server. If
blank, the node does not have a redundant server, or the
node responding to the query lacks the information.
<Redundant_TCP_Port> The TCP Port of the redundant CP Server. If blank, the node
does not have a redundant server, or the node responding to
the query lacks the information.
<Enable_System_OAI_
Sockets>
0 = System OAI Sockets disabled (or the node does not support
direct TCP/IP)
1 = System OAI Sockets enabled
If blank, the node responding to the query lacks the information.
<Max_Supported_System_
OAI_Sockets>
The maximum supported System OAI connections the node
supports. If zero, there is no connection limit. If blank, the
node does not support System OAI sockets, or the node
responding to the query lacks the information.
<Protocol_Version> The System OAI protocol version the node supports. This
field is in the form Vxx.yy where xx is the major version and
yy is the revision number. If blank, the node responding to the
query lacks the information.
<KSU_SW_Version> The software version running on the node. This field is in the
form Vxx.yyy where xx is the major version and yyy is the
revision number. If blank, the node responding to the query
lacks the information.
<Premium_Feature_Status> 1 = Only System OAI events are enabled
2 = Only Third-Party Call Control Commands are enabled
3 = Both premium features are enabled

* Available in protocol V06.00 and later.
** Available in protocol V08.00 and later.
NOTE: Text string fields (e.g., <Description>, <Username>, etc.) are delimited by vertical
slashes (|).
COMMON FAILURE
OUTCOME VALUES:
Invalid Device Identifier (9): The <Affected_Ext> parameter is specified but is invalid.
Value_Out_Of_Range (31): The <List_Type> value specified is invalid, or single message
mode has been specified and there is not enough space in the buffer for the number of entries
that the query command can return.
DESKTOP OAI: _Q
GATEWAY IMPACTS: Gateway version 4.0 or later is required to return the network information.

EXAMPLES: A list of all stations is queried with single response mode and with the following fields in each
Entity: Extension, Username, Description.
_QX,<InvokeID>,,1,3,1
001,CF,_QX,<InvokeID>,0,1,003,1,10,100,|John D.|,|Doe, John|,101,
|Sally S.|,|Smith, Sally|,102,|Charlie B.|,|Brown, Charlie|,
103,|Bugs B.|,|Bunny, Bugs|,104,|Elmer F.|,|Fudd, Elmer|,105,
|Wiley C.|,|Coyote, Wiley|,106,|Mickey M.|,|Mouse, Mickey|,107,
|Jimmini C.|,|Cricket, Jimminie|,108,|Kris K.|,|Kringle, Kris|,
109,|Clarke C.|,|Kent, Clarke|
A list of all stations is queried with multiple response mode and with the following fields in
each Entity: Extension, Username, Description. Each response may contain up to four entries.
_QX,<InvokeID>,,1,3,2,4
001,CF,_QX,<InvokeID>,0,1,003,0,4,100,|John D.|,|Doe, John|,101,
|Sally S.|,|Smith, Sally|,102,|Charlie B.|,|Brown, Charlie|,
103,|Bugs B.|,|Bunny, Bugs|
002,CF,_QX,<InvokeID>,0,1,003,0,4,104,|Elmer F.|,|Fudd, Elmer|,
105,|Wiley C.|,|Coyote, Wiley|,106,|Mickey M.|,|Mouse, Mickey|,
107,|Jimmeni C.|,|Cricket, Jimmenie|
003,CF,_QX,<InvokeID>,0,1,003,1,2,108,|Kris K.|,|Kringle, Kris|,
109,|Clarke C.|,|Kent, Clarke|
Query for all node information single response (connection to a node).
_QX,<Invoke_ID>,,18,FFFF,1
001,CF,_QX,<InvokeID>,0,18,FF,1,0001,1,|Node 1|,1,V06.00,V06.000,
3,1,0,0
Query for all node information single response (connection to a Gateway).
_QX,<Invoke_ID>,,18,FFFF,1
001,CF,_QX,<InvokeID>,0,18,FF,1,0003,1,|Node 1|
,1,V06.00,V06.000,3,1,0,0,2,|Node 2|,1,V06.00,V06.000,3,1,1,1,3,
|Node 3|,1,V06.00,V06.000,3,1,0,0
Query for all node information multiple response (connection to a node).
_QX,<Invoke_ID>,,18,FFFF,2,2
001,CF,_QX,<InvokeID>,0,18,FF,0,0001,1,|Node 1|,
1,V06.00,V06.000,3,1,0,0
Query for all node information multiple response (connection to a Gateway).
_QX,<Invoke_ID>,,18,FFFF,2,2
001,CF,_QX,<InvokeID>,0,18,FF,0,0002,1,|Node 1|,
1,V06.00,V06.000,3,1,0,2,|Node 2|,1,V06.00,V06.000,3,1,1,0
002,CF,_QX,<Invoke_ID>,0,18,FF,1,0001,3,|Node 3|,1,
V06.00,V06.000,3,1,0,0
Query for node associated with 1000 for Premium Feature Status only.
_QX,<Invoke_ID>,1000,18,10,1
001,CF,_QX,<InvokeID>,0,18,10,1,0001,1,3
Query for node 2 for OAI protocol level and TCP/IP indicator.
_QX,<Invoke_ID>,2:,18,44,1
001,CF,_QX,<InvokeID>,0,18,44,1,0001,2,V06.00,1
Query info about trunks.
_QX,45,,2,7,1
003,CF,_QX,45,0,2,1,2,8,94202,|Trunk 94202|,|94202|,2,94301,
|DID Trunk 94301|,|94301|,0
Query info about the network.
_QX,1,,19,ffff,2,1
002,CF,_QX,1,0,19,3FF,1,0001,1,
|Chandler Node 1|,|192.168.0.000|,4000,||,0,1,30,V08.00,V08.000,3

 */
public class QueryListExtended {

}
