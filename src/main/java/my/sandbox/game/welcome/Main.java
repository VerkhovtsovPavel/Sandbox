package my.sandbox.game.welcome;

import my.sandbox.deck.Deck;

public final class Main {

    private Main() {

    }

    public static void main(final String[] args) {
        Deck<Card> deck = Decks.classic();
        deck.shuffle();
        for (Card card : deck.draw(3)) {
            System.out.println(card.bonus());
            System.out.println(card.denomination() + " - " + card.bonus().getIcon());
        }
    }
}
