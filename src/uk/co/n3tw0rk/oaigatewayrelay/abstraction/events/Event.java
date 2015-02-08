package uk.co.n3tw0rk.oaigatewayrelay.abstraction.events;

import uk.co.n3tw0rk.oaigatewayrelay.interfaces.OAIPacket;

/**
 * 
 * @author M00SEMARKTWO
 *
 */
public abstract class Event implements OAIPacket
{
	protected String mEvent;

	protected int mResyncCode;

	protected int mMonCrossRefID;
	
	protected int mSequence;
	
	protected String[] mEventParts;
	
	public Event( String[] eventParts )
	{
		this.mEventParts = eventParts;
		this.parseEvent();
	}
	
	public Event( String eventString )
	{
		this.mEventParts = splitEvent( eventString );
		this.parseEvent();
	}
	
	protected abstract void parseEvent();
	
	public Event setSequence( int sequence )
	{
		this.mSequence = sequence;
		return this;
	}
	
	public int getSequence()
	{
		return this.mSequence;
	}

	public Event setEvent( String event )
	{
		this.mEvent = event;
		return this;
	}
	
	public String getEvent()
	{
		return this.mEvent;
	}

	public Event setResyncCode( int resyncCode )
	{
		this.mResyncCode = resyncCode;
		return this;
	}
	
	public int getResyncCode()
	{
		return this.mResyncCode;
	}
	
	public Event setMonCrossRefID( int monCrossRefID )
	{
		this.mMonCrossRefID = monCrossRefID;
		return this;
	}
	
	public int getMonCrossRefID()
	{
		return this.mMonCrossRefID;
	}
	
	/**
	 * 
	 * @param eventString
	 * @return
	 */
	public static String[] splitEvent( String eventString )
	{
		if( null == eventString || eventString.trim().isEmpty() )
		{
			return new String[]{};
		}

		/**
		 * TODO : 	FACTOR IN THAT STRING DELIMITERS ARE | AND SHOULD BE SPLIT 
		 * 			AROUND THIS IN CASE THE THE STRING CONTAINS A ,
		 */
		return eventString.split( ",(?=(?:(?:[^\"\']*[\"\']){2})*[^\"\']*$)" );
	}
	
	public int getIntPart( int index )
	{
		if( 0 <= index && this.mEventParts.length > index )
		{
			try
			{
				String part = this.mEventParts[ index ];
				if( null != part && !part.trim().isEmpty() )
				{
					return Integer.parseInt( part.trim() );
				}
			}
			catch( Exception exception )
			{
				
			}
		}
		
		return -1;
	}
	
	public String getStringPart( int index )
	{
		if( 0 <= index && this.mEventParts.length > index )
		{
			return this.mEventParts[ index ];
		}
		
		return null;
	}
	
	public int getPartsSize()
	{
		return this.mEventParts.length;
	}
}
