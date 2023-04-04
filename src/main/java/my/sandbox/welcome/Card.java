package my.sandbox.welcome;

public class Card {

    private final Bonus bonus;
    private final Denomination denomination;

    public Card(final Bonus bonus, final Denomination denomination) {
        this.bonus = bonus;
        this.denomination = denomination;
    }

    public Bonus getBonus() {
        return bonus;
    }

    public Denomination getDenomination() {
        return denomination;
    }
}
