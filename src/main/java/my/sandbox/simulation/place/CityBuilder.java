package my.sandbox.simulation.place;

import static my.sandbox.common.util.ExecutionUtil.times;

import java.util.ArrayList;

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
        times(homesCount, i -> places.add(new Home(placesUniqueIdentifiers)));
        times(workCount, i -> places.add(new Work(placesUniqueIdentifiers)));
        times(schoolCount, i -> places.add(new School(placesUniqueIdentifiers)));
        times(pubCount, i -> places.add(new Pub(placesUniqueIdentifiers)));
        times(parkCount, i -> places.add(new Park(placesUniqueIdentifiers)));
        times(hospitalCount, i -> places.add(new Hospital(placesUniqueIdentifiers)));
        return new City(places);
    }
}
