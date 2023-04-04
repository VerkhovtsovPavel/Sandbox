package my.sandbox.group;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> list = List.of("abc", "cba", "foo", "bar");
        printMap(groupBy(list, item -> item.chars().mapToObj(ch -> (char) ch).collect(Collectors.toSet())));
        System.out.println(Set.of('a', 'b', 'c').equals(Set.of('c', 'b', 'a')));
    }

    private static <V, K> Map<V, List<K>> groupBy(Collection<K> collection, Function<K, V> groupCondition) {
        HashMap<V, List<K>> groups = new HashMap<>();

        for (K item : collection) {
            V groupIdentifier = groupCondition.apply(item);
            List<K> currentGroup = groups.getOrDefault(groupIdentifier, new ArrayList<>());
            currentGroup.add(item);
            groups.put(groupIdentifier, currentGroup);
        }

        return groups;
    }

    private static void printMap(Map<?, ?> map) {
        for (Map.Entry<?, ?> e : map.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }
}
