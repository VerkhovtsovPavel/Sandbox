package my.sandbox.game.common;

import static my.sandbox.common.constant.IntConstant.FOUR;
import static my.sandbox.common.constant.IntConstant.ONE;
import static my.sandbox.common.constant.IntConstant.SIX;

import my.sandbox.common.util.Randomizer;

@SuppressWarnings("PMD.ShortMethodName")
public final class DiceFactory {
    private DiceFactory() {
    }

    public static Dice d4() {
        return () -> Randomizer.nextInt(ONE, FOUR);
    }

    public static Dice d6() {
        return () -> Randomizer.nextInt(ONE, SIX);
    }

    public static Dice dN(int bound) {
        return () -> Randomizer.nextInt(ONE, bound);
    }
}
