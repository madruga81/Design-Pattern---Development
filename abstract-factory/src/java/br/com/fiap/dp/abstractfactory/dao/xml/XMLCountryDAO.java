package br.com.fiap.dp.abstractfactory.dao.xml ;

import java.io.IOException ;
import java.util.HashSet ;
import java.util.Set ;

import javax.xml.parsers.ParserConfigurationException ;
import javax.xml.parsers.SAXParser ;
import javax.xml.parsers.SAXParserFactory ;

import org.xml.sax.Attributes ;
import org.xml.sax.SAXException ;
import org.xml.sax.helpers.DefaultHandler ;

import br.com.fiap.dp.abstractfactory.ReportException ;
import br.com.fiap.dp.abstractfactory.dao.CountryDAO ;
import br.com.fiap.dp.abstractfactory.domain.Country ;


public class XMLCountryDAO implements CountryDAO
{

	private SAXParser parser ;

	public XMLCountryDAO( )
	{
		super( ) ;
		SAXParserFactory factory = SAXParserFactory.newInstance( ) ;
		try
		{
			parser = factory.newSAXParser( ) ;
		}
		catch (ParserConfigurationException pce)
		{
			throw new ReportException( "Configuration error creating parser", pce ) ;
		}
		catch (SAXException se)
		{
			throw new ReportException( "SAX error creating parser", se ) ;
		}
	}

	public Set getCountries( )
	{
		Set result = new HashSet( ) ;
		try
		{
			parser.parse( XMLHelper.openXMLasBufferedInputStream( ),
					new ListCountriesContentHandler( result ) ) ;
		}
		catch (SAXException se)
		{
			throw new ReportException( "SAX error parsing source", se ) ;
		}
		catch (IOException ioe)
		{
			throw new ReportException( "I/O error parsing source", ioe ) ;
		}
		return result ;
	}

	private static class ListCountriesContentHandler extends DefaultHandler
	{
		private Set result ;
		private boolean inState ;
		private boolean inCountry ;
		private String countryName ;

		private boolean inName ;

		public ListCountriesContentHandler( Set result )
		{
			super( ) ;
			this.result = result ;
		}

		public void characters( char[ ] ch, int start, int length ) throws SAXException
		{
			if (!inName)
			{
				return ;
			}
			if (inCountry)
			{
				countryName = new String( ch, start, length ) ;
			}
		}

		public void endElement( String uri, String localName, String qName ) throws SAXException
		{
			if ("name".equals( qName ))
			{
				inName = false ;
			}
			else if ("state".equals( qName ))
			{
				inState = false ;
			}
			else if ("country".equals( qName ) && !inState)
			{
				Country country = new Country( countryName ) ;
				result.add( country ) ;
				inCountry = false ;
			}
		}

		public void startElement( String uri, String localName, String qName, Attributes attributes )
				throws SAXException
		{
			if ("name".equals( qName ))
			{
				inName = true ;
			}
			else if ("state".equals( qName ))
			{
				inState = true ;
			}
			else if ("country".equals( qName ) && !inState)
			{
				inCountry = true ;
			}
		}
	}

	public Country getCountry( String name )
	{
		GetCountryContentHandler handler = new GetCountryContentHandler( name ) ;
		try
		{
			parser.parse( XMLHelper.openXMLasBufferedInputStream( ), handler ) ;
		}
		catch (SAXException se)
		{
			throw new ReportException( "SAX error parsing source", se ) ;
		}
		catch (IOException ioe)
		{
			throw new ReportException( "I/O error parsing source", ioe ) ;
		}
		return handler.getCountry( ) ;
	}

	private static class GetCountryContentHandler extends DefaultHandler
	{
		private String name ;
		private Country country = null ;

		private boolean inState ;
		private boolean inCountry ;
		private String countryName ;

		private boolean inName ;

		public GetCountryContentHandler( String name )
		{
			this.name = name ;
		}

		public void characters( char[ ] ch, int start, int length ) throws SAXException
		{
			if (!inName)
			{
				return ;
			}
			if (inCountry)
			{
				countryName = new String( ch, start, length ) ;
			}
		}

		public void endElement( String uri, String localName, String qName ) throws SAXException
		{
			if ("name".equals( qName ))
			{
				inName = false ;
			}
			else if ("state".equals( qName ))
			{
				inState = false ;
			}
			else if ("country".equals( qName ) && !inState)
			{
				if (countryName.equals( name ))
				{
					country = new Country( countryName ) ;
				}
				inCountry = false ;
			}
		}

		public void startElement( String uri, String localName, String qName, Attributes attributes )
				throws SAXException
		{
			if ("name".equals( qName ))
			{
				inName = true ;
			}
			else if ("state".equals( qName ))
			{
				inState = true ;
			}
			else if ("country".equals( qName ) && !inState)
			{
				inCountry = true ;
			}
		}

		public Country getCountry( )
		{
			return country ;
		}
	}
}
