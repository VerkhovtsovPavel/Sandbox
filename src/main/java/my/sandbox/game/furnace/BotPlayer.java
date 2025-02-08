package my.sandbox.game.furnace;

import static my.sandbox.common.logger.CommonLogger.LOG;

import java.util.*;

import my.sandbox.common.game.Dice;

public class BotPlayer implements Player {

    private List<Card> cards;
    private Queue<Integer> disks;
    private final BotMode mode;
    private final PlayerColor color;
    private final Dice dice;

    public BotPlayer(BotMode upside, PlayerColor color, Dice dice) {
        this.mode = upside;
        this.color = color;
        this.dice = dice;
    }

    public void setRound(List<Card> cards, Queue<Integer> disks) {
        this.cards = cards;
        this.disks = disks;
    }

    @Override
    public void applyDisk() {
        int initialCard = dice.roll();
        LOG.debug("Bot[{}] rolled {}",color, initialCard);
        Integer currentDisk = disks.poll();
        List<Card> round = buildTheRound(initialCard, cards, mode);
        for (Card card : round) {
            var disks = card.disks();
            if (!disks.containsKey(color) && !disks.containsValue(currentDisk)) {
                disks.put(color, currentDisk);
                LOG.info("Bot[{}] put {} disk on {} card", color, currentDisk, card.numberInRow());
                break;
            }
        }
    }

    private List<Card> buildTheRound(int initialCard, List<Card> cards, BotMode mode) {
        List<Card> round = new ArrayList<>();
        switch (mode) {
            case UPSIDE -> {
                round.addAll(cards.subList(initialCard - 1, cards.size()));
                round.addAll(cards.subList(0, initialCard - 1));
            }
            case DOWNSIDE -> {
                round.addAll(cards.subList(0, initialCard));
                Collections.reverse(round);
                List<Card> secondPart = new ArrayList<>(cards.subList(initialCard, cards.size()));
                Collections.reverse(secondPart);
                round.addAll(secondPart);
            }
            case IMPULSIVE -> {
                round.addAll(cards);
                Collections.shuffle(round);
            }
        }
        return round;
    }
}

