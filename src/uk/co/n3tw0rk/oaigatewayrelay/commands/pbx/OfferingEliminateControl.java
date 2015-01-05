package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

OFFERING ELIMINATE CONTROL – _OEC
NOTE: This command is available only in protocol versions 07.00 and later.
USE: Allows an application to terminate the offering control that is has over a station device (see the
Offering Request Control command on the following page for details). When offering
control is disabled, the phone displays ROUTING OFF for a few seconds.
NOTES: The following items apply to the Offering Eliminate Control command:
• Stopping the device monitor on a station device automatically terminates the offering
control. However, eliminating offering control does not terminate a device monitor.
• If a call is currently in the offering mode when the station device receives this command,
Call Processing will not process the offered call(s) until <Timeout> (see
page 142) expires.
• To disable offering control on an extension, users must enter their station password,
which is assigned in Database Programming.
PREMIUM FEATURE: System OAI Third-Party Call Control
SYNTAX: _OEC,<InvokeID>,<Affected_Ext><CR>
Where <Affected_Ext> can be a keyset, single-line station, or modem (Axxess only).
CONFIRMATION: <Sequence_Number>,CF,_OEC,<InvokeID>,<Outcome>,<Affected_Ext><CR><LF>
COMMON FAILURE
OUTCOME VALUE:
Not_Owner_of_Resource (49): This application does not have offering control over the specified
station device.
DESKTOP OAI: None
GATEWAY IMPACT: This command is available only in CT Gateway versions 3.0 and later.
EXAMPLES: Terminate offering control over station 100.
_OEC,245,100
003,CF,_OEC,245,0,100
004,OE,,<MON100>,100,0
Terminate offering control on a station that the application does not control.
_OEC,1,105
003,CF,_OEC,1,49,

 */

public class OfferingEliminateControl {

}
