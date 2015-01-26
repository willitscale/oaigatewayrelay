package uk.co.n3tw0rk.oaigatewayrelay.commands.system;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Command;
import uk.co.n3tw0rk.oaigatewayrelay.utils.OAIToolkit;

/**
 * <strong>Connection Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 25-01-2015
 *
 */
public class Connection extends Command
{
	protected char mSocketType;
	
	protected String mApplicationName;
	
	protected String mPassword;

	public Connection setSocketType( char socketType )
	{
		this.mSocketType = socketType;
		return this;
	}
	
	public char getSocketType()
	{
		return this.mSocketType;
	}
	
	public Connection setApplicationName( String applicationName )
	{
		this.mApplicationName = applicationName;
		return this;
	}
	
	public String getApplicationName()
	{
		return this.mApplicationName;
	}
	
	public Connection setPassword( String password )
	{
		this.mPassword = password;
		return this;
	}
	
	public String getPassword()
	{
		return this.mPassword;
	}
	
	@Override
	protected String buildCommand()
	{
		return null;
	}
	
	@Override
	public String getCommand()
	{
		return OAIToolkit.buildConnectionPBXCommand( this.getSocketType(), 
			this.getApplicationName(), this.getPassword() );
	}

	@Override
	public void confirmation(){}

}
