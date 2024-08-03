package my.sandbox.game.furnace;

import static java.lang.String.format;
import static my.sandbox.common.logger.CommonLogger.LOG;
import static my.sandbox.common.util.ConsoleScanner.CONSOLE_SCANNER;

import java.util.List;

public class UserPlayer implements Player {
    private final List<Card> cards;
    private final PlayerColor color;

    public UserPlayer(List<Card> cards, PlayerColor color) {
        this.cards = cards;
        this.color = color;
    }

    @Override
    public void applyDisk() {
        LOG.info("Choose card and disk:");
        int card = CONSOLE_SCANNER.nextInt() - 1;
        int disk = CONSOLE_SCANNER.nextInt();
        cards.get(card).disks().put(color, disk);
        LOG.info(format("Player[%s] put %d disk on %d card%n", color, disk, card + 1));
    }
}
