package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.commands.Command;
import uk.co.n3tw0rk.oaigatewayrelay.events.acknowledgement.Confirmation;

/**
 * <strong>Query Display Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 15-02-2015
 * 
 * 	QUERY DISPLAY – _DQD
 * 
 * 	NOTE: 
 * 		This command is available only in protocol versions 08.00 and later.
 * 
 * 	USE: 
 * 		Provides important information about the characteristics of the station display.
 * 
 * 	PREMIUM FEATURE: 
 * 		Third-Party Call Control
 * 
 * 	SYNTAX: 
 * 		_DQD,<InvokeID>,<Affected_Ext><CR>
 * 		Where valid device types for <Affected_Ext> include stations with displays.
 * 
 * 	CONFIRMATION: 
 * 		<Sequence_Number>,CF,_DQD,<InvokeID>,<Outcome>,<Display_Model>,
 * 		<Keyset_Language>,<Actual_Keyset_Language>,<Character_Sets_Supported>,
 * 		<Supports_Running_Timer>,<Supports_Scrolling_Display><CR><LF>
 *
 *	Where:
 *		• Display_Model: Specifies the phone model at the station, which allows you to determine
 *			the number of menu buttons, display lines, etc. Possible values include:
 *			0 = Model unknown
 *			1 = No display
 *			2 = Digital Keyset Basic DVNK
 *			3 = Digital Keyset Basic
 *			4 = Digital Keyset AgentSet
 *			5 = Digital Keyset Executive
 *			6 = Digital Keyset Executive with Tones
 *			7 = Eclipse Keyset Associate
 *			8 = Eclipse Keyset Professional
 *			9 = Executone™ Wave 29
 *			10 = Executone Model 32
 *			11 = Executone Model 64
 *			12 = Executone Model ACD
 *			13 = Executone Model 160
 *			14 = Jaguar 8660
 *			15 = Jaguar 8560
 *			16 = Jaguar 8520
 *			17 = Jaguar 8500
 *			18 = Model 8620 (using Inter-Tel proprietary protocol)
 *			19 = Model 8662 (using Inter-Tel proprietary protocol)
 *			20 = Model 8690 (using Inter-Tel proprietary protocol)
 *			21 = Model 8664
 *			22 = Model 8665
 *		• Keyset_Language: Indicates if the phone is programmed to use the primary language
 *			(0), the secondary language (1), or the language set in the Actual_Keyset_Language as
 *			described below.
 *		• Actual_Keyset_Language: Indicates the language (e.g., English, Spanish, or Japanese)
 *			that the phone is programmed to use. Possible values include:
 *			2 = American English
 *			3 = UK English
 *			4 = Japanese
 *			5 = Mexican Spanish
 *			6 = Standard Spanish
 *			7 = Indo English
 *			255 = Unknown
 *		• Character_Sets_Supported: Provides a bit list of all the character sets the phone supports.
 *			Possible values include:
 *			0 = English
 *			1 = Latin
 *			2 = Katakana
 *		• Supports_Running_Timer: Indicates whether or not the station supports an active timer.
 *		• Supports_Scrolling_Display: Indicates whether or not the station supports a scrolling
 *			display.
 *
 *	COMMON FAILURE OUTCOME VALUES:
 *		Request_Incompatible_With_Object (3): The <Affected_Ext> device type does not support
 *		this command.
 *		Invalid_Device_Identifier (9): The <Affected_Ext> parameter is blank or invalid.
 *
 *	DESKTOP OAI: 
 *		None
 *
 *	EXAMPLES: 
 *		Query the display for extension 100, which has a display model of 0, is using the primary
 *		language (American English), supports character set 1, supports a running timer, and does
 *		not support a scrolling display.
 *		_DQD,<InvokeID>,100
 *		001,CF,_DQD,<InvokeID>,0,0,2,1,1,0
 */
public class QueryDisplay extends Command
{
	public static final String COMMAND = "_DQD";
	
	protected int mAffectedExt;

	public QueryDisplay setAffectedExt( int affectedExt )
	{
		this.mAffectedExt = affectedExt;
		return this;
	}
	
	public int getAffectedExt()
	{
		return this.mAffectedExt;
	}
	
	@Override
	public String buildCommand()
	{
		return COMMAND + "," + this.getInvokeID() + "," + this.getAffectedExt();
	}


	/*
	<Sequence_Number>,
	CF,
	_DQD,
	<InvokeID>,
	<Outcome>,
	<Display_Model>,
	<Keyset_Language>,
	<Actual_Keyset_Language>,
	<Character_Sets_Supported>,
	<Supports_Running_Timer>,
	<Supports_Scrolling_Display>
	<CR>
	<LF>
	*/

	@Override
	public void confirmation()
	{
		if( !( this.mEvent instanceof Confirmation ) )
		{
			return;
		}

		int partsSize = this.mEvent.getPartsSize();
		
		if( 0 == partsSize )
		{
			return;
		}
	}
}
