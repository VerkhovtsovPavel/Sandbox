package my.sandbox.group;

import static my.sandbox.constant.StringConstant.ABC;
import static my.sandbox.constant.StringConstant.BAR;
import static my.sandbox.constant.StringConstant.CBA;
import static my.sandbox.constant.StringConstant.FOO;
import static my.sandbox.group.GroupBy.groupBy;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupByTests {
    @Test
    public void validateGroupBy() {
        List<String> input = List.of(ABC, CBA, FOO, BAR);
        Function<String, Set<Character>> groper = item -> item.chars()
            .mapToObj(ch -> (char) ch)
            .collect(Collectors.toSet());

        Map<Set<Character>, List<String>> expectedResult = Map.of(
            Set.of('f', 'o'), List.of(FOO),
            Set.of('a', 'b', 'r'), List.of(BAR),
            Set.of('a', 'b', 'c'), List.of(ABC, CBA)
        );

        Map<Set<Character>, List<String>> actualResult = groupBy(input, groper);

        Assert.assertEquals(actualResult, expectedResult);
    }
}
