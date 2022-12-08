package pattern_matching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Matcher<T> implements Function<Object, T> {

    private final HashMap<Class<?>, Function<Object, T>> classBranches;
    private final List<Pair<Predicate<Object>, Function<Object, T>>> conditionList;
    private Function<Object, T> defaultBranch = (x) -> { throw new IllegalArgumentException(); };

    private Matcher() {
        classBranches = new HashMap<>();
        conditionList = new ArrayList<>();
    }

    public static <T> Matcher<T> match(Class<T> returnType) {
        return new Matcher<T>();
    }

    public static Matcher<Object> match() {
        return match(Object.class);
    }

    public <R> ClassAction<R> when(Class<R> clazz) {
        return new ClassAction<>(clazz, this);
    }

    public <R> ConditionAction<R> when(Predicate<R> condition) {
        return new ConditionAction<>(condition, this);
    }

    public Matcher<T> orElse(Function<Object, T> action) {
        this.defaultBranch = action;
        return this;
    }

    @Override
    public T apply(Object r) {

        for(Pair<Predicate<Object>, Function<Object, T>> pair : conditionList) {
            try {
                if (pair.getLeft().test(r)) {
                    return pair.getRight().apply(r);
                }
            } catch(ClassCastException ignore) {}
        }

        if (classBranches.containsKey(r.getClass())) {
            return classBranches.get(r.getClass()).apply(r);
        }

        return defaultBranch.apply(r);
    }

    public class ClassAction<R> {
        private final Class<R> clazz;
        private final Matcher matcher;

        private ClassAction(Class<R> clazz, Matcher<T> matcher) {
            this.clazz = clazz;
            this.matcher = matcher;
        }

        public Matcher<T> then(Function<R, T> action) {
            matcher.classBranches.put(clazz, action);
            return matcher;
        }
    }

    public class ConditionAction<R> {
        private final Predicate<R> condition;
        private final Matcher matcher;

        private ConditionAction(Predicate<R> condition, Matcher<T> matcher) {
            this.condition = condition;
            this.matcher = matcher;
        }

        public Matcher<T> then(Function<R, T> action) {
            matcher.conditionList.add(new Pair<>(condition, action));
            return matcher;
        }
    }
}
