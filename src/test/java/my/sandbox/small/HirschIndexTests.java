package my.sandbox.small;

import static my.sandbox.Small.hIndex;
import static my.sandbox.common.constant.IntConstant.ZERO;
import static my.sandbox.util.ParameterUtils.intArr;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import my.sandbox.common.structure.Pair;

public class HirschIndexTests {
    @Test(dataProvider = "arrays")
    public void validArray(Pair<int[], Integer> arrays) {
        int actual = hIndex(arrays.left());
        Assert.assertEquals(actual, arrays.right());
    }

    @Test
    public void emptyArray() {
        int actual = hIndex();
        Assert.assertEquals(actual, ZERO);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void nullArray() {
        hIndex(null);
    }

    @DataProvider
    @SuppressWarnings("checkstyle:MagicNumber")
    Object[] arrays() {
        return new Object[] {
            new Pair<>(intArr(1, 2, 3, 1, 6, 3), 3),
            new Pair<>(intArr(1, 2, 3), 2),
            new Pair<>(intArr(1, 1, 1, 1, 1, 1), 1),
            new Pair<>(intArr(3, 2, 1, 1, 2), 2),
            new Pair<>(intArr(4, 4, 7, 4), 4),
            new Pair<>(intArr(1, 3, 7, 4), 3),
            new Pair<>(intArr(1), 1)};
    }
}
