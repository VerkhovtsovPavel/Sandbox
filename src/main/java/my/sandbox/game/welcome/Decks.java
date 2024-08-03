package my.sandbox.game.welcome;

import my.sandbox.common.game.Deck;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class Decks {

    public static Deck<Card> classic() {
        List<Card> cards = new ArrayList<>();
        cards.addAll(smallBonusCards(BaseBonus.POOL_MANUFACTURER));
        cards.addAll(smallBonusCards(BaseBonus.TEMP_AGENCY));
        cards.addAll(smallBonusCards(BaseBonus.BIS));
        cards.addAll(bigBonusCards(BaseBonus.SURVEYOR));
        cards.addAll(bigBonusCards(BaseBonus.LANDSCAPER));
        cards.addAll(bigBonusCards(BaseBonus.REAL_ESTATE_AGENT));
        return new Deck<>(cards);
    }

    private static List<Card> smallBonusCards(BaseBonus bonus) {
       return Constant.SMALL_BONUS_CARD_VALUES.stream()
                .map(value -> new Card(bonus, value))
                .collect(Collectors.toList());
    }

    private static List<Card> bigBonusCards(BaseBonus bonus) {
        return Constant.BIG_BONUS_CARD_VALUES.stream()
                .map(value -> new Card(bonus, value))
                .collect(Collectors.toList());
    }

    private Decks() {
    }
}
