package maze;

public enum Direction implements Bitable {
        N(1, 0, -1),
        S(2, 0, 1),
        E(4, 1, 0),
        W(8, -1, 0);

        public final int bit;
        public final int dx;
        public final int dy;
        public Direction opposite;

        static {
            N.opposite = S;
            S.opposite = N;
            E.opposite = W;
            W.opposite = E;
        }

        Direction(int bit, int dx, int dy) {
            this.bit = bit;
            this.dx = dx;
            this.dy = dy;
        }

    @Override
    public int getBit() {
        return bit;
    }
}
