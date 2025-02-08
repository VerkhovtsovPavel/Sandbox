package my.sandbox.simulation.place;

import java.util.List;

import my.sandbox.common.util.Randomizer;

public class City {
    private static final Place GATE = new Gate();
    private final List<Place> places;

    public City(final List<Place> places) {
        this.places = places;
    }

    public static Place getGate() {
        return GATE;
    }

    public Place getRandom(final Class<? extends Place> clazz) {
        List<Place> filteredPlaces = places.stream().filter(x -> x.getClass() == clazz).toList();
        int randomIndex = Randomizer.nextInt(filteredPlaces.size());
        return filteredPlaces.get(randomIndex);
    }

    public List<Place> getPlaces() {
        return this.places;
    }
}

