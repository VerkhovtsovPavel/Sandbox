package my.sandbox.classification.util;

import java.util.List;

import my.sandbox.classification.entity.Entity;

public final class MathUtils {
    private MathUtils() {
    }

    public static double distance(final Entity first, final Entity second) {
        return Math.sqrt(sqrDistance(first, second));
    }

    public static double sqrDistance(final Entity first, final Entity second) {
        return Math.pow(Math.abs(first.getX() - second.getX()), 2)
            + Math.pow(Math.abs(first.getY() - second.getY()), 2);
    }

    public static double getAverageDeviation(final List<Entity> entities, final Entity core) {
        double sum = 0;
        for (Entity entity : entities) {
            if (entity.getAreaNumber() == core.getAreaNumber()) {
                sum += sqrDistance(entity, core);
            }
        }
        return Math.sqrt(sum / entities.size());
    }
}
