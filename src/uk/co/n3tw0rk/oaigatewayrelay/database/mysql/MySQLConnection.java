package uk.co.n3tw0rk.oaigatewayrelay.database.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import uk.co.n3tw0rk.oaigatewayrelay.utils.Config;

public class MySQLConnection
{

	private Connection mysqlConnection = null;
	private boolean queryExecuted;
	
	public MySQLConnection()
	{
		this.connect();
	}
	
	
	public void connect()
	{
		try
		{
			mysqlConnection = DriverManager.getConnection( String.format( 
					"jdbc:%1$s://%2$s/%3$s?user=%4$s&password=%5$s%6$s", 
					Config.DB_PROTOCOL, Config.DB_HOSTNAME, Config.DB_DATABASE, 
					"root", "foo32PANTS", Config.DB_RECONNECT ? "&autoReconnect=true" : "" ) );
		}
		catch( SQLException e )
		{
			MySQLConnection.sqlError( e );
		}
	}

	public void disconnect()
	{
		if( null == mysqlConnection ) return;

		try
		{
			mysqlConnection.close();
			mysqlConnection = null;
		}
		catch( SQLException e )
		{
			MySQLConnection.sqlError( e );
		}

	}

	public MySQLResults executeQuery( String query )
	{
		if( null == mysqlConnection ) return null;

		MySQLResults mysqlResults = null;
		Statement statement = null;

		try
		{
			statement = mysqlConnection.createStatement();
			if ( statement.execute( query ) )
				mysqlResults = new MySQLResults( statement.getResultSet() );

			queryExecuted = true;
		}
		catch( SQLException e )
		{
			queryExecuted = false;
			MySQLConnection.sqlError( e );
		}
		finally
		{
			try { if( null != statement ) statement.close(); statement = null; } catch( Exception e ) {}
		}
		return mysqlResults;
	}
	
	public boolean queryExecuted()
	{
		return queryExecuted;
	}
	
	public static void sqlError( SQLException e )
	{
		if( Config.DEBUGGING )
		{
			System.out.println( "SQLException: " + e.getMessage() );
			System.out.println( "SQLState: " + e.getSQLState() );
			System.out.println( "VendorError: " + e.getErrorCode() );
		}
	}

}
