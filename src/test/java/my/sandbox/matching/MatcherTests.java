package my.sandbox.matching;

import static java.lang.String.format;
import static my.sandbox.constant.StringConstant.AB;
import static my.sandbox.constant.StringConstant.ABC;
import static my.sandbox.constant.StringConstant.BCD;
import static my.sandbox.matching.Matcher.match;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MatcherTests {
    private static final String STRING_VALUE_FORMAT = "String value: %s";
    private static final String INTEGER_VALUE = "Integer value";
    private static final String DOUBLE_VALUE = "Double value";
    private static final String UNEXPECTED_VALUE = "Unexpected value";
    private static final String SHORT_STRING_VALUE = "Short string value";
    private static final String A_STARTED_STRING_VALUE = "'a' started string value";
    private Matcher<String> matcher;

    @BeforeClass
    void initMatcher() {
        matcher = match(String.class)
            .when((String s) -> s.length() < 3).then(SHORT_STRING_VALUE)
            .when((String s) -> s.startsWith("a")).then(A_STARTED_STRING_VALUE)
            .when(String.class).then(s -> format(STRING_VALUE_FORMAT, s))
            .when(Integer.class).then(i -> INTEGER_VALUE)
            .when(Double.class).then(d -> DOUBLE_VALUE)
            .orElse(UNEXPECTED_VALUE);
    }

    @Test(dataProvider = "branches")
    public void matchTest(final Object value, final String expectedResult) {
        Assert.assertEquals(matcher.match(value),
            expectedResult, "Matched branch is incorrect");
    }

    @Test
    public void matchAll() {
        Assert.assertEquals(matcher.matchAll(AB),
            List.of(SHORT_STRING_VALUE, A_STARTED_STRING_VALUE, format(STRING_VALUE_FORMAT, AB)),
            "Matched branches is incorrect");
    }

    @DataProvider(name = "branches")
    Object[][] branches() {
        return new Object[][]
            {
                {AB, SHORT_STRING_VALUE},
                {ABC, A_STARTED_STRING_VALUE},
                {BCD, format(STRING_VALUE_FORMAT, BCD)},
                {1, INTEGER_VALUE},
                {1.0, DOUBLE_VALUE},
                {'b', UNEXPECTED_VALUE}
            };
    }
}
