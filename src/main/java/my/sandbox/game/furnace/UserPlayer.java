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
        int card = -1;
        while (card < 0 || card >= cards.size()) {
            if (CONSOLE_SCANNER.hasNextInt()) {
                card = CONSOLE_SCANNER.nextInt() - 1;
                if (card < 0 || card >= cards.size()) {
                    LOG.error("Invalid card number. Please choose between 1 and {}", cards.size());
                }
            }
            else {
                // consume invalid input
                CONSOLE_SCANNER.next();
                LOG.error("Invalid input. Please enter numbers.");
            }
        }
        int disk = CONSOLE_SCANNER.nextInt();
        cards.get(card).disks().put(color, disk);
        LOG.debug("Player[{}] put {} disk on {} card", color, disk, card + 1);
    }

    @Override
    public void setup(int round) {
        LOG.debug("Player[{}] collected they disks", color);
    }
}
