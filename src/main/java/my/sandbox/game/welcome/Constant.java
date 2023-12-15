package my.sandbox.game.welcome;

import java.util.List;

import static my.sandbox.game.welcome.Denomination.EIGHTH;
import static my.sandbox.game.welcome.Denomination.ELEVEN;
import static my.sandbox.game.welcome.Denomination.FIFTEEN;
import static my.sandbox.game.welcome.Denomination.FIVE;
import static my.sandbox.game.welcome.Denomination.FOUR;
import static my.sandbox.game.welcome.Denomination.FOURTEEN;
import static my.sandbox.game.welcome.Denomination.NINE;
import static my.sandbox.game.welcome.Denomination.ONE;
import static my.sandbox.game.welcome.Denomination.SEVEN;
import static my.sandbox.game.welcome.Denomination.SIX;
import static my.sandbox.game.welcome.Denomination.TEN;
import static my.sandbox.game.welcome.Denomination.THIRTEEN;
import static my.sandbox.game.welcome.Denomination.THREE;
import static my.sandbox.game.welcome.Denomination.TWELVE;
import static my.sandbox.game.welcome.Denomination.TWO;

public class Constant {

    public final static List<Denomination> SMALL_BONUS_CARD_VALUES = List.of(THREE, FOUR, SIX, SEVEN, EIGHTH, NINE, TEN, TWELVE, THIRTEEN);

    public final static List<Denomination> BIG_BONUS_CARD_VALUES = List.of(ONE, TWO, THREE, FIVE, FIVE, SIX, SIX, SEVEN, EIGHTH, EIGHTH, NINE, TEN, TEN, ELEVEN, ELEVEN, THIRTEEN, FOURTEEN, FIFTEEN);

    private Constant() {
    }

}
