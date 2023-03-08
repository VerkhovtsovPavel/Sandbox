package my.sandbox.welcome;

public class Card {

    private Bonus bonus;
    private Denomination denomination;

    public Card(Bonus bonus, Denomination denomination) {
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
