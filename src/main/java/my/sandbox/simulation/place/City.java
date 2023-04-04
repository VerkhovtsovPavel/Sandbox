package my.sandbox.simulation.place;

import my.sandbox.simulation.util.Randomizer;

import java.util.List;

public class City {

    private static final Place GATE = new Gate();
    private final List<Place> places;

    public City(final List<Place> places) {
        this.places = places;
    }

    public static Place getGate() {
        return GATE;
    }

    //TODO Add generic for Place bounds
    public Place getRandom(final Class clazz) {
        Object[] filteredPlaces = places.stream().filter((x) -> x.getClass() == clazz).toArray();
        int randomIndex = Randomizer.nextInt(filteredPlaces.length);
        return (Place) filteredPlaces[randomIndex];
    }

    public List<Place> getPlaces() {
        return this.places;
    }
}
