package my.sandbox.game.furnace;

import static my.sandbox.common.logger.CommonLogger.LOG;
import static my.sandbox.common.util.ExecutionUtils.times;
import static my.sandbox.game.furnace.GameMode.UNIVERSITIES;
import static my.sandbox.game.furnace.GameMode.VARIABLE_CAPITAL_DISK;
import static my.sandbox.game.furnace.PlayerColor.*;
import static my.sandbox.game.furnace.PlayerColor.RED;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import my.sandbox.common.game.Dice;
import my.sandbox.common.game.DiceFactory;

public final class Application {

	public static void main(String[] args) {

		Set<GameMode> gameModes = Set.of(UNIVERSITIES);

		DisksFactory.configure(gameModes);

		Dice dice = DiceFactory.d6();

		Cards rowOfCard = new Cards(cardsInRound(gameModes));

		UserPlayer userPlayer = new UserPlayer(RED, rowOfCard);
		BotPlayer upsidePlayer = new BotPlayer(BLACK, BotMode.UPSIDE,  dice, rowOfCard, DisksFactory::highToLow);
		BotPlayer downsidePlayer = new BotPlayer(WHILE, BotMode.DOWNSIDE, dice, rowOfCard, DisksFactory::lowToHigh);

		Score score = new Score();

		List<Player> players = List.of(userPlayer, upsidePlayer, downsidePlayer);

		times(4, (round) -> {
			LOG.info("Round [{}] ", round.intValue() + 1);

			players.forEach(player -> player.setup(round.intValue() + 1));

			List<Player> playOrder = new ArrayList<>();
			times(disksInRound(gameModes), () -> playOrder.addAll(players));

			playOrder.forEach(Player::applyDisk);

			score.computeScope(rowOfCard.getCards());
			score.getScores().forEach((key, value) -> LOG.info("Player[{}] has {} points", key, value));

			rowOfCard.clean();
		});
	}

	private static int cardsInRound(Set<GameMode> gameModes) {
		return gameModes.contains(UNIVERSITIES) ? 8 : 6;
	}

	private static int disksInRound(Set<GameMode> gameModes) {
		return gameModes.contains(VARIABLE_CAPITAL_DISK) ? 5 : 4;
	}

	private Application() {
	}
}

