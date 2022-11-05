package simulation.person;

import simulation.place.*;
import simulation.place.type.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BehaviorFactory {

    private City city;

    public BehaviorFactory(City city) {
        this.city = city;
    }

    public Behavior worker() {
        return new Behavior() {
            @Override
            List<Place> initPlaces() {
                Place work = city.getRandom(Work.class);
                return new ArrayList<>(Arrays.asList(
                        work,
                        work,
                        city.getRandom(Pub.class),
                        city.getRandom(Home.class)));
            }
        };
    }

    public Behavior homeless() {
        return new Behavior() {
            @Override
            List<Place> initPlaces() {
                return new ArrayList<>(Arrays.asList(
                        city.getRandom(Park.class),
                        city.getRandom(Park.class),
                        city.getRandom(Pub.class),
                        city.getRandom(Park.class)));
            }
        };
    }

    public Behavior unemployed() {
        return new Behavior() {
            @Override
            List<Place> initPlaces() {
                Place home = city.getRandom(Home.class);
                return new ArrayList<>(Arrays.asList(
                        home,
                        city.getRandom(Park.class),
                        city.getRandom(Pub.class),
                        home));
            }
        };
    }

    public Behavior child() {
        return new Behavior() {
            @Override
            List<Place> initPlaces() {
                Place home = city.getRandom(Home.class);
                Place school = city.getRandom(School.class);
                return new ArrayList<>(Arrays.asList(
                        home,
                        school,
                        school,
                        home));
            }
        };
    }

    public Behavior sick() {
        return new Behavior() {
            @Override
            List<Place> initPlaces() {
                return new ArrayList<>(Collections.singletonList(city.getRandom(Hospital.class)));
            }
        };
    }
}
