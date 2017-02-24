package com.fiap.dp.decorator.p2;

import java.io.PrintStream;
import java.util.Iterator;

import com.fiap.dp.decorator.p2.dao.CityDAO;
import com.fiap.dp.decorator.p2.dao.CountryDAO;
import com.fiap.dp.decorator.p2.dao.DAOFactory;
import com.fiap.dp.decorator.p2.dao.StateDAO;

public class ReportPrinter {
    private CountryDAO countryDAO;
    private StateDAO stateDAO;
    private CityDAO cityDAO;

    public ReportPrinter(DAOFactory daoFactory) {
        countryDAO = daoFactory.createCountryDAO();
        stateDAO = daoFactory.createStateDAO();
        cityDAO = daoFactory.createCityDAO();
    }

    public void printReport(PrintStream ps) {
        ps.println("Países:");
        printPlaces(countryDAO.getCountries().iterator(), ps);
        
        ps.println("Estados:");
        printPlaces(stateDAO.getStates().iterator(), ps);

        ps.println("Cidades:");
        printPlaces(cityDAO.getCities().iterator(), ps);
    }

    private void printPlaces(Iterator iter, PrintStream ps) {
        while (iter.hasNext()) {
            ps.println("\t" + iter.next());
        }
    }
    
    public void printCountry(String name, PrintStream ps) {
        ps.println(countryDAO.getCountry(name));
    }
    
    public void printState(String name, PrintStream ps) {
        ps.println(stateDAO.getState(name));
    }
    
    public void printCity(String name, PrintStream ps) {
        ps.println(cityDAO.getCity(name));
    }
}
