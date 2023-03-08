package my.sandbox.simulation.util;

import java.util.Random;

public final class Randomizer {

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    private Randomizer() {
    }

    public static double nextDouble() {
        return RANDOM.nextDouble();
    }

    public static int nextInt(final int bound) {
        return RANDOM.nextInt(bound);
    }
}
