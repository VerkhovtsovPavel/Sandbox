package my.sandbox.classification.main;

import my.sandbox.classification.entity.Entity;
import my.sandbox.classification.util.MathUtils;

import java.util.List;
import java.util.Scanner;

/**
 * Main class for Max-Min approach
 */
//TODO Use same keywords: core, class, entity
public class MaxMin extends Classification {

    private static final int INITIAL_CLASSES_COUNT = 2;
    private Entity entityWithMaxDistance;

    public MaxMin(final int dispersion) {
        super(dispersion);
    }

    @Override
    protected int getEntitiesCount() {
        System.out.print("Input count of objects: ");
        return (new Scanner(System.in)).nextInt();
    }

    @Override
    protected int getClassesCount() {
        return INITIAL_CLASSES_COUNT;
    }

    @Override
    protected void prepare(final List<Entity> entities, final List<Entity> cores) {
        while (findMaximumDistanceFromClassKernel(entities, cores) > calculateNormDistance(cores)) {
            cores.add(entityWithMaxDistance);
            divideObjectsOnClasses(entities, cores);
        }
    }

    private double calculateNormDistance(final List<Entity> cores) {
        double normDistance = 0;
        for (Entity first : cores) {
            for (Entity second : cores) {
                normDistance += MathUtils.distance(first, second);
            }
        }
        return normDistance / (2 * cores.size() * (cores.size() - 1));
    }

    private double findMaximumDistanceFromClassKernel(final List<Entity> entities, final List<Entity> cores) {
        double maxDistance = 0;
        for (Entity entity : entities) {
            double distance = MathUtils.distance(entity, cores.get(entity.getAreaNumber()));
            if (distance > maxDistance) {
                maxDistance = distance;
                entityWithMaxDistance = entity;
            }
        }
        return maxDistance;
    }
}
