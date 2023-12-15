package my.sandbox;

import my.sandbox.compressor.StringCompressor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StringCompressorTests {
    private static final String ABC = "abc";
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
    Object[] strings() {
        return new Object[][]
                {
                        {ABC, ABC},
                        {"ab2[c]ab", "abccab"},
                        {"ab3[c]ab", "abcccab"},
                        {"2[ab2[c]ab]", "abccababccab"},
                        {"2[ab]2[c]ab", "ababccab"},
                };
    }
}
