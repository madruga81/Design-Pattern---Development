package com.fiap.dp.decorator.p2.dao.xml;

import com.fiap.dp.decorator.p2.dao.CityDAO;
import com.fiap.dp.decorator.p2.dao.CountryDAO;
import com.fiap.dp.decorator.p2.dao.StateDAO;

public class XmlDAOFactory implements com.fiap.dp.decorator.p2.dao.DAOFactory {

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
