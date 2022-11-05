package simulation.util;

import java.util.HashMap;

public class Counter {

    private Class defaultClass;

    public Counter() {
        this.defaultClass = Object.class;
    }

    public Counter(Class defaultClass) {
        this.defaultClass = defaultClass;
    }

    private HashMap<Class, Long> counters = new HashMap<>();

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
