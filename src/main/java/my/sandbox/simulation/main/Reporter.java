package my.sandbox.simulation.main;

import my.sandbox.simulation.person.HealthState;
import my.sandbox.simulation.person.Person;
import my.sandbox.simulation.place.Place;
import my.sandbox.simulation.util.Counter;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static my.sandbox.common.util.StringUtils.beatifyClassName;

public class Reporter {

    private static final String tableFormat = "| %9d | %7d | %8d | %10d | %4d | %8d | %4d |";
    private static final String tableHead = "| Iteration | Healthy | Infected | Contagious | Sick | Resisted | Dead |";
    private static final String tableBorder = "------------------------------------------------------------------------";

    private final LinkedList<String> tableRows = new LinkedList<>();
    private final Counter quantityOfInfection = new Counter();

    public void addLine(int iteration, List<Person> population) {
        long healthyCount = population.stream().filter((p) -> p.getStatus() == HealthState.HEALTHY).count();
        long infectedCount = population.stream().filter((p) -> p.getStatus() == HealthState.INFECTED).count();
        long contagiousCount = population.stream().filter((p) -> p.getStatus() == HealthState.CONTAGIOUS).count();
        long sickCount = population.stream().filter((p) -> p.getStatus() == HealthState.SICK).count();
        long resistedCount = population.stream().filter((p) -> p.getStatus() == HealthState.RESISTED).count();
        long deadCount = population.stream().filter((p) -> p.getStatus() == HealthState.DEAD).count();

        tableRows.addLast(String.format(tableFormat, iteration, healthyCount, infectedCount, contagiousCount, sickCount, resistedCount, deadCount));
    }

    public void newInfected(Person person, Place place) {
        quantityOfInfection.inc(place.getClass());
        System.out.println(person + " was infected in " + place);
    }

    public void printTable() {
        System.out.println(tableBorder);
        System.out.println(tableHead);
        tableRows.forEach(System.out::println);
        System.out.println(tableBorder);
    }

    public void printInfectionStatistic() {
        System.out.println("Infected by place:");
        for (Map.Entry<Class, Long> infectionCounter : quantityOfInfection.getCounters().entrySet()) {
            System.out.println(beatifyClassName(infectionCounter.getKey()) + " -> " + infectionCounter.getValue());
        }
    }

}
