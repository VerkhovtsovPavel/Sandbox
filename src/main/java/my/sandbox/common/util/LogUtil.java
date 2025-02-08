package my.sandbox.common.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @deprecated Use CommonLogger instead
 */
@Deprecated(forRemoval = true, since = "0.1")
public final class LogUtil {
    @Deprecated(forRemoval = true, since = "0.1")
    public static final Logger LOG = LogManager.getLogger();

    private LogUtil() {
    }

    @Deprecated(forRemoval = true, since = "0.1")
    public static void info(String message) {
        LOG.info(message);
    }
}
