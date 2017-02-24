package com.fiap.dp.templatemethod.dao.rdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.fiap.dp.templatemethod.ReportException;
import com.fiap.dp.templatemethod.domain.Place;

public abstract class BasicHsqldbDAO {
    
    public BasicHsqldbDAO() {
        super();
    }

    protected Set getPlaces() {
        Set result = new HashSet();
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;
        
        try {
            conn = HsqldbHelper.getDataSource().getConnection();
            stmt = conn.createStatement();
            rset = stmt.executeQuery(getAllPlacesQuery());
            while (rset.next()) {
                Place place = createPlace(rset);
                result.add(place);
            }
        }
        catch (SQLException sqle) {
            throw new ReportException("SQL error querying database", sqle);
        }
        finally {
            try { rset.close(); } catch (Exception e) { }
            try { stmt.close(); } catch (Exception e) { }
            try { conn.close(); } catch (Exception e) { }
        }
        return result;
    }

    protected Place getPlace(String name) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        
        try {
            conn = HsqldbHelper.getDataSource().getConnection();
            stmt = conn.prepareStatement(getPlaceByNameQuery());
            stmt.setString(1, name);
            rset = stmt.executeQuery();
            if (rset.next()) {
                return createPlace(rset);
            }
        }
        catch (SQLException sqle) {
            throw new ReportException("SQL error querying database", sqle);
        }
        finally {
            try { rset.close(); } catch (Exception e) { }
            try { stmt.close(); } catch (Exception e) { }
            try { conn.close(); } catch (Exception e) { }
        }
        return null;
    }

    protected abstract String getAllPlacesQuery();

    protected abstract Place createPlace(ResultSet rset) throws SQLException;

    protected abstract String getPlaceByNameQuery();
}
