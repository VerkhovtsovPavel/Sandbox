package my.sandbox.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

public class Deck {

    private final Queue<Card> cards;

    public Deck(List<Card> cards) {
        this.cards = new LinkedList<>();
        this.cards.addAll(cards);
    }

    public Optional<Card> draw() {
        return Optional.ofNullable(cards.poll());
    }

    public List<Card> draw(int count) {
        List<Card> cardsToDraw = new ArrayList<>(count);
        int cardsCount = Math.min(count, cards.size());
        for(int i = 0; i < cardsCount; i++) {
            cardsToDraw.add(cards.poll());
        }
        return cardsToDraw;
    }

    public void shuffle() {
        Collections.shuffle((LinkedList<Card>)cards);
    }

    public int size() {
        return cards.size();
    }
}
