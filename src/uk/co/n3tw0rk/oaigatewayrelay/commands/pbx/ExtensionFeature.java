package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

EXTENSION FEATURE – _EF
USE: Allows the application to simulate an extension or feature being accessed on a station device.
This command also allows the application to dial digits over an existing call by specifying the
Call ID in the <Call_ID> field. If the <Affected_Ext> is busy and a Call ID is not specified,
this command will fail. Because the station device enters the digit string exactly as specified,
this command may leave the device in a non-idle state. This, however, should not be an issue
because the station should always time out and eventually return to idle. Because there is no
way to force a single line off-hook, this command fails if sent to an on-hook single line.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _EF,<InvokeID>,<Affected_Ext>,<Call_ID>,
<Extension/Feature_String><CR>
Where:
• Affected_Ext: Indicates a keyset (online) or single-line set (online and already offhook).
• Extension/Feature_String: Includes the digit string for the extension number or feature
code to be dialed. Depending on how the phone system is programmed, the feature code
may require an exclamation point (!) at the beginning of the digit string, even when the
station is idle (see Appendix A, page 239, for a list of default feature codes). If the station
is in the connected state and the <Call_ID> field is blank, only those feature codes
preceded by an exclamation point will be accepted. This field may be up to 48 digits
and may include the following:
CONFIRMATION: <Sequence_Number>,CF,_EF,<InvokeID>,<Outcome><CR><LF>
COMMON FAILURE
OUTCOME VALUES: Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command.
Invalid_Call_Identifier (8): The <Call_ID> parameter is blank.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
Invalid_Feature (10): The <Extension/Feature_String> parameter is blank.
Generic_State_Incompatibility (15): The <Affected_Ext> is not in the connected, on hold, or
idle state, or it is an on-hook single-line set.
No_Active_Call (16): The <Call_ID> parameter was not blank, but the call is not connected to
the <Affected_Ext>.
DESKTOP OAI: _E
EXAMPLES: Access the HeadSet OFF feature from extension 111.
_EF, <InvokeID>,111,,316
001,CF,_EF,<InvokeID>,0
From extension 111, reverse transfer (call pickup) the call at extension 125.
_EF, <InvokeID>,111,,4125
001,CF,_EF,<InvokeID>,0
From extension 111, reverse transfer (group call pickup) the call at Hunt Group extension
235.
_EF, <InvokeID>,111,,4235
001,CF,_EF,<InvokeID>,0
Set MsgWait (“MESSAGE FROM EXT 101") on extension 123 from extension 101.
_EF, <InvokeID>,101,,367123
001,CF,_EF,<InvokeID>,0
Turn on DND “GONE HOME” for extension 101.
_EF, <InvokeID>,101,,37019
001,CF,_EF,<InvokeID>,0
Set Forward-If-Busy to extension 299 for extension 101.
_EF, <InvokeID>,101,,357299
001,CF,_EF,<InvokeID>,0
Toggle Handsfree for extension 101 while connected.
_EF, <InvokeID>,101,,!301
001,CF,_EF,<InvokeID>,0

 */
public class ExtensionFeature {

}
