package br.com.fiap.dp.abstractfactory ;

import java.io.PrintStream ;
import java.util.Iterator ;

import br.com.fiap.dp.abstractfactory.dao.CityDAO ;
import br.com.fiap.dp.abstractfactory.dao.CountryDAO ;
import br.com.fiap.dp.abstractfactory.dao.DAOFactory ;
import br.com.fiap.dp.abstractfactory.dao.StateDAO ;

public class ReportPrinter
{
	private CountryDAO countryDAO ;
	private StateDAO stateDAO ;
	private CityDAO cityDAO ;

	public ReportPrinter( DAOFactory daoFactory )
	{
		countryDAO = daoFactory.createCountryDAO( ) ;
		stateDAO = daoFactory.createStateDAO( ) ;
		cityDAO = daoFactory.createCityDAO( ) ;
	}

	public void printReport( PrintStream ps )
	{
		ps.println( "Países:" ) ;
		printPlaces( countryDAO.getCountries( ).iterator( ), ps ) ;

		ps.println( "Estados:" ) ;
		printPlaces( stateDAO.getStates( ).iterator( ), ps ) ;

		ps.println( "Cidades:" ) ;
		printPlaces( cityDAO.getCities( ).iterator( ), ps ) ;
	}

	private void printPlaces( Iterator iter, PrintStream ps )
	{
		while (iter.hasNext( ))
		{
			ps.println( "\t" + iter.next( ) ) ;
		}
	}

	public void printCountry( String name, PrintStream ps )
	{
		ps.println( countryDAO.getCountry( name ) ) ;
	}

	public void printState( String name, PrintStream ps )
	{
		ps.println( stateDAO.getState( name ) ) ;
	}

	public void printCity( String name, PrintStream ps )
	{
		ps.println( cityDAO.getCity( name ) ) ;
	}
}
