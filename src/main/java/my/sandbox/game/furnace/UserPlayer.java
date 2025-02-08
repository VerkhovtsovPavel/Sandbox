package my.sandbox.game.furnace;

import static my.sandbox.common.logger.CommonLogger.LOG;
import static my.sandbox.common.util.ConsoleScanner.CONSOLE_SCANNER;
import java.util.List;

public class UserPlayer implements Player {
    private final List<Card> cards;
    private final PlayerColor color;

    public UserPlayer(PlayerColor color, Cards cards) {
        this.color = color;
        this.cards = cards.getCards();
    }

    @Override
    public void applyDisk() {
        LOG.info("[{}] Choose card and disk:", color);
        int card = CONSOLE_SCANNER.nextInt() - 1;
        int disk = CONSOLE_SCANNER.nextInt();
        // TODO Add validation on valid turn
        cards.get(card).disks().put(color, disk);
        LOG.debug("Player[{}] put {} disk on {} card", color, disk, card + 1);
    }

    @Override
    public void setup(int round) {
        LOG.debug("Player[{}] collected they disks", color);
    }
}
