package my.sandbox.university.util;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import my.sandbox.university.unit.Constance;
import my.sandbox.university.unit.Statistics;

public class StatisticsTests {
    @Test(dataProvider = "getTestData")
    public void checkAverage(ArrayList<Integer> list, double expectedAverage) {
        assertEquals(Statistics.average(list), expectedAverage);
    }

    @DataProvider
    private Object[][] getTestData() {
        return new Object[][]{
                {new ArrayList<Integer>(), Constance.AVERAGE_OF_EMPTY_LIST},
                {new ArrayList<>(Collections.singletonList(1)), 1.0},
                {new ArrayList<>(Arrays.asList(1, 3)), 2.0}
        };
    }
}
