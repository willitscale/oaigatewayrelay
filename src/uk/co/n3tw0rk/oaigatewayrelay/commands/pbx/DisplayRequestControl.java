package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

DISPLAY REQUEST CONTROL – _DRC
NOTE: This command is available only in protocol versions 08.00 and later.
USE: Requests Display Control over a station device, such as a keyset, single-line set, etc. Once
issued, applications have full control over:
• Phone displays, including information and menu regions (except transient regions). See
page 111 for an illustration of the regions.
• Other various controls, such as menu buttons, clear, cancel, etc.
• Tones and timers.
NOTE: This command requires a device monitor on the <Affected_Ext>, which must be a station
device. Do NOT send this command if the <Affected_Ext> is not a station device.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _DRC,<InvokeID>,<Affected_Ext>,<Call_ID>,<Display_Control_Type><CR>
Where:
• Affected_Ext: Indicates a keyset (online) or a single-line set (online).
• Call_ID: Indicates the call ID if the <Affected_Ext> is currently on a call; otherwise,
this is blank. If a valid call ID is not present when Display Control is requested over the
connected station, the command is rejected.
• Display_Control_Type: Specifies the type of Display Control requested (1 = full connected
control, which is the only value currently available).
CONFIRMATION: <Sequence_Number>,CF,_DRC,<InvokeID>,<Outcome>,<Affected_Ext>,
<Call_ID>,<Display_Control_Type>,<Display_Model>,<Keyset_Language>,
<Actual_Keyset_Language>,<Character_Sets_Supported>,
<Supports_Running_Timer>,<Supports_Scrolling_Display><CR><LF>
Where:
• Display_Model: Specifies the phone model at the <Affected_Ext>. Possible values
include:
0 = Model unknown
1 = No display
2 = Digital Keyset Basic DVNK
3 = Digital Keyset Basic
4 = Digital Keyset AgentSet
5 = Digital Keyset Executive
6 = Digital Keyset Executive with Tones
7 = Eclipse Keyset Associate
8 = Eclipse Keyset Professional
9 = Executone Wave 29
10 = Executone Model 32
11 = Executone Model 64
12 = Executone Model ACD
13 = Executone Model 160
14 = Jaguar 8660
15 = Jaguar 8560
16 = Jaguar 8520
17 = Jaguar 8500
18 = Model 8620 (using Inter-Tel proprietary protocol)
19 = Model 8662 (using Inter-Tel proprietary protocol)
20 = Model 8690 (using Inter-Tel proprietary protocol)
NOTE: If a Model 8620, 8662, or 8690 phone is using Session Initiation Protocol (SIP),
the <Display_Model> field returns a value of “0” (model unknown).
• Keyset_Language: Indicates if the phone is programmed to use the primary language
(0) or the secondary language (1).
• Actual_Keyset_Language: Indicates the language (e.g., English, Spanish, or Japanese)
that the phone is programmed to use. Possible values include:
2 = American English
3 = UK English
4 = Japanese
5 = American Spanish
6 = Standard Spanish
7 = Indo English
255 = Unknown
• Character_Sets_Supported: Provides a bit list of all the character sets the phone supports.
Possible values include:
0 = English
1 = Latin
2 = Katakana
• Supports_Running_Timer: Indicates whether or not the station supports an active timer.
• Supports_Scrolling_Display: Indicates whether or not the station supports a scrolling
display.
COMMON FAILURE
OUTCOME VALUES: Request_Incompatible_With_Object (3): The <Affected_Ext> is a device (e.g., trunk, trunk
group, page zone, etc.) that does not support Display Control.
Invalid_Call_Identifier (8): The <Call_ID> parameter does not match the current call for this
device or is invalid.
Invalid_Device_Identifier (9): The <Affected_Ext> device type does not support this command.
Generic_State_Incompatibility (15): The <Affected_Ext> device is either offline or not in a
state that accepts this command.
Value_Out_Of_Range (31): The <Display_Control_Type> parameter is invalid.
Other_Application_Already_Has_Display_Control (48): Another application is currently
controlling the <Affected_Ext> device.
Invalid_Device_Monitor (50): A monitor has not been started on the <Affected_Ext> device.
The device must be monitored before the application can gain Display Control.
DESKTOP OAI: None
EXAMPLE: Request Display Control (FULL CONNECTED CONTROL) on extension 1000 (where 1000 is
a station).
_DRC,<Invoke_ID>,1000,*01,1
001,CF,_DRC,<Invoke_ID>,0,1000,*01,1,5,0,2,0,1,1

 */
public class DisplayRequestControl {

}
