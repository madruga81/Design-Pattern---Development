package com.fiap.dp.decorator.p2.dao.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fiap.dp.decorator.p2.ReportException;
import com.fiap.dp.decorator.p2.dao.CityDAO;
import com.fiap.dp.decorator.p2.domain.City;
import com.fiap.dp.decorator.p2.domain.Country;
import com.fiap.dp.decorator.p2.domain.State;

public class CsvCityDAO implements CityDAO {
    
    private Pattern pattern;

    public CsvCityDAO() {
        super();
        pattern = Pattern.compile("([^;]+);([^;]+);([^;]+)");
    }

    public Set getCities() {
        Set result = new HashSet();
        BufferedReader reader = CsvHelper.openCSVasBufferedReader();
        try {
            String line = reader.readLine();
            while (line != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    String cityName = matcher.group(1);
                    String stateName = matcher.group(2);
                    String countryName = matcher.group(3);
                    Country country = new Country(countryName);
                    State state = new State(stateName, country);
                    City city = new City(cityName, state);
                    result.add(city);
                }
                line = reader.readLine();
            }
        } catch (IOException ioe) {
            throw new ReportException("I/O error reading input", ioe);
        }
        return result;
    }

    public City getCity(String name) {
        BufferedReader reader = CsvHelper.openCSVasBufferedReader();
        try {
            String line = reader.readLine();
            while (line != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    String cityName = matcher.group(1);
                    if (name.equals(cityName)) {
                        String stateName = matcher.group(2);
                        String countryName = matcher.group(3);
                        Country country = new Country(countryName);
                        State state = new State(stateName, country);
                        return new City(cityName, state);
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException ioe) {
            throw new ReportException("I/O error reading input", ioe);
        }
        return null;
    }
}
