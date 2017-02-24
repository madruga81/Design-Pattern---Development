package com.fiap.dp.composite.domain;

public abstract class Place {

    private String name;

    public Place(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public abstract boolean contains(City city);

    public int hashCode() {
        return name.hashCode();
    }

}
