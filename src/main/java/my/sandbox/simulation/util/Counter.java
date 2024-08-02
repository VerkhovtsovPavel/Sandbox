package my.sandbox.simulation.util;

import java.util.HashMap;

public class Counter {
    private final HashMap<Class<?>, Long> counters = new HashMap<>();

    public long inc(final Class<?> clazz) {
        long counter = counters.getOrDefault(clazz, 0L);
        counters.put(clazz, counter + 1);
        return counter;
    }

    public long inc() {
        return inc(Object.class);
    }

    public HashMap<Class<?>, Long> getCounters() {
        return counters;
    }
}
