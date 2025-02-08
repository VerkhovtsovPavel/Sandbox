package my.sandbox.common.util;

import static my.sandbox.common.logger.CommonLogger.LOG;

import java.util.HashMap;
import java.util.Map;

public final class MapUtil {
    private MapUtil() {
    }

    public static void printMap(Map<?, ?> map) {
        for (Map.Entry<?, ?> e : map.entrySet()) {
            LOG.info(e.getKey() + ": " + e.getValue());
        }
    }

    public static <K> void increase(HashMap<K, Integer> map, K key, Integer value) {
        map.put(key, map.getOrDefault(key, 0) + value);
    }
}
