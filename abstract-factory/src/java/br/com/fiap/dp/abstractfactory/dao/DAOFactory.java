package br.com.fiap.dp.abstractfactory.dao ;

public interface DAOFactory
{

	CountryDAO createCountryDAO( ) ;

	StateDAO createStateDAO( ) ;

	CityDAO createCityDAO( ) ;
}
