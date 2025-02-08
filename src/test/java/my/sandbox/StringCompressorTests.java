package my.sandbox;

import static my.sandbox.constant.StringConstant.ABC;
import static my.sandbox.util.ParameterUtils.arr;

import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import my.sandbox.compressor.StringCompressor;

public class StringCompressorTests {
    private final StringCompressor stringCompressor = new StringCompressor();

    @Test(dataProvider = "strings")
    public void validArray(final String compressedString, final String expectedString) {
        String actualString = stringCompressor.unzip(compressedString);
        Assert.assertEquals(actualString, expectedString);
    }

    @Test
    public void emptyString() {
        String actualString = stringCompressor.unzip("");
        Assert.assertEquals(actualString, "");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void nullArray() {
        stringCompressor.unzip(null);
    }

    @DataProvider
    Iterator<Object[]> strings() {
        return List.of(
            arr(ABC, ABC),
            arr("ab2[c]ab", "abccab"),
            arr("ab3[c]ab", "abcccab"),
            arr("2[ab2[c]ab]", "abccababccab"),
            arr("2[ab]2[c]ab", "ababccab"),
            arr("10[a]", "aaaaaaaaaa"),
            arr("12b3[a]", "12baaa")
        ).iterator();
    }
}
