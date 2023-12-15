package my.sandbox.common.util;

import java.util.function.Consumer;

public class ExecutionUtils {

    public static void times(long times, Consumer<Number> body) {
        for (long i = 0; i < times; i++) {
            body.accept(i);
        }
    }

    public static void times(long times, Runnable body) {
        for (long i = 0; i < times; i++) {
            body.run();
        }
    }
}
