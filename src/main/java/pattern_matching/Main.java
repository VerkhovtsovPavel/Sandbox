package pattern_matching;

import static pattern_matching.Matcher.match;

public class Main {

    public static void main(String[] args) {
        System.out.println(getValue("1"));
        System.out.println(getValue(1));
        System.out.println(getValue(1.0));
        System.out.println(getValue('b'));

    }

    private static Object getValue(Object o) {
        return match(String.class)
                .when(String.class).then((s) -> "String value: "+ s)
                .when(Integer.class).then((i) -> "Integer value: "+ i)
                .when(Double.class).then((d) -> "Double value: " + d)
        .apply(o);
    }
}
