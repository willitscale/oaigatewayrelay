package uk.co.n3tw0rk.oaigatewayrelay.events.system;

/**
 * 
 * @author M00SEMARKTWO

DATABASE CHANGE – DC
NOTE: This event is available only in protocol versions 05.10 and later.
USE: Occurs whenever System OAI-related areas of the database change. The <Database_Area>
parameter specifies the database area where changes have occurred, as described below.
MONITOR TYPE: System
SYNTAX: DC,<Resync_Code>,<Mon_Cross_Ref_ID>,<Network_Node_Number>,
<Database_Area>,[Database_Changes]<CR><LF>
Where:
• Network_Node_Number: Indicates the node number of the connected phone system. If
the system is not networked, this will be “1.” When this event is sent to an application
by the CT Gateway, this field specifies the node number of the phone system that originally
generated the event.
• Database_Area: Indicates the area of the database that has changed, specifying the form
of the [Database_Changes] field (see Table 16 on page 60). Possible values are shown
in the table below.

Table 14: DC – Database_Area Values
VALUE <DATABASE_AREA> VALUE <DATABASE_AREA>
0 Station Device 10 Off-Node Page Zone
1 ACD/Hunt Group 11 Off-Node Voice Mail Application
2 Trunk Group 12 System Speed-Dial Bin
3 Trunk Device 13 System DND Message
4 Voice Mail Application 14 System Reminder Message
5 Page Zone 15 System Class of Service Flag
6 Page Port 16 ACD Agent
7 Off-Node Station Device 17 Unassociated Mailbox*
8 Off-Node Hunt Group 18 Off-Node Unassociated Mailbox*
9 Off-Node Page Port 19 Node**

* Available in protocol versions 05.20 and later.
** Available in protocol versions 05.30 and later.
• Database_Changes: Includes several fields that are dependent on the
<Database_Area>. The first field (<Device_Type>) is the identifier that indicates which
object of the <Database_Area> has changed (e.g., Extension). The fields following the
identifiers describe what has changed for the specified database object (e.g., Username).

The following table describes what is included in the <Device_Type> field for the
[Database_Changes] identifier field, if applicable.

Table 15: DC – Device_Type Values
VALUE <DEVICE_TYPE> VALUE <DEVICE_TYPE>
0 Keyset Station Device 17 Off-Node Keyset Station Device
1 Single-Line Station Device 18 Off-Node Single-Line Station Device
2 ACD/Hunt Group 19 Off-Node Hunt Group
3 Loop Start Trunk 20 Off-Node Page Port
4 Loop Start Trunk w/Caller ID 21 Off-Node Page Zone
5 Ground Start Trunk 22 Off-Node Voice Mail
6 Ground Start Trunk w/Caller ID 23 ACD Agent
7 DID Trunk 24 Unassociated Mailbox
8 E&M Trunk 25 Off-Node Unassociated Mailbox
9 ISDN Trunk (Primary or Basic Rate) 26 B-Channel Station
10 Trunk Group 27 Off-Node B-Channel Station
11 Operator 28 MFC/R2 Trunk
12 Voice Mail 29 Modem*
13 Other 30 [not used]
14 Feature Code 31 MGCP Endpoint
15 Page Zone 32 MGCP Gateway and Endpoint
16 Page Port 33 SIP Trunk
*Axxess only

<Database_Area> values 0 through 11 use the following formats for [Database_Changes]:
[Database_Changes] = <Extension>,<Device_Type>,<Field_Type>,
[Changed_Fields]
Where:
• Extension: Identifies the device that changed.
• Device_Type: Identifies the device type of <Extension> (see Table 15 on page 59).
• Field_Type: Identifies the changes and, therefore, specifies the form of
[Changed_Fields] (see Table 16 for a complete description).

The following table details the possible values associated with the [Changed_Fields] parameter
for database areas 0-11.
Table 16: DC – Changed_Field Parameters for Database_Areas 0-11 

<DATABASE_AREA> <FIELD
_TYPE> [CHANGED_FIELDS]
VAL. DESCRIPTION VAL. FIELD(S) INDICATES
0 Station Device
0 <|Username|> The device’s new username.
1 <|Description|> The device’s new description.
2 <Attendant> The device’s attendant. If blank, the device has no attendant.
3 <Is_
Administrator>
0 = The station is NOT an administrator.
1 = The station is an administrator.
4 <Is_
Attendant>
0 = The station is NOT an attendant.
1 = The station is an attendant.
5 <Day_COS_
Flags>
This value is in the form XXXX, where X is a hexadecimal
number in the range 0 through F. The least significant bit represents
Day COS flag 1, and the most significant bit represents
Day COS flag 16. The bits indicate whether the day COS flag
is set or reset.
6 <Night_COS_
Flags>
This value is in the form XXXX, where X is a hexadecimal
number in the range 0 through F. The least significant bit represents
Night COS flag 1, and the most significant bit represents
Night COS flag 16. The bits indicate whether the night COS
flag is set or reset.
7 <Voice_Mail_Ext> The voice mail extension for the station. If blank, the station
has no voice mail extension.
8 <Mailbox_Node_
Number>*
The node where the station’s mailbox resides. A zero indicates
that this station does not have an associated mailbox on any
node.
9** <Stn_Bin_
Number>
The station speed-dial bin that changed.
<Stn_Bin_
Contents>
The number that the bin is programmed to dial.
<|Stn_Bin_Name|> The name of the speed-dial bin.


1 ACD/Hunt
Group
0 <|Username|> The hunt group’s new username.
1 <|Description|> The hunt group’s new description.
2 <Number_Of_
Members>
The total number of members in the hunt group. This is generated
when members might have been added/removed from the
hunt group.
Extension lists count as one member, regardless of how many
extensions are in the list.
Each time an extension occurs in the hunt path, it counts as a
member (e.g., if the hunt group has members of 1000, 1001,
and 1000 again, they are counted as three members)
NOTE: There are other types of hunt group changes that may
indicate a change in the number of members; therefore, the
application could receive this event many times without any
variance in the number.
3 <Mailbox_Node_
Number>*
The node where the hunt group’s associated mailbox resides.
A zero indicates that the hunt group does not have an associated
mailbox on any node.
2 Trunk Group
0 <|Username|> The trunk group’s new username.
1 <|Description|> The trunk group’s new description.
2 <Add/Remove> 0 = A member extension has been removed.
1 = A member extension has been added.
<Member_Ext> The trunk extension that has been added or removed.
<Number_Of_
Members>
The new total number of members in the trunk group.
3 Trunk Device 0 <|Username|> The trunk’s new username.
1 <|Description|> The trunk’s new description.
4 Voice Mail
Applications
0 <|Username|> The voice mail Application’s new username.
1 <|Description|> The voice mail Application’s new description.
5 Page Zone 0 <|Username|> The Page Zone’s new username.
1 <|Description|> The Page Zone’s new description.
6 Page Port 0 <|Username|> The Page Port’s new username.
1 <|Description|> The Page Port’s new description.
7 Off-Node
Station Device
0 <|Username|> The Station Device’s new username.
1 <|Description|> The Station Device’s new description.
2 <Mailbox_Node_
Number>*
The new node number where the Station Device’s associated
mailbox now resides. A zero indicates that this station does not
have an associated mailbox on any node.
8 Off-Node Hunt
Group
0 <|Username|> The Off-Node Hunt Group’s new username.
1 <|Description|> The Off-Node Hunt Group’s new description.
2 <Mailbox_Node_
Number>*
The new node number where the Off-Node Hunt Group’s associated
mailbox now resides. A zero indicates that the hunt
group does not have an associated mailbox.

9 Off-Node
Page Port
0 <|Username|> The Page Port’s new username.
1 <|Description|> The Page Port’s new description.
10 Off-Node
Page Zone
0 <|Username|> The Page Zone’s new username.
1 <|Description|> The Page Zone’s new description.
11
Off-Node
Voice Mail
Application
0 <|Username|> The voice mail Application’s new username.
1 <|Description|> The voice mail Application’s new description.

*
 Available in protocol versions 05.20 and later.
** Available in protocol versions 06.00 and later.
NOTE: Text string fields (e.g., <Description>, <Username>, etc.) are delimited by vertical
slashes (|).

For System Speed-Dial Bins (<Database_Area> = 12), [Database_Changes] is defined as follows:
[Database_Changes] = <Bin_Number>,<Field_Type>,[Changed_Fields]
Where:
• Bin_Number: Identifies the system speed-dial bin that changed.
• Field_Type: Identifies the changes for this system speed-dial bin and, therefore, specifies
the form of [Changed_Fields] as shown in Table 17. 

Table 17: DC – Changed_Field Parameters for Database_Area 12

<DATABASE_AREA> <FIELD
_TYPE> [CHANGED_FIELDS]
VAL. DESCRIPTION VAL. FIELD(S) INDICATES
12
System
Speed-Dial
Bin
0 <|Bin_Name|> The system speed-dial bin’s new name.
1 <Bin_Is_Private> 0 = The system speed-dial bin is NOT private.
1 = The system speed-dial bin is private.
<Bin_Contents> The new contents of the speed-dial bin. If private, this field is
blank.
2 <Bin_Is_
Programmed>
0 = The system speed-dial bin is NOT programmed.
1 = The system speed-dial bin is programmed.
<Bin_Is_Private> 0 = The system speed-dial bin is NOT private.
1 = The system speed-dial bin is private.
<|Bin_Name|> See above for details. If the bin is not programmed, this is
blank.
<Bin_Contents> See above for details. If the bin is not programmed or is private,
this field is blank.


For System DND Messages (<Database_Area> = 13), [Database_Changes] is defined as follows:
[Database_Changes] = <DND_Message_Number>,<Field_Type>,
[Changed_Fields].
Where:
• DND_Message_Number: Identifies the system DND message that changed.
• Field_Type: Identifies the changes for this DND message and, therefore, specifies the
form of [Changed_Fields] as shown in Table 18. 

Table 18: DC – Changed_Field Parameters for Database_Area 13 (&14)
<DATABASE_AREA> <FIELD_
TYPE> [CHANGED_FIELDS]
VAL. DESCRIPTION VAL. FIELD(S) INDICATES
13 System DND
Messages
0 <New_Message> The new, system-programmed DND message.

For System Reminder Messages (<Database_Area> = 14), see the information for System
DND Messages, as described above.
NOTE: Although [Database_Changes] takes on the same form for System DND Messages
(<Database_Area> = 13) and System Reminder Messages (<Database_Area> = 14), this may
not always be the case as new fields may be added to any or both of these database areas.

For System Class Of Service (<Database_Area> = 15), [Database_Changes] is defined as follows:
[Database_Changes] = <Flag_Number>,<Field_Type>,[Changed_Fields].
Where:
• Flag_Number: Identifies the system class of service flag that changed.
• Field_Type: Identifies the changes for this class of service flag and, therefore, specifies
the form of [Changed_Fields] as shown in Table 19.

Table 19: DC – Changed_Field Parameters for Database_Area 15
<DATABASE_AREA> <FIELD
_TYPE> [CHANGED_FIELDS]
VAL. DESCRIPTION VAL. FIELD(S) INDICATES
15 System COS 0 <|Description|> The system Class of Service flag’s new description, delimited
by vertical slashes.

For ACD Agent (<Database_Area> = 16), [Database_Changes] is defined as follows:
[Database_Changes] = <Agent_ID>,<Device_Type>,<Field_Type>,
[Changed_Fields].
Where:
• Agent_ID: Identifies the ACD agent that changed.
• Device_Type: Identifies the device type of <Agent_ID> (see Table 14 on page 58).
• Field_Type: Identifies the changes for this ACD agent and, therefore, specifies the form
of [Changed_Fields] as shown in Table 20.

Table 20: DC – Changed_Field Parameters for Database_Area 16
<DATABASE_AREA> <FIELD
_TYPE> [CHANGED_FIELDS]
VAL. DESCRIPTION VAL. FIELD(S) INDICATES
16 ACD Agent 0 <|Description|> The ACD Agent’s new description, delimited by vertical
slashes.

For Unassociated Mailboxes (<Database_Area> = 17), [Database_Changes] is defined as follows:
[Database_Changes] = <Mailbox>,<Device_Type>,<Field_Type>,
[Changed_Fields].
Where:
• Mailbox: Identifies the mailbox that changed.
• Device_Type: Identifies the device type of <Mailbox> (see Table 14 on page 58).
• Field_Type: Identifies the changes for this mailbox and, therefore, specifies the form of
[Changed_Fields] as shown in Table 21.
NOTE: Unassociated Mailboxes are available only in protocol versions 05.20 and later.

Table 21: DC – Changed_Field Parameters for Database_Area 17
<DATABASE_AREA> <FIELD
_TYPE> [CHANGED_FIELDS]
VAL. DESCRIPTION VAL. FIELD(S) INDICATES
17 Unassociated
Mailbox
0 <|Username|> The mailbox’s new username.
1 <|Description|> The mailbox’s new description.

For Off-Node Unassociated Mailboxes (<Database_Area> = 18), [Database_Changes] is
defined as follows:
[Database_Changes] = <Mailbox>,<Device_Type>,<Field_Type>,
[Changed_Fields].
Where:
• Mailbox: Identifies the mailbox that changed. This parameter is in the <Node>:<Mbox>
format if Expanded Format is enabled (see page 119); otherwise, this is the mailbox
number only.
• Device_Type: Identifies the device type of <Mailbox> (see Table 14 on page 58).
• Field_Type: Identifies the changes for this mailbox and, therefore, specifies the form of
[Changed_Fields] as shown in Table 22.
NOTE: Unassociated Mailboxes are available only in protocol versions 05.20 and later.


Table 22: DC – Changed_Field Parameters for Database_Area 18
<DATABASE_AREA> <FIELD
_TYPE> [CHANGED_FIELDS]
VAL. DESCRIPTION VAL. FIELD(S) INDICATES
18
Off-Node
Unassociated
Mailbox
0 <|Username|> The off-node mailbox’s new username.
1 <|Description|> The off-node mailbox’s new description.


For Node (<Database_Area> = 19), [Database_Changes] is defined as follows:
[Database_Changes] = <Field_Type>,[Changed_Fields].
Where <Field_Type> identifies the changes for this node and, therefore, specifies the form of
[Changed_Fields] as shown in Table 23.
NOTE: This <Database_Area> is available only in protocol versions 05.30 and later.

Table 23: DC – Changed_Field Parameters for Database_Area 19
<DATABASE_AREA> <FIELD
_TYPE> [CHANGED_FIELDS]
VAL. DESCRIPTION VAL. FIELD(S) INDICATES
19 Node 0 <|Username|> The node’s new username.
1 <|Description|> The node’s new description.


EXAMPLES: A username is changed for extension 1000.
001,DC,,<Mon_Cross_Ref_ID>,<Network_Node_Number>,0,1000,0,0,|BARNEY|
A name is changed for speed-dial bin 1.
001,DC,,<Mon_Cross_Ref_ID>,<Network_Node_Number>,12,1,0,|PHOENIX|
A message is changed for DND message 3.
001,DC,,<Mon_Cross_Ref_ID>,<Network_Node_Number>,13,3,0,|GONE HOME|
A message is changed for Reminder message 9.
001,DC,,<Mon_Cross_Ref_ID>,<Network_Node_Number>,14,9,0,|CARDS DUE|
Trunk 94161 has been added to trunk group 9400. Trunk Group 9400 now has five members.
001,DC,,<Mon_Cross_Ref_ID>,<Network_Node_Number>,2,9400,10,2,1,94161,5
Station 1000 has been removed from hunt group 2001. Hunt Group 2001 now has 27
members.
001,DC,,<Mon_Cross_Ref_ID>,<Network_Node_Number>,1,2001,2,2,27
A description is changed for system Class of Service flag 9.
001,DC,,<Mon_Cross_Ref_ID>,<Network_Node_Number>,15,9,0,|COS FLAG 9|
A description is changed for system ACD Agent 24.
001,DC,,<Mon_Cross_Ref_ID>,<Network_Node_Number>,16,24,0,
|ACD AGENT 24|



 */
public class DatabaseChange {

}
