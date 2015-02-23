package uk.co.n3tw0rk.oaigatewayrelay.events.feature;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Feature;

/**
 * <strong>Elapsed Time For CO Call</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 30-01-2015
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 50
 * 
 * 	ELAPSED TIME FOR CO CALL – ET
 * 
 * 	USE: 
 * 		Occurs when a station connects to a CO call.
 * 
 * 	MONITOR TYPE: 
 * 		Device
 * 
 * 	SYNTAX: 
 * 		ET,<Resync_Code>,<Mon_Cross_Ref_ID>,<Call_ID>,
 * 		<Affected_Ext>,<Number_of_Elapsed_Seconds><CR><LF>
 * 	
 * 	Where:
 * 		• Call_ID: Identifies the connected call.
 * 		• Affected_Ext: Indicates the station connected to the CO call.
 * 		• Number_of_Elapsed_Seconds: Indicates the total number of seconds that this call has
 * 			been in the system.
 * 
 * 	EXAMPLE: 
 * 		Extension 1000 answers an incoming CO call that has been in the system for five minutes.
 * 		001,ET,<MON1000>,1000,@001,300
 */
public class ElapsedTimeForCOCall extends Feature
{
	public final static String EVENT = "ET";

	protected String mCallID;
	
	protected int mAffectedExt;
	
	protected int mNumberOfElapsedSeconds;
	
	public ElapsedTimeForCOCall( String event )
	{
		super( event );
	}

	public ElapsedTimeForCOCall( String[] eventParts )
	{
		super( eventParts );
	}
	
	public ElapsedTimeForCOCall setCallID( String callID )
	{
		this.mCallID = callID;
		return this;
	}
	
	public String getCallID()
	{
		return this.mCallID;
	}
	
	public ElapsedTimeForCOCall setAffectedExt( int affectedExt )
	{
		this.mAffectedExt = affectedExt;
		return this;
	}
	
	public int getAffectedExt()
	{
		return this.mAffectedExt;
	}

	public ElapsedTimeForCOCall setNumberOfElapsedSeconds( int numberOfElapsedSeconds )
	{
		this.mNumberOfElapsedSeconds = numberOfElapsedSeconds;
		return this;
	}
	
	public int getNumberOfElapsedSeconds()
	{
		return this.mNumberOfElapsedSeconds;
	}
	

	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <Call_ID>
	 * 5 <Affected_Ext>
	 * 6 <Number_of_Elapsed_Seconds>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setCallID( this.getStringPart( 4 ) );
		this.setAffectedExt( this.getIntPart( 5 ) );
		this.setNumberOfElapsedSeconds( this.getIntPart( 6 ) );
	}

	@Override
	public void process()
	{
	}

}
