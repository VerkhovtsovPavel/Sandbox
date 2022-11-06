package simulation.place;

import simulation.person.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Navigator {

    private final HashMap<Place, List<Person>> currentLocation = new HashMap<>();

    public void moveTo(Person person, Place from, Place to) {
        List<Person> fromList = currentLocation.get(from);
        if (fromList == null) {
            currentLocation.put(from, new ArrayList<>());
        } else {
            fromList.remove(person);
        }

        List<Person> toList = currentLocation.get(to);
        if (toList == null) {
            currentLocation.put(from, new ArrayList<>(Collections.singletonList(person)));
        } else {
            toList.add(person);
        }
    }

    public List<Person> inPlace(Place place) {
        return currentLocation.getOrDefault(place, new ArrayList<>());
    }

    public HashMap<String, Integer> getStatistic() {
        HashMap<String, Integer> statistic = new HashMap<>();
        for (Place place : currentLocation.keySet()) {
            List<Person> people = currentLocation.getOrDefault(place, new ArrayList<>());
            statistic.put(place.toString(), people.size());
        }
        return statistic;
    }
}