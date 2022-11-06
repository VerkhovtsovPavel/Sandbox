package simulation.place;

import simulation.util.Randomizer;

import java.util.List;

public class City {

    private final List<Place> places;
    private static final Place gate = new Gate();

    public City(List<Place> places) {
        this.places = places;
    }

    public static Place getGate() {
        return gate;
    }

    //TODO Add generic for Place bounds
    public Place getRandom(Class clazz) {
        Object[] filteredPlaces = places.stream().filter((x) -> x.getClass() == clazz).toArray();
        int randomIndex = Randomizer.nextInt(filteredPlaces.length);
        return (Place) filteredPlaces[randomIndex];
    }

    public List<Place> getPlaces() {
        return this.places;
    }
}
