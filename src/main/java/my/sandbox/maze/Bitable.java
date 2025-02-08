package my.sandbox.maze;

public interface Bitable {
    int getBit();

    default boolean isBitNotSet(int cell) {
        return (cell & getBit()) == 0;
    }

    default boolean isBitSet(int cell) {
        return (cell & getBit()) != 0;
    }
}
