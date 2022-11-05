package simulation.main;

import simulation.person.BehaviorFactory;
import simulation.person.HealthState;
import simulation.person.Person;
import simulation.place.City;
import simulation.place.Navigator;
import simulation.place.Place;
import simulation.util.Constant;
import simulation.util.Counter;
import simulation.util.Randomizer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static simulation.util.StringUtils.beatifyClassName;

public class Main {

    private static String tableFormat = "| %9d | %7d | %8d | %4d | %8d | %4d |";
    private static String tableHead =   "| Iteration | Healthy | Infected | Sick | Resisted | Dead |";
    private static String tableBorder = "-----------------------------------------------------------";

    public static void main(String[] args) {

        City city = new City();
        BehaviorFactory behaviorFactory = new BehaviorFactory(city);
        Navigator navigator = new Navigator();
        Counter quantityOfInfection = new Counter();
        Counter personalIdentifier = new Counter(Person.class);

        ArrayList<Person> population = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            population.add(new Person(personalIdentifier.inc(), behaviorFactory.worker(), behaviorFactory.sick()));
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

        for (int i = 0; i < Constant.INITIAL_INFECTED; i++) {
            population.get(Randomizer.nextInt(population.size())).infected();
        }

        LinkedList<String> tableRows = new LinkedList<>();

        for (int i = 0; i < 100; i++) {
            population.forEach((p) -> navigator.moveTo(p, p.getCurrentPlace(), p.tick()));

            for (Place place : city.getPlaces()) {
                List<Person> people = navigator.inPlace(place);
                long count = people.stream().filter((p) -> p.getStatus() == HealthState.INFECTED).count();
                if (count > 0) {
                    for (Person person : people) {
                        if (Randomizer.nextDouble() < Constant.INFECTION_PROBABILITY * count * place.getInfectionRate()) {
                            if (person.infected()) {
                                quantityOfInfection.inc(place.getClass());
                                System.out.println(person.toString() + " was infected in " + place.toString());
                            }
                        }
                    }
                }
            }

            long healthyCount = population.stream().filter((p) -> p.getStatus() == HealthState.HEALTHY).count();
            long infectedCount = population.stream().filter((p) -> p.getStatus() == HealthState.INFECTED).count();
            long sickCount = population.stream().filter((p) -> p.getStatus() == HealthState.SICK).count();
            long resistedCount = population.stream().filter((p) -> p.getStatus() == HealthState.RESISTED).count();
            long deadCount = population.stream().filter((p) -> p.getStatus() == HealthState.DEAD).count();

            tableRows.addLast(String.format(tableFormat, i, healthyCount, infectedCount, sickCount, resistedCount, deadCount));
        }

        System.out.println(tableBorder);
        System.out.println(tableHead);
        tableRows.forEach(System.out::println);
        System.out.println(tableBorder);

        for(Map.Entry<Class, Long> infectionCounter : quantityOfInfection.getCounters().entrySet()) {
            System.out.println(beatifyClassName(infectionCounter.getKey()) + " -> " + infectionCounter.getValue());
        }

        population.stream().filter((p) -> p.getStatus() == HealthState.HEALTHY).forEach((p) -> System.out.println(p.detailedDescription()));
    }
}
