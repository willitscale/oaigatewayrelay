package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;
/**
 * 
 * @author M00SEMARKTWO

SET VOLUME – _SV
NOTE: This command is available only in protocol versions 05.10 and later.
USE: Changes the volume level, which can increase or decrease by one level, of the <Affected_Ext>.
This command functions for digital keysets only.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _SV,<InvokeID>,<Affected_Ext>,<Volume>,<Save><CR>
Where:
• Affected_Ext: Indicates a digital keyset.
• Volume: Indicates which direction to change the volume (0 = No Change; 1 = Increase
by One Level; 2 = Decrease by One Level). This field may be blank if the volume level
is to be saved. Default value is No Change (0).
• Save: Indicates whether or not to save the volume (0 = Do Not Save; 1 = Save). Default
value is Do Not Save (0).
CONFIRMATION: <Sequence_Number>,CF,_SV,<InvokeID>,<Outcome>,<CR><LF>
COMMON FAILURE
OUTCOME VALUES:
Generic_Unspecified (1): The <Save> or <Volume> parameter contains invalid characters.
Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
Value_Out_Of_Range (31): The <Volume> or <Save> parameter is an invalid number.
Invalid_InvokeID (41): The <InvokeID> parameter is blank or invalid.
DESKTOP OAI: None
EXAMPLES: Increase the current volume on extension 1000 and save the volume level.
_SV,<InvokeID>,1000,1,1
001,CF,_SV,<InvokeID>,0
Save the current volume on extension 1000.
_SV,<InvokeID>,1000,,1
001,CF,_SV,<InvokeID>,0
Decrease the current volume on extension 1000 without saving the volume level.
_SV,<InvokeID>,1000,2,0
001,CF,_SV,<InvokeID>,0


 */
public class SetVolume {

}
