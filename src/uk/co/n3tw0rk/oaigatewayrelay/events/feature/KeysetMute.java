package uk.co.n3tw0rk.oaigatewayrelay.events.feature;

/**
 * 
 * @author M00SEMARKTWO

KEYSET MUTE – MU
USE: Occurs whenever a keyset enables or disables the mute feature.
MONITOR TYPE: Device, Call, Call via Device
SYNTAX
(V > 5.10):
MU,<Resync_Code>,<Mon_Cross_Ref_ID>,<Extension>,<On/Off><CR><LF>
Where:
• Extension: Identifies the extension number of the keyset device.
• On/Off: Indicates whether the mute mode has been disabled or enabled. This is a boolean
parameter (1 = Enabled; 0 = Disabled).
EXAMPLES: Keyset 1001 pressed the MUTE key.
001,MU,,<MON1001>,1001,1
Keyset 1000 takes itself out of mute using the feature code 314.
001,MU,,<MON1001>,1001,0

 */
public class KeysetMute {

}
