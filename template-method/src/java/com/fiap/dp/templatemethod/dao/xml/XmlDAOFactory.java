package com.fiap.dp.templatemethod.dao.xml;

import com.fiap.dp.templatemethod.dao.CityDAO;
import com.fiap.dp.templatemethod.dao.CountryDAO;
import com.fiap.dp.templatemethod.dao.StateDAO;

public class XmlDAOFactory implements com.fiap.dp.templatemethod.dao.DAOFactory {

    public CountryDAO createCountryDAO() {
        return new XmlCountryDAO();
    }

    public StateDAO createStateDAO() {
        return new XmlStateDAO();
    }

    public CityDAO createCityDAO() {
        return new XmlCityDAO();
    }
}
