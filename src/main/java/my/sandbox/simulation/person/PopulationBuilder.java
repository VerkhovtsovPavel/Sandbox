package my.sandbox.simulation.person;

import static my.sandbox.common.constant.IntConstant.FIFTY;
import static my.sandbox.common.constant.IntConstant.FIVE;
import static my.sandbox.common.constant.IntConstant.HUNDRED;
import static my.sandbox.common.constant.IntConstant.TEN;
import static my.sandbox.common.constant.IntConstant.TWO;
import static my.sandbox.common.constant.IntConstant.ZERO;

import java.util.ArrayList;
import java.util.List;

import my.sandbox.simulation.place.City;
import my.sandbox.simulation.util.Counter;

public class PopulationBuilder {
    private final BehaviorFactory behaviorFactory;

    public PopulationBuilder(City city) {
        this.behaviorFactory = new BehaviorFactory(city);
    }

    public List<Person> build() {
        Counter personalIdentifier = new Counter();
        ArrayList<Person> population = new ArrayList<>();

        for (int i = ZERO; i < FIVE * HUNDRED; i++) {
            population.add(new Person(personalIdentifier.inc(), behaviorFactory.worker(), behaviorFactory.sick()));
        }

        for (int i = ZERO; i < FIFTY; i++) {
            population.add(
                new Person(personalIdentifier.inc(), behaviorFactory.hardWorker(), behaviorFactory.hardWorker()));
        }

        for (int i = ZERO; i < TWO * HUNDRED; i++) {
            population.add(new Person(personalIdentifier.inc(), behaviorFactory.child(), behaviorFactory.sick()));
        }

        for (int i = ZERO; i < HUNDRED; i++) {
            population.add(new Person(personalIdentifier.inc(), behaviorFactory.unemployed(), behaviorFactory.sick()));
        }

        for (int i = ZERO; i < HUNDRED; i++) {
            population.add(
                new Person(personalIdentifier.inc(), behaviorFactory.homeless(), behaviorFactory.homeless()));
        }

        for (int i = ZERO; i < TEN; i++) {
            population.add(new Person(personalIdentifier.inc(), behaviorFactory.doctor(), behaviorFactory.sick()));
        }

        return population;
    }
}
