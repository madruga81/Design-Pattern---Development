package com.fiap.dp.decorator.p2.dao;

public interface DAOFactory {

    CountryDAO createCountryDAO();

    StateDAO createStateDAO();

    CityDAO createCityDAO();
}
