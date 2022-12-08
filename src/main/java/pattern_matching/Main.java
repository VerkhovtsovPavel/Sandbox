package pattern_matching;

import static pattern_matching.Matcher.match;

public class Main {

    public static void main(String[] args) {
        System.out.println(getValue("1"));
        System.out.println(getValue("12345"));
        System.out.println(getValue(1));
        System.out.println(getValue(1.0));
        System.out.println(getValue('b'));
    }

    private static String getValue(Object o) {
        return match(String.class)
                .when((String s) -> s.length() < 3).then((s) -> "Short string value: "+ s)
                .when(String.class).then((s) -> "String value: "+ s)
                .when(Integer.class).then((i) -> "Integer value: "+ i)
                .when(Double.class).then((d) -> "Double value: " + d)
                .orElse((x) -> "Unexpected value: " + x)
        .apply(o);
    }
}
