package com.fiap.dp.decorator.p2.dao.cache;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.fiap.dp.decorator.p2.dao.StateDAO;
import com.fiap.dp.decorator.p2.domain.State;

public class CacheStateDAO implements StateDAO {

    private StateDAO realDao;
    private Map cache = null;

    public CacheStateDAO(StateDAO dao) {
        super();
        realDao = dao;
    }

    public Set getStates() {
        if (cache == null) {
            loadCache();
        }
        return new HashSet(cache.values());
    }

    public State getState(String name) {
        if (cache == null) {
            loadCache();
        }
        return (State) cache.get(name);
    }

    private void loadCache() {
        cache = new HashMap();
        Set states = realDao.getStates();
        for (Iterator iter = states.iterator(); iter.hasNext(); ) {
            State state = (State) iter.next();
            cache.put(state.getName(), state);
        }
    }
}
