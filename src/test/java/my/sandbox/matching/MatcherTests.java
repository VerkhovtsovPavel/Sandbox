package my.sandbox.matching;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.String.format;
import static my.sandbox.matching.Matcher.match;

public class MatcherTests {

    private final String stringValueFormat = "String value: %s";
    private final String integerValue = "Integer value";
    private final String doubleValue = "Double value";
    private final String unexpectedValue = "Unexpected value";
    private final String shortStringValue = "Short string value";
    private final String aStartedStringValue = "'a' started string value";
    private Matcher<String> matcher;


    @BeforeClass
    void initMatcher() {
        matcher = match(String.class)
                .when((String s) -> s.length() < 3).then(shortStringValue)
                .when((String s) -> s.startsWith("a")).then(aStartedStringValue)
                .when(String.class).then((s) -> format(stringValueFormat, s))
                .when(Integer.class).then((i) -> integerValue)
                .when(Double.class).then((d) -> doubleValue)
                .orElse(unexpectedValue);
    }

    @Test(dataProvider = "branches")
    public void matchTest(final Object value, final String expectedResult) {
        Assert.assertEquals(matcher.match(value),
                expectedResult, "Matched branch is incorrect");
    }

    @Test
    public void matchAll() {
        Assert.assertEquals(matcher.matchAll("ab"),
                List.of(shortStringValue, aStartedStringValue, format(stringValueFormat, "ab")), "Matched branches is incorrect");
    }

    @DataProvider(name = "branches")
    Object[][] branches() {
        return new Object[][]
                {
                        {"ab", shortStringValue},
                        {"abc", aStartedStringValue},
                        {"bcd", format(stringValueFormat, "bcd")},
                        {1, integerValue},
                        {1.0, doubleValue},
                        {'b', unexpectedValue}
                };
    }
}
