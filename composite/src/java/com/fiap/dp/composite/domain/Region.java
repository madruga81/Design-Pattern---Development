package com.fiap.dp.composite.domain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Region extends Place {

    private Set places = new HashSet();

    public Region(String name) {
        super(name);
    }

    public Set getPlaces() {
        return places;
    }
    
    public void addPlace(Place place) {
        places.add(place);
    }

    public boolean contains(City city) {
        for (Iterator iter = places.iterator(); iter.hasNext();) {
            Place place = (Place) iter.next();
            if (place.contains(city)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Region)) {
            return false;
        }
        Region other = (Region) obj;
        return getName().equals(other.getName());
    }

    public String toString() {
        return getName() + "=" + places;
    }
}
