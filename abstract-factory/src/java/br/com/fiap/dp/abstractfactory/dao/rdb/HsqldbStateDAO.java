package br.com.fiap.dp.abstractfactory.dao.rdb ;

import java.sql.Connection ;
import java.sql.PreparedStatement ;
import java.sql.ResultSet ;
import java.sql.SQLException ;
import java.sql.Statement ;
import java.util.HashSet ;
import java.util.Set ;

import br.com.fiap.dp.abstractfactory.ReportException ;
import br.com.fiap.dp.abstractfactory.dao.StateDAO ;
import br.com.fiap.dp.abstractfactory.domain.Country ;
import br.com.fiap.dp.abstractfactory.domain.State ;


public class HsqldbStateDAO implements StateDAO
{

	private static final String GET_STATES = "select S.NM_STATE, C.NM_COUNTRY from STATE S, COUNTRY C where S.ID_COUNTRY = C.ID_COUNTRY" ;
	private static final String GET_STATE_BY_NAME = "select S.NM_STATE, C.NM_COUNTRY from STATE S, COUNTRY C where S.NM_STATE = ? "
			+ "and S.ID_COUNTRY = C.ID_COUNTRY" ;

	public HsqldbStateDAO( )
	{
		super( ) ;
	}

	public Set getStates( )
	{
		Set result = new HashSet( ) ;

		Connection conn = null ;
		Statement stmt = null ;
		ResultSet rset = null ;

		try
		{
			conn = HsqldbHelper.getDataSource( ).getConnection( ) ;
			stmt = conn.createStatement( ) ;
			rset = stmt.executeQuery( GET_STATES ) ;
			while (rset.next( ))
			{
				String stateName = rset.getString( 1 ) ;
				String countryName = rset.getString( 2 ) ;
				Country country = new Country( countryName ) ;
				State state = new State( stateName, country ) ;
				result.add( state ) ;
			}
		}
		catch (SQLException sqle)
		{
			throw new ReportException( "SQL error querying database", sqle ) ;
		}
		finally
		{
			try
			{
				rset.close( ) ;
			}
			catch (Exception e)
			{
			}
			try
			{
				stmt.close( ) ;
			}
			catch (Exception e)
			{
			}
			try
			{
				conn.close( ) ;
			}
			catch (Exception e)
			{
			}
		}
		return result ;
	}

	public State getState( String name )
	{
		Connection conn = null ;
		PreparedStatement stmt = null ;
		ResultSet rset = null ;

		try
		{
			conn = HsqldbHelper.getDataSource( ).getConnection( ) ;
			stmt = conn.prepareStatement( GET_STATE_BY_NAME ) ;
			stmt.setString( 1, name ) ;
			rset = stmt.executeQuery( ) ;
			if (rset.next( ))
			{
				String stateName = rset.getString( 1 ) ;
				String countryName = rset.getString( 2 ) ;
				Country country = new Country( countryName ) ;
				return new State( stateName, country ) ;
			}
		}
		catch (SQLException sqle)
		{
			throw new ReportException( "SQL error querying database", sqle ) ;
		}
		finally
		{
			try
			{
				rset.close( ) ;
			}
			catch (Exception e)
			{
			}
			try
			{
				stmt.close( ) ;
			}
			catch (Exception e)
			{
			}
			try
			{
				conn.close( ) ;
			}
			catch (Exception e)
			{
			}
		}
		return null ;
	}
}
