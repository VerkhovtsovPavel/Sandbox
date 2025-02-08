package my.sandbox.classification.main;

import static my.sandbox.common.logger.CommonLogger.LOG;
import static my.sandbox.common.util.ConsoleScanner.CONSOLE_SCANNER;

import java.util.List;

import my.sandbox.classification.entity.Entity;

public class KMeans extends Classification {
    public KMeans(final int dispersion) {
        super(dispersion);
    }

    @Override
    protected void prepare(List<Entity> entities, List<Entity> cores) {
        // Do nothing in this classifier
    }

    @Override
    protected int getEntitiesCount() {
        LOG.info("Input count entities: ");
        return CONSOLE_SCANNER.nextInt();
    }

    @Override
    protected int getClassesCount() {
        LOG.info("Input count classes: ");
        return CONSOLE_SCANNER.nextInt();
    }
}
