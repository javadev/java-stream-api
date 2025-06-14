package java_stream_api;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {
    // 1. Find the number of elements in a list of strings.
    public static long findNumberOfElements(List<String> strList) {
        return strList.stream().count();
    }

    // 2. Convert all strings in a list to uppercase.
    public static List<String> convertStringsToUppercase(List<String> strList) {
        return strList.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    // 3. Filter a list of strings, keeping only those that start with the letter 'A'.
    public static List<String> filterStringsStartingWithA(List<String> strList) {
        return strList.stream().filter(el -> el.startsWith("A")).collect(Collectors.toList());
    }

    // 4. Obtain unique integers from a list.
    public static List<Integer> uniqueIntegers(List<Integer> intsList) {
        return intsList.stream().distinct().collect(Collectors.toList());
    }

    // 5. Calculate the sum of all numbers in a list of integers.
    public static int sumOfIntegers(List<Integer> intsList) {
        return intsList.stream().mapToInt(Integer::intValue).sum();
    }

    // 6. Find the minimum number in a list of integers.
    public static int minOfIntegers(List<Integer> intsList) {
        return intsList.stream().mapToInt(Integer::intValue).min().orElse(Integer.MIN_VALUE);
    }

    // 7. Find the maximum number in a list of integers.
    public static int maxOfIntegers(List<Integer> intsList) {
        return intsList.stream().mapToInt(Integer::intValue).max().orElse(Integer.MAX_VALUE);
    }

    // 8. Concatenate all strings from a list into one string, separated by commas.
    public static String concatenateStringsWithComma(List<String> strList) {
        return strList.stream().collect(Collectors.joining(", "));
    }

    // 9. Get the first element of a list of integers or 0 if the list is empty.
    public static int getFirstIntegerOrZero(List<Integer> intsList) {
        return intsList.stream().mapToInt(Integer::intValue).findFirst().orElse(0);
    }

    // 10. Get the last element of a list of strings or "" if empty.
    public static String getLastString(List<String> strList) {
        return strList.stream().reduce((first, second) -> second).orElse("");
    }

    // 11. Convert a list of integers into a list of their squares.
    public static List<Integer> listOfSquares(List<Integer> intsList) {
        return intsList.stream().map(i -> i * i).collect(Collectors.toList());
    }

    // 12. Filter a list of integers, keeping only even numbers.
    public static List<Integer> filterEvenNumbers(List<Integer> intsList) {
        return intsList.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
    }

    // 13. Find people older than 18 years and return a list of their names.
    public static List<String> namesOfUsersOlderThan18(List<User> users) {
        return users.stream()
                .filter(u -> u.getAge() > 18)
                .map(User::getName)
                .collect(Collectors.toList());
    }

    // 14. Sort a list of strings by their length.
    public static List<String> sortStringsByLength(List<String> strList) {
        return strList.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    // 15. Check if a list of strings contains at least one string that includes the word "Java."
    public static boolean containsStringWithJava(List<String> strList) {
        return strList.stream().anyMatch(str -> str.contains("Java"));
    }

    // 16. Merge two lists of strings into one.
    public static List<String> mergeTwoStringLists(List<String> list1, List<String> list2) {
        return Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
    }

    // 17. Get the average value of all numbers in a list of integers.
    public static double averageOfIntegers(List<Integer> intsList) {
        return intsList.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    // 18. Discard the first three elements in a list of integers.
    public static List<Integer> discardFirstThreeIntegers(List<Integer> intsList) {
        return intsList.stream().skip(3).collect(Collectors.toList());
    }

    // 19. Keep only the first three elements of a list of integers.
    public static List<Integer> keepFirstThreeIntegers(List<Integer> intsList) {
        return intsList.stream().limit(3).collect(Collectors.toList());
    }

    // 20. Convert each string into a list of integers representing the character codes.
    public static List<Integer> stringToAsciiCodes(List<String> strList) {
        return strList.stream().flatMapToInt(String::chars).boxed().collect(Collectors.toList());
    }

    // 21. Count the number of strings longer than 5 characters.
    public static long countStringsLongerThan5(List<String> strList) {
        return strList.stream().filter(s -> s.length() > 5).count();
    }

    // 22. Create a map from a list of strings where key - string, value - its length.
    public static Map<String, Integer> stringsToLengthMap(List<String> strList) {
        return strList.stream().collect(Collectors.toMap(Function.identity(), String::length));
    }

    // 23. Sort a list of users by their age.
    public static List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    // 24. Find the user with the maximum age.
    public static Optional<User> userWithMaxAge(List<User> users) {
        return users.stream().max(Comparator.comparing(User::getAge));
    }

    // 25. Check if all strings in a list are longer than 3 characters.
    public static boolean areAllStringsLongerThan3(List<String> strList) {
        return strList.stream().allMatch(s -> s.length() > 3);
    }

    // 26. Select all every 3rd element from a list of strings (1-based).
    public static List<String> selectEvery3rd(List<String> strList) {
        AtomicInteger counter = new AtomicInteger();
        return strList.stream()
                .filter(x -> counter.incrementAndGet() % 3 == 0)
                .collect(Collectors.toList());
    }

    // 27. Calculate the total number of hobbies all users have.
    public static int totalHobbiesCount(List<User> users) {
        return users.stream().mapToInt(u -> u.getHobbies().size()).sum();
    }

    // 28. Find a list of strings that appear more than once in a list.
    public static List<String> duplicateStrings(List<String> strList) {
        return strList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    // 29. Convert all users' birthdates to string "AGE MM YYYY".
    public static List<User> convertBirthdatesToString(List<User> users) {
        users.forEach(user -> user.setBirthdate(user.getAge() + " MM YYYY"));
        return users;
    }

    // 30. Filter a list of Person objects, keeping only those who live in "City X".
    public static List<Person> filterPersonsByCity(List<Person> persons, String city) {
        return persons.stream().filter(p -> city.equals(p.getCity())).collect(Collectors.toList());
    }

    // 31. Reverse the order of elements in a list.
    public static <T> List<T> reverseList(List<T> list) {
        return IntStream.range(0, list.size())
                .mapToObj(i -> list.get(list.size() - 1 - i))
                .collect(Collectors.toList());
    }

    // 32. Find the percentage of elements with the value "null" in a list.
    public static long percentageOfNulls(List<?> list) {
        long nullCount = list.stream().filter(Objects::isNull).count();
        return list.isEmpty() ? 0 : (nullCount * 100) / list.size();
    }

    // 33. Shuffle the elements of a list randomly.
    public static <T> void shuffleList(List<T> list) {
        Collections.shuffle(list);
    }

    // 34. Group numbers by their remainder when divided by 3.
    public static Map<Integer, List<Integer>> groupByRemainder3(List<Integer> intsList) {
        return intsList.stream().collect(Collectors.groupingBy(n -> n % 3));
    }

    // 35. Convert a list of integers into a list of booleans: true for even, false for odd.
    public static List<Boolean> evenIntegersAsBooleans(List<Integer> intsList) {
        return intsList.stream().map(n -> n % 2 == 0).collect(Collectors.toList());
    }

    // 36. Filter a list, keeping only unique elements, and return the result in reverse order.
    public static <T> List<T> uniqueElementsReversed(List<T> list) {
        List<T> unique = list.stream().distinct().collect(Collectors.toList());
        Collections.reverse(unique);
        return unique;
    }

    // 37. Create a list of 100 random numbers and find the top 5 largest.
    public static List<Integer> top5Of100Random() {
        Random rnd = new Random();
        return rnd.ints(100, 0, 1000)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .collect(Collectors.toList());
    }

    // 38. Split a list of strings into groups by their length.
    public static Map<Integer, List<String>> groupStringsByLength(List<String> strList) {
        return strList.stream().collect(Collectors.groupingBy(String::length));
    }

    // 39. Find the element in a list that has the largest length.
    public static String longestString(List<String> strList) {
        return strList.stream().max(Comparator.comparing(String::length)).orElse("");
    }

    // 40. Remove from the list all users whose name starts with "J."
    public static List<String> removeUsersWithJ(List<String> names) {
        return names.stream().filter(n -> !n.startsWith("J")).collect(Collectors.toList());
    }

    // 41. Convert a list of integers into a map: number -> square.
    public static Map<Integer, Integer> integersToSquareMap(List<Integer> intsList) {
        return intsList.stream().collect(Collectors.toMap(n -> n, n -> n * n, (a, b) -> b));
    }

    // 42. Find the total number of all words in a list of sentences.
    public static long totalWordsInSentences(List<String> sentences) {
        return sentences.stream().flatMap(s -> Arrays.stream(s.split("\\s+"))).count();
    }

    // 43. Create a list of strings "yes" or "no," based on whether a number is even.
    public static List<String> yesNoIfEven(List<Integer> intsList) {
        return intsList.stream().map(n -> n % 2 == 0 ? "yes" : "no").collect(Collectors.toList());
    }

    // 44. Calculate the range in a list of numbers.
    public static int rangeOfNumbers(List<Integer> intsList) {
        int min = intsList.stream().mapToInt(i -> i).min().orElse(0);
        int max = intsList.stream().mapToInt(i -> i).max().orElse(0);
        return max - min;
    }

    // 45. List of lengths of strings, sorted in descending order.
    public static List<Integer> lengthsDescending(List<String> strList) {
        return strList.stream()
                .map(String::length)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    // 46. Find the sum of all string lengths in a list of strings.
    public static int sumStringLengths(List<String> strList) {
        return strList.stream().mapToInt(String::length).sum();
    }

    // 47. Count the number of elements equal to null in a list.
    public static long countNullElements(List<?> list) {
        return list.stream().filter(Objects::isNull).count();
    }

    // 48. Group users by their year of birth.
    public static Map<Integer, List<User>> groupUsersByBirthYear(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(User::getBirthYear));
    }

    // 49. Find all unique characters in a list of strings and form them into a sorted list.
    public static List<Character> uniqueSortedCharacters(List<String> strList) {
        return strList.stream()
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    // 50. Returns a list of user names, sorted by the length of these names.
    public static List<String> userNamesSortedByLength(List<User> users) {
        return users.stream()
                .map(User::getName)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    // 51. Group a list of integers by even or odd.
    public static Map<Boolean, List<Integer>> groupByEvenOdd(List<Integer> intsList) {
        return intsList.stream().collect(Collectors.groupingBy(n -> n % 2 == 0));
    }

    // 52. Find the second largest number in a list.
    public static Optional<Integer> secondLargest(List<Integer> intsList) {
        return intsList.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
    }

    // 53. Get a comma-separated list of the first letters of each string.
    public static String firstLettersAsString(List<String> strList) {
        return strList.stream()
                .filter(s -> !s.isEmpty())
                .map(s -> s.substring(0, 1))
                .collect(Collectors.joining(","));
    }

    // 54. Partition strings into those containing digits and those not.
    public static Map<Boolean, List<String>> partitionByContainsDigit(List<String> strList) {
        return strList.stream().collect(Collectors.partitioningBy(s -> s.matches(".*\\d.*")));
    }

    // 55. Remove palindromes from a list of strings.
    public static List<String> removePalindromes(List<String> strList) {
        return strList.stream()
                .filter(s -> !s.equals(new StringBuilder(s).reverse().toString()))
                .collect(Collectors.toList());
    }

    // 56. Find the most frequent string in a list.
    public static Optional<String> mostFrequentString(List<String> strList) {
        return strList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    // 57. Remove empty or blank strings from a list.
    public static List<String> removeBlankStrings(List<String> strList) {
        return strList.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toList());
    }

    // 58. Double only odd numbers in a list.
    public static List<Integer> doubleOdds(List<Integer> intsList) {
        return intsList.stream().map(n -> n % 2 != 0 ? n * 2 : n).collect(Collectors.toList());
    }

    // 59. Replace negative numbers in a list with zero.
    public static List<Integer> replaceNegativesWithZero(List<Integer> intsList) {
        return intsList.stream().map(n -> n < 0 ? 0 : n).collect(Collectors.toList());
    }

    // 60. Get a map of string lengths to the count of strings of that length.
    public static Map<Integer, Long> lengthToCountMap(List<String> strList) {
        return strList.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
    }

    // 61. Filter numbers that are perfect squares.
    public static List<Integer> filterPerfectSquares(List<Integer> intsList) {
        return intsList.stream()
                .filter(n -> n >= 0 && Math.sqrt(n) % 1 == 0)
                .collect(Collectors.toList());
    }

    // 62. Get the first non-repeating string in a list.
    public static Optional<String> firstNonRepeatingString(List<String> strList) {
        Map<String, Long> freq =
                strList.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Function.identity(),
                                        LinkedHashMap::new,
                                        Collectors.counting()));
        return freq.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
    }

    // 63. Sum of all odd numbers in a list.
    public static int sumOfOdds(List<Integer> intsList) {
        return intsList.stream().filter(n -> n % 2 != 0).mapToInt(Integer::intValue).sum();
    }

    // 64. Capitalize the first letter of each string.
    public static List<String> capitalizeFirstLetter(List<String> strList) {
        return strList.stream()
                .map(s -> s.isEmpty() ? s : s.substring(0, 1).toUpperCase() + s.substring(1))
                .collect(Collectors.toList());
    }

    // 65. Find all pairs of numbers that sum to a given value.
    public static List<int[]> pairsThatSumTo(List<Integer> intsList, int sum) {
        return intsList.stream()
                .flatMap(
                        i ->
                                intsList.stream()
                                        .filter(j -> j != i && i + j == sum)
                                        .map(j -> new int[] {i, j}))
                .collect(Collectors.toList());
    }

    // 66. Map each word in a sentence to its frequency (case-insensitive).
    public static Map<String, Long> wordFrequency(String sentence) {
        return Arrays.stream(sentence.toLowerCase().split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    // 67. Repeat each string in a list twice (e.g., "abc" -> "abcabc").
    public static List<String> repeatStringsTwice(List<String> strList) {
        return strList.stream().map(s -> s + s).collect(Collectors.toList());
    }

    // 68. Find unique words from a list of sentences.
    public static Set<String> uniqueWords(List<String> sentences) {
        return sentences.stream()
                .flatMap(s -> Arrays.stream(s.split("\\s+")))
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
    }

    // 69. Sum all elements except the largest and smallest.
    public static int sumExcludingExtremes(List<Integer> intsList) {
        return intsList.stream()
                .sorted()
                .skip(1)
                .limit(Math.max(0, intsList.size() - 2))
                .mapToInt(Integer::intValue)
                .sum();
    }

    // 70. Return the list truncated at the first occurrence of 0 (not including the 0).
    public static List<Integer> untilFirstZero(List<Integer> intsList) {
        List<Integer> result = new ArrayList<>();
        for (Integer n : intsList) {
            if (n == 0) break;
            result.add(n);
        }
        return result;
    }

    // 71. Group words by their first letter.
    public static Map<Character, List<String>> groupByFirstChar(List<String> strList) {
        return strList.stream()
                .filter(s -> !s.isEmpty())
                .collect(Collectors.groupingBy(s -> s.charAt(0)));
    }

    // 72. Get the N longest strings in a list.
    public static List<String> nLongestStrings(List<String> strList, int n) {
        return strList.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    // 73. Join all numbers as a string, separated by dashes.
    public static String joinNumbersWithDash(List<Integer> intsList) {
        return intsList.stream().map(String::valueOf).collect(Collectors.joining("-"));
    }

    // 74. Swap even and odd indexed elements in a list.
    public static <T> List<T> swapEvenOddIndexed(List<T> list) {
        List<T> copy = new ArrayList<>(list);
        for (int i = 0; i < copy.size() - 1; i += 2) {
            T temp = copy.get(i);
            copy.set(i, copy.get(i + 1));
            copy.set(i + 1, temp);
        }
        return copy;
    }

    // 75. Remove all elements except the last N elements.
    public static <T> List<T> lastNElements(List<T> list, int n) {
        return list.stream().skip(Math.max(0, list.size() - n)).collect(Collectors.toList());
    }

    // 76. Partition a list of numbers into primes and non-primes.
    public static Map<Boolean, List<Integer>> partitionPrimes(List<Integer> intsList) {
        return intsList.stream().collect(Collectors.partitioningBy(App::isPrime));
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) if (n % i == 0) return false;
        return true;
    }

    // 77. Map string to its reverse.
    public static Map<String, String> stringToReverse(List<String> strList) {
        return strList.stream()
                .collect(
                        Collectors.toMap(
                                Function.identity(),
                                s -> new StringBuilder(s).reverse().toString()));
    }

    // 78. Give a list of every prefix of each string (e.g. "abc" -> "a", "ab", "abc").
    public static List<String> getAllPrefixes(List<String> strList) {
        return strList.stream()
                .flatMap(s -> IntStream.rangeClosed(1, s.length()).mapToObj(i -> s.substring(0, i)))
                .collect(Collectors.toList());
    }

    // 79. Multiply all numbers in the list.
    public static int multiplyAll(List<Integer> intsList) {
        return intsList.stream().reduce(1, (a, b) -> a * b);
    }

    // 80. Remove all vowels from all strings in a list.
    public static List<String> removeVowels(List<String> strList) {
        return strList.stream()
                .map(s -> s.replaceAll("[AEIOUaeiou]", ""))
                .collect(Collectors.toList());
    }

    // 81. Create a map of strings to number of vowels in each.
    public static Map<String, Long> vowelCounts(List<String> strList) {
        return strList.stream()
                .collect(
                        Collectors.toMap(
                                Function.identity(),
                                s -> s.chars().filter(c -> "AEIOUaeiou".indexOf(c) >= 0).count()));
    }

    // 82. Count palindromes in a list.
    public static long countPalindromes(List<String> strList) {
        return strList.stream()
                .filter(s -> s.equals(new StringBuilder(s).reverse().toString()))
                .count();
    }

    // 83. Collect the indices of all negative numbers.
    public static List<Integer> indicesOfNegatives(List<Integer> intsList) {
        return IntStream.range(0, intsList.size())
                .filter(i -> intsList.get(i) < 0)
                .boxed()
                .collect(Collectors.toList());
    }

    // 84. Group numbers by the sum of their digits.
    public static Map<Integer, List<Integer>> groupByDigitSum(List<Integer> intsList) {
        return intsList.stream()
                .collect(
                        Collectors.groupingBy(
                                n ->
                                        String.valueOf(Math.abs(n))
                                                .chars()
                                                .map(Character::getNumericValue)
                                                .sum()));
    }

    // 85. For each word, repeat it as many times as its length (e.g., "hi" -> "hihi").
    public static List<String> repeatByLength(List<String> strList) {
        return strList.stream().map(s -> s.repeat(s.length())).collect(Collectors.toList());
    }

    // 86. Check if a string list is sorted (lexicographically).
    public static boolean isSorted(List<String> strList) {
        return IntStream.range(0, strList.size() - 1)
                .allMatch(i -> strList.get(i).compareTo(strList.get(i + 1)) <= 0);
    }

    // 87. Combine two lists into pairs (zip).
    public static <A, B> List<Map.Entry<A, B>> zip(List<A> listA, List<B> listB) {
        int size = Math.min(listA.size(), listB.size());
        return IntStream.range(0, size)
                .mapToObj(i -> new AbstractMap.SimpleEntry<>(listA.get(i), listB.get(i)))
                .collect(Collectors.toList());
    }

    // 88. Find all substrings of a string list.
    public static List<String> allSubstrings(List<String> strList) {
        return strList.stream()
                .flatMap(
                        s ->
                                IntStream.range(0, s.length())
                                        .boxed()
                                        .flatMap(
                                                i ->
                                                        IntStream.rangeClosed(i + 1, s.length())
                                                                .mapToObj(j -> s.substring(i, j))))
                .collect(Collectors.toList());
    }

    // 89. Set negative numbers to their absolute value.
    public static List<Integer> setNegativesToAbsolute(List<Integer> intsList) {
        return intsList.stream().map(Math::abs).collect(Collectors.toList());
    }

    // 90. Find all palindromic numbers in a list.
    public static List<Integer> palindromicNumbers(List<Integer> intsList) {
        return intsList.stream()
                .filter(
                        n -> {
                            String s = String.valueOf(Math.abs(n));
                            return s.equals(new StringBuilder(s).reverse().toString());
                        })
                .collect(Collectors.toList());
    }

    // 91. Map lowercased strings to their frequency.
    public static Map<String, Long> lowerCaseFrequency(List<String> strList) {
        return strList.stream()
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    // 92. Filter numbers that are Fibonacci numbers.
    public static List<Integer> filterFibonacci(List<Integer> intsList) {
        return intsList.stream().filter(App::isFibonacci).collect(Collectors.toList());
    }

    private static boolean isFibonacci(int n) {
        long x = 5L * n * n;
        return isPerfectSquare(x + 4) || isPerfectSquare(x - 4);
    }

    private static boolean isPerfectSquare(long x) {
        long s = (long) Math.sqrt(x);
        return s * s == x;
    }

    // 93. Get the difference between every consecutive element in a list.
    public static List<Integer> differences(List<Integer> intsList) {
        return IntStream.range(1, intsList.size())
                .mapToObj(i -> intsList.get(i) - intsList.get(i - 1))
                .collect(Collectors.toList());
    }

    // 94. Count the number of strings ending with a vowel.
    public static long countEndsWithVowel(List<String> strList) {
        return strList.stream()
                .filter(s -> !s.isEmpty() && "aeiouAEIOU".indexOf(s.charAt(s.length() - 1)) != -1)
                .count();
    }

    // 95. Extract only the unique sorted words from sentences.
    public static List<String> uniqueSortedWords(List<String> sentences) {
        return sentences.stream()
                .flatMap(s -> Arrays.stream(s.split("\\s+")))
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    // 96. Find the product of all even numbers.
    public static int productOfEvens(List<Integer> intsList) {
        return intsList.stream().filter(n -> n % 2 == 0).reduce(1, (a, b) -> a * b);
    }

    // 97. Replace each string with its length in a list.
    public static List<Integer> stringLengths(List<String> strList) {
        return strList.stream().map(String::length).collect(Collectors.toList());
    }

    // 98. Flatten a list of integer lists into a single list.
    public static List<Integer> flattenIntegerLists(List<List<Integer>> listOfLists) {
        return listOfLists.stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    // 99. Remove any integers that are multiples of either 3 or 5.
    public static List<Integer> removeMultiplesOf3Or5(List<Integer> intsList) {
        return intsList.stream().filter(n -> n % 3 != 0 && n % 5 != 0).collect(Collectors.toList());
    }

    // 100. Get the longest string for each string length.
    public static Map<Integer, String> longestStringForEachLength(List<String> strList) {
        return strList.stream()
                .collect(
                        Collectors.toMap(
                                String::length,
                                Function.identity(),
                                (s1, s2) -> s1.length() >= s2.length() ? s1 : s2));
    }

    public static void main(String[] args) {
        System.out.println("== Java Stream API Methods Demo ==");

        List<String> strList =
                Arrays.asList("One", "Two", "Three", "Four", "Five", "And", "Again", "Javaaaa");
        List<Integer> intsList = Arrays.asList(1, 2, 3, 4, 5, 6, 4, 2);
        List<String> moreStrs = Arrays.asList("Apple", "Banana", "Axe", "cat");

        List<User> users =
                Arrays.asList(new User("Alice", 25), new User("Bob", 17), new User("Eve", 30));
        users.get(0).getHobbies().addAll(Arrays.asList("reading", "sports"));
        users.get(2).getHobbies().add("dancing");

        List<Person> persons =
                Arrays.asList(new Person("Tom", "City X"), new Person("Jane", "City Y"));

        System.out.println("#1 Elements count: " + findNumberOfElements(strList));
        System.out.println("#2 To uppercase: " + convertStringsToUppercase(strList));
        System.out.println("#3 Starts with A: " + filterStringsStartingWithA(moreStrs));
        System.out.println("#4 Unique ints: " + uniqueIntegers(intsList));
        System.out.println("#5 Sum ints: " + sumOfIntegers(intsList));
        System.out.println("#6 Min int: " + minOfIntegers(intsList));
        System.out.println("#7 Max int: " + maxOfIntegers(intsList));
        System.out.println("#8 Join with comma: " + concatenateStringsWithComma(strList));
        System.out.println("#9 First int or zero: " + getFirstIntegerOrZero(intsList));
        System.out.println("#10 Last string: " + getLastString(strList));
        System.out.println("#11 List of squares: " + listOfSquares(intsList));
        System.out.println("#12 Even numbers: " + filterEvenNumbers(intsList));
        System.out.println("#13 Users > 18: " + namesOfUsersOlderThan18(users));
        System.out.println("#14 Sort by length: " + sortStringsByLength(strList));
        System.out.println("#15 Contains 'Java': " + containsStringWithJava(strList));
        System.out.println("#16 Merge string lists: " + mergeTwoStringLists(strList, moreStrs));
        System.out.println("#17 Average of ints: " + averageOfIntegers(intsList));
        System.out.println("#18 Skip 3 ints: " + discardFirstThreeIntegers(intsList));
        System.out.println("#19 First 3 ints: " + keepFirstThreeIntegers(intsList));
        System.out.println("#20 ASCII codes: " + stringToAsciiCodes(Arrays.asList("Ab", "C")));
        System.out.println("#21 Count > 5 chars: " + countStringsLongerThan5(strList));
        System.out.println("#22 String->length map: " + stringsToLengthMap(strList));
        System.out.println("#23 Users sorted by age: " + sortUsersByAge(users));
        System.out.println("#24 User with max age: " + userWithMaxAge(users).orElse(null));
        System.out.println("#25 All >3 length?: " + areAllStringsLongerThan3(strList));
        System.out.println("#26 Every 3rd element: " + selectEvery3rd(strList));
        System.out.println("#27 Total hobbies: " + totalHobbiesCount(users));
        System.out.println(
                "#28 Duplicates: "
                        + duplicateStrings(Arrays.asList("one", "two", "two", "one", "one")));
        System.out.println("#29 Convert birthdates: " + convertBirthdatesToString(users));
        System.out.println("#30 In 'City X': " + filterPersonsByCity(persons, "City X"));
        System.out.println("#31 Reverse list: " + reverseList(strList));
        System.out.println(
                "#32 % nulls: " + percentageOfNulls(Arrays.asList("a", null, null, "b")) + "%");
        List<String> shuffled = new ArrayList<>(strList);
        shuffleList(shuffled);
        System.out.println("#33 Shuffled: " + shuffled);
        System.out.println("#34 Group by n%3: " + groupByRemainder3(intsList));
        System.out.println("#35 Even->bool: " + evenIntegersAsBooleans(intsList));
        System.out.println("#36 Unique, reversed: " + uniqueElementsReversed(intsList));
        System.out.println("#37 Top 5 random: " + top5Of100Random());
        System.out.println("#38 Group strings by len: " + groupStringsByLength(strList));
        System.out.println("#39 Longest string: " + longestString(strList));
        System.out.println(
                "#40 Remove names w/ J: "
                        + removeUsersWithJ(Arrays.asList("Jim", "Bob", "Jane", "Alice")));
        System.out.println("#41 Int->square map: " + integersToSquareMap(intsList));
        System.out.println(
                "#42 Total words in sentences: "
                        + totalWordsInSentences(Arrays.asList("Hello world", "how are you")));
        System.out.println("#43 Yes/no even: " + yesNoIfEven(intsList));
        System.out.println("#44 Range: " + rangeOfNumbers(intsList));
        System.out.println("#45 Lengths desc: " + lengthsDescending(strList));
        System.out.println("#46 Sum of string lengths: " + sumStringLengths(strList));
        System.out.println(
                "#47 Null elements count: " + countNullElements(Arrays.asList(null, "a", null)));
        System.out.println("#48 Users by birthyear: " + groupUsersByBirthYear(users));
        System.out.println(
                "#49 Unique sorted chars: " + uniqueSortedCharacters(Arrays.asList("cab", "bad")));
        System.out.println("#50 User names by name len: " + userNamesSortedByLength(users));
    }
}
