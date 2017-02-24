package com.fiap.dp.composite.domain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Country extends Place {
    private Set states = new HashSet();

    public Country(String name) {
        super(name);
    }

    void addState(State state) {
        states.add(state);
    }

    public boolean contains(City city) {
        for (Iterator iter = states.iterator(); iter.hasNext();) {
            State state = (State) iter.next();
            if (state.contains(city)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Country)) {
            return false;
        }
        Country other = (Country) obj;
        return getName().equals(other.getName());
    }

    public String toString() {
        return getName();
    }
}
