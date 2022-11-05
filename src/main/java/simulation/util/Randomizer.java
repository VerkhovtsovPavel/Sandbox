package simulation.util;

import java.util.Random;

public class Randomizer {

    private static Random random = new Random(System.currentTimeMillis());

    public static double nextDouble() {
        return random.nextDouble();
    }

    public static int nextInt(int bound) {
        return random.nextInt(bound);
    }
}
