package br.com.fiap.dp.abstractfactory.dao.csv ;

import java.io.BufferedReader ;
import java.io.InputStream ;
import java.io.InputStreamReader ;

import br.com.fiap.dp.abstractfactory.ReportException ;

class CSVHelper
{
	private static final String CSV_FILENAME = "places.csv" ;

	private CSVHelper( )
	{
	}

	public static InputStream openCSV( ) throws ReportException
	{
		InputStream is = Thread.currentThread( ).getContextClassLoader( )
				.getResourceAsStream( CSV_FILENAME ) ;
		if (is == null)
		{
			throw new ReportException( CSV_FILENAME + " not found" ) ;
		}
		return is ;
	}

	public static BufferedReader openCSVasBufferedReader( ) throws ReportException
	{
		return new BufferedReader( new InputStreamReader( openCSV( ) ) ) ;
	}

}
