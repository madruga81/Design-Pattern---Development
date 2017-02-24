package com.fiap.dp.templatemethod.dao.rdb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import com.fiap.dp.templatemethod.dao.CountryDAO;
import com.fiap.dp.templatemethod.domain.Country;
import com.fiap.dp.templatemethod.domain.Place;

public class HsqldbCountryDAO extends BasicHsqldbDAO implements CountryDAO {
    
    private static final String GET_COUNTRIES = "select NM_COUNTRY from COUNTRY";
    private static final String GET_COUNTRY_BY_NAME = "select NM_COUNTRY from COUNTRY where NM_COUNTRY = ?";

    public HsqldbCountryDAO() {
        super();
    }

    public Set getCountries() {
        return getPlaces();
    }

    public Country getCountry(String name) {
        return (Country) getPlace(name);
    }

    protected Place createPlace(ResultSet rset) throws SQLException {
        String countryName = rset.getString(1);
        Country country = new Country(countryName);
        return country;
    }

    protected String getAllPlacesQuery() {
        return GET_COUNTRIES;
    }

    protected String getPlaceByNameQuery() {
        return GET_COUNTRY_BY_NAME;
    }
}
