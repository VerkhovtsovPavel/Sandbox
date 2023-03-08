package my.sandbox;

import my.sandbox.compressor.StringCompressor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static my.sandbox.Small.uniqueElements;

public class StringCompressorTests {

    private StringCompressor stringCompressor = new StringCompressor();

    @Test(dataProvider = "strings")
    public void validArray(String compressedString, String expectedString) {
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
        uniqueElements(null);
    }

    @DataProvider
    private Object[] strings() {
        return new Object[][] {
                {"abc",         "abc"   },
                {"ab2[c]ab",    "abccab"},
                {"ab3[c]ab",    "abcccab"},
                {"2[ab2[c]ab]", "abccababccab"},
                {"2[ab]2[c]ab", "ababccab"},
        };
    }
}
