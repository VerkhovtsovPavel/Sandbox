package my.sandbox.game.furnace;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public final class DisksFactory {

    public static Queue<Integer> lowToHigh() {
        final Queue<Integer> disks = new LinkedList<>();
        disks.add(1);
        disks.add(2);
        disks.add(3);
        disks.add(4);
        return disks;
    }

    public static Queue<Integer> lowToHigh(Integer rotationDisk) {
        final Queue<Integer> disks = lowToHigh();
        disks.add(rotationDisk);
        Collections.sort((List<Integer>) disks);
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

    public static Queue<Integer> highToLow(Integer rotationDisk) {
        final Queue<Integer> disks = highToLow();
        disks.add(rotationDisk);
        Collections.sort((List<Integer>) disks);
        Collections.reverse((List<Integer>) disks);
        return disks;
    }

    private DisksFactory() {}
}
