package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

QUERY LIST – _QL
NOTE: Do not issue another command until this one completes.
ALSO: Although this command is available in protocol versions 05.00 and later, it is being
phased out. Use the Query List Extended command instead (see page 165).
USE: Provides a list of various types depending upon the list number specified.
PREMIUM FEATURE: System OAI Events and/or Third-Party Call Control
SYNTAX: _QL,<InvokeID>,<Affected_Ext>,<List_Type>,<Response_Mode>,
<Response_Size><CR>
Where:
• Affected_Ext: Specifies the system node, using the Node: format (e.g., 1:) or any
valid extension on the system node, or it can be blank. When sending the command to
the Gateway, and the <Affected_Ext> parameter is empty, the Gateway either performs
the query on all nodes or queries only one node depending on the query type. The Gateway
queries every node when the <Affected_Ext> is empty and the query type is either
stations (1), hunt groups (3), page zones (5), page ports (6), or voice mail applications
(12). All other list types query only one node.
NOTE: Only protocol versions 05.10 and later support the node number followed by the colon
(e.g., 1:)
• List_Type: Indicates the type of list being queried, which may include the following:

Table 32: QL – List_Type
VALUE <LIST_TYPE> VALUE <LIST_TYPE>
1 Station List 9 Speed-Dial Bin List
2 Trunk List (does NOT include
trunk groups used for transparent
networking)
10 DND Message List
3 Hunt Group List 11 Reminder Message List
4 Trunk Group List (does NOT
include trunks used for transparent
networking)
12 Voice Mail Application List
5 Page Zone List 13 Private Networking Trunk List
(V05.01 and later)
6 Page Port List 14 Private Networking Trunk Group
List (V05.10 and later)
8 Feature List 15 Off-Node Devices (V05.10 and
later

• Response_Mode: Indicates how the queried information is returned. The options are:
— Single Message Mode (1): The entire list is sent in a single message. This is useful
when the amount of information is fairly small (e.g., DND and Reminder Messages
have a small system limit).
NOTE: Off-node device queries require Multiple Message Mode. 

— Multiple Message Mode (2): The list is generated in item groups. Each message
will contain, at most, the number of items specified in <Response_Size> per message.
Each item is dependent upon the type of list being generated.
• Response_Size: Defines the maximum number of elements to be included in a response.
This field is required only when the <Response_Mode> is Multiple Message Mode.
CONFIRMATION: <Sequence_Number>,CF,_QL,<InvokeID>,<List_Type>,<Outcome>,
<MSG_Indicator>,<Entity_Count>,<Entity_1>,<Entity_2>,...,<Entity_n>
<CR><LF>
Where:
• MSG_Indicator: Indicates if this is the last message to expect (1 = Last Message; 0 =
More To Follow).
• Entity_Count: Specifies the number of entities that follow in the message, if the Multiple
Message format is being used. This value is not larger than <Response_Size>.
• Entity: Indicates information on the type of item being listed and is dependent upon the
type of item listed, as detailed in the following table.
NOTE: Unless specified, all Extension fields may be in normal format or expanded extension
format, if enabled using the Expanded Extension (_XE) command (see page 119)..

Table 33: QL – Entity Values for List_Types
<LIST_TYPE> [PROGRAM_LIST]
VAL. DESCRIPTION FIELD(S) INDICATES
1 Station List <Extension> Extension of the station.
<|Username|> Username assigned to the station.
<|Description|> Description assigned to the station.
2 Trunk List <Extension> Extension of the trunk.
<|Username|> Username assigned to the trunk’s trunk group.
<|Description|> PC description assigned to the trunk’s trunk group.
3 Hunt Group List <Extension> Extension of the hunt group.
<|Username|> Username assigned to the hunt group.
<|Description|> Description assigned to the hunt group.
<Hunt_Group_Type> 0 = UCD Hunt Group
1 = ACD Hunt Group without ACD Agent IDs
2 = ACD Hunt Group with ACD Agent IDs
<Number_Of_Members> Total number of members or Agent IDs for the Hunt
Group.
Extension lists count as one member, regardless of how
many extensions are in the list.
Each time an extension occurs in the hunt path, it counts
as a member (e.g., if the hunt group has members of
1000, 1001, and 1000 again, they are counted as three
members)
4 Trunk Group
List
<Extension> Extension of the trunk group pilot.
<|Username|> Username assigned to the trunk group.
<|Description|> Description assigned to the trunk group.
<Number_Of_Members> Total number of members in the trunk group.

5 Page Zone List <Extension> Extension of the Page Zone.
<|Username|> Username assigned to the Page Zone.
<|Description|> Description assigned to the Page Zone.
<Number_Of_Members> Total number of Page Zone members.
6 Page Port List <Extension> Extension of the Page Port.
<|Username|> Username assigned to the Page Port.
<|Description|> Description assigned to the Page Port.
8 Feature List <Is_Administrator_Feature> 1 = Administrator-Only Feature
0 = NOT an Administrator-Only Feature
<Is_Directory_Feature> 1 = Directory Feature
0 = NOT a Directory Feature
<Is_Diagnostic_Feature> 1 = Diagnostic Feature
0 = NOT a Diagnostic Feature
<Is_Toggleable_Feature> 1 = Feature can be toggled
0 = Feature cannot be toggled
<Feature_Number> Logical number of the feature.
<Feature_Code> Access code for the feature.
<|Feature_Name|> Description assigned to the feature.
9 Speed-Dial Bin
List
<Bin_Number> Number assigned to System Speed-Dial bin.
<Bin_Contents> Number dialed as a result of speed-dial activation.
<|Bin_Name|> Description given to the Speed-Dial bin.
NOTE: If a speed-dial bin is empty (i.e., not programmed),
the entry will not be sent. This prevents sending
many empty entries to the application. Also, if the
contents of the bin is a private number, only the bin number
and bin name will actually be sent (i.e., the contents
are not displayed). This keeps private numbers confidential.
10 DND Message
List
<DND_Message_Number> Number (1-20) assigned to the DND message.
<|DND_Message_Text|> Text assigned to the DND message number.
11 Reminder Message
List
<Reminder_Message_Number> Number (1-20) assigned to the Reminder message.
<|Reminder_Message_Text|> Text assigned to the Reminder message number.
12 Voice Mail
Application List
<Extension> Extension of the application.
<|Username|> Username assigned to the application.
<|Description|> Description assigned to the application.
<Application_Type> 0 = Non-Subscriber Voice Mail
1 = Message Notification Retrieval
2 = Scheduled Time-Based Application Router (STAR)
3 = Reserved
4 = Reserved
5 = Call Routing Announcement
6 = Auto Attendant
7 = Auto Attendant Recall
8 = Record-A-Call

13 Private
Networking
Trunk List
<Extension> Extension of the trunk.
<|Username|> Username assigned to the trunk’s trunk group.
<|Description|> PC description assigned to the trunk’s trunk group.
14 Private
Networking
Trunk Group
List
<Extension> Extension of the trunk group.
<|Username|> Username assigned to the trunk group.
<|Group_Name|> Description assigned to the trunk group.
<Number_Of_Members> Total number of members in the trunk group.
15 Off-Node
Device List
<Device_Type> 0 = Non-Subscriber Voice Mail
1 = Message Notification Retrieval
2 = STAR Application
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
13 = Unassociated Mailbox
29 = Modem*
99 = Unknown
<|Username|> Username assigned to the station.
<|PC_Description|> PC description of the off-node device.
<Node: Extension> The off-node device number in expanded extension format.
NOTE: This field is always in expanded extension format,
regardless of the _XE command setting.

COMMON FAILURE
OUTCOME VALUE: Value Out Of Range (31): The <List_Type> value specified is invalid, or single message
mode has been specified for an off-node device query.
DESKTOP OAI: _Q
EXAMPLES: List of all extensions is queried for requesting a single response.
_QL,<InvokeID>,,1,1
001,CF,_QL,<InvokeID>,1,0,1,10,100,|John D.|,|Doe, John|,101,
|Sally S.|,|Smith, Sally|,102,|Charlie B.|,|Brown, Charlie|,
103,|Bugs B.|,|Bunny, Bugs|,104,|Elmer F.|,|Fudd, Elmer|,105,
|Wiley C.|,|Coyote, Wiley|,106,|Mickey M.|,|Mouse, Mickey|,107,
|Jimmini C.|,|Cricket, Jimminie|,108,|Kris K.|,
|Kringle, Kris|,109,|Clarke C.|,|Kent, Clarke|
List of all extensions is queried for requesting multiple responses in groups up to 4.
_QL,<InvokeID>,1,2,4
001,CF,_QL,<InvokeID>,1,0,0,4,100,|John D.|,|Doe, John|,101,
|Sally S.|,|Smith, Sally|,102,|Charlie B.|,
|Brown, Charlie|,103,|Bugs B.|,|Bunny, Bugs|
002,CF,_QL,<InvokeID>,1,0,0,4,104,|Elmer F.|,|Fudd, Elmer|,105,
|Wiley C.|,|Coyote, Wiley|,106,|Mickey M.|,|Mouse, Mickey|,
107,|Jimmeni C.|,|Cricket, Jimmenie|
003,CF,_QL,<InvokeID>,1,0,1,2,108,|Kris K.|,|Kringle, Kris|,
109,|Clarke C.|,|Kent, Clarke|
 */
public class QueryList {

}
