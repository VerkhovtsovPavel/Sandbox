package my.sandbox.game.furnace;

import my.sandbox.common.game.Dice;
import my.sandbox.common.game.DiceFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static my.sandbox.common.util.ExecutionUtils.times;

public final class Application {

    //TODO Need to re-tests after changes
    public static void main(String[] args) {

        Dice dice = DiceFactory.d6();

        times(4, (round) -> {
            final List<Card> cards = new LinkedList<>();
            times(7, (i) -> cards.add(new Card(i.longValue(), new HashMap<>())));

            Player userPlayer = new UserPlayer(cards, PlayerColor.RED);
            Player upsidePlayer = new BotPlayer(cards, DisksFactory.highToLow(round.intValue() + 1), BotMode.UPSIDE, PlayerColor.BLACK, dice);
            Player downsidePlayer = new BotPlayer(cards, DisksFactory.lowToHigh(round.intValue() + 1), BotMode.DOWNSIDE, PlayerColor.WHILE, dice);

            List<Player> playOrder = new ArrayList<>();
            times(5, () -> {
                playOrder.add(userPlayer);
                playOrder.add(upsidePlayer);
                playOrder.add(downsidePlayer);
            });

            for (Player currentPlayer : playOrder) {
                currentPlayer.applyDisk();
            }
        });
    }

    private Application() {}
}

