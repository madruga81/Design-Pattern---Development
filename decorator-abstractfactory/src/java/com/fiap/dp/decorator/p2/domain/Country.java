package com.fiap.dp.decorator.p2.domain;

public class Country {
    private String name;

    public Country(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public boolean equals(Object obj) {
        if (!(obj instanceof Country)) {
            return false;
        }
        Country other = (Country) obj;
        return name.equals(other.getName());
    }
    public int hashCode() {
        return name.hashCode();
    }
    public String toString() {
        return name;
    }
}
