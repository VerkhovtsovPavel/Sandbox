package my.sandbox.game.furnace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static my.sandbox.common.util.ExecutionUtils.times;

public class Main {

    public static void main(String[] args) {

        final List<Card> cards = new LinkedList<>();
        times(7, (i) -> cards.add(new Card((Long) i, new HashMap<>())));

        Player userPlayer = new UserPlayer(cards, PlayerColor.RED);
        Player upsidePlayer = new BotPlayer(cards, DisksFactory.highToLow(), BotMode.UPSIDE, PlayerColor.BLACK);
        Player downsidePlayer = new BotPlayer(cards, DisksFactory.lowToHigh(), BotMode.DOWNSIDE, PlayerColor.WHILE);

        List<Player> playOrder = new ArrayList<>();
        times(4, () -> {
            playOrder.add(userPlayer);
            playOrder.add(upsidePlayer);
            playOrder.add(downsidePlayer);
        });

        for (Player currentPlayer : playOrder) {
            currentPlayer.applyDisk();
        }
    }
}

