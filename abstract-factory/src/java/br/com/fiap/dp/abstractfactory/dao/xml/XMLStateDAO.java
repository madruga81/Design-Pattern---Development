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
import br.com.fiap.dp.abstractfactory.dao.StateDAO ;
import br.com.fiap.dp.abstractfactory.domain.Country ;
import br.com.fiap.dp.abstractfactory.domain.State ;


public class XMLStateDAO implements StateDAO
{

	private SAXParser parser ;

	public XMLStateDAO( )
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

	public Set getStates( )
	{
		Set result = new HashSet( ) ;
		try
		{
			parser.parse( XMLHelper.openXMLasBufferedInputStream( ), new ListStatesContentHandler(
					result ) ) ;
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

	private static class ListStatesContentHandler extends DefaultHandler
	{
		private Set result ;
		private boolean inCity ;
		private boolean inState ;
		private String stateName ;
		private boolean inStateCountry ;
		private String stateCountryName ;

		private boolean inName ;

		public ListStatesContentHandler( Set result )
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
			if (inStateCountry)
			{
				stateCountryName = new String( ch, start, length ) ;
			}
			else if (inState)
			{
				stateName = new String( ch, start, length ) ;
			}
		}

		public void endElement( String uri, String localName, String qName ) throws SAXException
		{
			if ("name".equals( qName ))
			{
				inName = false ;
			}
			else if ("city".equals( qName ))
			{
				inCity = false ;
			}
			else if ("state".equals( qName ) && !inCity)
			{
				State state = new State( stateName, new Country( stateCountryName ) ) ;
				result.add( state ) ;
				inState = false ;
			}
			else if ("country".equals( qName ) && inState)
			{
				inStateCountry = false ;
			}
		}

		public void startElement( String uri, String localName, String qName, Attributes attributes )
				throws SAXException
		{
			if ("name".equals( qName ))
			{
				inName = true ;
			}
			else if ("city".equals( qName ))
			{
				inCity = true ;
			}
			else if ("state".equals( qName ) && !inCity)
			{
				inState = true ;
			}
			else if ("country".equals( qName ) && inState)
			{
				inStateCountry = true ;
			}
		}
	}

	public State getState( String name )
	{
		GetStateContentHandler handler = new GetStateContentHandler( name ) ;
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
		return handler.getState( ) ;
	}

	private static class GetStateContentHandler extends DefaultHandler
	{
		private String name ;
		private State state = null ;

		private boolean inCity ;
		private boolean inState ;
		private String stateName ;
		private boolean inStateCountry ;
		private String stateCountryName ;

		private boolean inName ;

		public GetStateContentHandler( String name )
		{
			this.name = name ;
		}

		public void characters( char[ ] ch, int start, int length ) throws SAXException
		{
			if (!inName)
			{
				return ;
			}
			if (inStateCountry)
			{
				stateCountryName = new String( ch, start, length ) ;
			}
			else if (inState)
			{
				stateName = new String( ch, start, length ) ;
			}
		}

		public void endElement( String uri, String localName, String qName ) throws SAXException
		{
			if ("name".equals( qName ))
			{
				inName = false ;
			}
			else if ("city".equals( qName ))
			{
				inCity = false ;
			}
			else if ("state".equals( qName ) && !inCity)
			{
				if (stateName.equals( name ))
				{
					state = new State( stateName, new Country( stateCountryName ) ) ;
				}
				inState = false ;
			}
			else if ("country".equals( qName ) && inState)
			{
				inStateCountry = false ;
			}
		}

		public void startElement( String uri, String localName, String qName, Attributes attributes )
				throws SAXException
		{
			if ("name".equals( qName ))
			{
				inName = true ;
			}
			else if ("city".equals( qName ))
			{
				inCity = true ;
			}
			else if ("state".equals( qName ) && !inCity)
			{
				inState = true ;
			}
			else if ("country".equals( qName ) && inState)
			{
				inStateCountry = true ;
			}
		}

		public State getState( )
		{
			return state ;
		}
	}
}
