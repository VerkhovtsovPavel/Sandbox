package my.sandbox.common.game;

import java.util.LinkedList;
import java.util.List;

public class DeckUtil {
    public <T> Deck<T> unite(final Deck<T>... decks) {
        List<T> allCards = new LinkedList<>();

        for (Deck<T> deck : decks) {
            allCards.addAll(deck.draw(deck.size()));
        }

        return new Deck<T>(allCards);
    }
}
