package my.sandbox.classification.main;

import my.sandbox.classification.entity.Entity;
import my.sandbox.classification.entity.EntityFactory;
import my.sandbox.classification.graphics.GraphicsClass;
import my.sandbox.classification.util.MathUtils;
import my.sandbox.classification.util.SyncUtils;

import java.util.List;

import static my.sandbox.classification.util.Constants.UI_REDRAW_EVENT;

public abstract class Classification {

    private final int dispersion;

    public Classification(final int dispersion) {
        this.dispersion = dispersion;
    }

    public final void process() {
        int objectCount = getEntitiesCount();
        System.out.println("[*] Generate entities");
        List<Entity> entities = EntityFactory.generate(dispersion, objectCount);
        System.out.println("[x] Entities generated");
        int classCount = getClassesCount();
        List<Entity> entityCores = EntityFactory.selectRandomEntities(entities, classCount);

        System.out.println("[x] Initial dividing");
        divideObjectsOnClasses(entities, entityCores);
        System.out.println("[x] Entities initially divided");

        SyncUtils.register(UI_REDRAW_EVENT);
        GraphicsClass.setScreenSize(dispersion);
        GraphicsClass.bindEntityLists(entities, entityCores);

        GraphicsClass.visualizeClasses("Before");
        SyncUtils.wait(UI_REDRAW_EVENT);

        System.out.println("[x] Prepare entities");
        prepare(entities, entityCores);
        System.out.println("[x] Entities prepared");

        System.out.println("[x] Classify entities");
        classify(entities, entityCores);
        System.out.println("[x] Entities classified");

        GraphicsClass.visualizeClasses("After");
        SyncUtils.wait(UI_REDRAW_EVENT);
    }

    protected void prepare(final List<Entity> entities, final List<Entity> cores) {
    }

    protected void classify(final List<Entity> entities, final List<Entity> cores) {
        while (checkOptimalityDivision(entities, cores)) {
            divideObjectsOnClasses(entities, cores);
        }
    }

    protected void divideObjectsOnClasses(final List<Entity> entities, final List<Entity> cores) {
        for (Entity entity : entities) {
            entity.choiceArea(cores);
        }
    }

    protected boolean checkOptimalityDivision(final List<Entity> entities, final List<Entity> cores) {
        boolean redefinitionClasses = false;
        for (Entity entity : entities) {
            double currentKernelDeviation = MathUtils.getAverageDeviation(entities, cores.get(entity.getAreaNumber()));
            double candidateKernelDeviation = MathUtils.getAverageDeviation(entities, entity);
            if (candidateKernelDeviation < currentKernelDeviation) {
                cores.set(entity.getAreaNumber(), entity);
                redefinitionClasses = true;
            }
        }
        return redefinitionClasses;
    }

    protected abstract int getEntitiesCount();

    protected abstract int getClassesCount();
}
