package my.sandbox.common.util;

import java.util.Map;

public class LogUtil {

    public static void printMap(Map<?, ?> map) {
        for (Map.Entry<?, ?> e : map.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }

    private LogUtil() {
    }
}
