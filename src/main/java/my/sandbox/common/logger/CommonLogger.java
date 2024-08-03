package my.sandbox.common.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public final class CommonLogger {

	public static final Logger LOG = LogManager.getLogger();

	private CommonLogger() {}
}
