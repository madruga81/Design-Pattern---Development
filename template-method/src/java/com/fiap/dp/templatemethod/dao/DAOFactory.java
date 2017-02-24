package com.fiap.dp.templatemethod.dao;

public interface DAOFactory {

    CountryDAO createCountryDAO();

    StateDAO createStateDAO();

    CityDAO createCityDAO();
}
