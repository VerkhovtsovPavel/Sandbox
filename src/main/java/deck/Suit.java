package deck;

public enum Suit {

    SPADES(false), HEARTS(true), CLUBS(false), DIAMONDS(true);

    private final boolean color;

    Suit(boolean color) {
        this.color = color;
    }

    public boolean isRed() {
        return color;
    }

    public boolean isBlack() {
        return !color;
    }

}
