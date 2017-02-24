package br.com.fiap.dp.abstractfactory.dao.xml ;

import br.com.fiap.dp.abstractfactory.dao.CityDAO ;
import br.com.fiap.dp.abstractfactory.dao.CountryDAO ;
import br.com.fiap.dp.abstractfactory.dao.StateDAO ;

public class DAOFactory implements br.com.fiap.dp.abstractfactory.dao.DAOFactory
{

	public CountryDAO createCountryDAO( )
	{
		return new XMLCountryDAO( ) ;
	}

	public StateDAO createStateDAO( )
	{
		return new XMLStateDAO( ) ;
	}

	public CityDAO createCityDAO( )
	{
		return new XMLCityDAO( ) ;
	}
}
