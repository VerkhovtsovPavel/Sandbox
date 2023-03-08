package my.sandbox.furnace;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Player upsidePlayer = new Player();
        Player downsidePlayer = new Player();
    }

    private static int rollDice() {
        return 1;
    }

    private static class Board {
        private final List<Set<Integer>> cards = new LinkedList<Set<Integer>>();

        Board() {
            cards.add(new HashSet<>());
            cards.add(new HashSet<>());
            cards.add(new HashSet<>());
            cards.add(new HashSet<>());
        }
    }

    private static class Player {
        private final List<Integer> disks = new LinkedList<Integer>();

        Player() {
            disks.add(1);
            disks.add(2);
            disks.add(3);
            disks.add(4);
        }

        public void applyDisk() {
            for (Integer disk: disks) {

            }
        }
    }
}
