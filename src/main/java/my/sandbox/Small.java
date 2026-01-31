package my.sandbox;

import static my.sandbox.common.constant.IntConstant.ONE;
import static my.sandbox.common.constant.IntConstant.TWO;
import static my.sandbox.common.constant.IntConstant.ZERO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Small {
    private Small() {
    }

    public static int[] uniqueElements(final int... array) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int item : array) {
            set.add(item);
        }
        return set.stream().mapToInt(i -> i).toArray();
    }

    // return an array with count of positives and sum of negatives
    @SuppressWarnings("checkstyle:streamOf")
    public static int[] countPositivesSumNegatives(final int... input) {
        if (input == null || input.length == ZERO) {
            return new int[ZERO];
        }
        int[] result = new int[TWO];
        result[ZERO] = (int) Arrays.stream(input).filter(x -> x > 0).count();
        result[ONE] = Arrays.stream(input).filter(x -> x < 0).sum();
        return result;
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
            } else if (counter == ONE) {
                result.append(currentLetter);
                currentLetter = letters[i];
            } else {
                result.append(currentLetter);
                result.append(counter);
                currentLetter = letters[i];
                counter = ONE;
            }

            if (i == letters.length - ONE) {
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

    public static int hIndex(final int... quotes) {
        int[] counts = new int[quotes.length + ONE];

        for (int quote : quotes) {
            int currentValue = quote;
            if (currentValue > quotes.length) {
                currentValue = quotes.length;
            }
            counts[currentValue]++;
        }

        int hIndex = 0;
        int totalQuotes = 0;
        for (int i = counts.length - ONE; i > 0; i--) {
            totalQuotes += counts[i];
            if (totalQuotes >= i) {
                hIndex = i;
                break;
            }
        }
        return hIndex;
    }

    public static String allNonconsecutiveBinaryStrings(int length) {
        long uppedBound = (long) Math.pow(2, length);
        String addedZeros = "0".repeat(length);
        List<String> nonconsecutiveBinaryStrings = new ArrayList<>();

        for (long i = 0; i < uppedBound; i++) {
            String candidate = addedZeros + Long.toBinaryString(i);
            if (!candidate.contains("11")) {
                nonconsecutiveBinaryStrings.add(candidate.substring(candidate.length() - length));
            }
        }

        return String.join(" ", nonconsecutiveBinaryStrings);
    }

    public static int uniqueSequenceCount(String value) {
        int maxSequence = 0;
        Set<Character> sequenceChars = new HashSet<>();
        for (char currentChar : value.toCharArray()) {
            if (sequenceChars.contains(currentChar)) {
                int currentSequence = sequenceChars.size();
                if (currentSequence > maxSequence) {
                    maxSequence = currentSequence;
                }
                sequenceChars.clear();
            }
            sequenceChars.add(currentChar);
        }

        int currentSequence = sequenceChars.size();
        if (currentSequence > maxSequence) {
            maxSequence = currentSequence;
        }
        return maxSequence;
    }

    public static List<Integer> strictTwoOutOfThreeWithUniqueElements(List<Integer> a, List<Integer> b,
                                                                      List<Integer> c) {
        Map<Integer, Integer> mapA = toMap(a);
        Map<Integer, Integer> mapB = toMap(b);
        Map<Integer, Integer> mapC = toMap(c);

        Map<Integer, Integer> result = new HashMap<>();
        compareMaps(mapA, mapB, mapC, result);
        compareMaps(mapB, mapA, mapC, result);
        compareMaps(mapC, mapA, mapB, result);

        List<Integer> finalResult = new ArrayList<>();
        result.forEach((k, v) ->
            IntStream.range(0, v).mapToObj(i -> k).forEach(finalResult::add)
        );

        return finalResult;
    }

    private static void compareMaps(Map<Integer, Integer> coreMap,
                                    Map<Integer, Integer> firstMap,
                                    Map<Integer, Integer> secondMap,
                                    Map<Integer, Integer> result) {
        for (var item : coreMap.entrySet()) {
            if (firstMap.containsKey(item.getKey()) ^ secondMap.containsKey(item.getKey())
                || !firstMap.getOrDefault(item.getKey(), 0).equals(secondMap.getOrDefault(item.getKey(), 0))) {
                result.put(item.getKey(), Math.min(firstMap.getOrDefault(item.getKey(), Integer.MAX_VALUE),
                    secondMap.getOrDefault(item.getKey(), Integer.MAX_VALUE)));
            }
        }
    }

    private static Map<Integer, Integer> toMap(List<Integer> list) {
        return list.stream().map(x -> Map.entry(x, 1))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                Integer::sum));
    }
}
