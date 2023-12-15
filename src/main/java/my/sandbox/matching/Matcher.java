package my.sandbox.matching;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import my.sandbox.common.structure.Pair;

public class Matcher<R> {

    private final List<Pair<Predicate<Object>, Function<Object, R>>> conditionList;
    private Function<Object, R> defaultBranch = (x) -> {
        throw new IllegalArgumentException();
    };

    private Matcher() {
        conditionList = new ArrayList<>();
    }

    public static <R> Matcher<R> match(Class<R> returnType) {
        return new Matcher<>();
    }

    public static Matcher<Object> match() {
        return match(Object.class);
    }

    public <T> ConditionAction<T> when(Class<T> clazz) {
        return new ConditionAction<>(clazz, this);
    }

    public <T> ConditionAction<T> when(Predicate<T> condition) {
        return new ConditionAction<>(condition, this);
    }

    public Matcher<R> orElse(Function<Object, R> action) {
        this.defaultBranch = action;
        return this;
    }

    public Matcher<R> orElse(R result) {
        this.defaultBranch = (x) -> result;
        return this;
    }

    public R match(Object r) {
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

    public List<R> matchAll(Object r) {
        List<R> results = new ArrayList<>();
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


    public class ConditionAction<T> {
        private final Predicate<T> condition;
        private final Matcher<R> matcher;

        private ConditionAction(Predicate<T> condition, Matcher<R> matcher) {
            this.condition = condition;
            this.matcher = matcher;
        }

        private ConditionAction(Class<T> clazz, Matcher<R> matcher) {
            this.condition = (c) -> c.getClass().equals(clazz);
            this.matcher = matcher;
        }

        public Matcher<R> then(Function<T, R> action) {
            matcher.conditionList.add(new Pair<>(
                    (Predicate<Object>) condition,
                    (Function<Object, R>) action));
            return matcher;
        }

        public Matcher<R> then(R result) {
            Function<T, R> action = (T x) -> result;
            return then(action);
        }
    }
}
