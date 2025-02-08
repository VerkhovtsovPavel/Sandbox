package my.sandbox.common.util;

import java.util.LinkedList;

@Deprecated
public class ListUtils {

    /**
     * Use List::reversed instead
     */
    @Deprecated
    public static <T> LinkedList<T> reverse(LinkedList<T> list) {
        final LinkedList<T> reversedList = new LinkedList<>();
        list.descendingIterator().forEachRemaining(reversedList::add);
        return reversedList;
    }
}