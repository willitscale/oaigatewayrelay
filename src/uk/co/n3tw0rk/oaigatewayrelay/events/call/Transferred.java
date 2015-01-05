package uk.co.n3tw0rk.oaigatewayrelay.events.call;

/**
 * 
 * @author M00SEMARKTWO

TRANSFERRED – TR
USE: Occurs when a station transfers a call to another device. This does not include the reverse
transfer feature (call pick-up). (See the Diverted event on page 32 for details about call pickup.)
MONITOR TYPE: Device, Call, Call via Device
SYNTAX: TR,<Resync_Code>,<Mon_Cross_Ref_ID>,<Transferred_Call_ID>,
<Transferring_Ext>,<Transferred_Ext>,<Announcement_Call_ID>,
<Destination_Ext>,<Outside_Caller_Name>,<Outside_Caller_Number>,
<Trunk_Name>,<Trunk_Outside_Number>,<Local_Cnx_State>,
<Event_Cause><CR><LF>
Where:
• Transferred_Call_ID: Specifies the <Call_ID> (see page 11) of the transferred call. For
supervised transfers, this is the <Call_ID> that the transferring extension put on transfer-hold.
• Transferring_Ext: Indicates the extension of the device performing the transfer.
• Transferred_Ext: Specifies the extension of the device that was transferred to the
<Destination_Ext>. This may be blank if the transferred call is a conference call.
• Announcement_Call_ID: Displays the <Call_ID> (see page 11) of the transfer
announcement call. This field is blank if the transferred event is sent on behalf of the
device being transferred because it never had any knowledge of the announcement call.
• Destination_Ext: Indicates the extension of the transfer destination device.
• Outside_Caller_Name: Identifies the outside caller’s Caller ID/ANI name for the transferred
device. This can be added/modified with the Modify Call (_MD) command
in the System OAI (_M in Desktop OAI) but cannot be deleted. This text field is always
blank for IC calls.
• Outside_Caller_Number: Indicates the outside caller’s Caller ID/ANI number, if available,
of the transferred device. This can be added/modified with the Modify Call
(_MD) command in System OAI (_M in Desktop OAI) but cannot be deleted. This field
is always blank for IC calls.
• Trunk_Name: Displays the name associated with the transferred trunk, if applicable
(e.g., the name programmed in the system’s call routing table for the incoming number
dialed [DNIS/DID]). If there is no DID/DNIS number, this field displays the trunk
description programmed in the phone system. This can be added/modified with the
Modify Call (_MD) command in the System OAI (_M in Desktop OAI) but cannot
be deleted. This text field is always blank for IC calls.
• Trunk_Outside_Number: Indicates the DNIS or DID outside number associated with
the transferred trunk, if applicable. This can be added/modified with the Modify
Call (_MD) command in the System OAI (_M in Desktop OAI) but cannot be deleted.
This field is always blank for IC calls.
EXAMPLES: Extension 100 calls extension 101.
001,OR,,<MON100>,18532,100,,I,101,,C,22
002,DE,,<MON101>,18532,101,,I,100,,,,,I,101,,,A,22
003,DE,,<MON100>,18532,101,,I,100,,,,,I,101,,,C,22
Extension 101 answers, and extension 100 puts the call on transfer-hold.
004,ES,,<MON100>,18532,101,,I,100,,,I,101,,C,35
005,ES,,<MON101>,18532,101,,I,100,,,I,101,,C,35
006,HE,,<MON101>,18532,100,C,38
007,HE,,<MON100>,18532,100,H,38
Extension 100 calls extension 102 and completes the transfer to extension 102.
008,OR,,<MON100>,18533,100,,I,102,,C,22
009,DE,,<MON102>,18533,102,,I,100,,,,,I,102,,,A,40
010,DE,,<MON100>,18533,102,,I,100,,,,,I,102,,,C,40
011,TR,,<MON100>,18532,100,101,@002,102,,,,,N,32
012,XC,,<MON100>,18533,100,100,N,36
013,TR,,<MON101>,18532,100,101,,102,,,,,C,32
014,TR,,<MON102>,18532,100,101,@002,102,,,,,A,32
015,XC,,<MON102>,18533,100,100,,36
016,XC,,<MON102>,18532,102,100,N,36
017,DE,,<MON102>,18532,102,,I,101,,,,,I,102,100,,A,32
018,DE,,<MON101>,18532,102,,I,101,,,,,I,102,100,,C,32
NOTE: Transferred messages are not guaranteed to be followed by a Delivered, Held, or
Established event message to indicate the state of the call after the transfer.
 */
public class Transferred {

}
