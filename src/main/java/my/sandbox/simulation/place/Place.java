package my.sandbox.simulation.place;

import static my.sandbox.common.util.StringUtil.beatifyClassName;

import my.sandbox.simulation.util.Counter;

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
