package br.com.fiap.dp.abstractfactory.dao.rdb ;

import br.com.fiap.dp.abstractfactory.dao.CityDAO ;
import br.com.fiap.dp.abstractfactory.dao.CountryDAO ;
import br.com.fiap.dp.abstractfactory.dao.StateDAO ;

public class DAOFactory implements br.com.fiap.dp.abstractfactory.dao.DAOFactory
{

	public CountryDAO createCountryDAO( )
	{
		return new HsqldbCountryDAO( ) ;
	}

	public StateDAO createStateDAO( )
	{
		return new HsqldbStateDAO( ) ;
	}

	public CityDAO createCityDAO( )
	{
		return new HsqldbCityDAO( ) ;
	}
}
