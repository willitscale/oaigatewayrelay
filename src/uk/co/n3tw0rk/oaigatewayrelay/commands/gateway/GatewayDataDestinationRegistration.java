package uk.co.n3tw0rk.oaigatewayrelay.commands.gateway;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.commands.Command;

/**
 * 
 * @author M00SEMARKTWO

GATEWAY DATA DESTINATION REGISTRATION – _GDR
NOTE: This command is available only in CT Gateway version 4.2xx and later.
USE: Used by an application to inform the CT Gateway that it is going to allow applications to send
data to it via the GDA event.
SYNTAX: _GDR,<InvokeID>,<Registration_Flag>
Where Registration_Flag is either 0 or 1. By default, when an application connects to the CT
Gateway it is configured to not accept messages from other applications. To enable message
acceptance, an application must send this command with the registration flag set to 1. To disable
message acceptance, set the flag to 0.
CONFIRMATION: CF,_GDR,<InvokeID>,<Outcome>
COMMON FAILURE
OUTCOME VALUES:
Value_Out_Of_Range (31): The flag setting is missing or not in a valid range (0 - 1).

 */

public class GatewayDataDestinationRegistration extends Command
{
	@Override
	public String buildCommand()
	{
		return null;
	}

	@Override
	public void confirmation()
	{
	}
}