package my.sandbox.maze;

public enum Direction implements Bitable {
    N(1, 0, -1),
    S(2, 0, 1),
    E(4, 1, 0),
    W(8, -1, 0);

    static {
        N.opposite = S;
        S.opposite = N;
        E.opposite = W;
        W.opposite = E;
    }

    private final int bit;

    private final int dx;
    private final int dy;
    private Direction opposite;

    Direction(int bit, int dx, int dy) {
        this.bit = bit;
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public int getBit() {
        return bit;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public Direction getOpposite() {
        return opposite;
    }
}
