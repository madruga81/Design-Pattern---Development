package com.fiap.dp.decorator.p2.dao.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fiap.dp.decorator.p2.ReportException;
import com.fiap.dp.decorator.p2.dao.CountryDAO;
import com.fiap.dp.decorator.p2.domain.Country;

public class CsvCountryDAO implements CountryDAO {
    
    private Pattern pattern;

    public CsvCountryDAO() {
        super();
        pattern = Pattern.compile("([^;]+);;");
    }

    public Set getCountries() {
        Set result = new HashSet();
        BufferedReader reader = CsvHelper.openCSVasBufferedReader();
        try {
            String line = reader.readLine();
            while (line != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    String countryName = matcher.group(1);
                    Country country = new Country(countryName);
                    result.add(country);
                }
                line = reader.readLine();
            }
        } catch (IOException ioe) {
            throw new ReportException("I/O error reading input", ioe);
        }
        return result;
    }

    public Country getCountry(String name) {
        BufferedReader reader = CsvHelper.openCSVasBufferedReader();
        try {
            String line = reader.readLine();
            while (line != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    String countryName = matcher.group(1);
                    if (name.equals(countryName)) {
                        return new Country(countryName);
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
