package uk.co.n3tw0rk.oaigatewayrelay.events.call;

/**
 * 
 * @author M00SEMARKTWO

SERVICE INITIATED – SI
USE: Indicates that a device requested dialtone or that a callback is prompting the user to take a
phone off hook.
MONITOR TYPE: Device
SYNTAX
(V < 08.10):
SI,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,<Initiating_Ext>,
<Local_Cnx_State>,<Event_Cause><CR><LF>
SYNTAX
(V >= 08.10):
SI,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,<Initiating_Ext>,
<Local_Cnx_State>,<Event_Cause>,<Callback_Target_Ext><CR><LF>
Where:
• Call_ID: Identifies the initiated call.
• Initiating_Ext: Identifies the extension of the device initiating the service.
• Callback_Target_Ext: Indicates the device for which the <Initiating_Ext> requested a
callback. This field is populated only if <Event_Cause> is Callback (4).
EXAMPLES: Extension 105 calls extension 101 by hot-dialing (dialing without lifting the receiver).
001,SI,,<MON105>,507,105,I,22,
002,OR,,<MON105>,507,105,,I,101,,C,22,
003,DE,,<MON101>,507,101,,I,105,,,,,I,101,,,A,22,
004,DE,,<MON105>,507,101,,I,105,,,,,I,101,,,C,22,
Extension 105 comes off-hook and is connected to dialtone prior to dialing anything.
001,SI,,<MON105>,507,105,I,22,
Extension 1001 receives a callback prompt indicating extension 1002 is now available.
001,SI,,<MON1001>,1F01,1001,I,4,1002,

 */
public class ServiceInitiated {

}
