package uk.co.n3tw0rk.oaigatewayrelay.abstraction.events;

public abstract class DisplayMiscellaneous extends Miscellaneous
{
	protected int mSubjectExt;
	protected int mDisplayControlType;

	public DisplayMiscellaneous( String eventParts )
	{
		super( eventParts );
	}

	public DisplayMiscellaneous( String[] eventParts )
	{
		super( eventParts );
	}

	public DisplayMiscellaneous setSubjectExt( int subjectExt )
	{
		this.mSubjectExt = subjectExt;
		return this;
	}
	
	public int getSubjectExt()
	{
		return this.mSubjectExt;
	}

	public DisplayMiscellaneous setDisplayControlType( int displayControlType )
	{
		this.mDisplayControlType = displayControlType;
		return this;
	}
	
	public int getDisplayControlType()
	{
		return this.mDisplayControlType;
	}
	
	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <Subject_Ext>
	 * 5 <Display_Control_Type>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setSubjectExt( this.getIntPart( 4 ) );
		this.setDisplayControlType( this.getIntPart( 5 ) );
	}
}
