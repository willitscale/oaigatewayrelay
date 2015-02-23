package uk.co.n3tw0rk.oaigatewayrelay.events.feature;

/**
 * <strong>Callback Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 30-01-2015
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Pages 51-52
 * 
 * 	FEATURE STATUS – FE
 * 
 * 	USE: 
 * 		Occurs when a keyset enables or disables a toggleable feature.
 * 
 * 	MONITOR TYPE: 
 * 		Device (Requires the Feature Status <filter_list> bit enabled [bit 8])
 * 
 * 	PREMIUM FEATURE: 
 * 		System OAI Events
 * 
 * 	SYNTAX: 
 * 		When <Resync_Code> is not empty:
 * 		FE,<Resync_Code>,<Mon_Cross_Ref_ID>,<Extension>,
 * 		<Feature_Status_Mask><CR><LF>
 * 
 * 		When <Resync_Code> is empty:
 * 		FE,<Resync_Code>,<Mon_Cross_Ref_ID>,<Extension>,<Logical_Number>,
 * 		<On/Off><CR><LF>
 * 
 * 	Where:
 * 		• Extension: Identifies the extension number of the station device.
 * 		• Logical_Number: Identifies the feature logical number (see the following table). This
 *	 		parameter exists only when <Resync_Code> is empty.
 * 		• On/Off: Indicates whether the feature has been enabled or disabled (1 = Enabled; 0 =
 * 			Disabled). This parameter exists only when <Resync_Code> is empty.
 * 		• Feature_Status_Mask: Specifies a bit mask where each bit in the hexadecimal number
 * 			indicates whether a feature is enabled (1) or disabled (0). See the table on the following
 * 			page for a list of feature codes and their associated bit numbers. This parameter is used
 * 			only for resync-generated events (i.e., <Resync_Code> is not empty).
 * 	
 * 	NOTE: 
 * 		Currently, the maximum number of characters for the <Feature_Status_Mask>
 * 		field is seven. This may, however, increase in the future.
 * 
 * 	Table 13: Feature_Status_Masks
BIT # HEX FEATURE LOGICAL
NUMBER
DEFAULT
FEATURE
CODE (US)
0 1 Enhanced Speakerphone Enable 34 310
1 2 Background Music On/Off 35 313
2 4 Do-Not-Disturb On/Off 68 372
3 8 Handsfree On/Off 40 319
4 10 Headset On/Off 39 317
5 20 Hunt Group Remove/Replace 43 324
6 40 Call Forward – Busy 58 357
7 80 Call Forward – No Answer 57 356
8 100 Call Forward – If No Answer/Busy 59 358
9 200 Call Forward – All Calls 56 355
10 400 Mute On/Off 36 314
11 800 Page On/Off 44 325
12 1000 Ring Intercom Always On/Off 70 377
13 2000 Message 62 365
14 4000 System Forward On/Off 55 354
15 8000 Auto CO Access On/Off 60 360
16 10000 Auto IC Access On/Off 61 361
17 20000 Diagnostics Mode On/Off 1 9900
18 40000 ACD Agent Toggle 96 328
19 80000 Station Monitor 101 321
20 100000 Switch Keymap 102 399
21 200000 Agent Help 103 375
22 400000 Record-A-Call 105 385
23 800000 Group Listen 106 312
24 1000000 Display Outside Party Name On/Off 119 379
25 20000000 Barge In On/Off 136 386

GATEWAY IMPACTS: The CT Gateway allows an application to enable the FE status bit through the Monitor
Start (_MS) or Change Event Filter (_CE) command if all of the affected devices are on
a node with protocol version 06.00 or later. Otherwise, the CT Gateway strips the FE bit from
the command.
The CT Gateway allows an application to enable the FE status bit through the Monitor
Start Advanced (_MA) command on the nodes that support it even if some nodes in the network
do not support it (i.e., pre V06.00). For those nodes that do not support it, the filter bit list
in the confirmation indicates that the event was not enabled. Because the Monitor Start
Advanced command returns multiple confirmation messages, the CT Gateway can return a
different filter list for the monitors started on each node.
EXAMPLES: Keyset 1001 enables the handsfree feature.
001,FE,<MON1001>,1001,40,1
Keyset 1001 disables the group listen feature.
001,FE,<MON1001>,1001,106,0
A Resync Request is sent for Keyset 1001. It has handsfree enabled, a message, and system
forwarding enabled. All other features are disabled.
001,FE,1,<MON1001>,1001,0006008

 */
public class FeatureStatus {

}
