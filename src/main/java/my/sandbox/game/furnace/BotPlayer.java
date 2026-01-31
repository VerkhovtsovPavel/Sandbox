package my.sandbox.game.furnace;

import static my.sandbox.common.logger.CommonLogger.LOG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.function.Function;

import my.sandbox.game.common.Dice;

public class BotPlayer implements Player {
    private final List<Card> cards;
    private final Function<Integer, Queue<Integer>> disksProvider;
    private Queue<Integer> disks;
    private final BotMode mode;
    private final PlayerColor color;
    private final Dice dice;

    public BotPlayer(PlayerColor color, BotMode mode, Dice dice, Cards cards,
                     Function<Integer, Queue<Integer>> diskProvider) {
        this.color = color;
        this.mode = mode;
        this.dice = dice;
        this.cards = cards.getCards();
        this.disksProvider = diskProvider;
    }

    @Override
    public void applyDisk() {
        int initialCard = dice.roll();
        LOG.debug("Bot[{}] rolled {}", color, initialCard);
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

    @Override
    public void setup(int roundNumber) {
        this.disks = disksProvider.apply(roundNumber);
    }

    private List<Card> buildTheRound(int initialCard, List<Card> cards, BotMode mode) {
        List<Card> round = new ArrayList<>();
        return switch (mode) {
            case UPSIDE:
                round.addAll(cards.subList(initialCard - 1, cards.size()));
                round.addAll(cards.subList(0, initialCard - 1));
                yield round;
            case DOWNSIDE:
                round.addAll(cards.subList(0, initialCard).reversed());
                round.addAll(cards.subList(initialCard, cards.size()).reversed());
                yield round;
            case IMPULSIVE:
                round.addAll(cards);
                Collections.shuffle(round);
                yield round;
        };
    }
}

