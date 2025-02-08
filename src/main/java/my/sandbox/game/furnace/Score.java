package my.sandbox.game.furnace;

import java.util.*;


public class Score {

	private final HashMap<PlayerColor, Integer> wonCards = new HashMap<>();
	private final HashMap<PlayerColor, Integer> scores = new HashMap<>();

	public void computeScope(List<Card> cards) {
		for (Card card: cards) {
			var cardTaker = card.disks().entrySet().stream().sorted(Map.Entry.comparingByValue()).toList().reversed();
			// TODO Potentially no winner (Empty card)
			var winnerPlayer = cardTaker.get(0).getKey();
			increase(wonCards, winnerPlayer, 1);

			cardTaker.stream().skip(1).forEach(pair -> increase(scores, pair.getKey(), pair.getValue()));
		}

		wonCards.forEach((key, value) -> increase(scores, key, value * 3));
	}

	public HashMap<PlayerColor, Integer> getScores() {
		return scores;
	}

	private void increase(HashMap<PlayerColor, Integer> map, PlayerColor key,  Integer value) {
		map.put(key, map.getOrDefault(key, 0) + value);
	}

}
