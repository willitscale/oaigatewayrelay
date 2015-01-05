package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

PROGRAM STATION SPEED-DIAL BINS – _PSS
USE: Programs the contents of a station speed-dial bin.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _PSS,<InvokeID>,<Affected_Ext>,<Stn_Bin_Number>,<Change_Type>,<Data1>,
<Data2><CR>
Where:
• Affected_Ext: Indicates a keyset or single-line set where the speed-dial bin is programmed.
• Stn_Bin_Number: Indicates the station speed-dial bin to change. Current valid bin numbers
are 0-9.
• Change_Type: Specifies the fields that should change. Valid types are:
1 = Change only the bin contents (i.e., the number that the station dials when the user
activates the speed-dial bin. Currently, the telephone system limits the contents to
16 digits consisting of digits defined in the following table.

VALUE INDICATION
0-9, *, # Keypad Digits
P Pause
F Hookflash
! (Exclamation) SPCL Key
- (Hyphen) Ignored
( ) (Parentheses) Ignored
; (Semicolon) Ignored
Space Ignored

2 = Change only the <Stn_Bin_Name> (i.e., the description of the speed-dial bin). Currently,
the telephone system limits station bin names to 16 characters.
3 = Change both the <Stn_Bin_Contents> and the <Stn_Bin_Name>.
• Data1: (Optional) Indicates the value of the <Change_Type>, as described in the following
table. If this parameter is blank, the system clears the corresponding field (either
<Stn_Bin_Contents> or <Stn_Bin_Name>).

<CHANGE_TYPE> DATA1 MEANING
1 The new <Stn_Bin_Contents>.
2 The new <Stn_Bin_Name> delimited by vertical slashes (|).
3 The new <Stn_Bin_Contents>.

• Data2: (Optional): Indicates the new <Stn_Bin_Name>, delimited by vertical slashes
(|), only if the <Change_Type> is 3. If the <Change_Type> is 3 and this parameter is
blank, the system clears the <Stn_Bin_Name>.
CONFIRMATION: <Sequence_Number>,CF,_PSS,<InvokeID>,<Outcome><CR><LF>
COMMON FAILURE
OUTCOME VALUES:
Generic_Unspecified (1): A parameter contains invalid characters.
Request_Incompatible_With_Object (3): The <Affected_Ext>’s device type does not support
this command.
Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
Value_Out_Of_Range (31): The <Stn_Bin_Number> or <Stn_Bin_Contents> value is
invalid.
DESKTOP OAI: None
GATEWAY IMPACTS: If an application sends this command to a node with protocol V06.00 or later, the CT Gateway
sends the command to that node and allows the application to receive the confirmation. If the
CT Gateway receives this command for a node with a protocol earlier than V06.00, the CT
Gateway fails the command with an outcome of Invalid_Command (45).
NOTE: This command is available only in CT Gateway versions 2.0 and later.
EXAMPLES: Program station 100’s speed-dial bin number 5 to dial Inter-Tel (480-961-9000).
_PSS,<InvokeID>,100,5,3,4809619000,|Inter-Tel|
CF,_PSS,<InvokeID>,0
Change the name of station 100’s speed-dial bin number 0 to Mickey Mouse. The bin contents
remain unchanged.
_PSS,<InvokeID>,100,0,2,|Mickey Mouse|
CF,_PSS,<InvokeID>,0
Change the bin contents of station 100’s speed-dial bin number 0 to 1-818-560-1000. The bin
name remains unchanged.
_PSS,<InvokeID>,100,0,1,18185601000
CF,_PSS,<InvokeID>,0
Change the bin contents of station 100’s speed-dial bin number 0 to 1-818-560-1000 and
clear the bin name.
_PSS,<InvokeID>,100,0,3,18185601000,||
CF,_PSS,<InvokeID>,0
OR
_PSS,<InvokeID>,100,0,3,18185601000,
CF,_PSS,<InvokeID>,0
OR
_PSS,<InvokeID>,100,0,3,18185601000
CF,_PSS,<InvokeID>,0
Clear the bin name of station 100’s speed-dial bin number 0 while leaving the bin contents
unchanged.
_PSS,<InvokeID>,100,0,2,||
CF,_PSS,<InvokeID>,0
OR
_PSS,<InvokeID>,100,0,2,
CF,_PSS,<InvokeID>,0
OR
_PSS,<InvokeID>,100,0,2
CF,_PSS,<InvokeID>,0
Clear both the bin contents and the bin name of station 100’s speed-dial bin number 0.
_PSS,<InvokeID>,100,0,3,,||
001,CF,_PSS,<InvokeID>,0
OR
_PSS,<InvokeID>,100,0,3,,
CF,_PSS,<InvokeID>,0
OR
_PSS,<InvokeID>,100,0,3,
CF,_PSS,<InvokeID>,0
OR
_PSS,<InvokeID>,100,0,3
CF,_PSS,<InvokeID>,0
 */
public class ProgramStationSpeedDialBins {

}
