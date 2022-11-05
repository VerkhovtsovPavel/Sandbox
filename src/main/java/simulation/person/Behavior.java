package simulation.person;

import simulation.place.Place;

import java.util.ArrayList;
import java.util.List;

public abstract class Behavior {

    private ArrayList<Place> places = new ArrayList<>();
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
        places.forEach(buffer::append);
        return buffer.toString();
    }

    abstract List<Place> initPlaces();
}
