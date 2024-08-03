package my.sandbox.simulation.person;

import my.sandbox.simulation.place.City;
import my.sandbox.simulation.place.Place;

public class Person {
    private final long id;
    private final Health health;
    private final Behavior behavior;
    private final Behavior sickBehavior;
    private Place currentPlace;

    public Person(long id, Behavior behavior, Behavior sickBehavior) {
        this.id = id;
        this.health = new Health();
        this.behavior = behavior;
        this.sickBehavior = sickBehavior;
        this.currentPlace = City.getGate();
    }

    public Place tick() {
        health.tick();

        if (health.getCurrentState() == HealthState.DEAD) {
            return City.getGate();
        }

        if (health.getCurrentState() == HealthState.SICK) {
            currentPlace = sickBehavior.nextPlace();
        }
        else {
            currentPlace = behavior.nextPlace();
        }
        return currentPlace;
    }

    public HealthState getStatus() {
        return health.getCurrentState();
    }

    public boolean infected() {
        return health.infected();
    }

    public Place getCurrentPlace() {
        return currentPlace;
    }

    @Override
    public String toString() {
        return "Person #" + id;
    }

    public String detailedDescription() {
        String intro = toString();
        String behaviorInfo = behavior.toString();

        return intro + " | Places:" + behaviorInfo;
    }
}
