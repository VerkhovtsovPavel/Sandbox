package pattern_matching;

import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class Matcher<T> implements Function<Object, T> {

    private final HashMap<Class<?>, Function<Object, T>> branches;
    private Function<Object, T> defaultBranch = (x) -> { throw new IllegalArgumentException(); };

    private Matcher() {
        branches = new HashMap<>();
    }

    public static <T> Matcher<T> match(Class<T> returnType) {
        return new Matcher<T>();
    }

    public static Matcher<Object> match() {
        return match(Object.class);
    }

    public <R> Action<R> when(Class<R> clazz) {
        return new Action<>(clazz, this);
    }

    public <R> Action<R> when(Class<R> clazz, Predicate<R> condition) {
        //TODO: Update implementation for enable conditions
        return new Action<>(clazz, this);
    }

    public Matcher<T> orElse(Function<Object, T> action) {
        this.defaultBranch = action;
        return this;
    }

    @Override
    public T apply(Object r) {
        if (branches.containsKey(r.getClass())) {
            return branches.get(r.getClass()).apply(r);
        } else {
            return defaultBranch.apply(r);
        }
    }

    public class Action<R> {
        private final Class<R> clazz;
        private final Matcher matcher;

        private Action(Class<R> clazz, Matcher<T> matcher) {
            this.clazz = clazz;
            this.matcher = matcher;
        }

        public Matcher<T> then(Function<R, T> action) {
            matcher.branches.put(clazz, action);
            return matcher;
        }
    }
}
