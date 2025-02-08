package my.sandbox.classification.main;

import static my.sandbox.classification.util.Constants.UI_REDRAW_EVENT;
import static my.sandbox.common.logger.CommonLogger.LOG;
import java.util.List;
import my.sandbox.classification.entity.Entity;
import my.sandbox.classification.entity.EntityFactory;
import my.sandbox.classification.graphics.GraphicsClass;
import my.sandbox.classification.util.MathUtils;
import my.sandbox.classification.util.SyncUtils;

public abstract class Classification {

    private final int dispersion;

    public Classification(final int dispersion) {
        this.dispersion = dispersion;
    }

    public final void process() {
        int objectCount = getEntitiesCount();
        LOG.info("[*] Generate entities");
        List<Entity> entities = EntityFactory.generate(dispersion, objectCount);
        LOG.info("[x] Entities generated");
        int classCount = getClassesCount();
        List<Entity> entityCores = EntityFactory.selectRandomEntities(entities, classCount);

        LOG.info("[*] Initial dividing");
        divideObjectsOnClasses(entities, entityCores);
        LOG.info("[x] Entities initially divided");

        SyncUtils.register(UI_REDRAW_EVENT);
        GraphicsClass.setScreenSize(dispersion);
        GraphicsClass.bindEntityLists(entities, entityCores);

        GraphicsClass.visualizeClasses("Before");
        SyncUtils.wait(UI_REDRAW_EVENT);

        LOG.info("[*] Prepare entities");
        prepare(entities, entityCores);
        LOG.info("[x] Entities prepared");

        LOG.info("[*] Classify entities");
        classify(entities, entityCores);
        LOG.info("[x] Entities classified");

        GraphicsClass.visualizeClasses("After");
        SyncUtils.wait(UI_REDRAW_EVENT);
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

    protected abstract void prepare(List<Entity> entities, List<Entity> cores);

    protected abstract int getEntitiesCount();

    protected abstract int getClassesCount();
}
