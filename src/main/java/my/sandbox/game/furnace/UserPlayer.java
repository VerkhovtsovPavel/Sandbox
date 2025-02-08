package my.sandbox.game.furnace;

import static java.lang.String.format;
import static my.sandbox.common.logger.CommonLogger.LOG;
import static my.sandbox.common.util.ConsoleScanner.CONSOLE_SCANNER;

import java.util.List;

public class UserPlayer implements Player {
    private List<Card> cards;
    private final PlayerColor color;

    public UserPlayer(PlayerColor color) {
        this.color = color;
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

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
