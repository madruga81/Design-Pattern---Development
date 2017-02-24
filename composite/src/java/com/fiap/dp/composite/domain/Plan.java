package com.fiap.dp.composite.domain;

public class Plan {
    private Place place;

    public Plan(Place place) {
        super();
        this.place = place;
    }

    public boolean isOfferedIn(City city) {
        return place.contains(city);
    }

    public String toString() {
        return place.getName();
    }
}
