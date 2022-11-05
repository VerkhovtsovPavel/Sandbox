package simulation.place;

import simulation.util.Counter;

import static simulation.util.StringUtils.beatifyClassName;

public abstract class Place {

    private long id;

    public Place(Counter counter) {
        this.id = counter.inc(this.getClass());
    }

    public abstract double getInfectionRate();

    @Override
    public String toString() {
        String className = beatifyClassName(this.getClass());
        return className + " #" + id;
    }
}
