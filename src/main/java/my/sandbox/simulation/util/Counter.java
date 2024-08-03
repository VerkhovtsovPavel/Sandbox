package my.sandbox.simulation.util;

import java.util.HashMap;
import java.util.Map;


public class Counter {
    private final Map<Class<?>, Long> counters = new HashMap<>();

    public long inc(final Class<?> clazz) {
        long counter = counters.getOrDefault(clazz, 0L);
        counters.put(clazz, counter + 1);
        return counter;
    }

    public long inc() {
        return inc(Object.class);
    }

    public Map<Class<?>, Long> getCounters() {
        return counters;
    }
}
