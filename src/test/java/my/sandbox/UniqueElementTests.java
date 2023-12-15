package my.sandbox;

import my.sandbox.common.structure.Pair;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static my.sandbox.Small.uniqueElements;

public class UniqueElementTests {
    @Test(dataProvider = "arrays")
    public void validArray(Pair<int[], int[]> arrays) {
        int[] actual = uniqueElements(arrays.left());
        Assert.assertEquals(actual, arrays.right());
    }

    @Test
    public void emptyArray() {
        int[] emptyArray = new int[0];
        int[] actual = uniqueElements(emptyArray);
        Assert.assertEquals(actual, emptyArray);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void nullArray() {
        uniqueElements(null);
    }

    @DataProvider
    @SuppressWarnings("checkstyle:MagicNumber")
    Object[] arrays() {
        return new Object[]{
                new Pair<>(arr(1, 2, 3, 1, 6, 3), arr(1, 2, 3, 6)),
                new Pair<>(arr(1, 2, 3, 1, 6, 3), arr(1, 2, 3, 6)),
                new Pair<>(arr(1, 2, 3), arr(1, 2, 3)),
                new Pair<>(arr(1, 1, 1, 1, 1, 1), arr(1)),
                new Pair<>(arr(3, 2, 1, 1, 2), arr(3, 2, 1)),
                new Pair<>(arr(1), arr(1))
        };
    }

    private int[] arr(final int... values) {
        return values;
    }
}
