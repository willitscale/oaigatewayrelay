package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

PROGRAM STATION PASSWORD – _PSP
NOTE: This command is available only in protocol versions 08.00 and later.
USE: Changes the station password based on input from the station user.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _PSP,<InvokeID>,<Affected_Ext>,<Old_Station_Password>,
<New_Station_Password><CR>
Where:
• Affected_Ext: Indicates the keyset or single-line set whose password should change.
• Old_Station_Password: Indicates the current station password. If this password is not
correct, the command fails, and the password is not changed. This field is delimited
with vertical slashes ( | ) and cannot exceed eight digits.
• New_Station_Password: Indicates the new station password. This field is delimited
with vertical slashes ( | ) and cannot exceed eight digits.
NOTE: The password supports the digits 0-9. Any other characters are not allowed.
CONFIRMATION: <Sequence_Number>,CF,_PSP,<InvokeID>,<Outcome>,<Affected_Ext><CR><LF>
COMMON FAILURE
OUTCOME VALUES: Generic_Unspecified (1): A parameter contains invalid characters.
Request_Incompatible_With_Object (3): The <Affected_Ext> device type does not support
this command.
Invalid_Password (39): The <Old_Station_Password> parameter does not match the actual
station password.
DESKTOP OAI: None
EXAMPLES: Change station 100’s password from 123 to 456.
_PSP,<InvokeID>,100,|123|,|456|
001,CF,_PSP,<InvokeID>,0,100

 */
public class ProgramStationPassword {

}
