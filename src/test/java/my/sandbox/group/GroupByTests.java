package my.sandbox.group;

import static my.sandbox.group.GroupBy.groupBy;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupByTests {
    @Test
    public void validateGroupBy() {
        List<String> input = List.of("abc", "cba", "foo", "bar");
        Function<String, Set<Character>> groper = item -> item.chars()
            .mapToObj(ch -> (char) ch)
            .collect(Collectors.toSet());

        Map<Set<Character>, List<String>> expectedResult = Map.of(
            Set.of('f', 'o'), List.of("foo"),
            Set.of('a', 'b', 'r'), List.of("bar"),
            Set.of('a', 'b', 'c'), List.of("abc", "cba")
        );

        Map<Set<Character>, List<String>> actualResult = groupBy(input, groper);

        Assert.assertEquals(actualResult, expectedResult);
    }
}
