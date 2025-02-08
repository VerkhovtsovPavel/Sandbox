package my.sandbox.classification.util;

import java.util.ArrayList;
import java.util.List;
import my.sandbox.classification.entity.Entity;

public final class CloneUtils {

    private CloneUtils() {
    }

    public static List<Entity> clone(final List<Entity> list) {
        List<Entity> clonedList = new ArrayList<>(list.size());
        for (Entity item : list) {
            clonedList.add(item.clone());
        }
        return clonedList;
    }
}
