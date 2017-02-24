package com.fiap.dp.templatemethod.dao;

import java.util.Set;

import com.fiap.dp.templatemethod.domain.Country;

public interface CountryDAO {

    Set getCountries();

    Country getCountry(String name);

}
