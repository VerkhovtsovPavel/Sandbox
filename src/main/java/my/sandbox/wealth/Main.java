package my.sandbox.wealth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import my.sandbox.common.util.StatUtils;

import static my.sandbox.common.constant.DoubleConstant.DOUBLE_NINE;
import static my.sandbox.common.constant.DoubleConstant.HALF;
import static my.sandbox.common.constant.DoubleConstant.TRIPLE_NINE;
import static my.sandbox.common.constant.DoubleConstant.ZERO_EIGHTH;
import static my.sandbox.common.constant.DoubleConstant.ZERO_NINE;
import static my.sandbox.common.constant.DoubleConstant.ZERO_NINETY_FIVE;
import static my.sandbox.common.constant.DoubleConstant.ZERO_NINE_NINE_FIVE;
import static my.sandbox.common.constant.DoubleConstant.ZERO_SEVEN;
import static my.sandbox.common.constant.DoubleConstant.ZERO_SIX;
import static my.sandbox.common.constant.IntConstant.HUNDRED;
import static my.sandbox.common.logger.CommonLogger.LOG;
import static my.sandbox.common.util.ExecutionUtils.times;
import static my.sandbox.wealth.Configuration.BEGINNING_WEALTH;
import static my.sandbox.wealth.Configuration.INVESTING_FACTOR;
import static my.sandbox.wealth.Configuration.INVESTORS_AMOUNT;
import static my.sandbox.wealth.Configuration.ROUNDS_AMOUNT;


public class Main {

    public static void main(String[] args) {
        ArrayList<Investor> investors = new ArrayList<>(INVESTORS_AMOUNT);
        times(INVESTORS_AMOUNT, () -> investors.add(new Investor(BEGINNING_WEALTH, INVESTING_FACTOR)));

        times(ROUNDS_AMOUNT, () -> investors.forEach(Investor::invest));

        List<Double> wealthValues = new ArrayList<>(investors.stream().map(Investor::getWealth).toList());
        Collections.sort(wealthValues);

        LOG.info("Avg:\t" + StatUtils.average(wealthValues));
        LOG.info("Median:\t" + StatUtils.median(wealthValues));

        printPercentiles(wealthValues, HALF, ZERO_SIX, ZERO_SEVEN, ZERO_EIGHTH, ZERO_NINE, ZERO_NINETY_FIVE,
                DOUBLE_NINE, ZERO_NINE_NINE_FIVE, TRIPLE_NINE);
    }

    private static void printPercentiles(List<Double> wealthValues, double... percentiles) {
        for(double percentile : percentiles) {
            LOG.info((percentile * HUNDRED)+"th:\t" + StatUtils.percentile(wealthValues, percentile));
        }
    }
}
