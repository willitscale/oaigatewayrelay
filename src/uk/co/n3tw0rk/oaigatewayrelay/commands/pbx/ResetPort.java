package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

RESET PORT – _RP
NOTE: This command is available only in protocol versions 08.00 and later.
USE: Resets the specified port to an initialized state. Specifically, this command:
• Stops all monitors (Display Control Eliminated and Offering Eliminated
are issued on monitor stop).
• Turns off expanded format.
• Deletes all blocked events.
• Prevents any confirmations (from the telephone system) to be written for commands
sent before the _RP command was issued.
• Clears node aware settings (_NA) making the application node unaware (CT Gateway
only).
• Clears scope settings (_USS), putting all nodes in scope (CT Gateway only).
• Clears application parameter settings (_AP), setting command responses to ordered and
events to delayed (CT Gateway only).
• Sends an _RP confirmation event.
• Sends power-up Resync Response (RS) and Resync Ended (RD) events; or, if a
node is down, the CT Gateway sends Link Status (LS) events.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _RP,<InvokeID><CR>
CONFIRMATION: <Sequence_Number>,CF,_RP,<InvokeID>,<Outcome><CR><LF>
COMMON FAILURE
OUTCOME VALUES:
Invalid_Invoke_ID (41): The <InvokeID> parameter is blank or invalid.
DESKTOP OAI: None
EXAMPLE: An application sends a Reset Port command to a version 4.0 CT Gateway.
_RP,1
001,CF,_RP,1,0
000,RS,0,16:02,030702,V07.00,V07.000,3,1,1,1,0
001,RD,0

 */
public class ResetPort {

}
