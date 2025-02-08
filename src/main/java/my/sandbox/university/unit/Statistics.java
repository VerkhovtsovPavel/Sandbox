package my.sandbox.university.unit;

import java.util.ArrayList;

public final class Statistics {
    private Statistics() {
    }

    public static double average(ArrayList<Integer> list) {
        if (list.isEmpty()) {
            return Constance.AVERAGE_OF_EMPTY_LIST;
        }
        double sum = 0.0;
        for (Integer number : list) {
            sum += number;
        }
        return sum / list.size();
    }
}
