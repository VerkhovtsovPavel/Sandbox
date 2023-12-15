package my.sandbox.game.furnace;

import java.util.Map;

public record Card(long numberInRow, Map<PlayerColor, Integer> disks) {
}
