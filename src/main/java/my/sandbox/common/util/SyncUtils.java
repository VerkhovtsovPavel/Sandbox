package my.sandbox.common.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class SyncUtils {
    private static final Map<String, BlockingQueue<Object>> SYNCS = new HashMap<>();

    private SyncUtils() {
    }

    public static void register(final String key) {
        SYNCS.put(key, new ArrayBlockingQueue<>(1));
    }

    public static void wait(final String key) {
        BlockingQueue<Object> queue = SYNCS.get(key);
        if (queue != null) {
            try {
                queue.take();
            }
            catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public static void notify(final String key) {
        BlockingQueue<Object> queue = SYNCS.get(key);
        if (queue != null) {
            queue.add(new Object());
        }
    }
}
