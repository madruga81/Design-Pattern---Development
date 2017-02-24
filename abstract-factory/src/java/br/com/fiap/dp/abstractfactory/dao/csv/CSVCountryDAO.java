package br.com.fiap.dp.abstractfactory.dao.csv ;

import java.io.BufferedReader ;
import java.io.IOException ;
import java.util.HashSet ;
import java.util.Set ;
import java.util.regex.Matcher ;
import java.util.regex.Pattern ;

import br.com.fiap.dp.abstractfactory.ReportException ;
import br.com.fiap.dp.abstractfactory.dao.CountryDAO ;
import br.com.fiap.dp.abstractfactory.domain.Country ;


public class CSVCountryDAO implements CountryDAO
{

	private Pattern pattern ;

	public CSVCountryDAO( )
	{
		super( ) ;
		pattern = Pattern.compile( "([^;]+);;" ) ;
	}

	public Set getCountries( )
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
					String countryName = matcher.group( 1 ) ;
					Country country = new Country( countryName ) ;
					result.add( country ) ;
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

	public Country getCountry( String name )
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
					String countryName = matcher.group( 1 ) ;
					if (name.equals( countryName ))
					{
						return new Country( countryName ) ;
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
