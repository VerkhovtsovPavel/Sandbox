package my.sandbox.simulation.place;

import my.sandbox.simulation.util.Counter;

import static my.sandbox.common.util.StringUtils.beatifyClassName;

public abstract class Place {

    private final long id;

    public Place(final Counter counter) {
        this.id = counter.inc(this.getClass());
    }

    public abstract double getInfectionRate();

    @Override
    public String toString() {
        String className = beatifyClassName(this.getClass());
        return className + " #" + id;
    }
}
