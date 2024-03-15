package my.sandbox.common.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

public class Deck<T> {

    private final Queue<T> cards;

    public Deck(List<T> cards) {
        this.cards = new LinkedList<>();
        this.cards.addAll(cards);
    }

    public Optional<T> draw() {
        return Optional.ofNullable(cards.poll());
    }

    public List<T> draw(int count) {
        List<T> cardsToDraw = new ArrayList<>(count);
        int cardsCount = Math.min(count, cards.size());
        for (int i = 0; i < cardsCount; i++) {
            cardsToDraw.add(cards.poll());
        }
        return cardsToDraw;
    }

    public void shuffle() {
        Collections.shuffle((LinkedList<T>) cards);
    }

    public int size() {
        return cards.size();
    }
}
