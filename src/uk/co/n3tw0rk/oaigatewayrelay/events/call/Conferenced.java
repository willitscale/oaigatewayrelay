package uk.co.n3tw0rk.oaigatewayrelay.events.call;

import java.util.LinkedList;
import java.util.List;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.CallID;

/**
 * <strong>Conferenced Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 07-02-2014
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 27
 * 
 * 	CONFERENCED – CO
 * 
 * 	USE: 
 * 		Occurs when a conference call forms.
 * 
 * 	MONITOR TYPE: 
 * 		Device, Call, Call via Device
 * 
 * 	SYNTAX: 
 * 		CO,<Resync_Code>,<Mon_Cross_Ref_ID>,<Subject_Ext>,<Primary_Call_ID>,
 * 		<Secondary_Call_ID>,<Conf_Controller_Ext>,<Number_Of_Parties>,
 * 		<Party #1>,<Call_ID #1>,...<Party #N>,<Call_ID #N>,
 * 		<Local_Cnx_State>,<Event_Cause><CR><LF>
 * 
 * 	Where:
 * 		• Subject_Ext: Indicates the device sending this event.
 * 		• Primary_Call_ID: Displays the ID of the main call identified by <Subject_Ext> before
 * 			the conference formed. If <Subject_Ext> is the device forming the conference, this is
 * 			the ID of the call the device put onto conference-wait hold first. If <Subject_Ext> is not
 * 			the device forming the conference, this is the ID of the call between <Subject_Ext> and
 * 			the device forming the conference.
 * 		• Secondary_Call_ID: Identifies the call used to form the conference (consultative call
 * 			for the device forming the conference).
 * 		• Conf_Controller_Ext: Identifies the extension of the device controlling this conference
 * 			(i.e., the device forming the conference).
 * 		• Number_Of_Parties: Identifies the number of devices in the conference.
 * 		• Party n: Specifies the extension number of the nth party involved in the conference.
 * 		• Call_ID n: Displays the system-generated ID of the call to which the nth party is connected.
 * 	
 * EXAMPLES: 
 * 		Extension 100 calls extension 101.
 * 		001,OR,,<MON100>,222,100,,I,101,,C,22
 * 		002,DE,,<MON101>,222,101,,I,100,,,,,I,101,,,A,22
 * 		003,DE,,<MON100>,222,101,,I,100,,,,,I,101,,,C,22
 * 		Extension 101 answers, and extension 100 puts the call onto conference-wait hold.
 * 		004,ES,,<MON100>,2001,101,,I,100,,,I,101,,C,35
 * 		005,ES,,<MON101>,222,101,,I,100,,,I,101,,C,35
 * 		006,HE,,<MON101>,222,100,C,39
 * 		007,HE,,<MON100>,222,100,H,39
 * 		Extension 100 calls extension 102.
 * 		008,OR,,<MON100>,223,100,,I,102,,C,22
 * 		009,DE,,<MON102>,223,102,,I,100,,,,,I,102,,,A,22
 * 		010,DE,,<MON100>,223,,I,100,,,,,I,102,,,C,22
 * 		011,ES,,<MON100>,223,102,,I,100,,,I,102,,C, 35
 * 		012,ES,,<MON102>,223,102,,I,100,,,I,102,,C,3
 * 		Extension 100 pulls the conference together.
 * 		013,HE,,<MON102>,223,100,C,39
 * 		014,HE,,<MON100>,223,100,H,39
 * 		015,CO,,<MON100>,100,222,223,100,3,100,224,101,222,102,223,C,41
 * 		016,CO,,<MON101>,101,222,,100,3,100,224,101,222,102,223,C,41
 * 		017,CO,,<MON102>,102,223,,100,3,100,224,101,222,102,223,C,41
 * 
 */
public class Conferenced extends CallID
{
	public final static String EVENT = "CO";
	
	public Conferenced( String[] eventParts )
	{
		super( eventParts );
	}
	
	public Conferenced( String event )
	{
		super( event );
	}

	/** Subject Ext */
	protected int mSubjectExt;
	
	/** Primary Call ID */
	protected int mPrimaryCallID;
	
	/** Seconary Call ID */
	protected int mSecondaryCallID;
	
	/** Conf Controller Ext */
	protected int mConfControllerExt;
	
	/** Number of Parties */
	protected int mNumberOfParties;
	
	/** Parties */
	protected List<Party> mParties = new LinkedList<Party>();
	
	public class Party
	{
		public int mCallID;
		public int mParty;
		
		public Party( int callID, int party )
		{
			this.mCallID = callID;
			this.mParty = party;
		}
	}

	public Conferenced setSubjectExt( int subjectExt )
	{
		this.mSubjectExt = subjectExt;
		return this;
	}
	
	public int getSubjectExt()
	{
		return this.mSubjectExt;
	}
	
	public Conferenced setPrimaryCallID( int primaryCallID )
	{
		this.mPrimaryCallID = primaryCallID;
		return this;
	}
	
	public int getPrimaryCallID()
	{
		return this.mPrimaryCallID;
	}
	
	public Conferenced setSecondaryCallID( int secondaryCallID )
	{
		this.mSecondaryCallID = secondaryCallID;
		return this;
	}
	
	public int getSecondaryCallID()
	{
		return this.mSecondaryCallID;
	}
	
	public Conferenced setConfControllerExt( int confControllerExt )
	{
		this.mConfControllerExt = confControllerExt;
		return this;
	}
	
	public int getConfControllerExt()
	{
		return this.mConfControllerExt;
	}
	
	public Conferenced setNumberOfParties( int numberOfParties )
	{
		this.mNumberOfParties = numberOfParties;
		return this;
	}
	
	public int getNumberOfParties()
	{
		return this.mNumberOfParties;
	}
	
	public Conferenced addParty( Party party )
	{
		if( null != party )
		{
			this.mParties.add( party );
		}

		return this;
	}
	
	public List<Party> getParties()
	{
		return this.mParties;
	}
	
	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <Subject_Ext>
	 * 5 <Primary_Call_ID>
	 * 6 <Secondary_Call_ID>
	 * 7 <Conf_Controller_Ext>
	 * 8 <Number_Of_Parties>
	 * #A <Party #N>
	 * #B <Call_ID #N>,
	 * n-2 <Local_Cnx_State>,
	 * n-1 <Event_Cause>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();

		this.setSubjectExt( this.getIntPart( 4 ) );
		this.setPrimaryCallID( this.getIntPart( 5 ) );
		this.setSecondaryCallID( this.getIntPart( 6 ) );
		this.setConfControllerExt( this.getIntPart( 7 ) );
		this.setNumberOfParties( this.getIntPart( 8 ) );

		int partySize = ( this.getPartsSize() - 11 ) / 2;

		if( partySize == this.getIntPart( 8 ) )
		{
			for( int i = 0; i < partySize * 2; i+=2 )
			{
				this.addParty( new Party( this.getIntPart( i ), 
					this.getIntPart( i + 1 ) ) );
			}
		}

		this.setLocalCnxState( this.getStringPart( this.getPartsSize() - 2 ) );
		this.setEventCause( this.getIntPart( this.getPartsSize() - 1 ) );
	}

	@Override
	public void process()
	{
	}
}
