package my.sandbox.deck;

public class Card {

    private final Suit suit;
    private final Value value;

    public Card(final Suit cardSuit, final Value cardValue) {
        this.suit = cardSuit;
        this.value = cardValue;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }
}
