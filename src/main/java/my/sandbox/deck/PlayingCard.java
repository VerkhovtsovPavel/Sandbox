package my.sandbox.deck;

public class PlayingCard {
    private final Suit suit;
    private final Value value;

    public PlayingCard(final Suit cardSuit, final Value cardValue) {
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
