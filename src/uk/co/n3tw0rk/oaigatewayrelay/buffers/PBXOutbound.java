package uk.co.n3tw0rk.oaigatewayrelay.buffers;

import java.util.HashMap;
import java.util.LinkedList;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.commands.Command;

public class PBXOutbound
{
	// TODO : Consider using ConcurrentLinkedQueue (does not support pop)
	protected static LinkedList<String> mMessageQueue = new LinkedList<String>();
	
	// TODO : Consider using ConcurrentHashMap
	protected static HashMap<Integer,Command> mCommandQueue = new HashMap<Integer,Command>();
	
	protected static final int MAXIMUM_INVOKE = 65535;

	protected static int invokeID = 0;
	
	public static int nextInvokeID()
	{
		invokeID++;
		if( invokeID >= MAXIMUM_INVOKE )
		{
			invokeID = 1;
		}
		return invokeID;
	}

	protected PBXOutbound(){}
	
	public static synchronized Command addCommand( Command command )
	{
		mCommandQueue.put( invokeID, command.setInvokeID( invokeID ) );
		mMessageQueue.add( command.getCommand() );
		nextInvokeID();
		return command;
	}
	
	public static synchronized Command getCommand( int invokeID )
	{
		return mCommandQueue.get( invokeID );
	}
	
	public static synchronized String getNextMessage()
	{
		if( 0 >= mMessageQueue.size() )
		{
			return null;
		}
		
		return mMessageQueue.pop();
	}
	
	public static synchronized int size()
	{
		return mMessageQueue.size();
	}
}
