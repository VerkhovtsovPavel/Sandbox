package my.sandbox.group;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public final class GroupBy {
    private GroupBy() {
    }

    public static <V, K> Map<V, List<K>> groupBy(Collection<K> collection, Function<K, V> groupCondition) {
        HashMap<V, List<K>> groups = new HashMap<>();

        for (K item : collection) {
            V groupIdentifier = groupCondition.apply(item);
            List<K> currentGroup = groups.getOrDefault(groupIdentifier, new ArrayList<>());
            currentGroup.add(item);
            groups.put(groupIdentifier, currentGroup);
        }

        return groups;
    }
}
