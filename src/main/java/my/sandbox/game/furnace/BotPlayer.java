package my.sandbox.game.furnace;

import static java.lang.String.format;
import static my.sandbox.common.logger.CommonLogger.LOG;

import my.sandbox.common.game.Dice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class BotPlayer implements Player {

    private final List<Card> cards;
    private final Queue<Integer> disks;
    private final BotMode mode;
    private final PlayerColor color;
    private final Dice dice;

    public BotPlayer(List<Card> cards, Queue<Integer> disks, BotMode upside, PlayerColor color, Dice dice) {
        this.cards = cards;
        this.disks = disks;
        this.mode = upside;
        this.color = color;
        this.dice = dice;
    }

    @Override
    public void applyDisk() {
        int initialCard = dice.roll();
        Integer currentDisk = disks.poll();
        List<Card> round = buildTheRound(initialCard, cards, mode);
        for (Card card : round) {
            var disks = card.disks();
            if (!disks.containsKey(color) && !disks.containsValue(currentDisk)) {
                disks.put(color, currentDisk);
                LOG.info(format("Bot[%s] put %d disk on %d card%n", color, currentDisk, card.numberInRow() + 1));
                break;
            }
        }
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
            default -> throw new IllegalArgumentException(mode.toString());
        }
        return round;
    }
}

