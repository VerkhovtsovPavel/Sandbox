package my.sandbox.game.furnace;

import static my.sandbox.common.constant.IntConstant.THREE;
import static my.sandbox.common.util.MapUtil.increase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Score {
    private final HashMap<PlayerColor, Integer> wonCards = new HashMap<>();
    private final HashMap<PlayerColor, Integer> scores = new HashMap<>();

    public void computeScore(List<Card> cards) {
        for (Card card : cards) {
            var disks = card.disks();
            if (!disks.isEmpty()) {
                var cardTaker = disks.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .toList()
                    .reversed();
                var winnerPlayer = cardTaker.get(0).getKey();
                increase(wonCards, winnerPlayer, 1);

                cardTaker.stream().skip(1).forEach(pair -> increase(scores, pair.getKey(), pair.getValue()));
            }
        }

        wonCards.forEach((key, value) -> increase(scores, key, value * THREE));
    }

    public HashMap<PlayerColor, Integer> getScores() {
        return scores;
    }
}
