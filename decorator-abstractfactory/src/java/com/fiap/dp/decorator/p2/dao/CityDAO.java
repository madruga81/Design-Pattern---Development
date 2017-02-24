package com.fiap.dp.decorator.p2.dao;

import java.util.Set;

import com.fiap.dp.decorator.p2.domain.City;

public interface CityDAO {

    Set getCities();

    City getCity(String name);

}
