package my.sandbox.wealth;

import static my.sandbox.common.logger.CommonLogger.LOG;
import static my.sandbox.common.util.ExecutionUtil.times;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import my.sandbox.common.constant.DoubleConstant;
import my.sandbox.common.constant.IntConstant;
import my.sandbox.common.util.StatUtil;

public final class Application {
    private Application() {
    }

    public static void main(String[] args) {
        ArrayList<Investor> investors = new ArrayList<>(Configuration.INVESTORS_AMOUNT);
        times(Configuration.INVESTORS_AMOUNT,
            () -> investors.add(new Investor(Configuration.BEGINNING_WEALTH, Configuration.INVESTING_FACTOR)));

        times(Configuration.ROUNDS_AMOUNT, () -> investors.forEach(Investor::invest));

        List<Double> wealthValues = new ArrayList<>(investors.stream().map(Investor::getWealth).toList());
        Collections.sort(wealthValues);

        LOG.info("Avg:\t" + StatUtil.average(wealthValues));
        LOG.info("Median:\t" + StatUtil.median(wealthValues));

        printPercentiles(wealthValues, DoubleConstant.HALF, DoubleConstant.ZERO_SIX, DoubleConstant.ZERO_SEVEN,
            DoubleConstant.ZERO_EIGHTH, DoubleConstant.ZERO_NINE, DoubleConstant.ZERO_NINETY_FIVE,
            DoubleConstant.DOUBLE_NINE, DoubleConstant.ZERO_NINE_NINE_FIVE, DoubleConstant.TRIPLE_NINE);
    }

    private static void printPercentiles(List<Double> wealthValues, double... percentiles) {
        for (double percentile : percentiles) {
            LOG.info((percentile * IntConstant.HUNDRED) + "th:\t" + StatUtil.percentile(wealthValues, percentile));
        }
    }
}
