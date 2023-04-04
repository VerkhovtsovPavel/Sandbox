package my.sandbox.pattern_matching;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Matcher<T> {

    private final List<Pair<Predicate<Object>, Function<Object, T>>> conditionList;
    private Function<Object, T> defaultBranch = (x) -> {
        throw new IllegalArgumentException();
    };

    private Matcher() {
        conditionList = new ArrayList<>();
    }

    public static <T> Matcher<T> match(Class<T> returnType) {
        return new Matcher<>();
    }

    public static Matcher<Object> match() {
        return match(Object.class);
    }

    public <R> ConditionAction<R> when(Class<R> clazz) {
        return new ConditionAction<>(clazz, this);
    }

    public <R> ConditionAction<R> when(Predicate<R> condition) {
        return new ConditionAction<>(condition, this);
    }

    public Matcher<T> orElse(Function<Object, T> action) {
        this.defaultBranch = action;
        return this;
    }

    public Matcher<T> orElse(T result) {
        this.defaultBranch = (x) -> result;
        return this;
    }

    public T match(Object r) {
        for (var pair : conditionList) {
            try {
                if (pair.left().test(r)) {
                    return pair.right().apply(r);
                }
            } catch (ClassCastException ignore) {
            }
        }

        return defaultBranch.apply(r);
    }

    public List<T> matchAll(Object r) {
        List<T> results = new ArrayList<>();
        for (var pair : conditionList) {
            try {
                if (pair.left().test(r)) {
                    results.add(pair.right().apply(r));
                }
            } catch (ClassCastException ignore) {
            }
        }

        return results;
    }


    public class ConditionAction<R> {
        private final Predicate<R> condition;
        private final Matcher<T> matcher;

        private ConditionAction(Predicate<R> condition, Matcher<T> matcher) {
            this.condition = condition;
            this.matcher = matcher;
        }

        private ConditionAction(Class<R> clazz, Matcher<T> matcher) {
            this.condition = (c) -> c.getClass().equals(clazz);
            this.matcher = matcher;
        }

        public Matcher<T> then(Function<R, T> action) {
            matcher.conditionList.add(new Pair<>(
                    (Predicate<Object>) condition,
                    (Function<Object, T>) action));
            return matcher;
        }

        public Matcher<T> then(T result) {
            Function<R, T> action = (R x) -> result;
            return then(action);
        }
    }
}
