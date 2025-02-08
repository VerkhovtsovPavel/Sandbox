package my.sandbox.game.furnace;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class DisksFactory {

    public static Queue<Integer> lowToHigh() {
        return IntStream.rangeClosed(1, 4).boxed().collect(Collectors.toCollection(LinkedList::new));
    }

    public static Queue<Integer> lowToHigh(Integer rotationDisk) {
        final Queue<Integer> disks = lowToHigh();
        disks.add(rotationDisk);
        return disks.stream().sorted().collect(Collectors.toCollection(LinkedList::new));
    }

    public static Queue<Integer> highToLow() {
        return reverse((LinkedList<Integer>) lowToHigh());
    }

    public static Queue<Integer> highToLow(Integer rotationDisk) {
        return reverse((LinkedList<Integer>) lowToHigh(rotationDisk));
    }

    private static <T> LinkedList<T> reverse(LinkedList<T> list) {
        final LinkedList<T> reversedList = new LinkedList<>();
        list.descendingIterator().forEachRemaining(reversedList::add);
        return reversedList;
    }

    private DisksFactory() {}
}
