package uk.co.n3tw0rk.oaigatewayrelay.events.feature;

/**
 * 
 * @author M00SEMARKTWO

CALLBACK – CB
NOTE: This event is available only in protocol versions 08.10 and later.
USE: Occurs when a device registers or removes a register for a callback. Currently, only the device
registering or deregistering the callback request issues this event. Because future System OAI
versions, might issue this event for other devices and/or calls, applications should use all
parameters within this event to understand the event meaning.
NOTE: This event is issued only if bit #12 in the feature-event bit mask is enabled. By default,
this filter bit is off.
MONITOR TYPE: Device
SYNTAX: CB,<Resync_Code>,<Mon_Cross_Ref_ID>,<On/Off>,<Affected_Ext>,
<Target_Ext>,<|Target_Username|>,<|Target_PC_Description|>,
<Account_Code>,<Outside_Number><CR><LF>
Where:
• On/Off: Indicates whether the callback register was initiated (1) or removed (0).
• Affected_Ext: Specifies the device requesting the callback (i.e., the requestor).
• Target_Ext: Indicates the device extension for which the <Affected_Ext> requested a
callback.
• Target_Username: Identifies the username programmed for the <Target_Ext>. This
field is delimited by vertical slashes ( | ).
• Target_PC_Description: Indicates the <Target_Ext> PC description. This field is delimited
by vertical slashes ( | ).
• Account_Code: Specifies the account code if Call Processing collected an account code
before the callback request occurred. If no account code was collected, this field is
blank.
• Outside_Number: Indicates the outside number that Call Processing collected before
the callback request occurred. If Call Processing modified the number, this field will not
match the exact number the user dialed. If the call is an IC call or if call processing has
not collected the outside number, this field is blank.
GATEWAY IMPACTS: CT Gateway version 4.1 or later is required to use this event.
EXAMPLES: Extension 100 calls 101, but 101 is in DND. Extension 100 requests a callback.
001,SI,,<MON100>,57301,100,I,22,
002,OR,,<MON100>,57301,100,,I,1002,,C,22
003,FA,,<MON100>,57301,101,101,C,14
_RCB,<InvokeID>,100,57301
004,CF,_RCB,<InvokeID>,0
005,XC,,<MON100>,57301,100,100,N,04
006,CB,,<MON100>,1,100,101,|USER101|,|101Description|,,
Cancel a callback request where extension 100 is the requestor and extension 101 is the
target.
_CCB,<InvokeID>,100,101
001,CF,_CCB,<InvokeID>,0
002,CB,,<MON100>,0,100,101,|USER101|,|101Description|,,
Extension 1001 calls Extension 1002, but 1002 is busy. 1001 manually requests a callback.
001,SI,,<MON1001>,1P01,1001,I,22,
002,OR,,<MON1001>,1P01,1001,,I,1002,,C,22
003,DE,,<MON1002>,1P01,1002,,I,1001,,,,,I,1002,,,A,22,
004,DE,,<MON1001>,1P01,1002,,I,1001,,,,,I,1002,,,C,22,
005,XC,,<MON1001>,1P01,1001,1001,N,04
006,XC,,<MON1002>,1P01,1001,1001,,36
007,XC,,<MON1002>,1P01,1002,1001,N,36
008,CB,,<MON1001>,1,1001,1002,|USER1002|,|1002Description|,,
When 1002 becomes available, several things could happen, including one of the following
four scenarios.
1. Extension 1001 answers the callback prompt (either manually or with the Answer Call
command). The callback is automatically deregistered.
009,SI,,<MON1001>,1F01,1001,I,04,1002
_AC,1,1001,1F01
010,CF,_AC,1,0
011,CB,,<MON1001>,0,1001,1002,|USER1002|,|1002Description|,,
012,OR,,<MON1001>,1F01,1001,,I,1002,,C,04
013,DE,,<MON1002>,1F01,1002,,I,1001,,,,,I,1002,,,A,22,
014,DE,,<MON1001>,1F01,1002,,I,1001,,,,,I,1002,,,C,22,
2. Extension 1001 ignores the callback prompt. The callback times out and deregisters itself.
009,SI,,<MON1001>,1F01,1001,I,04,1002
010,CB,,<MON1001>,0,1001,1002,|USER1002|,|1002Description|,,
011,XC,,<MON1001>,1F01,1002,1002,N,36
3. Extension 1002 becomes busy before 1001 answers the prompt. The prompt stops, but the
callback is still registered.
009,SI,,<MON1001>,1F01,1001,I,04,1002
010,XC,,<MON1001>,1F01,1002,1002,N,36
4. Extension 1001 cancels the callback manually, with the Clear Connection command or
with the Cancel Callback command.
009,SI,,<MON1001>,1F01,1001,I,04,1002
_CCB,1,1001,1002
010,CF,_CCB,1,0
011,CB,,<MON1001>,0,1001,1002,|USER1002|,|1002Description|,,
012,XC,,<MON1001>,1F01,1002,10021001,1000,N,36
 */
public class Callback {

}
