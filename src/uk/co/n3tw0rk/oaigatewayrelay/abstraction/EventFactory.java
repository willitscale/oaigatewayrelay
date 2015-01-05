package uk.co.n3tw0rk.oaigatewayrelay.abstraction;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Confirmation;
import uk.co.n3tw0rk.oaigatewayrelay.events.agent.*;
import uk.co.n3tw0rk.oaigatewayrelay.events.miscellaneous.ResyncEnded;

public class EventFactory
{
	public static Event getEvent( String[] eventParts )
	{
		if( 0 >= eventParts.length )
		{
			return null;
		}
		
		// Confirmation Event
		if( 0 == Confirmation.EVENT.compareTo( eventParts[ 1 ] ) )
		{
			return new Confirmation( eventParts );
		}
		// Agent Events
		else if( 0 == Logoff.EVENT.compareTo( eventParts[ 1 ] ) )
		{
			return new Logoff( eventParts );
		}
		// Call Events
		
		// Miscellaneous
		else if( 0 == ResyncEnded.EVENT.compareTo( eventParts[ 1 ] ) )
		{
			return new ResyncEnded( eventParts );
		}
		
		return null;
	}
}
