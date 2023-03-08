package my.sandbox;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static my.sandbox.Small.uniqueElements;

public class UniqueElementTests {

    @Test(dataProvider = "arrays")
    public void validArray(int[] origin, int[] expected) {
        int[] actual = uniqueElements(origin);
        Assert.assertEquals(actual, expected);
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
    private Object[] arrays() {
        return new Object[][] {
                {arr(1, 2, 3, 1, 6, 3), arr(1, 2, 3, 6)},
                {arr(1, 2, 3),          arr(1, 2, 3)   },
                {arr(1, 1, 1, 1, 1, 1), arr(1)         },
                {arr(3, 2, 1, 1, 2),    arr(3, 2, 1)   },
                {arr(1),                arr(1)         }
        };
    }

    private int[] arr(int... values){
        return values;
    }
}
