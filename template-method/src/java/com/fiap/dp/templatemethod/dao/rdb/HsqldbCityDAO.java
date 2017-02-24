package com.fiap.dp.templatemethod.dao.rdb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import com.fiap.dp.templatemethod.dao.CityDAO;
import com.fiap.dp.templatemethod.domain.City;
import com.fiap.dp.templatemethod.domain.Country;
import com.fiap.dp.templatemethod.domain.Place;
import com.fiap.dp.templatemethod.domain.State;

public class HsqldbCityDAO extends BasicHsqldbDAO implements CityDAO {

    private static final String GET_CITIES =
            "select T.NM_CITY, S.NM_STATE, C.NM_COUNTRY from CITY T, STATE S, COUNTRY C " + 
            "where T.ID_STATE = S.ID_STATE and S.ID_COUNTRY = C.ID_COUNTRY";

    private static final String GET_CITY_BY_NAME =
            "select T.NM_CITY, S.NM_STATE, C.NM_COUNTRY from CITY T, STATE S, COUNTRY C where T.NM_CITY = ? "
            + "and T.ID_STATE = S.ID_STATE and S.ID_COUNTRY = C.ID_COUNTRY";

    public HsqldbCityDAO() {
        super();
    }

    public Set getCities() {
        return getPlaces();
    }

    public City getCity(String name) {
        return (City) getPlace(name);
    }

    protected Place createPlace(ResultSet rset) throws SQLException {
        String cityName = rset.getString(1);
        String stateName = rset.getString(2);
        String countryName = rset.getString(3);
        Country country = new Country(countryName);
        State state = new State(stateName, country);
        City city = new City(cityName, state);
        return city;
    }

    protected String getAllPlacesQuery() {
        return GET_CITIES;
    }

    protected String getPlaceByNameQuery() {
        return GET_CITY_BY_NAME;
    }
}
