package my.sandbox.maze;

public enum Type implements Bitable {
    START(16),
    FINISH(32);

    private final int bit;

    Type(int bit) {
        this.bit = bit;
    }

    @Override
    public int getBit() {
        return bit;
    }
}
