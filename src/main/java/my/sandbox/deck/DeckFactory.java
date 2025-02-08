package my.sandbox.deck;

import java.util.ArrayList;
import java.util.List;

import my.sandbox.game.common.Deck;

public class DeckFactory {
    public Deck<PlayingCard> thirtySixCardsDeck() {
        List<PlayingCard> cards =
            combinations(Suit.values(), Value.SIX, Value.SEVEN, Value.EIGHTH, Value.NINE, Value.TEN,
                Value.JACK, Value.QUEEN, Value.KING, Value.ACE);

        return new Deck<>(cards);
    }

    public Deck<PlayingCard> fiftyTwoCardsDeck() {
        List<PlayingCard> cards = combinations(Suit.values(), Value.values());
        return new Deck<>(cards);
    }

    private List<PlayingCard> combinations(final Suit[] suits, final Value... values) {
        List<PlayingCard> cards = new ArrayList<>(suits.length * values.length);
        for (Suit suit : suits) {
            for (Value value : values) {
                cards.add(new PlayingCard(suit, value));
            }
        }
        return cards;
    }
}
