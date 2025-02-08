package my.sandbox.common.util;

import static my.sandbox.common.constant.StringConstant.DOT;

public final class StringUtil {
    private StringUtil() {
    }

    public static String beatifyClassName(final String className) {
        int indexOfLastDot = className.lastIndexOf(DOT) + 1;
        return className.substring(indexOfLastDot);
    }

    public static String beatifyClassName(final Class<?> clazz) {
        return beatifyClassName(clazz.toString());
    }

    public static String repeat(final String value, final int times) {
        return value.repeat(times);
    }
}
