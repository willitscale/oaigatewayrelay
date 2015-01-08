package uk.co.n3tw0rk.oaigatewayrelay.commands.gateway;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Command;

/**
 * 
 * @author M00SEMARKTWO

GATEWAY SEND DATA – _GSD
NOTE: This command is available only in CT Gateway version 4.2xx and later.
USE: Allows an application to send data to another application. This information is available through
the use of the _UQA command. Applications can disconnect from the CT Gateway, then
reconnect and be assigned a different application number (defined by the CT Gateway). For
that reason, an application should verify that the target application number is correct immediately
prior to sending the data. An application also must have registered with the Gateway
(using the _GDR command) to receive messages from another application. See “Gateway Data
Destination Registration – _GDR” on page 211.
When the data is sent to the application a new Gateway-specific event of Gateway Data Arrival
(GDA) is generated immediately to the application that is the target of the GSD command.
SYNTAX: _GSD,<InvokeID>,<Target_Application>,<Byte_Count>,<Data_To_Send>
Where:
• Target_Application: Indicates the application number of the application to send data to.
An application can have a list of applications attached to the Gateway and their application
information using the _UQA command.
NOTE: For applications to communicate through a CT Gateway, all applications must
be on the same CT Gateway.
• Byte_Count: Specifies the number of bytes to send. Valid values are 1 - 256.
• Data_To_Send: Specifies the data that the application wants to send to the other application.
CONFIRMATION: CF,_GSD,<InvokeID>,<Outcome>
EVENT FORMAT: GDA,<Resync_Code>,<Monitor_Xref>,<Sending_Application>,
<Sending_Application_Name>,<Sending_Application_Address>,
<Byte_Count>,<Data_Sent>
Where:
• Resync_Code: Is blank
• Monitor_Xref: Is blank
• Sending_Application: Indicates the application number of the application sending the
data.
• Sending_Application_Name: Indicates the name of the application sending the data,
which is delimited by || characters.
• Sending_Application_Address: Specifies the IP address of the application sending the
data.
• Byte_Count: Specifies the number of bytes to send. Valid values are 1 - 256.
• Data_Sent: Specifies the data that the application wants to send to the other application.
COMMON FAILURE
OUTCOME VALUES:
Invalid_Destination (11): The <Target_Application> is unknown or is not accepting data.
Invalid_Message_Length (44): The byte count is > 256. The Gateway uses the byte count to
count the number of bytes in the data to be saved. This byte count is compared to the data in
the command packet received via IP for correctness. If the byte count is incorrect the CT Gateway
returns an error. 

 */

public class GatewaySendData extends Command
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