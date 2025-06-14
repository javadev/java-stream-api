package java_stream_api;

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
        return users.stream().filter(u -> u.getAge() > 18).map(User::getName).collect(Collectors.toList());
    }
    
    // 14. Sort a list of strings by their length.
    public static List<String> sortStringsByLength(List<String> strList) {
        return strList.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
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
        return users.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
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
        return strList.stream().filter(x -> counter.incrementAndGet() % 3 == 0).collect(Collectors.toList());
    }
    
    // 27. Calculate the total number of hobbies all users have.
    public static int totalHobbiesCount(List<User> users) {
        return users.stream().mapToInt(u -> u.getHobbies().size()).sum();
    }
    
    // 28. Find a list of strings that appear more than once in a list.
    public static List<String> duplicateStrings(List<String> strList) {
        return strList.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }
    
    // 29. Convert all users' birthdates to string "AGE MM YYYY".
    public static List<User> convertBirthdatesToString(List<User> users) {
        users.forEach(user -> user.setBirthdate(user.getAge() + " MM YYYY"));
        return users;
    }
    
    // 30. Filter a list of Person objects, keeping only those who live in "City X". 
    public static List<Person> filterPersonsByCity(List<Person> persons, String city) {
        return persons.stream().filter(p -> "City X".equals(p.getCity())).collect(Collectors.toList());
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
        return list.size() == 0 ? 0 : (nullCount * 100) / list.size();
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
        return rnd.ints(100, 0, 1000).boxed()
            .sorted(Comparator.reverseOrder()).limit(5)
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
        return strList.stream().map(String::length)
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
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
        return users.stream().map(User::getName)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
