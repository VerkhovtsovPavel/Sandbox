package my.sandbox.game.welcome;

public enum Denomination {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHTH(8),
    NINE(9),
    TEN(10),
    ELEVEN(11),
    TWELVE(12),
    THIRTEEN(13),
    FOURTEEN(14),
    FIFTEEN(15);

    private final int denomination;

    Denomination(final int denomination) {
        this.denomination = denomination;
    }

    public int getDenomination() {
        return denomination;
    }

    public static Denomination valueOf(int value) {
        for(Denomination denomination : values()) {
            if (denomination.getDenomination() == value) {
                return denomination;
            }
        }
        return null;
    }
}
