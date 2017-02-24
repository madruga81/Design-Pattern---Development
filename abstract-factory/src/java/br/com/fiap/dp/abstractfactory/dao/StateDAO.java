package br.com.fiap.dp.abstractfactory.dao ;

import java.util.Set ;

import br.com.fiap.dp.abstractfactory.domain.State ;

public interface StateDAO
{

	Set getStates( ) ;

	State getState( String name ) ;

}
