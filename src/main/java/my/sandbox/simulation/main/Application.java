package my.sandbox.simulation.main;

import static my.sandbox.common.constant.IntConstant.*;
import static my.sandbox.common.logger.CommonLogger.LOG;

import java.util.List;

import my.sandbox.common.util.Randomizer;
import my.sandbox.simulation.person.Person;
import my.sandbox.simulation.person.PopulationBuilder;
import my.sandbox.simulation.place.*;
import my.sandbox.simulation.util.Constant;


public final class Application {

	private static final int ITERATIONS = 100;

	public static void main(String[] args) {

		Navigator navigator = new Navigator();
		Reporter reporter = new Reporter();

		City city = new CityBuilder().withHomes(FIVE * HUNDRED).withWorks(50).withSchools(THREE).withPubs(FIVE).withParks(
				TWO).withHospitals(ONE).build();

		PopulationBuilder populationBuilder = new PopulationBuilder(city);
		List<Person> population = populationBuilder.build();

		initInfection(population);

		for (int i = 0; i < ITERATIONS; i++) {
			population.forEach((p) -> navigator.moveTo(p, p.getCurrentPlace(), p.tick()));

			newInfection(city, navigator, reporter);
			reporter.addLine(i, population);
			long count = population.stream().filter((p) -> p.getStatus().isSick()).count();
			if (count == 0) {
				LOG.info("End of simulation on " + i + " iteration. Not more sick people");
				break;
			}
		}

		finalReport(reporter, population);
	}

	private static void initInfection(List<Person> population) {
		for (int i = 0; i < Constant.INITIAL_INFECTED; i++) {
			population.get(Randomizer.nextInt(population.size())).infected();
		}
	}

	private static void newInfection(City city, Navigator navigator, Reporter reporter) {
		for (Place place : city.getPlaces()) {
			List<Person> people = navigator.inPlace(place);
			long count = people.stream().filter((p) -> p.getStatus().isContagious()).count();
			if (count > 0) {
				for (Person person : people) {
					if (person.infected()
							&& Randomizer.nextDouble() < Constant.INFECTION_PROBABILITY * count * place.getInfectionRate()) {
						reporter.newInfected(person, place);
					}
				}
			}
		}
	}

	private static void finalReport(Reporter reporter, List<Person> population) {
		reporter.printTable();
		reporter.printInfectionStatistic();
		reporter.printUninfected(population);
	}

	private Application() {
	}
}
