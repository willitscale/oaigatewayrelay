package uk.co.n3tw0rk.oaigatewayrelay.events.miscellaneous;

/**
 * 
 * @author M00SEMARKTWO

PORTS EXCEEDED – PE
USE: Occurs when a client connects to a TCP/IP System OAI Server that cannot allocate a System
OAI port for the client. Servers, which typically support only a limited number of clients, send
this event and close the TCP/IP connection when additional clients attempt to connect and the
ports are already occupied.
MONITOR TYPE: None
SYNTAX
(V >= 5.10):
PE,<Resync_Code>,<Max_OAI_Ports><CR><LF>
Where <Max_OAI_Ports> identifies the maximum number of System OAI ports that the TCP/
IP connection can support.
EXAMPLE: A client attempts to connect to a server that supports one port, which is currently in use.
000,PE,,1

 */
public class PortsExceeded {

}
