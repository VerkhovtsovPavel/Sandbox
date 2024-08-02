package my.sandbox.classification.main;

import static my.sandbox.common.logger.CommonLogger.LOG;

import java.util.List;
import java.util.Scanner;

import my.sandbox.classification.entity.Entity;


public class KMeans extends Classification {

    public KMeans(final int dispersion) {
        super(dispersion);
    }

    @Override
    protected int getEntitiesCount() {
        LOG.info("Input count entities: ");
        return (new Scanner(System.in)).nextInt();
    }

    @Override
    protected int getClassesCount() {
        LOG.info("Input count classes: ");
        return (new Scanner(System.in)).nextInt();
    }
}
