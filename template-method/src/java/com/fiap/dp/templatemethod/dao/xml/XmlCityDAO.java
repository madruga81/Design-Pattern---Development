package com.fiap.dp.templatemethod.dao.xml;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.fiap.dp.templatemethod.ReportException;
import com.fiap.dp.templatemethod.dao.CityDAO;
import com.fiap.dp.templatemethod.domain.City;
import com.fiap.dp.templatemethod.domain.Country;
import com.fiap.dp.templatemethod.domain.State;

public class XmlCityDAO implements CityDAO {
    
    private SAXParser parser;

    public XmlCityDAO() {
        super();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException pce) {
            throw new ReportException("Configuration error creating parser", pce);
        } catch (SAXException se) {
            throw new ReportException("SAX error creating parser", se);
        }
    }

    public Set getCities() {
        Set result = new HashSet();
        try {
            parser.parse(XmlHelper.openXMLasBufferedInputStream(), new ListCitiesContentHandler(result));
        } catch (SAXException se) {
            throw new ReportException("SAX error parsing source", se);
        } catch (IOException ioe) {
            throw new ReportException("I/O error parsing source", ioe);
        }
        return result;
    }

    private static class ListCitiesContentHandler extends DefaultHandler {
        private Set result;
        private boolean inCity;
        private String cityName;
        private boolean inCityState;
        private String cityStateName;
        private boolean inCityStateCountry;
        private String cityStateCountryName;

        private boolean inName;

        public ListCitiesContentHandler(Set result) {
            super();
            this.result = result;
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (!inName) {
                return;
            }
            if (inCityStateCountry) {
                cityStateCountryName = new String(ch, start, length);
            }
            else if (inCityState) {
                cityStateName = new String(ch, start, length);
            }
            else if (inCity) {
                cityName = new String(ch, start, length);
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("name".equals(qName)) {
                inName = false;
            }
            else if ("city".equals(qName)) {
                City city = new City(cityName, new State(cityStateName, new Country(cityStateCountryName)));
                result.add(city);
                inCity = false;
            }
            else if ("state".equals(qName) && inCity) {
                inCityState = false;
            }
            else if ("country".equals(qName) && inCityState) {
                inCityStateCountry = false;
            }
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if ("name".equals(qName)) {
                inName = true;
            }
            else if ("city".equals(qName)) {
                inCity = true;
            }
            else if ("state".equals(qName) && inCity) {
                inCityState = true;
            }
            else if ("country".equals(qName) && inCityState) {
                inCityStateCountry = true;
            }
        }
        
    }

    public City getCity(String name) {
        GetCityContentHandler handler = new GetCityContentHandler(name);
        try {
            parser.parse(XmlHelper.openXMLasBufferedInputStream(), handler);
        } catch (SAXException se) {
            throw new ReportException("SAX error parsing source", se);
        } catch (IOException ioe) {
            throw new ReportException("I/O error parsing source", ioe);
        }
        return handler.getCity();
    }

    private static class GetCityContentHandler extends DefaultHandler {
        private String name;
        private City city = null;

        private boolean inCity;
        private String cityName;
        private boolean inCityState;
        private String cityStateName;
        private boolean inCityStateCountry;
        private String cityStateCountryName;

        private boolean inName;

        public GetCityContentHandler(String name) {
            this.name = name;
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (!inName) {
                return;
            }
            if (inCityStateCountry) {
                cityStateCountryName = new String(ch, start, length);
            }
            else if (inCityState) {
                cityStateName = new String(ch, start, length);
            }
            else if (inCity) {
                cityName = new String(ch, start, length);
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("name".equals(qName)) {
                inName = false;
            }
            else if ("city".equals(qName)) {
                if (cityName.equals(name)) {
                    city = new City(cityName, new State(cityStateName, new Country(cityStateCountryName)));
                }
                inCity = false;
            }
            else if ("state".equals(qName) && inCity) {
                inCityState = false;
            }
            else if ("country".equals(qName) && inCityState) {
                inCityStateCountry = false;
            }
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if ("name".equals(qName)) {
                inName = true;
            }
            else if ("city".equals(qName)) {
                inCity = true;
            }
            else if ("state".equals(qName) && inCity) {
                inCityState = true;
            }
            else if ("country".equals(qName) && inCityState) {
                inCityStateCountry = true;
            }
        }
        
        public City getCity() {
            return city;
        }
    }
}
