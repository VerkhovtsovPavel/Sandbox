package my.sandbox.wealth;

import java.util.ArrayList;
import java.util.Arrays;

import static my.sandbox.common.util.ExecutionUtils.times;

public class Main {

    private static final int investorsAmount = 1000000;
    private static final int roundsAmount = 25;
    private static final int beginningWealth = 100;

    public static void main(String[] args) {
        ArrayList<Investor> investors = new ArrayList<>(investorsAmount);
        times(investorsAmount, () -> investors.add(new Investor(beginningWealth, 1)));

        times(roundsAmount, () -> investors.forEach(Investor::invest));

        long[] wealthValues = investors.stream().mapToLong(Investor::getWealth).toArray();
        Arrays.sort(wealthValues);
        double median;
        if (wealthValues.length % 2 == 0) {
            median = ((double) wealthValues[wealthValues.length / 2] + (double) wealthValues[wealthValues.length / 2 - 1]) / 2;
        } else {
            median = wealthValues[wealthValues.length / 2];
        }

        System.out.println("Avg:\t" + Arrays.stream(wealthValues).average().orElse(0.0));
        System.out.println("Median:\t" + median);

        printPercentiles(wealthValues, .5, .6, .7, .8, .9, .95, .99, .995, .999);
    }

    private static long percentiles(long[] wealthValues, double percentile) {
        return wealthValues[(int) (wealthValues.length * percentile)];
    }

    private static void printPercentiles(long[] wealthValues, double... percentiles) {
        for(double percentile : percentiles) {
            System.out.println((percentile*100)+"th:\t" + percentiles(wealthValues, percentile));
        }
    }
}
