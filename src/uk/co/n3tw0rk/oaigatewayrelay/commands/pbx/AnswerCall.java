package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

ANSWER CALL – _AC
USE: Allows the application to cause the <Affected_Ext> to access a particular call, regardless of its
status, priority, or sequence number. The call with the specified Call_ID will be connected to
the device if the device is not already connected to another call. Versions prior to 08.10 do not
support using this command to answer a queue callback call. As of version 08.10, you can use
this command to answer a callback request.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _AC,<InvokeID>,<Affected_Ext>,<Call_ID><CR>
Where valid device types for the <Affected_Ext> field are a keyset (online), a single-line set
(online and off-hook) or a modem (Axxess only).
CONFIRMATION: <Sequence_Number>,CF,_AC,<InvokeID>,<Outcome><CR><LF>
COMMON FAILURE
OUTCOME VALUES:
Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command.
Invalid_Call_Identifier (8): The <Call_ID> parameter is blank or invalid.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
Invalid_Object_State (14): The specified call is not in an answerable state or the
<Affected_Ext> is already connected on another call.
Generic_State_Incompatibility (15): The device specified by <Affected_Ext> is offline, or it
is an on-hook single-line phone.
No_Call_to_Answer (20): The specified call is not present at the <Affected_Ext>.
Resource_Busy (24): The <Affected_Ext> cannot allocate a voice channel.
Invalid_InvokeID (41): The <InvokeID> parameter is blank or invalid.
DESKTOP OAI: _C
EXAMPLES: Answer Call ID @004 on extension 107.
_AC,<InvokeID>,107,@004
001,CF,_AC,<InvokeID>,0
Extension 1001 receives a callback prompt. The Answer Call command is then issued to
answer the prompt and dial extension 1002.
001,SI,,<MON1001>,1F01,1001,I,04,1002
_AC,1,1001,1F01
002,CF,_AC,1,0
003,CB,,<MON1001>,0,1001,1002,|USER1002|,|1002Description|,,
004,OR,,<MON1001>,1F01,1001,,I,1002,,C,04
005,DE,,<MON1002>,1F01,1002,,I,1001,,,,,I,1002,,,A,22,
006,DE,,<MON1001>,1F01,1002,,I,1001,,,,,I,1002,,,C,22,


 */
public class AnswerCall {

}
