package com.fiap.dp.decorator.p2.dao.rdb;

import com.fiap.dp.decorator.p2.dao.CityDAO;
import com.fiap.dp.decorator.p2.dao.CountryDAO;
import com.fiap.dp.decorator.p2.dao.StateDAO;

public class HsqldbDAOFactory implements com.fiap.dp.decorator.p2.dao.DAOFactory {

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
