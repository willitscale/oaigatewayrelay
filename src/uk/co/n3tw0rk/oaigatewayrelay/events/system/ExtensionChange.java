package uk.co.n3tw0rk.oaigatewayrelay.events.system;

/**
 * 
 * @author M00SEMARKTWO

EXTENSION CHANGE – EC
NOTE: This event is available only in protocol versions 05.10 and later.
USE: Occurs whenever device extensions are changed in the database, or when a device is equipped
or unequipped.
MONITOR TYPE: System
SYNTAX: EC,<Resync_Code>,<Mon_Cross_Ref_ID>,<Network_Node_Number>,
<Old_Extension>,<New_Extension>,<Device_Type><CR><LF>
Where:
• Network_Node_Number: Indicates the node number of the connected phone system. If
the system is not networked, this will be “1.” When this event is sent to an application
by the CT Gateway, this field specifies the node number of the phone system that originally
generated the event.
• Old_Extension: Displays the old extension number of the device. If blank, the device is
new.
• New_Extension: Shows the new extension of the device. If blank, the device has been
removed. 
• Device_Type: Identifies the device type of the <Old_Extension> and/or
<New_Extension>. Possible values are listed in the table below.

Table 24: EC – Device_Type Values
VALUE <DEVICE_TYPE> VALUE <DEVICE_TYPE>
0 Keyset Station Device or
Operator (11)1 18 Off-Node Single-Line Station
Device
1 Single-Line Station Device 19 Off-Node Hunt Group
2 ACD/Hunt Group 20 Off-Node Page Port
3 Loop Start Trunk with (4)1 or without
Caller ID
21 Off-Node Page Zone
5 Ground Start Trunk with (6)1 or
without Caller ID
22 Off-Node Voice Mail
7 DID Trunk 23 ACD Agent
8 E&M Trunk 243 Unassociated Mailbox
9 ISDN Trunk 253 Off-Node Unassociated Mailbox
10 Trunk Group 26 BRI Station
12 Voice Mail Application 27 Off-Node BRI Station
13 Other 28 MFC/R2 Trunk
142 Feature Code 294 Modem*
15 Page Zone 31 MGCP Endpoint
16 Page Port 32 MGCP Gateway and Endpoint
17 Off-Node Keyset Station Device 33 SIP Trunk
*Axxess only

1 Other commands and events separate these devices when reporting types. The number enclosed in
parentheses indicates the value other commands and events use to report the segregated type (i.e.,
the loop start trunk with Caller ID is reported as type 4).
2 Feature-code extensions cannot be removed or created, but they can be changed.
3 These values are valid only for protocol versions 5.20 and later.
4 This value is valid only for protocol versions 8.00 and later.
NOTE: As indicated, the Extension Change event does not always report the
most-detailed device type. To obtain the most-detailed device type, issue a Query
Device Info (_QI) command (see page 149).
EXAMPLES: The extension number for extension 1000 has been changed to 1001.
001,EC,,<Mon_Cross_Ref_ID>,<Network_Node_Number>,1000,1001,1
Extension 1000 changed to a modem*.
001,EC,,<Mon_Cross_Ref_ID>,<Network_Node_Number>,1000,1005,29
* Applies to Axxess only

 */

public class ExtensionChange {

}
