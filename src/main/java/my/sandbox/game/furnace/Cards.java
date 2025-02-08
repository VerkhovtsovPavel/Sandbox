package my.sandbox.game.furnace;

import static my.sandbox.common.util.ExecutionUtil.times;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Cards {
    private final List<Card> cards = new LinkedList<>();

    public Cards(int cardsInRow) {
        times(cardsInRow, i -> cards.add(new Card(i.longValue() + 1, new HashMap<>())));
    }

    public void clean() {
        cards.forEach(card -> card.disks().clear());
    }

    public List<Card> getCards() {
        return cards;
    }
}
