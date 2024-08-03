package my.sandbox.common.util;

import static my.sandbox.common.logger.CommonLogger.LOG;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public final class LogUtil {

    public static final Logger LOG = LogManager.getLogger();

    public static void printMap(Map<?, ?> map) {
        for (Map.Entry<?, ?> e : map.entrySet()) {
            LOG.info(e.getKey() + ": " + e.getValue());
        }
    }

    public static void info(String message) {
        LOG.info(message);
    }

    private LogUtil() {
    }
}
