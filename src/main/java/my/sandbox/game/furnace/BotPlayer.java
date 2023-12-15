package my.sandbox.game.furnace;

import my.sandbox.common.util.Randomizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class BotPlayer implements Player {

    private final List<Card> cards;
    private final Queue<Integer> disks;
    private final BotMode mode;
    private final PlayerColor color;

    public BotPlayer(List<Card> cards, Queue<Integer> disks, BotMode upside, PlayerColor color) {
        this.cards = cards;
        this.disks = disks;
        this.mode = upside;
        this.color = color;
    }

    public void applyDisk() {
        int initialCard = rollDice();
        Integer currentDisk = disks.poll();
        List<Card> round = buildTheRound(initialCard, cards, mode);
        for (Card card : round) {
            if (!card.disks().containsKey(color)) {
                if (!card.disks().containsValue(currentDisk)) {
                    card.disks().put(color, currentDisk);
                    System.out.printf("Bot[%s] put %d disk on %d card%n", color, currentDisk, card.numberInRow() + 1);
                    break;
                }
            }
        }
    }

    private int rollDice() {
        return 1 + Randomizer.nextInt(cards.size() - 1);
    }

    private List<Card> buildTheRound(int initialCard, List<Card> cards, BotMode mode) {
        List<Card> round = new ArrayList<>();
        switch (mode) {
            case UPSIDE -> {
                round.addAll(cards.subList(initialCard, cards.size()));
                round.addAll(cards.subList(0, initialCard));
            }
            case DOWNSIDE -> {
                round.addAll(cards.subList(0, initialCard));
                round.addAll(cards.subList(initialCard, cards.size()));
                Collections.reverse(round);
            }
        }
        return round;
    }
}

