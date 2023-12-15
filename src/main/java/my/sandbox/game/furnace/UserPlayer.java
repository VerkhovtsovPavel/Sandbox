package my.sandbox.game.furnace;

import java.util.List;
import java.util.Scanner;

public class UserPlayer implements Player {
    private final List<Card> cards;
    private final PlayerColor color;

    public UserPlayer(List<Card> cards, PlayerColor color) {
        this.cards = cards;
        this.color = color;
    }

    @Override
    public void applyDisk() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose card and disk:");
        int card = in.nextInt() - 1;
        int disk = in.nextInt();
        cards.get(card).disks().put(color, disk);
        System.out.printf("Player[%s] put %d disk on %d card%n", color, disk, card + 1);
    }
}
