package uk.co.n3tw0rk.oaigatewayrelay.commands.gateway;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.commands.Command;

/**
 * 
 * @author M00SEMARKTWO

SET SCOPE COMMAND – _USS
USE: Allows applications to identify the specific nodes that they will be using. In some cases, a CT
Gateway will be set up to communicate to a large group of nodes, but an application will need
to interact only with a portion of these nodes. If the application is not node aware, the loss of
communication with any node will cause the application to stop functioning. In some cases,
however, making the application node aware is not practical. For these cases, this command
lets an application specify the nodes with which it intends to interact. Because the default
mode is “in scope,” any new nodes added to the CT Gateway are running in scope until the
application uses this command to take them out of scope.
Because this command can cause loss of event information, depending on the types of active
monitors, setting the application scope should be done only when the application first initializes
or whenever it receives a power-up Resync.
The following guidelines apply to this command:
1. The command is allowed as long as the application does not have a pending command
for the node for which the scope is changing. For example, you cannot take a node out
of scope if that node has a pending command.
2. The application can set up the scope to include nodes that do not exist on the CT Gateway.
3. The application’s scope will be reset to all nodes if:
a. The application loses its TCP/IP connection to the CT Gateway.
b. The application fails to send a command before the command timer expires.
c. One of the nodes the application is using drops, and the application is not node
aware.
d. A new node is added to the CT Gateway that is in scope for the application, and the
protocol version of the node changes the protocol version of the CT Gateway. This
would normally happen only in a node aware situation.
SYNTAX: _USS,<InvokeID>,<Mode>,<Node><CR>
Where:
• Mode: Defines whether or not the node is in scope (0 = Node is NOT within scope of
the application; 1 = Node is within scope of the application).
• Node: Identifies the node number of the node for which the scope is changing. If left
blank, this command affects the mode of all nodes known by the CT Gateway.
CONFIRMATION: <Sequence_Number>,CF,_USS,<InvokeID>,<Outcome><CR><LF>
NOTE: You can check the scope of an application in the CT Gateway interface by selecting an
application window and then selecting Application Scope from the View menu (see the CT
Gateway Manual for details).
Tokens specify how to format the display with the Display Control commands. When using
tokens, consider the following:
• By default, the system pre-clears the physical display before any display is presented.
• By default, all display lines are left-justified, except for prompts.
• You do not need to pad a display line with trailing blanks; the system does this by
default.
• Information displays can use any of the format tokens.
• Display Control cannot use the following tokens:
— FORMAT_TOKEN_STRING
— FORMAT_TOKEN_ARGUMENT_STRING
— FORMAT_TOKEN_PADDED_ARGUMENT_STRING
The following table lists the available display tokens.

Formatting Token % Newline %E
Tab* %H Expand Line* %X
Response (Cursor)* %_ Clear and Return* %A
Center Line %C Left Line %L
Countdown Timer* %d Stopwatch Timer* %w
Right Line %R Phone Number* %#

* Not available for menu displays.

 */
public class SetScopeCommand extends Command
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
