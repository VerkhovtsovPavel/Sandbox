package simulation.place;

import simulation.place.type.*;
import simulation.util.Counter;
import simulation.util.Randomizer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class City {

    private List<Place> places;
    private static Place gate = new Gate();

    public City() {
        this.places = new ArrayList<>();
        buildPlaces(500, 50, 3, 5, 2, 1);
    }

    public static Place getGate() {
        return gate;
    }

    private void buildPlaces(int homesCount, int workCount, int schoolCount, int pubCount, int parkCount, int hospitalCount) {
        Counter placesUniqueIdentifiers = new Counter();
        IntStream.range(0, homesCount).forEach(i -> this.places.add(new Home(placesUniqueIdentifiers)));
        IntStream.range(0, workCount).forEach(i -> this.places.add(new Work(placesUniqueIdentifiers)));
        IntStream.range(0, schoolCount).forEach(i -> this.places.add(new School(placesUniqueIdentifiers)));
        IntStream.range(0, pubCount).forEach(i -> this.places.add(new Pub(placesUniqueIdentifiers)));
        IntStream.range(0, parkCount).forEach(i -> this.places.add(new Park(placesUniqueIdentifiers)));
        IntStream.range(0, hospitalCount).forEach(i -> this.places.add(new Hospital(placesUniqueIdentifiers)));
    }

    public Place getRandom(Class clazz) {
        Object[] filteredPlaces = places.stream().filter((x) -> x.getClass() == clazz).toArray();
        int randomIndex = Randomizer.nextInt(filteredPlaces.length);
        return (Place) filteredPlaces[randomIndex];
    }

    public List<Place> getPlaces() {
        return this.places;
    }
}
