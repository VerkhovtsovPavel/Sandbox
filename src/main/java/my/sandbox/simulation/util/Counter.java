package my.sandbox.simulation.util;

import java.util.HashMap;

public class Counter {

    private final Class defaultClass;
    private final HashMap<Class, Long> counters = new HashMap<>();

    public Counter() {
        this.defaultClass = Object.class;
    }

    public Counter(final Class defaultClass) {
        this.defaultClass = defaultClass;
    }

    public long inc(final Class clazz) {
        long counter = counters.getOrDefault(clazz, 0L);
        counters.put(clazz, counter + 1);
        return counter;
    }

    public long inc() {
        return inc(defaultClass);
    }

    public HashMap<Class, Long> getCounters() {
        return counters;
    }
}
