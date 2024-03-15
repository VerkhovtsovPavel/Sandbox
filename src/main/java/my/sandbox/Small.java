package my.sandbox;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class Small {

    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{1, 3, 7, 4}));
        System.out.println(hIndex(new int[]{4, 4, 7, 4}));
        System.out.println(hIndex(new int[]{}));
    }

    public static int[] uniqueElements(final int[] array) {
        Set<Integer> set = new LinkedHashSet<>();
        for(int item : array) {
            set.add(item);
        }
        return set.stream().mapToInt(i -> i).toArray();
    }

    public static int[] countPositivesSumNegatives(final int[] input) {
        if (input == null || input.length == 0) {
            return new int[0];
        }
        int[] result = new int[2];
        result[0] = (int) Arrays.stream(input).filter(x -> x > 0).count();
        result[1] = Arrays.stream(input).filter(x -> x < 0).sum();
        return result; //return an array with count of positives and sum of negatives
    }

    public static boolean isIsogram(final String str) {
        Set<Character> letters = new HashSet<>();
        for (char letter : str.toLowerCase().toCharArray()) {
            if (letters.contains(letter)) {
                return false;
            }
            letters.add(letter);
        }
        return true;
    }

    public static List<Object> filterList(final List<Object> list) {
        return list.stream().filter(x -> x instanceof Integer).collect(Collectors.toList());
    }

    public static String countLetters(final String string) {
        int counter = 0;
        char[] letters = string.toCharArray();
        char currentLetter = letters[0];

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == currentLetter) {
                counter++;
            } else if (counter == 1) {
                result.append(currentLetter);
                currentLetter = letters[i];
            } else {
                result.append(currentLetter);
                result.append(counter);
                currentLetter = letters[i];
                counter = 1;
            }

            if (i == letters.length - 1) {
                result.append(currentLetter);
                result.append(counter);
            }
        }

        return result.toString();
    }

    public static boolean compareOrderIgnoreIntermediate(
            final List<String> eventsLog,
            final List<String> targetSequence) {
        int count = 0;
        for (String event : eventsLog) {
            if (targetSequence.get(count).equals(event)) {
                count++;
            }
        }
        return count == targetSequence.size();
    }

    public static int hIndex(final int[] quotes) {
        int[] counts = new int[quotes.length + 1];

        for (int quote : quotes) {
            int currentValue = quote;
            if (currentValue > quotes.length) {
                currentValue = quotes.length;
            }
            counts[currentValue]++;
        }

        int hIndex = 0;
        int totalQuotes = 0;
        for (int i = counts.length - 1; i > 0; i--) {
            totalQuotes += counts[i];
            if (totalQuotes >= i) {
                hIndex = i;
                break;
            }
        }
        return hIndex;
    }

    private Small() {

    }
}
