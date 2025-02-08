package my.sandbox.common.util;

import java.util.LinkedList;

@Deprecated(forRemoval = true, since = "0.1")
public final class ListUtils {
    private ListUtils() {
    }

    /**
     * @deprecated Use List::reversed instead
     * @param <T> list element type
     * @param list original list
     * @return reverted list
     */
    @Deprecated(forRemoval = true, since = "0.1")
    public static <T> LinkedList<T> reverse(LinkedList<T> list) {
        final LinkedList<T> reversedList = new LinkedList<>();
        list.descendingIterator().forEachRemaining(reversedList::add);
        return reversedList;
    }
}
