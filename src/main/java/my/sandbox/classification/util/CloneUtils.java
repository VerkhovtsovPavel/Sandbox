package my.sandbox.classification.util;

import my.sandbox.classification.entity.Entity;

import java.util.ArrayList;
import java.util.List;

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
