package uk.co.n3tw0rk.oaigatewayrelay.commands.gateway;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Command;

/**
 * 
 * @author M00SEMARKTWO

GATEWAY UTILITY QUERY APPLICATIONS – _UQA
USE: Returns a list of all the applications that are currently running.
SYNTAX: _UQA,<InvokeID><CR>
CONFIRMATION: <Sequence_Number>,CF,_UQA,<InvokeID>,<Outcome>,
<Number_Of_Apps>,<AppData1>,...,<AppDataN><CR><LF>
Where:
• Number_Of_Apps: Indicates the number of open application windows.
• AppData: Specifies the following comma-separated information:
— AppNum: Indicates the integer number of the application.
— Connected_State: Specifies whether or not the application is connected (0 = Not
Connected; 1 = Connected).
— App_Name: Displays the name of the application, delimited by vertical slashes
(|). If blank, the application is not connected.
— IP_Address: Specifies the IP address of the application. If blank, the application is
not connected.

 */
public class GatewayUtilityQueryApplications extends Command
{
	@Override
	public String buildCommand()
	{
		return null;
	}
}