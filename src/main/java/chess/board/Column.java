package chess.board;

public enum Column {

    A(1),
    B(2),
    C(3),
    D(4),
    E(5),
    F(6),
    G(7),
    H(8);

    Column(int value) {
        this.value = value;
    }

    private final int value;

    public int getValue() {
        //TODO Beatify
        return value - 1;
    }
}
