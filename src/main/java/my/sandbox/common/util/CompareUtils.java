package my.sandbox.common.util;

import my.sandbox.common.constant.CompareResult;

public class CompareUtils {

    public static <T extends Comparable<T>> CompareResult compare(T left, T right) {
       int intResult = left.compareTo(right);

       if (intResult == 0) {
           return CompareResult.EQUAL;
       } else if (intResult > 0) {
           return CompareResult.MORE;
       } else {
           return CompareResult.LESS;
       }
    }
}
