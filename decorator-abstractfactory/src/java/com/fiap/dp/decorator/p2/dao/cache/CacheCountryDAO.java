package com.fiap.dp.decorator.p2.dao.cache;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.fiap.dp.decorator.p2.dao.CountryDAO;
import com.fiap.dp.decorator.p2.domain.Country;

public class CacheCountryDAO implements CountryDAO {

    private CountryDAO realDao;
    private Map cache = null;

    public CacheCountryDAO(CountryDAO dao) {
        super();
        realDao = dao;
    }

    public Set getCountries() {
        if (cache == null) {
            loadCache();
        }
        return new HashSet(cache.values());
    }

    public Country getCountry(String name) {
        if (cache == null) {
            loadCache();
        }
        return (Country) cache.get(name);
    }

    private void loadCache() {
        cache = new HashMap();
        Set countries = realDao.getCountries();
        for (Iterator iter = countries.iterator(); iter.hasNext(); ) {
            Country country = (Country) iter.next();
            cache.put(country.getName(), country);
        }
    }
}
