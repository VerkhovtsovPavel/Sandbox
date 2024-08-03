package my.sandbox.wealth;

import static my.sandbox.wealth.Configuration.INVESTMENT_GAIN;
import static my.sandbox.wealth.Configuration.INVESTMENT_LOSS;

import my.sandbox.common.util.Randomizer;

public class Investor {
    private double wealth;
    private final double investingFraction;

    public Investor(long wealth, double investingFraction) {
        this.wealth = wealth;
        this.investingFraction = investingFraction;
    }

    public void invest() {
        double investedAmount = wealth * investingFraction;

        if (Randomizer.nextBoolean()) {
            wealth += investedAmount * INVESTMENT_GAIN;
        }
        else {
            wealth -= investedAmount * INVESTMENT_LOSS;
        }
    }

    public double getWealth() {
        return wealth;
    }
}
