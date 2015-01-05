package uk.co.n3tw0rk.oaigatewayrelay.events.call;

/**
 * 
 * @author M00SEMARKTWO

QUEUED – QU
USE: Indicates that a call has been delivered or redirected to a trunk group or hunt/ACD group, and
the call queues (“camps on” in the Inter-Tel telephone system family).
MONITOR TYPE: Device, Call, Call via Device
SYNTAX: QU,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,<Queued_Ext>,
<Internal_Calling_Ext>,<Outside_Caller_Name>,<Outside_Caller_Number>,
<Trunk_Name>,<Trunk_Outside_Number>,<Calling_Device_Type>,
<Originally_Called_Dev>,<Last_Redirection_Ext>,<Number_Queued>,
<Account_Code>,<Local_Cnx_State>,<Event_Cause><CR><LF>
Where:
• Queued_Ext: Indicates the device where the call is queued.
• Internal_Calling_Ext: Indicates the extension number of the internal call originator. For
internal calls and outgoing CO calls, this is the calling party’s extension. For incoming
CO calls, this is the trunk extension.
• Outside_Caller_Name: Identifies the Caller ID/ANI name for incoming CO calls. This
can be added/modified with the Modify Call (_MD) command but cannot be
deleted. This text field is always blank for IC calls.
• Outside_Caller_Number: Indicates the outside caller’s Caller ID/ANI number, if available.
This can be added/modified with the Modify Call (_MD) command but cannot
be deleted. This field is always blank for IC calls.
• Trunk_Name: Displays the name associated with the trunk used for the call (e.g., the
name programmed in the system’s call routing table for the incoming number dialed
[DNIS/DID]). This can be added/modified with the Modify Call (_MD) command
but cannot be deleted. This text field is always blank for IC calls.
• Trunk_Outside_Number: Indicates the DNIS or DID outside number associated with
the trunk used for the call. This can be added/modified with the Modify Call (_MD)
command but cannot be deleted. This field is always blank for IC calls.
• Calling_Device_Type: Indicates the type of the calling device (I = Internal Party; E =
External Party).
• Originally_Called_Dev: Indicates the initial call destination if the call has never been
answered. For IC and incoming CO calls, this is the originally dialed extension. For
outgoing CO calls, this is the dialed digit string. The initial transfer destination for a
transferred call and the initial recall destination for a recalling call become the originally
called device. 
• Last_Redirection_Ext: Identifies the extension number of the last device that redirected
(forwarded, deflected, transferred, or recalled) the call, if applicable; otherwise, this is
blank.
• Number_Queued: Indicates the call’s position in the queue (1-65535), where a “1” indicates
that the call is the first call waiting for an available device to ring.
• Event_Cause: Indicates why the event occurred. The only possible values for this field
are as follows:
23 = No available agents
30 = Some resource is not available
33 = Trunks busy
40 = Transfer announcement (takes precedence over the other two)
EXAMPLE: Incoming CO call from 602-555-1212 to 800-222-5555 (using trunk 97061) rings directly to a
busy ACD group (273).
001,QU,,<MON273>,18532,273,,I,97061,,6025551212,,8002225555,E,273,,1,,
Q,23
002,QU,,<MON97061>,18532,273,,I,97061,,6025551212,,8002225555,E,273,,
1,,C,23
 */
public class Queued {

}
