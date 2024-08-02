package my.sandbox.simulation.main;

import my.sandbox.simulation.person.Person;
import my.sandbox.simulation.person.PopulationBuilder;
import my.sandbox.simulation.place.City;
import my.sandbox.simulation.place.CityBuilder;
import my.sandbox.simulation.place.Navigator;
import my.sandbox.simulation.place.Place;
import my.sandbox.simulation.util.Constant;
import my.sandbox.common.util.Randomizer;

import java.util.List;

import static my.sandbox.common.constant.IntConstant.*;
import static my.sandbox.common.logger.CommonLogger.LOG;


public class Main {

    private static final int ITERATIONS = 100;

    public static void main(String[] args) {

        CityBuilder cityBuilder = new CityBuilder();
        City city = cityBuilder
                .withHomes(FIVE * HUNDRED)
                .withWorks(50)
                .withSchools(THREE)
                .withPubs(FIVE)
                .withParks(TWO)
                .withHospitals(ONE)
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
                LOG.info("End of simulation on " + i + " iteration. Not more sick people");
                break;
            }
        }

        reporter.printTable();
        reporter.printInfectionStatistic();
        reporter.printUninfected(population);
    }
}
