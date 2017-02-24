package com.fiap.dp.decorator.p2.dao;

import java.util.Set;

import com.fiap.dp.decorator.p2.domain.Country;

public interface CountryDAO {

    Set getCountries();

    Country getCountry(String name);

}
