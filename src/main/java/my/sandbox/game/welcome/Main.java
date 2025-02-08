package my.sandbox.game.welcome;

import static my.sandbox.common.logger.CommonLogger.LOG;

import my.sandbox.common.game.Deck;

public final class Main {

    private Main() {

    }

    public static void main(final String[] args) {
        Deck<Card> deck = Decks.classic();
        deck.shuffle();
        for (Card card : deck.draw(3)) {
            LOG.info("{} - {} ({})", card.denomination(), card.bonus().getIcon(), card.bonus());
        }
    }
}
