package chess.board;

public enum Row {

    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8);

    Row(int value) {
        this.value = value;
    }

    private final int value;

    public int getValue() {
        //TODO Beatify
        return value - 1;
    }
}
