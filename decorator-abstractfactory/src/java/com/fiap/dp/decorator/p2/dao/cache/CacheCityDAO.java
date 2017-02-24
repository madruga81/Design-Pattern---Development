package com.fiap.dp.decorator.p2.dao.cache;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.fiap.dp.decorator.p2.dao.CityDAO;
import com.fiap.dp.decorator.p2.domain.City;

public class CacheCityDAO implements CityDAO {

    private CityDAO realDao;
    private Map cache = null;

    public CacheCityDAO(CityDAO dao) {
        super();
        realDao = dao;
    }

    public Set getCities() {
        if (cache == null) {
            loadCache();
        }
        return new HashSet(cache.values());
    }

    public City getCity(String name) {
        if (cache == null) {
            loadCache();
        }
        return (City) cache.get(name);
    }

    private void loadCache() {
        cache = new HashMap();
        Set cities = realDao.getCities();
        for (Iterator iter = cities.iterator(); iter.hasNext(); ) {
            City city = (City) iter.next();
            cache.put(city.getName(), city);
        }
    }
}
