package my.sandbox.game.welcome;

import java.util.List;

public final class Constant {

    public final static List<Denomination> SMALL_BONUS_CARD_VALUES = List.of(Denomination.THREE, Denomination.FOUR, Denomination.SIX, Denomination.SEVEN, Denomination.EIGHTH, Denomination.NINE, Denomination.TEN, Denomination.TWELVE, Denomination.THIRTEEN);

    public final static List<Denomination> BIG_BONUS_CARD_VALUES = List.of(Denomination.ONE, Denomination.TWO, Denomination.THREE, Denomination.FIVE, Denomination.FIVE, Denomination.SIX, Denomination.SIX, Denomination.SEVEN, Denomination.EIGHTH, Denomination.EIGHTH, Denomination.NINE, Denomination.TEN, Denomination.TEN, Denomination.ELEVEN, Denomination.ELEVEN, Denomination.THIRTEEN, Denomination.FOURTEEN, Denomination.FIFTEEN);

    private Constant() {
    }

}