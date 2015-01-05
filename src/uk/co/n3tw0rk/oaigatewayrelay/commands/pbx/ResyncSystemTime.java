package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

RESYNC SYSTEM TIME – RT
NOTE: This command is available only in protocol versions 02.20 and later, but not in V03.00.
USE: Resynchronizes the application’s time with the phone system’s time. In response, the phone
system will send a Resync Response Event (see page 73).
PREMIUM FEATURE: System OAI Events or Third-Party Call Control
SYNTAX
(V < 05.10):
RT<CR>
SYNTAX
(V >= 05.10):
RT,<Specific_Extension><CR>
NOTE: The <InvokeID> parameter is not required and not allowed.
Where the <Specific_Extension> may specify the system node, using the Node: format, or
any valid device on the node.
GATEWAY SYNTAX: RT,<Affected_Ext><CR>
Where the <Affected_Ext> can be a node or an extension (expanded or normal format), or it
can be blank.
EXAMPLE: Request resynchronization of system time.
RT
000,RS,1,05:25,012494,V02.10,V03.1,3,1,1,1

 */
public class ResyncSystemTime {

}
