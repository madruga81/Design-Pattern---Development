package com.fiap.dp.decorator.p2.domain;

public class City {
    private String name;
    private State state;
    public City(String name) {
        super();
        this.name = name;
    }
    public City(String name, State state) {
        super();
        this.name = name;
        this.state = state;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }
    public boolean equals(Object obj) {
        if (!(obj instanceof City)) {
            return false;
        }
        City other = (City) obj;
        return name.equals(other.getName());
    }
    public int hashCode() {
        return name.hashCode();
    }
    public String toString() {
        return name + ", " + state;
    }
}
