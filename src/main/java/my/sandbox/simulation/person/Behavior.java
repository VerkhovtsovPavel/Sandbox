package my.sandbox.simulation.person;

import java.util.ArrayList;
import java.util.List;
import my.sandbox.simulation.place.Place;

public abstract class Behavior {

    private final List<Place> places = new ArrayList<>();
    private int currentElement;

    Behavior() {
        places.addAll(initPlaces());
        currentElement = 0;
    }

    public Place nextPlace() {
        if (currentElement == places.size()) {
            currentElement = 0;
        }
        Place place = places.get(currentElement);
        currentElement++;
        return place;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        places.forEach(p -> buffer.append(" -> ").append(p));
        return buffer.toString();
    }

    abstract List<Place> initPlaces();
}
