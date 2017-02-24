package br.com.fiap.dp.abstractfactory.dao ;

import java.util.Set ;

import br.com.fiap.dp.abstractfactory.domain.Country ;

public interface CountryDAO
{

	Set getCountries( ) ;

	Country getCountry( String name ) ;

}
