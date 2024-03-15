package my.sandbox.common.game;

import my.sandbox.common.util.Randomizer;

public class DiceFactory {

    public static Dice d4() {
        return () -> Randomizer.nextInt(1,4);
    }
    public static Dice d6() {
        return () -> Randomizer.nextInt(1,6);
    }

    public static Dice dN(int bound) {
        return () -> Randomizer.nextInt(1,bound);
    }
}
