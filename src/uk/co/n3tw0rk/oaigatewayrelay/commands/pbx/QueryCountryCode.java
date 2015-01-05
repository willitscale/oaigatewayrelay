package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

QUERY COUNTRY CODE – _QC
NOTE: This command is available only in protocol versions 05.10 and later.
USE: Returns the country code of the system.
PREMIUM FEATURE: System OAI Events or Third-Party Call Control
SYNTAX: _QC,<InvokeID>,<Affected_Ext><CR>
Where the <Affected_Ext>, if specified, must contain a valid extension residing on the system
node being queried.
CONFIRMATION: <Sequence_Number>,CF,_QC,<InvokeID>,<Outcome>,<Country_Code><CR><LF>
Where <Country_Code> can be one of the following:
1 = United States
2 = Japan
3 = United Kingdom
4 = Indonesia
5 = Mexico
DESKTOP OAI: None
EXAMPLES: The system's country code is 1 (United States).
_QC,<InvokeID>
001,CF,_QC,<InvokeID>,0,1
The system's country code is 2 (Japan).
_QC,<InvokeID>
001,CF,_QC,<InvokeID>,0,2

 */
public class QueryCountryCode {

}
