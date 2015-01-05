package uk.co.n3tw0rk.oaigatewayrelay.events.feature;

/**
 * 
 * @author M00SEMARKTWO

CALL INFO – CI
USE: Occurs when a user account code is collected for a party on the call. This includes all account
code types (e.g., forced, standard, optional, etc.).
MONITOR TYPE: Device, Call, Call via Device
SYNTAX: CI,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,<Device_Ext>,
<Account_Code><CR><LF>
Where:
• Device_Ext: Displays the extension of the station that entered the account code.
• Account_Code: Identifies the account code for the call.
EXAMPLES: Extension 100 enters account code 12345 on call 037.
001,CI,,<MON100>,037,100,12345
The Make Call command is used to make an outgoing CO call from extension 1000 to
9619000 using account code 1234.
001,OR,,<MON1000>,037,1000,,I,9619000,1234,C,22
002,CI,,<MON1000>,037,1000,1234
A call with an attached account code is transferred from extension 1000 to extension 1002.
014,TR,,<MON102>,037,100,101,@002,102,,,,,A,32
015,XC,,<MON102>,038,100,100,,36
016,XC,,<MON102>,037,102,100,N,36
017,CI,<MON1002>,037,1002,1234

 */
public class CallInfo {

}
