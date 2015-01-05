package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

CANCEL CALLBACK – _CCB
NOTE: This command is available only in protocol versions 08.10 and later.
USE: Cancels a callback request. The <Affected_Ext> must have previously requested a callback,
either manually or via the Request Callback (_RCB) command. This command cancels a
waiting callback request or one that is currently prompting the requestor’s (<Affected_Ext>
phone.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _CCB,<InvokeID>,<Affected_Ext>,<Target_Ext><CR>
Where:
• Affected_Ext: Indicates the extension of a keyset or single-line set that previously
requested a callback.
• Target_Ext: Indicates the extension for which the <Affected_Ext> requested a callback.
CONFIRMATION: <Sequence_Number>,CF,_CCB,<InvokeID>,<Outcome><CR><LF>
COMMON FAILURE
OUTCOME VALUES:
Request_Incompatible_With_Object (3): The <Affected_Ext> device type does not support
this command.
Invalid_Device_Identifier (9): Either the <Affected_Ext> or the <Target_Ext> parameter is
blank or invalid.
Generic_State_Incompatibility (15): The <Affected_Ext> does not have a pending callback
request for the <Target_Ext>.
EXAMPLES: Cancel a callback request where extension 100 is the requestor and extension 101 is the
target.
_CCB,<InvokeID>,100,101
001,CF,_CCB,<InvokeID>,0
002,CB,,<MON100>,0,100,101,|USER101|,|101Description|,,
While a callback from station 1002 is ringing 1001, cancel the callback at station 1001.
001,SI,,<MON1001>,1F01,1001,I,04,1002
_CCB,1,1001,1002
002,CF,_CCB,1,0
003,CB,,<MON1001>,0,1001,1002,|USER1002|,|1002Description|,,
004,XC,,<MON1001>,1F01,1002,1002,N,36

 */
public class CancelCallback {

}
