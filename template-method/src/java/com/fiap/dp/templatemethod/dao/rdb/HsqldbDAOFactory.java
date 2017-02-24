package com.fiap.dp.templatemethod.dao.rdb;

import com.fiap.dp.templatemethod.dao.CityDAO;
import com.fiap.dp.templatemethod.dao.CountryDAO;
import com.fiap.dp.templatemethod.dao.StateDAO;

public class HsqldbDAOFactory implements com.fiap.dp.templatemethod.dao.DAOFactory {

    public CountryDAO createCountryDAO() {
        return new HsqldbCountryDAO();
    }

    public StateDAO createStateDAO() {
        return new HsqldbStateDAO();
    }

    public CityDAO createCityDAO() {
        return new HsqldbCityDAO();
    }
}
