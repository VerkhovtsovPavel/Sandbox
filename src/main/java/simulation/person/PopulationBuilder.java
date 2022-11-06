package simulation.person;

import simulation.place.City;
import simulation.util.Counter;

import java.util.ArrayList;
import java.util.List;

public class PopulationBuilder {

    private final BehaviorFactory behaviorFactory;

    public PopulationBuilder(City city) {
        this.behaviorFactory = new BehaviorFactory(city);
    }

    public List<Person> build() {
        Counter personalIdentifier = new Counter(Person.class);
        ArrayList<Person> population = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            population.add(new Person(personalIdentifier.inc(), behaviorFactory.worker(), behaviorFactory.sick()));
        }

        for (int i = 0; i < 50; i++) {
            population.add(new Person(personalIdentifier.inc(), behaviorFactory.hardWorker(), behaviorFactory.hardWorker()));
        }

        for (int i = 0; i < 200; i++) {
            population.add(new Person(personalIdentifier.inc(), behaviorFactory.child(), behaviorFactory.sick()));
        }

        for (int i = 0; i < 100; i++) {
            population.add(new Person(personalIdentifier.inc(), behaviorFactory.unemployed(), behaviorFactory.sick()));
        }

        for (int i = 0; i < 100; i++) {
            population.add(new Person(personalIdentifier.inc(), behaviorFactory.homeless(), behaviorFactory.homeless()));
        }

        for (int i = 0; i < 10; i++) {
            population.add(new Person(personalIdentifier.inc(), behaviorFactory.doctor(), behaviorFactory.doctor()));
        }

        return population;
    }
}
