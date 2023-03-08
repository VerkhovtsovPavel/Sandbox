package my.sandbox.simulation.util;

public final class StringUtils {

    private StringUtils() {

    }

    public static String beatifyClassName(final String className) {
        int indexOfLastDot = className.lastIndexOf(".") + 1;
        return className.substring(indexOfLastDot);
    }

    public static String beatifyClassName(final Class clazz) {
        return beatifyClassName(clazz.toString());
    }
}
