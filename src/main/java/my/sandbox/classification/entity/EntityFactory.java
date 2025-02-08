package my.sandbox.classification.entity;

import java.util.ArrayList;
import java.util.List;
import my.sandbox.common.util.Randomizer;

public final class EntityFactory {

    private EntityFactory() {
    }

    public static List<Entity> generate(final int dispersion, final int count) {
        List<Entity> entities = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            entities.add(new Entity(Randomizer.nextInt(dispersion), Randomizer.nextInt(dispersion)));
        }
        return entities;
    }

    public static List<Entity> selectRandomEntities(final List<Entity> entities, final int count) {
        List<Entity> centers = new ArrayList<>();
        while (centers.size() != count) {
            Entity center = entities.get(Randomizer.nextInt(entities.size()));
            if (!centers.contains(center)) {
                center.setAreaNumber(centers.size());
                centers.add(center);
            }
        }
        return centers;
    }
}
