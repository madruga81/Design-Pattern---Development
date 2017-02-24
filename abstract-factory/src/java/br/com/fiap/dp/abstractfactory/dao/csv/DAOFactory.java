package br.com.fiap.dp.abstractfactory.dao.csv ;

import br.com.fiap.dp.abstractfactory.dao.CityDAO ;
import br.com.fiap.dp.abstractfactory.dao.CountryDAO ;
import br.com.fiap.dp.abstractfactory.dao.StateDAO ;

public class DAOFactory implements br.com.fiap.dp.abstractfactory.dao.DAOFactory
{

	public CountryDAO createCountryDAO( )
	{
		return new CSVCountryDAO( ) ;
	}

	public StateDAO createStateDAO( )
	{
		return new CSVStateDAO( ) ;
	}

	public CityDAO createCityDAO( )
	{
		return new CSVCityDAO( ) ;
	}
}
