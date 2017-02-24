package com.fiap.dp.templatemethod.dao.csv;

import com.fiap.dp.templatemethod.dao.CityDAO;
import com.fiap.dp.templatemethod.dao.CountryDAO;
import com.fiap.dp.templatemethod.dao.StateDAO;

public class CsvDAOFactory implements com.fiap.dp.templatemethod.dao.DAOFactory {

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
