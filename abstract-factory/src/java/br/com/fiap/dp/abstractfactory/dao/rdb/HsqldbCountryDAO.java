package br.com.fiap.dp.abstractfactory.dao.rdb ;

import java.sql.Connection ;
import java.sql.PreparedStatement ;
import java.sql.ResultSet ;
import java.sql.SQLException ;
import java.sql.Statement ;
import java.util.HashSet ;
import java.util.Set ;

import br.com.fiap.dp.abstractfactory.ReportException ;
import br.com.fiap.dp.abstractfactory.dao.CountryDAO ;
import br.com.fiap.dp.abstractfactory.domain.Country ;


public class HsqldbCountryDAO implements CountryDAO
{

	private static final String GET_COUNTRIES = "select NM_COUNTRY from COUNTRY" ;
	private static final String GET_COUNTRY_BY_NAME = "select NM_COUNTRY from COUNTRY where NM_COUNTRY = ?" ;

	public HsqldbCountryDAO( )
	{
		super( ) ;
	}

	public Set getCountries( )
	{
		Set result = new HashSet( ) ;

		Connection conn = null ;
		Statement stmt = null ;
		ResultSet rset = null ;

		try
		{
			conn = HsqldbHelper.getDataSource( ).getConnection( ) ;
			stmt = conn.createStatement( ) ;
			rset = stmt.executeQuery( GET_COUNTRIES ) ;
			while (rset.next( ))
			{
				String countryName = rset.getString( 1 ) ;
				Country country = new Country( countryName ) ;
				result.add( country ) ;
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

	public Country getCountry( String name )
	{
		Connection conn = null ;
		PreparedStatement stmt = null ;
		ResultSet rset = null ;

		try
		{
			conn = HsqldbHelper.getDataSource( ).getConnection( ) ;
			stmt = conn.prepareStatement( GET_COUNTRY_BY_NAME ) ;
			stmt.setString( 1, name ) ;
			rset = stmt.executeQuery( ) ;
			if (rset.next( ))
			{
				String countryName = rset.getString( 1 ) ;
				return new Country( countryName ) ;
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
