package uk.co.n3tw0rk.oaigatewayrelay.events.miscellaneous;

/**
 * 
 * @author M00SEMARKTWO

RESYNC RESPONSE – RS
USE: Occurs in response to the Resync Request (RR, not _RR) command or at power-up of the
system. Following this event, the system sends a complete set of events providing information
on all monitored devices unless a specific station was requested. If the resync request message
requested a resync of a specific station, the system generates the events pertaining only to that
station.
NOTE: If your application receives a Resync Response with a zero in the <Resync_Code>
field, your application has lost all of its monitors and settings. If this occurs, your application
should reset its information and re-initialize the port. If using a socket connection, the TCP/IP
connection is still valid, and you do not need to resend the TCP/IP login command (see
page 218).
MONITOR TYPE: No monitor required.
SYNTAX
 (V < 05.00):
RS,<Resync_Code>,<Time>,<Date>,<Protocol_Version>,<KSU_SW_Version><CR>
<LF>
SYNTAX
(05.00 <= V <
05.10):
RS,<Resync_Code>,<Time>,<Date>,<Protocol_Version>,<KSU_SW_Version>,
<Premium_Feature_Status>,<Network_Node_Number>,
<Networking Enabled/Disabled><CR><LF>
SYNTAX
(05.10 <= V <
06.00 &
GATEWAY):
RS,<Resync_Code>,<Time>,<Date>,<Protocol_Version>,<KSU_SW_Version>,
<Premium_Feature_Status>,<Network_Node_Number>,
<Networking Enabled/Disabled>,<Country_Code><CR><LF>
SYNTAX
(V >= 06.00 &
GATEWAY):
RS,<Resync_Code>,<Time>,<Date>,<Protocol_Version>,<KSU_SW_Version>,
<Premium_Feature_Status>,<Network_Node_Number>,
<Networking Enabled/Disabled>,<Country_Code>,<TCPIP_Flag><CR><LF>
Where:
• Time: Displays the time information from the phone system, allowing the attached computer
to synchronize clocks. This is displayed in 24-hour format (e.g., 13:30 = 1:30PM).
• Date: Displays the date information from the phone system, using the MMDDYY format.
• Protocol_Version: Identifies the version number of the System OAI protocol in use.
This is displayed in the format Vxx.yy where xx is the major version and yy is the revision
number.
NOTE: If the Gateway sends this event as a response to a node-specific Resync
Time command (RT), the <Protocol_Version> parameter contains the protocol version
of the node specified in the command. In all other cases, the CT Gateway populates
this field with the lowest protocol version of all of the telephone system nodes.
Possible protocol version numbers are as follows:
— V01.00 - Axxess V02.0, V02.1, V02.2 and Axxent V01.0 and V02.0 Level 1
— V01.01 - Axxess V03.0 and V03.1 Level 1
— V01.10 - Axxess V03.2 and above Level 1
— V02.00 - Axxess V03.0 Level 2
NOTE: Axxess V03.0 Level 2 version does not support this event and does not follow
this specification.
— V02.10 - Axxess V03.1 Level 2
— V02.20 - Axxess V03.2 Level 2
— V03.00 - Axxess V04.0 Level 2
— V03.20 - Axxess V04.2 and V04.3 Level 2
NOTE: This document does not define the above protocol versions. Contact Technical
Support for information regarding these versions.
— V04.40 - Axxess V04.4 Level 2
— V05.00 - Axxess V05.0 Level 2
— V05.10 - Axxess V05.1 Level 2
— V05.15 - Axxess 5.1 Production of V05.118 and later Level 2
— V05.20 - Axxess/Eclipse V05.2 Level 2
— V05.30 - Axxess/Eclipse V05.3 Level 2
— V06.00 - Axxess/Eclipse V06.0 Level 2
— V07.00 - Axxess/Eclipse V07.0 Level 2
— V08.00 - Axxess V08.0 Level 2
— V08.01 - Axxess V08.001 Level 2
— V08.02 - Axxess V08.002 Level 2
— V08.10 - Axxess V08.100 Level 2
— V08.20 - Axxess V08.200 Level 2
— V09.00 - Axxess V09.00 Level 2
— V09.00 - Inter-Tel 5000 V01.000 Level 2
• KSU_SW_Version: Indicates the version number of the equipment cabinet (KSU) software
in use. This is displayed in the format Vxx.yyy where xx is the major version and
yyy is the revision number.
NOTE: If the Gateway sends this event as a response to a node-specific Resync
Time command (RT), the <KSU_SW_Version> parameter contains the equipment cabinet
version of the node specified in the command. In all other cases, the CT Gateway
populates this field with the lowest cabinet version of all of the telephone system nodes.
• Premium_Feature_Status: Displays the enabled premium features. The options are:
0 = There is no common feature status across nodes (see the note below)
1 = Only System OAI Events are enabled
2 = Only Third-Party Call Control commands are enabled
3 = Both of the premium features are enabled
NOTE: If the Gateway sends this event as a response to a node-specific Resync
Time command (RT), the <Premium_Feature_Status> parameter contains the premium
feature status of the node specified in the command. In all other cases, the CT Gateway
populates this field with the lowest-common premium feature status of all of the telephone
system nodes. If there is no common premium feature status (i.e., some nodes
have only Third-Party Call Control enabled while others have only System OAI Events
enabled), the CT Gateway specifies this field as “0.”
• Network_Node_Number: Indicates the node number of the connected phone system. If
the system is not networked, this will be “1.” When this event is sent to an application
by the CT Gateway, this field specifies the node number of the phone system that originally
generated the event.
NOTE: The Gateway reports network node number “0” for power-up Resync
responses and resync responses it generates due to a system-wide Resync Request
(i.e., RR or _RR with a blank extension parameter). In all other cases, this field indicates
the specific node that generated the Resync Response.
• Networking Enabled/Disabled: Indicates whether or not the networking premium feature
is enabled on the phone system (0 = Disabled; 1 = Enabled).
NOTE: This parameter indicates only whether or not the premium feature for networking
has been enabled. It does not guarantee that the phone system is actually networked
to another node.
• Country_Code: Identifies the country code associated with the system. The options are:
1 = United States
2 = Japan
3 = United Kingdom
4 = Indonesia
5 = Mexico
• TCPIP_Flag: Indicates the type of interface being used for OAI. Possible values are:
0 = OAI data via RS232 (Axxess only)
1 = OAI data via TCP/IP
NOTE: The CT Gateway reports “1” for power-up Resync responses and resync
responses it generates due to a system-wide Resync Request (i.e., RR or _RR with a
blank extension parameter). In all other cases, this field indicates the connection type
between the CT Gateway and the specific node that generated the Resync
Response.
EXAMPLE: The phone system has received the Resync Request at 10:25PM, January 24, 1994.
000,RS,1,22:25,012494,V02.10,V03.1,3,1,1,1
 */
public class ResyncResponse {

}
