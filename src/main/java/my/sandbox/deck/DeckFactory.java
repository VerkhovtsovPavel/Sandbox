package my.sandbox.deck;

import my.sandbox.common.game.Deck;

import java.util.ArrayList;
import java.util.List;

public class DeckFactory {

    public Deck<Card> thirtySixCardsDeck() {
        List<Card> cards = combinations(Suit.values(),
                new Value[]{
                        Value.SIX,
                        Value.SEVEN,
                        Value.EIGHTH,
                        Value.NINE,
                        Value.TEN,
                        Value.JACK,
                        Value.QUEEN,
                        Value.KING,
                        Value.ACE
                });

        return new Deck<>(cards);
    }

    public Deck<Card> fiftyTwoCardsDeck() {
        List<Card> cards = combinations(Suit.values(), Value.values());
        return new Deck<>(cards);
    }

    private List<Card> combinations(final Suit[] suits, final Value[] values) {
        List<Card> cards = new ArrayList<>(suits.length * values.length);
        for (Suit suit : suits) {
            for (Value value : values) {
                cards.add(new Card(suit, value));
            }
        }
        return cards;
    }
}
