package my.sandbox.common.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Use CommonLogger instwad
 */
@Deprecated
public final class LogUtil {

    @Deprecated
    public static final Logger LOG = LogManager.getLogger();

    @Deprecated
    public static void info(String message) {
        LOG.info(message);
    }

    private LogUtil() {
    }
}
