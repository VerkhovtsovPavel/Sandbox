package my.sandbox.common.util.compare;

public final class CompareUtil {
    private CompareUtil() {
    }

    public static <T extends Comparable<T>> CompareResult compare(T left, T right) {
        int intResult = left.compareTo(right);

        if (intResult == 0) {
            return CompareResult.EQUAL;
        }
        else if (intResult > 0) {
            return CompareResult.MORE;
        }
        else {
            return CompareResult.LESS;
        }
    }
}
