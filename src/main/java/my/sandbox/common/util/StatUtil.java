package my.sandbox.common.util;

import java.util.List;
import java.util.function.Function;

public final class StatUtil {
    private StatUtil() {
    }

    public static Number median(List<? extends Number> sortedValues) {
        int halfSize = sortedValues.size() / 2;
        if (sortedValues.size() % 2 == 0) {
            return (sortedValues.get(halfSize).doubleValue() + sortedValues.get(halfSize - 1).doubleValue()) / 2;
        }
        else {
            return sortedValues.get(halfSize);
        }
    }

    public static double average(List<? extends Number> values) {
        return values.stream().mapToDouble(Number::doubleValue).average().orElse(0.0);
    }

    public static <T> double average(List<T> values, Function<T, ? extends Number> mapper) {
        return average(values.stream().map(mapper).toList());
    }

    public static <T> T percentile(List<T> values, double th) {
        int valueIndex = (int) (values.size() * th);
        return values.get(valueIndex);
    }
}
