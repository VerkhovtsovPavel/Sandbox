package my.sandbox;

import java.util.*;
import java.util.stream.Collectors;

public final class Small {

    private Small() {

    }

    public static void main(String[] args) {

    }

    public static int[] uniqueElements(int[] array) {
        List<Integer> temp = new ArrayList<>();
        Arrays.stream(array).forEach(temp::add);

        int tempLength = temp.size();
        int counter = 0;
        while (tempLength > counter) {
            for (int k = counter+1; k < tempLength; k++) {
                if(Objects.equals(temp.get(counter), temp.get(k))){
                    temp.remove(k);
                    tempLength--;
                    k--;
                }
            }
            counter++;
        }
        array = temp.stream().mapToInt(i -> i).toArray();
        return array;
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
}
