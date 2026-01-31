package my.sandbox.small;

import static my.sandbox.Small.strictTwoOutOfThreeWithUniqueElements;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StrictTwoOutOfThreeTests {
    @Test(dataProvider = "lists")
    public void validArray(List<Integer> a, List<Integer> b, List<Integer> c, List<Integer> expected) {
        List<Integer> actual = strictTwoOutOfThreeWithUniqueElements(a, b, c);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void emptyArray() {
        List<Integer> emptyArray = List.of();
        List<Integer> actual = strictTwoOutOfThreeWithUniqueElements(emptyArray, emptyArray, emptyArray);
        Assert.assertEquals(actual, emptyArray);
    }

    @DataProvider
    @SuppressWarnings("checkstyle:MagicNumber")
    Object[] lists() {
        return new Object[][] {
            {List.of(1, 2, 3, 1, 6, 3), List.of(1, 2, 3, 1, 6, 3), List.of(1, 2, 3, 1, 6), List.of(3)},
            {List.of(1, 3, 3), List.of(2, 8, 5), List.of(2, 3, 3), List.of(2, 3, 3)},
            {List.of(1, 2, 3), List.of(1, 6, 3), List.of(2, 6), List.of(1, 2, 3, 6)}
        };
    }
}
