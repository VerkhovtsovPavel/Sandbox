package my.sandbox.common.util;

public final class StringUtils {
    public static String beatifyClassName(final String className) {
        int indexOfLastDot = className.lastIndexOf(".") + 1;
        return className.substring(indexOfLastDot);
    }

    public static String beatifyClassName(final Class clazz) {
        return beatifyClassName(clazz.toString());
    }

    public static String repeat(final String value, final int times) {
        return value.repeat(times);
    }

    private StringUtils() {

    }
}
