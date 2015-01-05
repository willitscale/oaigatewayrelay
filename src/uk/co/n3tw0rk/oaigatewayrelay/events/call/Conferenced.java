package uk.co.n3tw0rk.oaigatewayrelay.events.call;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Event;

/**
 * 
 * @author M00SEMARKTWO

CONFERENCED – CO
USE: Occurs when a conference call forms.
MONITOR TYPE: Device, Call, Call via Device
SYNTAX: CO,<Resync_Code>,<Mon_Cross_Ref_ID>,<Subject_Ext>,<Primary_Call_ID>,
<Secondary_Call_ID>,<Conf_Controller_Ext>,<Number_Of_Parties>,
<Party #1>,<Call_ID #1>,...<Party #N>,<Call_ID #N>,
<Local_Cnx_State>,<Event_Cause><CR><LF>
Where:
• Subject_Ext: Indicates the device sending this event.
• Primary_Call_ID: Displays the ID of the main call identified by <Subject_Ext> before
the conference formed. If <Subject_Ext> is the device forming the conference, this is
the ID of the call the device put onto conference-wait hold first. If <Subject_Ext> is not
the device forming the conference, this is the ID of the call between <Subject_Ext> and
the device forming the conference.
• Secondary_Call_ID: Identifies the call used to form the conference (consultative call
for the device forming the conference).
• Conf_Controller_Ext: Identifies the extension of the device controlling this conference
(i.e., the device forming the conference).
• Number_Of_Parties: Identifies the number of devices in the conference.
• Party n: Specifies the extension number of the nth party involved in the conference.
• Call_ID n: Displays the system-generated ID of the call to which the nth party is connected.
EXAMPLES: Extension 100 calls extension 101.
001,OR,,<MON100>,222,100,,I,101,,C,22
002,DE,,<MON101>,222,101,,I,100,,,,,I,101,,,A,22
003,DE,,<MON100>,222,101,,I,100,,,,,I,101,,,C,22
Extension 101 answers, and extension 100 puts the call onto conference-wait hold.
004,ES,,<MON100>,2001,101,,I,100,,,I,101,,C,35
005,ES,,<MON101>,222,101,,I,100,,,I,101,,C,35
006,HE,,<MON101>,222,100,C,39
007,HE,,<MON100>,222,100,H,39
Extension 100 calls extension 102.
008,OR,,<MON100>,223,100,,I,102,,C,22
009,DE,,<MON102>,223,102,,I,100,,,,,I,102,,,A,22
010,DE,,<MON100>,223,,I,100,,,,,I,102,,,C,22
011,ES,,<MON100>,223,102,,I,100,,,I,102,,C, 35
012,ES,,<MON102>,223,102,,I,100,,,I,102,,C,3
Extension 100 pulls the conference together.
013,HE,,<MON102>,223,100,C,39
014,HE,,<MON100>,223,100,H,39
015,CO,,<MON100>,100,222,223,100,3,100,224,101,222,102,223,C,41
016,CO,,<MON101>,101,222,,100,3,100,224,101,222,102,223,C,41
017,CO,,<MON102>,102,223,,100,3,100,224,101,222,102,223,C,41

 */

public class Conferenced extends Event
{

	public Conferenced(String event) {
		super(event);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void parseEvent() {
		// TODO Auto-generated method stub
		
	}

}
