package my.sandbox.pattern_matching;

import static my.sandbox.pattern_matching.Matcher.match;

public class Main {

    public static void main(String[] args) {

        Matcher<String> matcher = getTestMatcher();
        System.out.println(matcher.match("ab"));
        System.out.println(matcher.match("abc"));
        System.out.println(matcher.match("bcd"));
        System.out.println(matcher.match(1));
        System.out.println(matcher.match(1.0));
        System.out.println(matcher.match('b'));

        System.out.println(matcher.matchAll("ab"));
    }

    private static Matcher<String> getTestMatcher() {
        return match(String.class)
                .when((String s) -> s.length() < 3).then((s) -> "Short string value: "+ s)
                .when((String s) -> s.startsWith("a")).then("'a' started string value")
                .when(String.class).then((s) -> "String value: "+ s)
                .when(Integer.class).then((i) -> "Integer value: "+ i)
                .when(Double.class).then((d) -> "Double value: " + d)
                .orElse((x) -> "Unexpected value: " + x);
    }
}
