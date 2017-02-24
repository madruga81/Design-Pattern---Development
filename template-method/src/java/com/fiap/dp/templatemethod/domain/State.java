package com.fiap.dp.templatemethod.domain;

import java.util.HashSet;
import java.util.Set;

public class State extends Place {
    private Set cities = new HashSet();
    private Country country;

    public State(String name, Country country) {
        super(name);
        this.country = country;
        this.country.addState(this);
    }

    public Country getCountry() {
        return country;
    }
    
    void addCity(City city) {
        cities.add(city);
    }

    public boolean contains(City city) {
        return cities.contains(city);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof State)) {
            return false;
        }
        State other = (State) obj;
        return getName().equals(other.getName());
    }

    public String toString() {
        return getName() + ", " + country;
    }
}
