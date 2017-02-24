package com.fiap.dp.decorator.p2.dao.csv;

import com.fiap.dp.decorator.p2.dao.CityDAO;
import com.fiap.dp.decorator.p2.dao.CountryDAO;
import com.fiap.dp.decorator.p2.dao.StateDAO;

public class CsvDAOFactory implements com.fiap.dp.decorator.p2.dao.DAOFactory {

    public CountryDAO createCountryDAO() {
        return new CsvCountryDAO();
    }

    public StateDAO createStateDAO() {
        return new CsvStateDAO();
    }

    public CityDAO createCityDAO() {
        return new CsvCityDAO();
    }
}
