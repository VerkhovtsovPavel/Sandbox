package my.sandbox.game.furnace;

import static my.sandbox.common.constant.IntConstant.FOUR;
import static my.sandbox.common.constant.IntConstant.ONE;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class DisksFactory {
    private final Set<GameMode> gameModes;

    public DisksFactory(Set<GameMode> modes) {
        this.gameModes = modes;
    }

    public Queue<Integer> lowToHigh() {
        return IntStream.rangeClosed(ONE, FOUR).boxed().collect(Collectors.toCollection(LinkedList::new));
    }

    public Queue<Integer> lowToHigh(Integer rotationDisk) {
        Queue<Integer> disks = lowToHigh();

        if (gameModes.contains(GameMode.VARIABLE_CAPITAL_DISK)) {
            disks.add(rotationDisk);
            disks = disks.stream().sorted().collect(Collectors.toCollection(LinkedList::new));
        }
        return disks;
    }

    public Queue<Integer> highToLow() {
        return ((LinkedList<Integer>) lowToHigh()).reversed();
    }

    public Queue<Integer> highToLow(Integer rotationDisk) {
        return ((LinkedList<Integer>) lowToHigh(rotationDisk)).reversed();
    }
}
