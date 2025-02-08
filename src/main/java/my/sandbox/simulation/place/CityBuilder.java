package my.sandbox.simulation.place;

import java.util.ArrayList;
import java.util.stream.IntStream;
import my.sandbox.simulation.place.type.Home;
import my.sandbox.simulation.place.type.Hospital;
import my.sandbox.simulation.place.type.Park;
import my.sandbox.simulation.place.type.Pub;
import my.sandbox.simulation.place.type.School;
import my.sandbox.simulation.place.type.Work;
import my.sandbox.simulation.util.Counter;

public class CityBuilder {
    private int homesCount;
    private int workCount;
    private int schoolCount;
    private int pubCount;
    private int parkCount;
    private int hospitalCount;

    public CityBuilder withHomes(final int newHomesCount) {
        this.homesCount = newHomesCount;
        return this;
    }

    public CityBuilder withWorks(final int newWorkCount) {
        this.workCount = newWorkCount;
        return this;
    }

    public CityBuilder withSchools(final int newSchoolCount) {
        this.schoolCount = newSchoolCount;
        return this;
    }

    public CityBuilder withPubs(final int newPubCount) {
        this.pubCount = newPubCount;
        return this;
    }

    public CityBuilder withParks(final int newParkCount) {
        this.parkCount = newParkCount;
        return this;
    }

    public CityBuilder withHospitals(final int newHospitalCount) {
        this.hospitalCount = newHospitalCount;
        return this;
    }

    public City build() {
        Counter placesUniqueIdentifiers = new Counter();
        ArrayList<Place> places = new ArrayList<>();
        //TODO Re-work with times
        IntStream.range(0, homesCount).forEach(i -> places.add(new Home(placesUniqueIdentifiers)));
        IntStream.range(0, workCount).forEach(i -> places.add(new Work(placesUniqueIdentifiers)));
        IntStream.range(0, schoolCount).forEach(i -> places.add(new School(placesUniqueIdentifiers)));
        IntStream.range(0, pubCount).forEach(i -> places.add(new Pub(placesUniqueIdentifiers)));
        IntStream.range(0, parkCount).forEach(i -> places.add(new Park(placesUniqueIdentifiers)));
        IntStream.range(0, hospitalCount).forEach(i -> places.add(new Hospital(placesUniqueIdentifiers)));
        return new City(places);
    }
}
