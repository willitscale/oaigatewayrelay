package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

MODIFY CALL – _MD
USE: Modifies specific information pertaining to a CO call. This command allows the application to
modify the outside caller’s name, the outside caller’s number, the trunk’s name, the trunk’s outside
number, and the account code. The outside caller’s information is equivalent to ANI or
Caller ID information, and the trunk’s information is equivalent to DID or DNIS information.
NOTE: As of version 08.10, you can specify an account code for IC calls that are transferred,
deflected, or moved to an outside number. Because the command specifies the account code,
the enduser is not prompted to enter the code.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _MD,<InvokeID>,<Affected_Ext>,<Call_ID>,
<Outside_Caller_Name>,<Outside_Caller_Number>,<Trunk_Name>,
<Trunk_Outside_Number>,<Account_Code><CR>
Where:
• Affected_Ext: Indicates a keyset or single-line set. In protocol V05.10 and later, the
<Affected_Ext> can be the same as the Call ID specified in the <Call_ID> parameter.
• Outside_Caller_Name: (Optional) Identifies the new name for the outside caller. This
field has a maximum length of 16 characters and is delimited by vertical slashes (|). If
blank, the system does not modify the outside caller’s name (i.e., this command cannot
be used to delete the outside caller’s name).
• Outside_Caller_Number: (Optional) Indicates the new number for the outside call. This
field has a maximum length of 32 digits. If blank or an empty string (| |), the system
does not modify the outside caller’s number (i.e., this command cannot be used to
delete the outside caller’s number).
• Trunk_Name: (Optional) Includes the new name for the trunk. This field has a maximum
length of 16 characters and is delimited by vertical slashes (|). If blank or an
empty string, the system does not modify the trunk’s name (i.e., this command cannot
be used to delete the trunk’s name).
• Trunk_Outside_Number: (Optional) Indicates the new outside number for the trunk.
This field has a maximum length of 32 digits. If blank, the system does not modify the
trunk’s outside number (i.e., this command cannot be used to delete the trunk’s outside
number).
• Account_Code: (Optional) Indicates the new account code the system should use. This
field has a maximum length of 12 digits. If blank, the system does not modify the
account code (i.e., this command cannot be used to delete the account code).
CONFIRMATION: <Sequence_Number>,CF,_MD,<InvokeID>,<Outcome><CR><LF>
COMMON FAILURE
OUTCOME VALUES: Generic_Unspecified (1): The <Outside_Caller_Name>, <Outside_Caller_Number>,
<Trunk_Name>, or <Trunk_Number> field is specified but contains invalid characters.
Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command.
Invalid_Call_Identifier (8): The <Call_ID> parameter is blank or invalid.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
Value_Out_Of_Range (31): The <Account_Code> parameter is invalid.
DESKTOP OAI: _M
EXAMPLES: Modify the outside caller's name and the account code.
_MD,<InvokeID>,1000,@10*,| New Name|,,,,12345
001,CF,_MD,<InvokeID>,0
Deflect Call (_DF) Examples
Extension 1005 makes a call to extension 1000. Deflect the call to 961-9000 with a
confirmation outcome of 6.
_MC,1,1005,1000
_DF,1,1000,201,8961-9000
CF,_DF,1,6
Extension 1005 makes a call to ext 1000. Modify the account code to 1234 so that both
extensions 1000 and 1005 have the new account code of 1234. Then deflect the call to 961-
9000.
_MC,1,1005,1000
_MD,1,1000,@201,,,,,1234
_DF,1,1000,201,8961-9000
OR
_DF,1,1000,201,8961-9000,,1005
(1005 should have the account code of 1234.)
Extension 1005 makes a call to Hunt Group 2001. Modify the account code to 1234.
_MC,1,1005,2001
_MD,1,1000,@201,,,,,1234
OR
_MD,1,1005,@201,,,,,1234
At this point both extensions 1000 and 1005 should have the new account code of 1234. It
does not matter which extension is used to set the account code because both the originating
call (1005) and the hunt group member 1000 have the same OAI Call_ID. Deflect the call to
961-9000.
_DF,1,1000,201,8961-9000
OR
_DF,1,2001,201,8961-9000,,1000
_DF,1,2001,201,8961-9000,,1005
Move Call (_MO) Examples
Extension 1005 makes a call to extension 1000. Deflect the call to 961-9000 with a
confirmation outcome of 6.
_MC,1,1005,1000
_MO,1,1000,201,8961-9000
CF,_MO,1,6
Extension 1005 makes a call to extension 1000. Modify the account code to 1234 so that both
extensions 1000 and 1005 have the same new account code of 1234. Then move the call to
961-9000.
_MC,1,1005,1000
_MD,1,1000,@201,,,,,1234
_MO,1,1000,201,8961-9000
OR
_MO,1,1000,201,8961-9000,,1005
(1005 should have the account code of 1234.)
Extension 1005 makes a call to Hunt Group 2001. Modify the account code to 1234.
_MC,1,1005,2001
_MD,1,1000,@201,,,,,1234
OR
_MD,1,1005,@201,,,,,1234
At this point both extensions 1000 and 1005 should have the new account code of 1234. It
does not matter which extension is used to set the account code because both the originating
call (1005) and the hunt group member 1000 have the same OAI Call_ID. Move the call to
961-9000
_MO,1,1000,201,8961-9000
OR
_MO,1,2001,201,8961-9000,,1000
_MO,1,2001,201,8961-9000,,1005
Transfer (One Step) (_TO) Examples
Extension 1005 makes a call to extension 1000, who answers the call. Modify the account
code to 1234. Then transfer the call (one-step) to 961-9000/
_MC,1,1005,1000
_MD,1,1000,201,,,,,1234
OR
_MD,1,1005,201,,,,,1234
_TO,1,1000,201,8961-9000
Extension 1005 makes a call to Hunt Group 2001. Hunt group member 1000 answers the call.
Modify the account code to 1234. Transfer the call (one-step) to 961-9000.
_MC,1,1005,2001
_MD,1,1000,201,,,,,1234
_TO,1,2001,201,8961-9000,,1000 <- This should fail.
_TO,1,1000,201,8961-9000,,1000 

 */
public class ModifyCall {

}
