package br.com.fiap.dp.abstractfactory.dao.rdb ;

import java.sql.Connection ;
import java.sql.PreparedStatement ;
import java.sql.ResultSet ;
import java.sql.SQLException ;
import java.sql.Statement ;
import java.util.HashSet ;
import java.util.Set ;

import br.com.fiap.dp.abstractfactory.ReportException ;
import br.com.fiap.dp.abstractfactory.dao.CityDAO ;
import br.com.fiap.dp.abstractfactory.domain.City ;
import br.com.fiap.dp.abstractfactory.domain.Country ;
import br.com.fiap.dp.abstractfactory.domain.State ;


public class HsqldbCityDAO implements CityDAO
{

	private static final String GET_CITIES = "select T.NM_CITY, S.NM_STATE, C.NM_COUNTRY from CITY T, STATE S, COUNTRY C "
			+ "where T.ID_STATE = S.ID_STATE and S.ID_COUNTRY = C.ID_COUNTRY" ;

	private static final String GET_CITY_BY_NAME = "select T.NM_CITY, S.NM_STATE, C.NM_COUNTRY from CITY T, STATE S, COUNTRY C where T.NM_CITY = ? "
			+ "and T.ID_STATE = S.ID_STATE and S.ID_COUNTRY = C.ID_COUNTRY" ;

	public HsqldbCityDAO( )
	{
		super( ) ;
	}

	public Set getCities( )
	{
		Set result = new HashSet( ) ;

		Connection conn = null ;
		Statement stmt = null ;
		ResultSet rset = null ;

		try
		{
			conn = HsqldbHelper.getDataSource( ).getConnection( ) ;
			stmt = conn.createStatement( ) ;
			rset = stmt.executeQuery( GET_CITIES ) ;
			while (rset.next( ))
			{
				String cityName = rset.getString( 1 ) ;
				String stateName = rset.getString( 2 ) ;
				String countryName = rset.getString( 3 ) ;
				Country country = new Country( countryName ) ;
				State state = new State( stateName, country ) ;
				City city = new City( cityName, state ) ;
				result.add( city ) ;
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

	public City getCity( String name )
	{
		Connection conn = null ;
		PreparedStatement stmt = null ;
		ResultSet rset = null ;

		try
		{
			conn = HsqldbHelper.getDataSource( ).getConnection( ) ;
			stmt = conn.prepareStatement( GET_CITY_BY_NAME ) ;
			stmt.setString( 1, name ) ;
			rset = stmt.executeQuery( ) ;
			if (rset.next( ))
			{
				String cityName = rset.getString( 1 ) ;
				String stateName = rset.getString( 2 ) ;
				String countryName = rset.getString( 3 ) ;
				Country country = new Country( countryName ) ;
				State state = new State( stateName, country ) ;
				return new City( cityName, state ) ;
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
