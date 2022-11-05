package simulation.util;

public class StringUtils {

    static public String beatifyClassName(String className) {
        int indexOfLastDot = className.lastIndexOf(".") + 1;
        return className.substring(indexOfLastDot);
    }

    static public String beatifyClassName(Class clazz) {
        return beatifyClassName(clazz.toString());
    }
}
