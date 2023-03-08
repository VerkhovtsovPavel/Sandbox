package my.sandbox.simulation.main;

import my.sandbox.simulation.person.HealthState;
import my.sandbox.simulation.person.Person;
import my.sandbox.simulation.person.PopulationBuilder;
import my.sandbox.simulation.place.City;
import my.sandbox.simulation.place.CityBuilder;
import my.sandbox.simulation.place.Navigator;
import my.sandbox.simulation.place.Place;
import my.sandbox.simulation.util.Constant;
import my.sandbox.simulation.util.Randomizer;

import java.util.List;

import static my.sandbox.simulation.util.StringUtils.beatifyClassName;

public class Main {

    private static final int ITERATIONS = 100;

    public static void main(String[] args) {

        CityBuilder cityBuilder = new CityBuilder();
        City city = cityBuilder
                .withHomes(500)
                .withWorks(50)
                .withSchools(3)
                .withPubs(5)
                .withParks(2)
                .withHospitals(1)
                .build();

        PopulationBuilder populationBuilder = new PopulationBuilder(city);

        Navigator navigator = new Navigator();

        Reporter reporter = new Reporter();

        List<Person> population = populationBuilder.build();

        for (int i = 0; i < Constant.INITIAL_INFECTED; i++) {
            population.get(Randomizer.nextInt(population.size())).infected();
        }

        for (int i = 0; i < ITERATIONS; i++) {
            population.forEach((p) -> navigator.moveTo(p, p.getCurrentPlace(), p.tick()));

            for (Place place : city.getPlaces()) {
                List<Person> people = navigator.inPlace(place);
                long count = people.stream().filter((p) -> p.getStatus().isContagious()).count();
                if (count > 0) {
                    for (Person person : people) {
                        if (Randomizer.nextDouble() < Constant.INFECTION_PROBABILITY * count * place.getInfectionRate()) {
                            if (person.infected()) {
                                reporter.newInfected(person, place);
                            }
                        }
                    }
                }
            }
            reporter.addLine(i, population);
            long count = population.stream().filter((p) -> p.getStatus().isSick()).count();
            if (count == 0) {
                System.out.println("End of my.sandbox.simulation on " + i + " iteration. Not more sick people");
                break;
            }
        }

        reporter.printTable();
        reporter.printInfectionStatistic();

        population.stream()
                .filter((p) -> p.getStatus() == HealthState.HEALTHY)
                .forEach((p) -> System.out.println(p.detailedDescription()));
    }
}
