package my.sandbox.simulation.main;

import static my.sandbox.common.constant.StringConstant.DASH;
import static my.sandbox.common.logger.CommonLogger.LOG;
import java.util.LinkedList;
import java.util.List;
import my.sandbox.common.util.StringUtils;
import my.sandbox.simulation.person.HealthState;
import my.sandbox.simulation.person.Person;
import my.sandbox.simulation.place.Place;
import my.sandbox.simulation.util.Counter;

public class Reporter {
    private static final String TABLE_FORMAT = "| %9d | %7d | %8d | %10d | %4d | %8d | %4d |";
    private static final String TABLE_HEAD = "| Iteration | Healthy | Infected | Contagious | Sick | Resisted | Dead |";
    private static final String TABLE_BORDER = DASH.repeat(TABLE_HEAD.length());

    private final List<String> tableRows = new LinkedList<>();
    private final Counter quantityOfInfection = new Counter();

    public void addLine(int iteration, List<Person> population) {
        long healthyCount = population.stream().filter(p -> p.getStatus() == HealthState.HEALTHY).count();
        long infectedCount = population.stream().filter(p -> p.getStatus() == HealthState.INFECTED).count();
        long contagiousCount = population.stream().filter(p -> p.getStatus() == HealthState.CONTAGIOUS).count();
        long sickCount = population.stream().filter(p -> p.getStatus() == HealthState.SICK).count();
        long resistedCount = population.stream().filter(p -> p.getStatus() == HealthState.RESISTED).count();
        long deadCount = population.stream().filter(p -> p.getStatus() == HealthState.DEAD).count();

        tableRows.add(
              String.format(
                  TABLE_FORMAT,
                  iteration,
                  healthyCount,
                  infectedCount,
                  contagiousCount,
                  sickCount,
                  resistedCount,
                  deadCount
              )
        );
    }

    public void newInfected(Person person, Place place) {
        quantityOfInfection.inc(place.getClass());
        LOG.info(person + " was infected in " + place);
    }

    public void printTable() {
        LOG.info(TABLE_BORDER);
        LOG.info(TABLE_HEAD);
        tableRows.forEach(LOG::info);
        LOG.info(TABLE_BORDER);
    }

    public void printInfectionStatistic() {
        LOG.info("Infected by place:");
        quantityOfInfection.getCounters()
              .forEach((key, value) -> LOG.info(StringUtils.beatifyClassName(key) + " -> " + value));
    }

    public void printUninfected(List<Person> population) {
        List<Person> uninfectedPeople = population.stream()
                .filter(p -> p.getStatus() == HealthState.HEALTHY).toList();
        if (!uninfectedPeople.isEmpty()) {
            LOG.info("Uninfected persons:");
            uninfectedPeople.forEach(p -> LOG.info(p.detailedDescription()));
        }
    }
}
