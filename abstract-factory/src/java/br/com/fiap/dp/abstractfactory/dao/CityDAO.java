package br.com.fiap.dp.abstractfactory.dao ;

import java.util.Set ;

import br.com.fiap.dp.abstractfactory.domain.City ;

public interface CityDAO
{

	Set getCities( ) ;

	City getCity( String name ) ;

}
