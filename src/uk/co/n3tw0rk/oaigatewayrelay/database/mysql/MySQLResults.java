package uk.co.n3tw0rk.oaigatewayrelay.database.mysql;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class MySQLResults
{
	
	private int rowsReturned, position;
	private ArrayList<HashMap<String,String>> resultSet = new ArrayList<HashMap<String,String>>();

	public MySQLResults( ResultSet resultSet )
	{
		buildResultSet( resultSet );
	}
	
	private void buildResultSet( ResultSet resultSet )
	{
		ResultSetMetaData resultSetMetaData = null;
		HashMap<String,String> hashMap = null;
		try
		{
			resultSetMetaData = resultSet.getMetaData();
			resultSet.beforeFirst();
			while( resultSet.next() )
			{
				hashMap = new HashMap<String,String>();
				for( int i = 1; i <= resultSetMetaData.getColumnCount(); i++ )
					hashMap.put( resultSetMetaData.getColumnName( i ), resultSet.getString( i ) );
				this.resultSet.add( hashMap );
				this.rowsReturned++;
			}
		}
		catch( SQLException e ) 
		{
			MySQLConnection.sqlError( e );
		}
		finally
		{
			resultSetMetaData = null;
			hashMap = null;
		}
	}
	
	public int getRowsReturned()
	{
		return this.rowsReturned;
	}
	
	public String getColumn( String name )
	{
		String returnString = null;
		try
		{
			returnString = (String)((HashMap<String, String>)this.resultSet.get( position )).get( name );
		}
		catch( NullPointerException e )
		{
			e.printStackTrace();
		}
		return returnString;
	}
	
	public boolean next()
	{
		if( ++this.position < this.rowsReturned && this.position >= 0 )
			return true;
		this.position--;
		return false;
	}
	
	public boolean previous()
	{
		if( --this.position <= this.rowsReturned && this.position > 0 )
			return true;
		this.position++;
		return false;
	}
	
	public void rewind()
	{
		this.position = 0;
	}
	
	public void end()
	{
		this.position = this.rowsReturned;
	}
	
	public boolean seek( int position )
	{
		if( position <= this.rowsReturned && position >= 0 )
		{
			this.position = position;
			return true;
		}
		return false;
	}
	
}
