package uk.co.n3tw0rk.oaigatewayrelay.commands.gateway;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Command;

/**
 * 
 * @author M00SEMARKTWO

APPLICATION PARAMETERS PROGRAMMING – _AP
USE: Specifies the sequencing properties the application wants to use, as explained below. This
allows the command response and event delay sequencing to be set.
SYNTAX: _AP,<InvokeID>,<Command_Response_Ordered>,<Events_Delayed><CR>
Where:
• Command_Response_Ordered: Causes command responses either to be ordered (1) or
unordered (0) when the application chooses to send many commands at once without
waiting for a confirmation. By default, this is set to Ordered (1).
• Events_Delayed: Causes events to be delayed until all pending commands have completed
(1) or allows events that are not associated with any node holding a pending
command to be sent immediately (0). By default, this is set to Delayed (1).

 */

public class ApplicationParametersProgramming extends Command
{
	@Override
	public String buildCommand()
	{
		return null;
	}
}