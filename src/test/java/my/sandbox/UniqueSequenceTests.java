package my.sandbox;

import static my.sandbox.Small.uniqueSequenceCount;
import static my.sandbox.util.ParameterUtils.arr;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class UniqueSequenceTests {
    @Test(dataProvider = "strings")
    public void validValues(final String value, final int expectedCount) {
        int actualCount = uniqueSequenceCount(value);
        Assert.assertEquals(actualCount, expectedCount);
    }

    @Test
    public void emptyString() {
        int actualCount = uniqueSequenceCount("");
        Assert.assertEquals(actualCount, 0);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void nullArray() {
        uniqueSequenceCount(null);
    }

    @DataProvider
    Iterator<Object[]> strings() {
        return List.of(
                arr("123442", 4),
                arr("123312", 3),
                arr("1212345", 5),
                arr("11111", 1))
            .iterator();
    }
}
