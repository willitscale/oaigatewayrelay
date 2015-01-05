package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

DISPLAY GENERIC TONE – _DGT
NOTE: This command is available only in protocol versions 08.00 and later.
USE: Sends a generic tone to a station. Only the <Affected_Ext> user hears the tone; the connected
party does not.
NOTE: The application must have Display Control before it can issue this command.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _DGT,<InvokeID>,<Affected_Ext>,<Display_Control_Type>,<Generic_Tone>,
<Tone_Status><CR>
Where:
• Affected_Ext: Indicates a keyset (online) or a single-line set (online).
• Display_Control_Type: Specifies the type of Display Control the application has (1 =
full connected control, which is the only value currently available).
• Generic_Tone: Specifies the type of tone issued at the keyset. Burst tones last only for a
few seconds. Dialtones and other static tones continue until they are turned off. Possible
values include:
0 = Reorder burst
1 = Handsfree ringback burst
2 = Camp on burst
3 = Confirmation burst
4 = Prompt burst (not heard on display phones)
5 = Short camp on burst (not issued to keysets)
6 = Short confirmation burst
7 = Short prompt burst (not heard on display phones)
8 = Monitor burst
9 = Alert burst
10 = ARS dialtone
11 = Standard DND/FWD dialtone
12 = Standard message dialtone
13 = Standard dialtone
14 = Standard busy
15 = Standard system busy
16 = Standard DND busy
17 = IC Ringback
18 = CO Ringback
19 = Reorder
20 = Chime
21 = Ticktone
22 = Howler off-hook
NOTE: While in headset mode, transient tones 2 and 9 will only be heard if the Send
Alert Burst to Headset flag is enabled. This flag is under System\Devices and Feature
Codes\Stations\Local\<Station>\Flags.
• Tone_Status: Indicates if the tone is on (1) or off (0). If omitted, this field defaults to on
(1).
CONFIRMATION: <Sequence_Number>,CF,_DGT,<InvokeID>,<Outcome>,
<Affected_Ext>,<Display_Control_Type><CR><LF>
COMMON FAILURE
OUTCOME VALUES:
Invalid_Device_Identifier (9): The <Affected_Ext> device type does not support this command.
Generic_State_Incompatibility (15): The <Affected_Ext> device is either offline or not in a
state that accepts this command.
Value_Out_Of_Range (31): The <Generic_Tone> parameter is invalid.
Not_Owner_Of_Resource (49): The application does not have Display Control over the
<Affected_Ext>, the <Affected_Ext> is either offline or not in a state that accepts this command,
or the <Affected_Ext> does not support Display Control.
DESKTOP OAI: None
EXAMPLES: Present a reorder burst for extension 1000 (where 1000 is a station).
_DGT,<InvokeID>,1000,1,0,1
001,CF,_DGT,<InvokeID>,0,1000,1
Add dialtone for extension 1000 (where 1000 is a station).
_DGT,<InvokeID>,1000,1,14,1
001,CF,_DGT,<InvokeID>,0,1000,1
Remove dialtone for extension 1000 (where 1000 is a station).
_DGT,<InvokeID>,1000,1,14,0
001,CF,_DGT,<InvokeID>,0,1000,1
 */
public class DisplayGenericTone {

}
