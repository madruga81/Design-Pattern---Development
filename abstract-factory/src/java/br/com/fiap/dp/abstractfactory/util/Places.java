package br.com.fiap.dp.abstractfactory.util ;

import java.util.ArrayList ;
import java.util.List ;

import br.com.fiap.dp.abstractfactory.domain.City ;
import br.com.fiap.dp.abstractfactory.domain.Country ;
import br.com.fiap.dp.abstractfactory.domain.State ;

import com.thoughtworks.xstream.XStream ;

public class Places
{
	public static void main( String[ ] args )
	{
		Country brasil = new Country( "Brasil" ) ;
		Country estadosUnidos = new Country( "Estados Unidos" ) ;

		State minasGerais = new State( "Minas Gerais", brasil ) ;
		State saoPaulo = new State( "São Paulo", brasil ) ;
		State bahia = new State( "Bahia", brasil ) ;
		State florida = new State( "Florida", estadosUnidos ) ;
		State california = new State( "California", estadosUnidos ) ;
		State newYork = new State( "New York", estadosUnidos ) ;

		City beloHorizonte = new City( "Belo Horizonte", minasGerais ) ;
		City seteLagoas = new City( "Sete Lagoas", minasGerais ) ;
		City saoPauloCity = new City( "São Paulo", saoPaulo ) ;
		City campinas = new City( "Campinas", saoPaulo ) ;
		City salvador = new City( "Salvador", bahia ) ;
		City tampa = new City( "Tampa", florida ) ;
		City miami = new City( "Miami", florida ) ;
		City losAngeles = new City( "Los Angeles", california ) ;
		City sanFrancisco = new City( "San Francisco", california ) ;
		City newYorkCity = new City( "New York", newYork ) ;

		List lugares = new ArrayList( ) ;
		lugares.add( brasil ) ;
		lugares.add( estadosUnidos ) ;
		lugares.add( minasGerais ) ;
		lugares.add( saoPaulo ) ;
		lugares.add( bahia ) ;
		lugares.add( florida ) ;
		lugares.add( california ) ;
		lugares.add( newYork ) ;
		lugares.add( beloHorizonte ) ;
		lugares.add( seteLagoas ) ;
		lugares.add( saoPauloCity ) ;
		lugares.add( campinas ) ;
		lugares.add( salvador ) ;
		lugares.add( miami ) ;
		lugares.add( tampa ) ;
		lugares.add( losAngeles ) ;
		lugares.add( sanFrancisco ) ;
		lugares.add( newYorkCity ) ;

		XStream xstream = new XStream( ) ;
		xstream.alias( "country", Country.class ) ;
		xstream.alias( "state", State.class ) ;
		xstream.alias( "city", City.class ) ;
		xstream.alias( "places", ArrayList.class ) ;
		xstream.setMode( XStream.NO_REFERENCES ) ;
		System.out.println( xstream.toXML( lugares ) ) ;
	}
}
