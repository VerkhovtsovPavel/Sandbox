package my.sandbox.game.furnace;

import static my.sandbox.common.constant.IntConstant.EIGHTH;
import static my.sandbox.common.constant.IntConstant.FIVE;
import static my.sandbox.common.constant.IntConstant.FOUR;
import static my.sandbox.common.constant.IntConstant.SIX;
import static my.sandbox.common.logger.CommonLogger.LOG;
import static my.sandbox.common.util.ExecutionUtil.times;
import static my.sandbox.game.furnace.GameMode.UNIVERSITIES;
import static my.sandbox.game.furnace.GameMode.VARIABLE_CAPITAL_DISK;
import static my.sandbox.game.furnace.PlayerColor.BLACK;
import static my.sandbox.game.furnace.PlayerColor.RED;
import static my.sandbox.game.furnace.PlayerColor.WHILE;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import my.sandbox.common.game.Dice;
import my.sandbox.common.game.DiceFactory;

public final class Application {
    private Application() {
    }

    public static void main(String[] args) {
        Set<GameMode> gameModes = Set.of(UNIVERSITIES);

        DisksFactory.configure(gameModes);

        Dice dice = DiceFactory.d6();

        Cards rowOfCard = new Cards(cardsInRound(gameModes));

        UserPlayer userPlayer = new UserPlayer(RED, rowOfCard);
        BotPlayer upsidePlayer = new BotPlayer(BLACK, BotMode.UPSIDE, dice, rowOfCard, DisksFactory::highToLow);
        BotPlayer downsidePlayer = new BotPlayer(WHILE, BotMode.DOWNSIDE, dice, rowOfCard, DisksFactory::lowToHigh);

        Score score = new Score();

        List<Player> players = List.of(userPlayer, upsidePlayer, downsidePlayer);

        times(FOUR, round -> {
            int humanReadableRoundNumber = round.intValue() + 1;
            LOG.info("Round [{}] ", humanReadableRoundNumber);

            players.forEach(player -> player.setup(humanReadableRoundNumber));

            List<Player> playOrder = new ArrayList<>();
            times(disksInRound(gameModes), () -> playOrder.addAll(players));

            playOrder.forEach(Player::applyDisk);

            score.computeScope(rowOfCard.getCards());
            score.getScores().forEach((key, value) -> LOG.info("Player[{}] has {} points", key, value));

            rowOfCard.clean();
        });
    }

    private static int cardsInRound(Set<GameMode> gameModes) {
        return gameModes.contains(UNIVERSITIES) ? EIGHTH : SIX;
    }

    private static int disksInRound(Set<GameMode> gameModes) {
        return gameModes.contains(VARIABLE_CAPITAL_DISK) ? FIVE : FOUR;
    }
}

