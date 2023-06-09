package my.sandbox.wealth;

import java.util.ArrayList;
import java.util.Arrays;

import static my.sandbox.common.Utils.times;

public class Main {

    private static final int investorsAmount = 1000000;
    private static final int roundsAmount = 25;

    public static void main(String[] args) {
        ArrayList<Investor> investors = new ArrayList<>(investorsAmount);
        times(investorsAmount, () -> investors.add(new Investor(100, 1)));

        times(roundsAmount,
                () -> times(investorsAmount -1 ,
                        (i) -> investors.get(i.intValue()).invest()
                )
        );

        long[] wealthValues = investors.stream().mapToLong(Investor::getWealth).toArray();

        Arrays.sort(wealthValues);
        double median;
        if (wealthValues.length % 2 == 0) {
            median = ((double)wealthValues[wealthValues.length / 2] + (double)wealthValues[wealthValues.length / 2 - 1]) / 2;
        }
        else {
            median = wealthValues[wealthValues.length / 2];
        }

        System.out.println("Average: " + Arrays.stream(wealthValues).average().orElse(0));
        System.out.println("Median: " + median);

        System.out.println("50%: " + percentiles(wealthValues, 0.50));
        System.out.println("60%: " + percentiles(wealthValues, 0.60));
        System.out.println("70%: " + percentiles(wealthValues, 0.70));
        System.out.println("80%: " + percentiles(wealthValues, 0.80));
        System.out.println("90%: " + percentiles(wealthValues, 0.90));
        System.out.println("95%: " + percentiles(wealthValues, 0.95));
        System.out.println("99%: " + percentiles(wealthValues, 0.99));
        System.out.println("99.5%: " + percentiles(wealthValues, 0.995));
        System.out.println("99.9%: " + percentiles(wealthValues, 0.999));
    }

    private static long percentiles(long[] wealthValues, double percentiles) {
        return wealthValues[(int)(wealthValues.length * percentiles)];
    }
}
