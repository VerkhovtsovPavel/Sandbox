package pattern_matching;

import java.util.HashMap;
import java.util.function.Function;

public class Matcher<T> implements Function<Object, T> {

    private HashMap<Class<?>, Function<Object, T>> braches;

    private Matcher() {
        braches = new HashMap<>();
    }

    public static <T> Matcher<T> match(Class<T> clazz) {
        return new Matcher<T>();
    }

    public <R> Action<R> when(Class<R> clazz) {
        return new Action<>(clazz, this);
    }

    @Override
    public T apply(Object r) {
        if(braches.containsKey(r.getClass())) {
            return braches.get(r.getClass()).apply(r);
        } else
            throw new IllegalArgumentException();
    }

    public class Action<R> {
        private Class<R> clazz;
        private Matcher matcher;

        private Action(Class<R> clazz, Matcher<T> matcher){
            this.clazz = clazz;
            this.matcher = matcher;
        }

        public Matcher<T> then(Function<R, T> action){
            matcher.braches.put(clazz, action);
            return matcher;
        }
    }
}
