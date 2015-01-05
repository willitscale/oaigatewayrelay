package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

TRANSFER CALL – _TR
USE: Transfers a held call to an active call when the <Affected_Ext> is involved with both calls. The
announcement call is the transfer-announcement call, and the held call is the call on hold (individual
hold or transfer hold).
PREMIUM FEATURE: Third-Party Call Control
SYNTAX
(V < 05.00):
_TR,<InvokeID>,<Affected_Ext>,<Held_Call_ID>,
<Announcement_Call_ID><CR>
SYNTAX
(V >= 05.00):
_TR,<InvokeID>,<Affected_Ext>,<Held_Call_ID>,
<Announcement_Call_ID>,<Transfer_Type><CR>
Where:
• Affected_Ext: Indicates a keyset (online) or single-line set (online).
• Held_Call_ID: Specifies the ID of the held call to be transferred.
• Announcement_Call_ID: Indicates the ID of the announcement call that will receive the
transferred call. This call can be in the alerting or connected state.
• Transfer_Type: Indicates whether or not the call should automatically be placed on individual
hold at the destination station (0 = Transfer To Ring; 1 = Transfer To Hold).
Default is Transfer To Ring (0).
CONFIRMATION: <Sequence_Number>,CF,_TR,<InvokeID>,<Outcome>,<New_Call_ID>,
<Destination_Ext>,<Transferred_Ext>,<Outside_Caller_Name>,
<Outside_Caller_Number>,<Trunk_Name>,<Trunk_Outside_Number><CR><LF>
Where:
• New_Call_ID: Specifies the Call ID of the resulting call.
• Destination_Ext: Indicates the transfer destination extension (internal extension). If
transferred to the public network, this is the extension of the trunk used.
• Transferred_Ext: Identifies the device (internal extension) that was transferred. This
field may be blank if the transferred call is a conference call.
• Outside_Caller_Name: Indicates the outside caller’s name of the transferred device
(e.g., Caller ID/ANI name, if available). This information can be added/modified with
the Modify Call (_MD) command in System OAI (_M in Desktop OAI) but cannot
be deleted. This field is always blank for IC calls.
• Outside_Caller_Number: Identifies the outside caller’s Caller ID/ANI number for an
incoming CO call, if available. This can be added/modified with the Modify Call
(_MD) command in System OAI (_M in Desktop OAI) but cannot be deleted. This field
is always blank for IC calls.
• Trunk_Name: Specifies the name associated with the transferred device if it is a trunk
(e.g., the name programmed in the system’s call routing table for the incoming number
dialed [DID/DNIS]). If there is no DID/DNIS number, this field displays the trunk
description programmed in the phone system. This information can be added/modified
with the Modify Call (_MD) command is System OAI but cannot be deleted. This
field is always blank for IC calls.
• Trunk_Outside_Number: Identifies the DNIS or DID information associated with the
transferred trunk, if applicable. This can be added/modified with the Modify Call
(_MD) command in System OAI (_M in Desktop OAI) but cannot be deleted. This field
is always blank for IC calls.
COMMON FAILURE
OUTCOME VALUES:
Generic_Unspecified (1): The <Transfer_Type> parameter contains invalid characters.
Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command.
Invalid_Call_Identifier (8): One or both of the <Call_ID> parameters are blank or invalid.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
Generic_State_Incompatibility (15): The <Affected_Ext> cannot complete the transfer (e.g.,
the <Affected_Ext> has a call other than <Held_Call_ID> on transfer-hold).
No_Active_Call (16): The <Affected_Ext> is not active on any call, or it is active on a call
other than the one specified by <Announcement_Call_ID>.
No_Held_Call (17): The call specified by <Held_Call_ID> is not on hold at the
<Affected_Ext>.
Value_Out_Of_Range (31): The <Transfer_Type> field contains an invalid value.
EXAMPLE: Transfer a call on hold (@103 connected to 101) at extension 111 to extension 120
(announcement call ID = @001).
_TR,<InvokeID>,111,@103,@001
001,CF,_TR,<InvokeID>,0,@103,120,101,,,,
 */
public class TransferCall {

}
