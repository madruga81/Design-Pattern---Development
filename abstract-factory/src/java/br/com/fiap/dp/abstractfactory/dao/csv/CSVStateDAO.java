package br.com.fiap.dp.abstractfactory.dao.csv ;

import java.io.BufferedReader ;
import java.io.IOException ;
import java.util.HashSet ;
import java.util.Set ;
import java.util.regex.Matcher ;
import java.util.regex.Pattern ;

import br.com.fiap.dp.abstractfactory.ReportException ;
import br.com.fiap.dp.abstractfactory.dao.StateDAO ;
import br.com.fiap.dp.abstractfactory.domain.Country ;
import br.com.fiap.dp.abstractfactory.domain.State ;


public class CSVStateDAO implements StateDAO
{

	private Pattern pattern ;

	public CSVStateDAO( )
	{
		super( ) ;
		pattern = Pattern.compile( "([^;]+);([^;]+);" ) ;
	}

	public Set getStates( )
	{
		Set result = new HashSet( ) ;
		BufferedReader reader = CSVHelper.openCSVasBufferedReader( ) ;
		try
		{
			String line = reader.readLine( ) ;
			while (line != null)
			{
				Matcher matcher = pattern.matcher( line ) ;
				if (matcher.matches( ))
				{
					String stateName = matcher.group( 1 ) ;
					String countryName = matcher.group( 2 ) ;
					Country country = new Country( countryName ) ;
					State state = new State( stateName, country ) ;
					result.add( state ) ;
				}
				line = reader.readLine( ) ;
			}
		}
		catch (IOException ioe)
		{
			throw new ReportException( "I/O error reading input", ioe ) ;
		}
		return result ;
	}

	public State getState( String name )
	{
		BufferedReader reader = CSVHelper.openCSVasBufferedReader( ) ;
		try
		{
			String line = reader.readLine( ) ;
			while (line != null)
			{
				Matcher matcher = pattern.matcher( line ) ;
				if (matcher.matches( ))
				{
					String stateName = matcher.group( 1 ) ;
					if (name.equals( stateName ))
					{
						String countryName = matcher.group( 2 ) ;
						Country country = new Country( countryName ) ;
						return new State( stateName, country ) ;
					}
				}
				line = reader.readLine( ) ;
			}
		}
		catch (IOException ioe)
		{
			throw new ReportException( "I/O error reading input", ioe ) ;
		}
		return null ;
	}
}
