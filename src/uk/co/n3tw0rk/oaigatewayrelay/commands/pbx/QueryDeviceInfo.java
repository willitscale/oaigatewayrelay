package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Command;

/**
 * <strong>Query Device Info Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 28-12-2014

QUERY DEVICE INFO – _QI
NOTE: This command is available only in protocol versions 03.00 and later.
USE: Queries general information about a device. The confirmation event for this service includes
information on the class and type of the device being queried. In V09.0 and later, an application
can use the _QI command to obtain the station’s Account Code Type and Account Code
Validated values. This is used by the application to prompt a user for an account code when
making an outgoing CO call.
PHANTOM
USE:
When this command is executed on a phantom device, the confirmation returns a TPC device
type of “TPC KEYSET” (0). The TPC device class will be “TPC_VOICE” (0). Because a
phantom cannot come on line as a physical device, the TPC physical device type will be
“TPC_PHYSICAL_DEVICE_TYPE_NONE” (0).
When a phantom is an attendant, this command returns "Operator" (11) for the TPC device
type. Otherwise, a TPC_KEYSET value (0) will be returned.
PREMIUM FEATURE: Third-Party Call Control prior to V05.20; System OAI Events or Third-Party Call Control after
V05.20
SYNTAX: _QI,<InvokeID>,<Affected_Ext><CR>
Where valid device types for <Affected_Ext> include a keyset, single-line set, modem (Axxess
only), trunk, voice mail application, hunt/ACD group, or trunk group.
CONFIRMATION
(03.00 < V <
05.10):
<Sequence_Number>,CF,_QI,<InvokeID>,<Outcome>,<Affected_Ext>,
<Device_Type>,<Device_Class>,<Description><CR><LF>
CONFIRMATION
(05.10 <= V <
05.20):
If <Affected_Ext> is a station device:
<Sequence_Number>,CF,_QI,<InvokeID>,<Outcome>,<Affected_Ext>,
<Device_Type>,<Device_Class>,<Description>,<Username>,
<Is_An_Administrator>,<Is_An_Attendant>,<Attendant_Extension>,
<Day_COS_Flags>,<Night_COS_Flags>,<Voice_Mail_Ext><CR><LF>
If <Affected_Ext> is NOT a station device:
<Sequence_Number>,CF,_QI,<InvokeID>,<Outcome>,<Affected_Ext>,
<Device_Type>,<Device_Class>,<Description>,<Username><CR><LF>
CONFIRMATION
(05.20 <= V <
06.00):
If <Affected_Ext> is a station device:
<Sequence_Number>,CF,_QI,<InvokeID>,<Outcome>,<Affected_Ext>,
<Device_Type>,<Device_Class>,<Description>,<Username>,
<Is_An_Administrator>,<Is_An_Attendant>,<Attendant_Extension>,
<Day_COS_Flags>,<Night_COS_Flags>,<Voice_Mail_Ext>,
<Mailbox_Node_Number><CR><LF>
CONFIRMATION
(06.00 <= V <
07.00):
If <Affected_Ext> is a station device:
<Sequence_Number>,CF,_QI,<InvokeID>,<Outcome>,<Affected_Ext>,
<Device_Type>,<Device_Class>,<Description>,<Username>,
<Is_An_Administrator>,<Is_An_Attendant>,<Attendant_Extension>,
<Day_COS_Flags>,<Night_COS_Flags>,<Voice_Mail_Ext>,
<Mailbox_Node_Number>,<Stn_Speed_Dial_Bin_Data><CR><LF>
If <Affected_Ext> is NOT a station device:
<Sequence_Number>,CF,_QI,<InvokeID>,<Outcome>,<Affected_Ext>,
<Device_Type>,<Device_Class>,<Description>,<Username><CR><LF>
CONFIRMATION
(07.00 <= V <
08.10):
If <Affected_Ext> is a station device:
<Sequence_Number>,CF,_QI,<InvokeID>,<Outcome>,<Affected_Ext>,
<Device_Type>,<Device_Class>,<Description>,<Username>,
<Is_An_Administrator>,<Is_An_Attendant>,<Attendant_Extension>,
<Day_COS_Flags>,<Night_COS_Flags>,<Voice_Mail_Ext>,
<Mailbox_Node_Number>,<Stn_Speed_Dial_Bin_Data><CR><LF>
If <Affected_Ext> is NOT a station device:
<Sequence_Number>,CF,_QI,<InvokeID>,<Outcome>,<Affected_Ext>,
<DeviceType>,<DeviceClass>,<Description>,<Username>,
<Answer_Supervision_Type><CR><LF>
CONFIRMATION
(08.10 <= V <
09.00):
If <Affected_Ext> is a station device:
<Sequence_Number>,CF,_QI,<InvokeID>,<Outcome>,<Affected_Ext>,
<Device_Type>,<Device_Class>,<Description>,<Username>,
<Is_An_Administrator>,<Is_An_Attendant>,<Attendant_Extension>,
<Day_COS_Flags>,<Night_COS_Flags>,<Voice_Mail_Ext>,
<Mailbox_Node_Number>,<Stn_Speed_Dial_Bin_Data>,<Physical_Device_Type>
<CR><LF>
If <Affected_Ext> is NOT a station device:
<Sequence_Number>,CF,_QI,<InvokeID>,<Outcome>,<Affected_Ext>,
<DeviceType>,<DeviceClass>,<Description>,<Username>,
<Answer_Supervision_Type><CR><LF>
CONFIRMATION
(V >= 09.00):
If <Affected_Ext> is a station device:
<Sequence_Number>,CF,_QI,<InvokeID>,<Outcome>,<Affected_Ext>,
<Device_Type>,<Device_Class>,<Description>,<Username>,
<Is_An_Administrator>,<Is_An_Attendant>,<Attendant_Extension>,
<Day_COS_Flags>,<Night_COS_Flags>,<Voice_Mail_Ext>,
<Mailbox_Node_Number>,<Stn_Speed_Dial_Bin_Data>,
<Physical_Device_Type>,<Account_Code_Type>,
<Account_Code_Validated_Flag><CR><LF>
If <Affected_Ext> is NOT a station device:
<Sequence_Number>,CF,_QI,<InvokeID>,<Outcome>,<Affected_Ext>,
<DeviceType>,<DeviceClass>,<Description>,<Username>,
<Answer_Supervision_Type><CR><LF>
Where:
• Device_Type: Identifies the device type of the <Affected_Ext>, which includes the
options defined in the following table.

Table 30: QI – Device_Type Values
VALUE <DEVICE_TYPE>
0 Keyset Station Device
1 Single-Line Station Device
2 ACD/Hunt Group
3 Loop Start Trunk
4 Loop Start Trunk w/Caller ID
5 Ground Start Trunk
6 Ground Start Trunk w/Caller ID
7 DID Trunk
8 E&M Trunk
9 ISDN Trunk – Basic or Primary Rate
10 Trunk Group
11 Operator
12 Voice Mail
13 Other
26 B-Channel Station
28 MFC/R2 Trunk
29 Modem*
31 MGCP Endpoint
32 MGCP Gateway and Endpoint
33 SIP Trunk
* Axxess only

NOTE: Device types not listed in Table 30 are not currently reported by this command.
(For a complete list of device types, refer to the Database Change event section,
page 59).
• Device_Class: Indicates the device class of <Affected_Ext>, and can be one of the following
values:
0 = Voice
1 = Data
2 = Image
3 = Other
• Is_An_Administrator:* Specifies whether or not the device is an administrator station (0
= Is NOT An Administrator; 1 = Is An Administrator). This field is available only
when the command specifies a station device.
• Is_An_Attendant:* Specifies whether or not the device is an attendant station (0 = Is
NOT An Attendant; 1 = Is An Attendant). This field is available only when the command
specifies a station device.
• Day COS Flags:* Indicates the day class of service flag value. This value is in the form
XXXX, where X is a hexadecimal number in the range 0-F. The least significant bit represents
Day COS flag 1, and the most significant bit represents Day COS flag 16. A set

bit indicates that the corresponding flag is enabled. This field is available only when the
command specifies a station device.
• Night COS Flags:1 Indicates the night class of service flag value. This value is in the
form XXXX, where X is a hexadecimal number in the range 0-F. The least significant bit
represents Night COS flag 1, and the most significant bit represents Night COS flag 16.
A set bit indicates that the corresponding flag is enabled. This field is available only
when the command specifies a station device.
• Mailbox_Node_Number:2
 Indicates the node containing the specified station’s associated
mailbox. If zero, the station does not have an associated mailbox on any node.
• Stn_Speed_Dial_Bin_Data: Contains a count of the actual number of station speed-dial
bins found for the extension, followed by additional entries. The syntax for this field is
as follows:
<Number_Of_Bins>,<Stn_Speed_Dial_Data1>,...,
<Stn_Speed_Dial_DataN>
Where:
— Number_Of_Bins: Indicates the number of bins sent.
— Stn_Speed_Dial_Data: Includes the following:
 • Stn_Bin_Number: Specifies the station speed-dial bin number.
 • Stn_Bin_Contents: Indicates the number that the bin is programmed to dial.
 • Stn_Bin_Name: Indicates the name of the speed-dial bin, delimited by vertical
slashes (|).
NOTE: If the <Stn_Bin_Contents> field for a particular bin is blank, the
<Stn_Speed_Dial_Data> for this bin is skipped. It is possible, therefore, to get a value of
0 for <Number_Of_Bins>.
• Answer_Supervision_Type:3 Indicates how the system identifies when outgoing calls
are answered. The application determines if <Answer_Supervision_Type> should be
present in the command response based on the <Device_Type> field returned by the
Query Device Info (_QI) command.
The device types that provide answer supervision are as follows:
3 = Loop Start Trunk
4 = Loop Start Trunk w/Caller ID
5 = Ground Start Trunk
6 = Ground Start Trunk w/Caller ID
7 = DID Trunk
8 = E&M Trunk
9 = ISDN Trunk (both BRI and PRI)
28 = MFC/R2 Trunk

The <Answer_Supervision_Type> values are included in the following table.
VALUE INDICATES
0 No Answer Supervision Defined (i.e., DID)
1 Valid Call Timer
2 Polarity Reversal
3 Valid Call Timer with Polarity Reversal
4 Answer Recognition Timer
5 Off-hook Debounce Timer
6 ISDN

• Physical_Device_Type:4 Indicates the device physically connected to the phone system
only if the <Affected_Ext> is a station device (<Device_Type> is 0, 1, 11, 26, or 27). If
the device is offline, this field is Unknown (0). When a station device is online, this
field contains the physical device type for that station. Table 31 lists the valid values for
<Physical_Device_Type>.
Table 31: Physical_Device_Type Values 
VALUE <PHYSICAL_DEVICE_TYPE> VALUE <PHYSICAL_DEVICE_TYPE>
0 Unknown or Not Applicable 29 Executone Model ACD
1 Analog Keyset AIM 8-Line 30 Executone Model 160
2 Analog Keyset DVK 8-Line 31 Reserved
3 Analog Keyset ESP 8-Line 32 Executone DSS Console
4 Analog Keyset ESP 8-Line w/
DTMF
33 Executone OPX
5 Analog Keyset DVK 12-Line 34 Executone Wave 17-Key
6 Analog Keyset GMX 12-Line 35 Executone Wave 6-Key
7 Analog Keyset AIM 24-Line 36 Eclipse Basic Digital Phone
8 Analog Keyset DVK 24-Line 37 Eclipse Associate Display Phone
9 Analog Keyset ESP 24-Line 38 Modem*
10 Analog Keyset GMX 24-Line 39 Eclipse Professional Display
Phone
11 DVK Basic Digital Phone 40 Model 8500
12 Axxess Basic Digital Phone 41 Model 8520
13 Digital Keyset Economy 42 Model 8560
14 Digital AgentSet 43 Model 8660
15 Axxess Executive Display Phone 44 Model 8600 (SIP)
16 Axxess Executive Display Phone
w/Tones
45 Model 8690 (SIP)
17 Direct Inward Dial for SLA Port 46 Model 8601
18 Direct Inward Dial for T1 Port 47 Model 8662 (SIP)
19 Modem Data Port for AKTS Port* 48 Other SIP Endpoint
20 Modem Data Port for DKTS Port* 49 BRI Station
21 OPX for SLA Port 50 Model 8620 (SIP)
22 OPX for T1 Port 51 Eclipse IPPhone+
23 Single-Line Set 52 Model 8600 (Inter-Tel Protocol)
24 Executone Model 12 53 Model 8620 (Inter-Tel Protocol)
25 Executone Model 18 54 Model 8662 (Inter-Tel Protocol)
26 Executone Wave 29-Key 55 Model 8690 (Inter-Tel Protocol)
27 Executone Model 32 56 Model 8664
28 Executone Model 64 57 Model 8665

• Account_Code_Type:
5
 Indicates the type of account code that was used for a call, and
can be one of the following values:
0 = No Account Code
1 = Standard Account Code
2 = Forced All
3 = Forced Local Toll
4 = Forced Long Distance
• Account_Code_Validated_Flag:
6
 Indicates the type of account code that was used for a
call, and can be one of the following values:
0 = The account code is not validated
1 = The account code is validated
NOTE: The account code can be validated (1) only if the account code type is either 2,
3 or 4.
1 Available only in protocol versions 05.10 and later.
2
 Available only in V05.20 and later.
3
 Available only in V07.00 and later.
4
 Available only in V08.10 and later.
5, 6 Available only in V09.00 and later

COMMON FAILURE
OUTCOME VALUES:
Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
DESKTOP OAI: None
EXAMPLES: Query Device Info of extension 1000 (keyset).
_QI,1,1000
001,CF,_QI,1,0,1000,0,0,| Extension 1000|,|1000|,0,1,,
0000,0000,2599,1
Query Device Info of extension 1000 (keyset).
_QI,1,1000
001,CF,_QI,1,0,1000,0,0,| Extension 1000|,|1000|,0,1,,
0000,0000,2599,1,2,5,9619000,|SomeNumber|,9,18005551212,
|Information|
Query Device Info of extension 1001 (keyset) which has no station speed-dial bins.
_QI,2,1001
001,CF,_QI,2,0,1001,0,0,| Extension 1001|,|1001|,0,1,,
0000,0000,2599,1,2,0
Query device info about trunk 94202.
_QI,245,94202
003,CF,_QI,245,0,94202,8,0,|Trunk 94202|,|94202|,2
Query device info about trunk 94301.
_QI,245,94202
003,CF,_QI,245,0,94202,7,0,|DID Trunk 94301|,|94301|,0
Query Device Info of extension 1000 (Model 8660 Phone).
_QI,1,1000
001,CF,_QI,1,0,1000,0,0,| Extension 1000|,|1000|,0,1,,
0000,0000,2599,1,2,5,9619000,|SomeNumber|,9,18005551212,
|Information|,43

TROUBLESHOOTING
TIPS:
SYMPTOM PROBABLE CAUSE RESOLUTION
Unable to get Account Coderelated
fields for _QI command.
Device of the _QI is not a
Station type device.
Use a device that is a station
as that is the scope of this
command.
Account Code results are not
as expected.
The account code fields of
the device are not set properly.
Use database programming
to verify the settings of the
Account code fields for the
device.

 */
public class QueryDeviceInfo extends Command
{

	public static final String COMMAND = "_QI";
	
	protected int mAffectedExt;

	public QueryDeviceInfo setAffectedExt( int affectedExt )
	{
		this.mAffectedExt = affectedExt;
		return this;
	}
	
	public int getAffectedExt()
	{
		return this.mAffectedExt;
	}
	
	@Override
	public String buildCommand()
	{
		return COMMAND + "," + this.getInvokeID() + "," + this.getAffectedExt();
	}
	


	/*
	<Sequence_Number>,								005
	CF,												CF
	_QI,											_QI
	<InvokeID>,										4
	<Outcome>,										0
	<Affected_Ext>,									1876
	<Device_Type>,									0						0 = Keyset Station Device
	<Device_Class>,									0						0 = Voice
	<Description>,									||
	<Username>,										|Test|
	<Is_An_Administrator>,							0
	<Is_An_Attendant>,								0
	<Attendant_Extension>,							0000,
	<Day_COS_Flags>,								0000,
	<Night_COS_Flags>,								,
	<Voice_Mail_Ext>,								0,
	<Mailbox_Node_Number>,							0,
	<Stn_Speed_Dial_Bin_Data>,						64,
	<Physical_Device_Type>,							0,						0 = Unknown or Not Applicable
	<Account_Code_Type>,							0,						0 = No Account Code
	<Account_Code_Validated_Flag>					01234567890
	<CR>
	<LF>
	*/

	@Override
	public void confirmation()
	{
	}
}
