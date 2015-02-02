package uk.co.n3tw0rk.oaigatewayrelay.events.call;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Event;

/**
 * 
 * @author M00SEMARKTWO

CALL CLEARED – CC
USE: Occurs when a call that was on a device is now terminating and clearing out of the phone system.
This event is sent only for calls that are being monitored. If the devices involved in the
call are being monitored but the call is not, Connection Cleared (XC) events (see
page 29) are the only events sent. In protocol versions 05.00 and above, the phone system also
generates Call Cleared events for every call in the system, on a per-system OAI serial
port basis, if a specific monitor type is specified in a Monitor Start (_MS) command (see
page 128). This allows the application to receive Call Cleared events for every call in the
system without having to initiate a call monitor on each and every call.
MONITOR TYPE: Call, Call Termination, Call via Device
SYNTAX
(V < 08.00):
CC,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,<Event_Cause><CR><LF>
SYNTAX
(V >= 08.00):
CC,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,<Event_Cause>,
<Transferred_Call_ID>,<Transfer_Destination><CR><LF>
Where:
• Transferred_Call_ID: If <Event_Cause> is 32 (Transfer), specifies the call ID of the
call that was transferred. If <Event_Cause> is any value other than 32, this field is
blank.
• Transfer_Destination: If <Event_Cause> is 32 (Transfer), specifies the destination
extension. If <Event_Cause> is any value other than 32, this field is blank.
EXAMPLES: Extension 105 hangs up call 562.
001,CC,,<MON562>,562,36
Extension 105 hangs up on call 561 to complete a transfer to extension 106.
001,CC,,<MON561>,561,36,560,106
Extension 105 terminates call 563.
001,CC,,<MON561>,563,36,,

 */

public class CallCleared extends Event
{

	public CallCleared(String event) {
		super(event);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void parseEvent() {
		// TODO Auto-generated method stub
		
	}

}
