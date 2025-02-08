package my.sandbox.game.furnace;

import static my.sandbox.common.logger.CommonLogger.LOG;
import static my.sandbox.common.util.ExecutionUtils.times;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import my.sandbox.common.game.Dice;
import my.sandbox.common.game.DiceFactory;

// Add mods support and dynamic reconfiguration
public final class Application {

	public static void main(String[] args) {
		Dice dice = DiceFactory.d6();

		UserPlayer userPlayer = new UserPlayer(PlayerColor.RED);
		BotPlayer upsidePlayer = new BotPlayer(BotMode.UPSIDE, PlayerColor.BLACK, dice);
		BotPlayer downsidePlayer = new BotPlayer(BotMode.DOWNSIDE, PlayerColor.WHILE, dice);

		Score score = new Score();

		times(4, (round) -> {
			LOG.info("Round [{}] ", round.intValue() + 1);
			final List<Card> cards = new LinkedList<>();
			times(8, (i) -> cards.add(new Card(i.longValue() + 1, new HashMap<>())));

			userPlayer.setCards(cards);
			upsidePlayer.setRound(cards, DisksFactory.highToLow(/*round.intValue() + 1*/));
			downsidePlayer.setRound(cards, DisksFactory.lowToHigh(/*round.intValue() + 1*/));

			List<Player> playOrder = new ArrayList<>();
			times(4, () -> {
				playOrder.add(userPlayer);
				playOrder.add(upsidePlayer);
				playOrder.add(downsidePlayer);
			});

			playOrder.forEach(Player::applyDisk);

			score.computeScope(cards);

			score.getScores().forEach((key, value) -> LOG.info("Player[{}] has {} points", key, value));
		});
	}

	private Application() {
	}
}

