package my.sandbox.common.util;

import java.util.Random;

public final class Randomizer {

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    public static double nextDouble() {
        return RANDOM.nextDouble();
    }

    public static int nextInt(final int bound) {
        return RANDOM.nextInt(bound);
    }

    public static boolean nextBoolean() {
        return RANDOM.nextBoolean();
    }

    private Randomizer() {
    }
}
