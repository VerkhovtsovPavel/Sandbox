package my.sandbox.common.util;

import static my.sandbox.common.logger.CommonLogger.LOG;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Use CommonLogger instwad
 */
@Deprecated
public final class LogUtil {

    public static final Logger LOG = LogManager.getLogger();


    public static void info(String message) {
        LOG.info(message);
    }

    private LogUtil() {
    }
}
