package simulation.place;

import simulation.place.type.*;
import simulation.util.Counter;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class CityBuilder {
    int homesCount;
    int workCount;
    int schoolCount;
    int pubCount;
    int parkCount;
    int hospitalCount;

    public CityBuilder withHomes(final int homesCount) {
        this.homesCount = homesCount;
        return this;
    }

    public CityBuilder withWorks(final int workCount) {
        this.workCount = workCount;
        return this;
    }

    public CityBuilder withSchools(final int schoolCount) {
        this.schoolCount = schoolCount;
        return this;
    }

    public CityBuilder withPubs(final int pubCount) {
        this.pubCount = pubCount;
        return this;
    }

    public CityBuilder withParks(final int parkCount) {
        this.parkCount = parkCount;
        return this;
    }

    public CityBuilder withHospitals(final int hospitalCount) {
        this.hospitalCount = hospitalCount;
        return this;
    }

    public City build() {
        Counter placesUniqueIdentifiers = new Counter();
        ArrayList<Place> places = new ArrayList<>();
        IntStream.range(0, homesCount).forEach(i -> places.add(new Home(placesUniqueIdentifiers)));
        IntStream.range(0, workCount).forEach(i -> places.add(new Work(placesUniqueIdentifiers)));
        IntStream.range(0, schoolCount).forEach(i -> places.add(new School(placesUniqueIdentifiers)));
        IntStream.range(0, pubCount).forEach(i -> places.add(new Pub(placesUniqueIdentifiers)));
        IntStream.range(0, parkCount).forEach(i -> places.add(new Park(placesUniqueIdentifiers)));
        IntStream.range(0, hospitalCount).forEach(i -> places.add(new Hospital(placesUniqueIdentifiers)));
        return new City(places);
    }
}
