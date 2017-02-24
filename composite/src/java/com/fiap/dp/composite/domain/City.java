package com.fiap.dp.composite.domain;


public class City extends Place {
    private State state;

    public City(String name, State state) {
        super(name);
        this.state = state;
        this.state.addCity(this);
    }

    public State getState() {
        return state;
    }

    public boolean contains(City city) {
        return equals(city);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof City)) {
            return false;
        }
        City other = (City) obj;
        return getName().equals(other.getName());
    }

    public String toString() {
        return getName() + ", " + state;
    }
}
