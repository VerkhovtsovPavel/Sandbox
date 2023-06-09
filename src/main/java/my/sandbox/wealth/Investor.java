package my.sandbox.wealth;

import my.sandbox.common.Randomizer;

import static my.sandbox.wealth.Constant.INVESTMENT_GAIN;
import static my.sandbox.wealth.Constant.INVESTMENT_LOSS;

public class Investor {

    private long wealth;
    private final double investingFraction;

    public Investor(long wealth, double investingFraction) {
        this.wealth = wealth;
        this.investingFraction = investingFraction;
    }

    public void invest() {
        long investedAmount = (long) (wealth * investingFraction);

        if(Randomizer.nextBoolean()) {
            wealth += investedAmount * INVESTMENT_GAIN;
        } else {
            wealth -= investedAmount * INVESTMENT_LOSS;
        }
    }

    public long getWealth() {
        return wealth;
    }
}
