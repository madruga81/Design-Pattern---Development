package com.fiap.dp.templatemethod.dao.rdb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import com.fiap.dp.templatemethod.dao.StateDAO;
import com.fiap.dp.templatemethod.domain.Country;
import com.fiap.dp.templatemethod.domain.Place;
import com.fiap.dp.templatemethod.domain.State;

public class HsqldbStateDAO extends BasicHsqldbDAO implements StateDAO {
    
    private static final String GET_STATES =
                "select S.NM_STATE, C.NM_COUNTRY from STATE S, COUNTRY C where S.ID_COUNTRY = C.ID_COUNTRY";
    private static final String GET_STATE_BY_NAME =
                "select S.NM_STATE, C.NM_COUNTRY from STATE S, COUNTRY C where S.NM_STATE = ? " +
                "and S.ID_COUNTRY = C.ID_COUNTRY";

    public HsqldbStateDAO() {
        super();
    }

    public Set getStates() {
        return getPlaces();
    }

    public State getState(String name) {
        return (State) getPlace(name);
    }

    protected Place createPlace(ResultSet rset) throws SQLException {
        String stateName = rset.getString(1);
        String countryName = rset.getString(2);
        Country country = new Country(countryName);
        State state = new State(stateName, country);
        return state;
    }

    protected String getAllPlacesQuery() {
        return GET_STATES;
    }

    protected String getPlaceByNameQuery() {
        return GET_STATE_BY_NAME;
    }
}
