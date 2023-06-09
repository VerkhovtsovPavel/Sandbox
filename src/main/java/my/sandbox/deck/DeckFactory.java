package my.sandbox.deck;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DeckFactory {

    public <T> Deck<T> unite(final Deck<T>... decks) {
        List<T> allCards = new LinkedList<>();

        for (Deck<T> deck : decks) {
            allCards.addAll(deck.draw(deck.size()));
        }

        return new Deck<T>(allCards);
    }

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
