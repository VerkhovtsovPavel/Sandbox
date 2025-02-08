package my.sandbox.simulation.place;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import my.sandbox.simulation.person.Person;

public class Navigator {
    private final Map<Place, List<Person>> currentLocation = new HashMap<>();

    public void moveTo(final Person person, final Place from, final Place to) {
        List<Person> fromList = currentLocation.get(from);
        if (fromList == null) {
            currentLocation.put(from, new ArrayList<>());
        }
        else {
            fromList.remove(person);
        }

        List<Person> toList = currentLocation.get(to);
        if (toList == null) {
            currentLocation.put(from, new ArrayList<>(Collections.singletonList(person)));
        }
        else {
            toList.add(person);
        }
    }

    public List<Person> inPlace(final Place place) {
        return currentLocation.getOrDefault(place, new ArrayList<>());
    }

    public Map<String, Integer> getStatistic() {
        Map<String, Integer> statistic = new HashMap<>();
        for (Place place : currentLocation.keySet()) {
            List<Person> people = currentLocation.getOrDefault(place, new ArrayList<>());
            statistic.put(place.toString(), people.size());
        }
        return statistic;
    }
}
