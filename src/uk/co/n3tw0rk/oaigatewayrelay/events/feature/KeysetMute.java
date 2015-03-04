package uk.co.n3tw0rk.oaigatewayrelay.events.feature;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Feature;

/**
 * <strong>Keyset Mute Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 04-03-2015
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 53
 * 
 * 	KEYSET MUTE – MU
 * 
 * 	USE: 
 * 		Occurs whenever a keyset enables or disables the mute feature.
 * 
 * 	MONITOR TYPE: 
 * 		Device, Call, Call via Device
 * 
 * 	SYNTAX (V > 5.10):
 * 		MU,<Resync_Code>,<Mon_Cross_Ref_ID>,<Extension>,<On/Off><CR><LF>
 * 
 * 	Where:
 * 		• Extension: Identifies the extension number of the keyset device.
 * 		• On/Off: Indicates whether the mute mode has been disabled or enabled. This is a boolean
 * 			parameter (1 = Enabled; 0 = Disabled).
 * 
 * 	EXAMPLES: 
 * 		Keyset 1001 pressed the MUTE key.
 * 		001,MU,,<MON1001>,1001,1
 * 		Keyset 1000 takes itself out of mute using the feature code 314.
 * 		001,MU,,<MON1001>,1001,0
 */
public class KeysetMute extends Feature
{
	public final static String EVENT = "MU";

	protected int mExtension;
	
	protected int mOnOff;
	
	public KeysetMute( String event )
	{
		super( event );
	}

	public KeysetMute( String[] eventParts )
	{
		super( eventParts );
	}
	
	public KeysetMute setExtension( int extension )
	{
		this.mExtension = extension;
		return this;
	}
	
	public int getExtension()
	{
		return this.mExtension;
	}
	
	public KeysetMute setOnOff( int onOff )
	{
		this.mOnOff = onOff;
		return this;
	}
	
	public int getOnOff()
	{
		return this.mOnOff;
	}

	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <Extension>
	 * 5 <On/Off>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setExtension( this.getIntPart( 4 ) );
		this.setOnOff( this.getIntPart( 5 ) );
	}

	@Override
	public void process()
	{
	}
}
