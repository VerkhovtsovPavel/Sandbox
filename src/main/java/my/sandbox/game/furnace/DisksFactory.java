package my.sandbox.game.furnace;

import java.util.LinkedList;
import java.util.Queue;

public class DisksFactory {

    public static Queue<Integer> lowToHigh() {
        final Queue<Integer> disks = new LinkedList<>();
        disks.add(1);
        disks.add(2);
        disks.add(3);
        disks.add(4);
        return disks;
    }

    public static Queue<Integer> highToLow() {
        final Queue<Integer> disks = new LinkedList<>();
        disks.add(4);
        disks.add(3);
        disks.add(2);
        disks.add(1);
        return disks;
    }
}
