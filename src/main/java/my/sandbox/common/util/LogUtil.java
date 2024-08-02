package my.sandbox.common.util;

import static my.sandbox.common.logger.CommonLogger.LOG;

import java.util.Map;

public class LogUtil {

    public static void printMap(Map<?, ?> map) {
        for (Map.Entry<?, ?> e : map.entrySet()) {
            LOG.info(e.getKey() + ": " + e.getValue());
        }
    }

    private LogUtil() {
    }
}
