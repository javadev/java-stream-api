package java_stream_api;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;

@DisplayName("App (Java Stream API Examples) Unit Tests - Full Coverage")
class AppTest {

    @Test
    @DisplayName("Counts number of elements in the list correctly")
    void testFindNumberOfElements() {
        assertEquals(
                3,
                App.findNumberOfElements(Arrays.asList("a", "b", "c")),
                "Should provide correct count of 3");
        assertEquals(
                0, App.findNumberOfElements(Collections.emptyList()), "Empty list should return 0");
    }

    @Test
    @DisplayName("Converts all strings to uppercase")
    void testConvertStringsToUppercase() {
        assertEquals(
                Arrays.asList("A", "B"),
                App.convertStringsToUppercase(Arrays.asList("a", "b")),
                "Lowercase letters should become uppercase");
    }

    @Test
    @DisplayName("Filters strings starting with 'A'")
    void testFilterStringsStartingWithA() {
        assertEquals(
                Arrays.asList("Apple", "Axe"),
                App.filterStringsStartingWithA(Arrays.asList("Apple", "Axe", "Bob")),
                "Only Apple and Axe begin with A");
    }

    @Test
    @DisplayName("Finds unique integers")
    void testUniqueIntegers() {
        assertEquals(
                Arrays.asList(1, 2, 3),
                App.uniqueIntegers(Arrays.asList(1, 2, 2, 3, 1)),
                "Should deduplicate");
    }

    @Test
    @DisplayName("Sums integers")
    void testSumOfIntegers() {
        assertEquals(6, App.sumOfIntegers(Arrays.asList(1, 2, 3)), "Sum should be 6");
    }

    @Test
    @DisplayName("Finds minimum integer")
    void testMinOfIntegers() {
        assertEquals(-2, App.minOfIntegers(Arrays.asList(-2, 1, 0, 5)), "Min should be -2");
        assertEquals(
                Integer.MIN_VALUE,
                App.minOfIntegers(Collections.emptyList()),
                "Empty returns MIN_VALUE");
    }

    @Test
    @DisplayName("Finds maximum integer")
    void testMaxOfIntegers() {
        assertEquals(8, App.maxOfIntegers(Arrays.asList(1, 4, 8)), "Max should be 8");
        assertEquals(
                Integer.MAX_VALUE,
                App.maxOfIntegers(Collections.emptyList()),
                "Empty returns MAX_VALUE");
    }

    @Test
    @DisplayName("Joins strings with comma")
    void testConcatenateStringsWithComma() {
        assertEquals(
                "a, b",
                App.concatenateStringsWithComma(Arrays.asList("a", "b")),
                "Join should be 'a, b'");
    }

    @Test
    @DisplayName("Gets first integer or zero")
    void testGetFirstIntegerOrZero() {
        assertEquals(
                10,
                App.getFirstIntegerOrZero(Arrays.asList(10, 20)),
                "Should get the first element, 10");
        assertEquals(0, App.getFirstIntegerOrZero(Collections.emptyList()), "Return 0 for empty");
    }

    @Test
    @DisplayName("Gets last string or empty")
    void testGetLastString() {
        assertEquals(
                "c", App.getLastString(Arrays.asList("a", "c")), "Should get last string, 'c'");
        assertEquals("", App.getLastString(Collections.emptyList()), "Empty returns ''");
    }

    @Test
    @DisplayName("Squares each integer")
    void testListOfSquares() {
        assertEquals(
                Arrays.asList(1, 4, 9),
                App.listOfSquares(Arrays.asList(1, 2, 3)),
                "Squares should be 1,4,9");
    }

    @Test
    @DisplayName("Filters only even numbers")
    void testFilterEvenNumbers() {
        assertEquals(
                Arrays.asList(2, 4),
                App.filterEvenNumbers(Arrays.asList(1, 2, 3, 4)),
                "Should return [2,4]");
    }

    @Test
    @DisplayName("Finds names of users > 18")
    void testNamesOfUsersOlderThan18() {
        List<User> users =
                Arrays.asList(new User("Ann", 19), new User("Bob", 10), new User("Carl", 25));
        assertEquals(
                Arrays.asList("Ann", "Carl"),
                App.namesOfUsersOlderThan18(users),
                "Should retain Ann and Carl");
    }

    @Test
    @DisplayName("Sort strings by length")
    void testSortStringsByLength() {
        assertEquals(
                Arrays.asList("z", "yes", "tees"),
                App.sortStringsByLength(Arrays.asList("tees", "yes", "z")),
                "Should sort by length ascending");
    }

    @Test
    @DisplayName("Checks if contains 'Java'")
    void testContainsStringWithJava() {
        List<String> s1 = Arrays.asList("hi", "Java 8", "b");
        List<String> s2 = Arrays.asList("hi", "xyz");
        assertTrue(App.containsStringWithJava(s1), "'Java' should be found in list");
        assertFalse(App.containsStringWithJava(s2), "'Java' not present, should be false");
    }

    @Test
    @DisplayName("Merges two lists")
    void testMergeTwoStringLists() {
        assertEquals(
                Arrays.asList("a", "b", "c"),
                App.mergeTwoStringLists(Arrays.asList("a", "b"), Arrays.asList("c")),
                "Merged lists");
    }

    @Test
    @DisplayName("Averages list of ints")
    void testAverageOfIntegers() {
        assertEquals(
                1.5, App.averageOfIntegers(Arrays.asList(1, 2)), 0.0001, "Average should be 1.5");
        assertEquals(0.0, App.averageOfIntegers(Collections.emptyList()), "Empty yields avg 0.0");
    }

    @Test
    @DisplayName("Discards first three numbers")
    void testDiscardFirstThreeIntegers() {
        assertEquals(
                Arrays.asList(4, 5),
                App.discardFirstThreeIntegers(Arrays.asList(1, 2, 3, 4, 5)),
                "Should skip first three");
        assertEquals(
                Collections.emptyList(),
                App.discardFirstThreeIntegers(Arrays.asList(1, 2)),
                "Should return empty list if skipped all");
    }

    @Test
    @DisplayName("Keeps first three numbers")
    void testKeepFirstThreeIntegers() {
        assertEquals(
                Arrays.asList(1, 2, 3),
                App.keepFirstThreeIntegers(Arrays.asList(1, 2, 3, 4, 5)),
                "Limit to first three");
        assertEquals(
                Arrays.asList(1),
                App.keepFirstThreeIntegers(Arrays.asList(1)),
                "Less than three returns all");
    }

    @Test
    @DisplayName("Flattens list of strings to ASCII codes")
    void testStringToAsciiCodes() {
        List<String> input = Arrays.asList("Ab");
        List<Integer> result = App.stringToAsciiCodes(input);
        assertEquals(Arrays.asList((int) 'A', (int) 'b'), result, "Should flatten to ASCII codes");
    }

    @Test
    @DisplayName("Counts strings longer than 5")
    void testCountStringsLongerThan5() {
        assertEquals(
                1L,
                App.countStringsLongerThan5(Arrays.asList("123", "abcdef")),
                "Only 'abcdef' is longer than 5");
    }

    @Test
    @DisplayName("Map: String to its length")
    void testStringsToLengthMap() {
        Map<String, Integer> m = App.stringsToLengthMap(Arrays.asList("hey", "there"));
        assertEquals(3, m.get("hey"), "hey->3");
        assertEquals(5, m.get("there"), "there->5");
    }

    @Test
    @DisplayName("Sorts users by age")
    void testSortUsersByAge() {
        User u1 = new User("A", 40), u2 = new User("B", 25);
        List<User> users = Arrays.asList(u1, u2);
        List<User> sorted = App.sortUsersByAge(users);
        assertEquals(u2, sorted.get(0), "B is younger than A");
    }

    @Test
    @DisplayName("java_stream_api.User with max age")
    void testUserWithMaxAge() {
        User u1 = new User("A", 40), u2 = new User("B", 25);
        assertTrue(App.userWithMaxAge(Arrays.asList(u1, u2)).isPresent(), "Should not be empty");
        assertEquals(u1, App.userWithMaxAge(Arrays.asList(u1, u2)).get(), "A is oldest");
    }

    @Test
    @DisplayName("Checks if all strings > 3 len")
    void testAreAllStringsLongerThan3() {
        assertTrue(App.areAllStringsLongerThan3(Arrays.asList("abcd", "eeee")), "Both > 3");
        assertFalse(App.areAllStringsLongerThan3(Arrays.asList("ab", "abcd")), "One less than 3");
    }

    @Test
    @DisplayName("Selects every 3rd element (1-based)")
    void testSelectEvery3rd() {
        List<String> list = Arrays.asList("A", "B", "C", "D", "E", "F");
        assertEquals(
                Arrays.asList("C", "F"),
                App.selectEvery3rd(list),
                "Should return every 3rd element");
    }

    @Test
    @DisplayName("Counts total user hobbies")
    void testTotalHobbiesCount() {
        User u1 = new User("A", 20), u2 = new User("B", 21);
        u1.getHobbies().addAll(Arrays.asList("a", "b"));
        u2.getHobbies().addAll(Arrays.asList("c"));
        assertEquals(
                3, App.totalHobbiesCount(Arrays.asList(u1, u2)), "Should sum all hobbies (2+1=3)");
    }

    @Test
    @DisplayName("Finds strings that appear more than once")
    void testDuplicateStrings() {
        assertEquals(
                Arrays.asList("a"),
                App.duplicateStrings(Arrays.asList("a", "b", "a", "c")),
                "a appears twice");
    }

    @Test
    @DisplayName("Sets user birthdate as AGE MM YYYY")
    void testConvertBirthdatesToString() {
        User u = new User("AB", 25);
        List<User> out = App.convertBirthdatesToString(Arrays.asList(u));
        assertEquals(
                "25 MM YYYY",
                out.get(0).getBirthdate(),
                "Should set birthdate string as '25 MM YYYY'");
    }

    @Test
    @DisplayName("Filters persons living in 'City X'")
    void testFilterPersonsByCity() {
        Person a = new Person("Ann", "City X"), b = new Person("Bob", "City Y");
        List<Person> filtered = App.filterPersonsByCity(Arrays.asList(a, b), "City X");
        assertEquals(1, filtered.size(), "Only one person in City X");
        assertEquals(a, filtered.get(0), "Ann is from City X");
    }

    @Test
    @DisplayName("Reverses a list")
    void testReverseList() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        assertEquals(Arrays.asList(3, 2, 1), App.reverseList(input), "Should reverse the list");
    }

    @Test
    @DisplayName("Calculates percentage of nulls")
    void testPercentageOfNulls() {
        List<String> l = Arrays.asList(null, "a", null, "b");
        assertEquals(50, App.percentageOfNulls(l), "2 of 4 are null => 50%");
        assertEquals(0, App.percentageOfNulls(Collections.emptyList()), "Empty returns 0 percent");
    }

    @Test
    @DisplayName("Shuffles list in place")
    void testShuffleList() {
        List<Integer> list = IntStream.range(1, 6).boxed().collect(Collectors.toList());
        List<Integer> orig = new ArrayList<>(list);
        App.shuffleList(list);
        // Can't assert order, just size and content
        assertTrue(
                list.containsAll(orig) && orig.containsAll(list),
                "All elements retained after shuffle");
    }

    @Test
    @DisplayName("Groups integers by n%3")
    void testGroupByRemainder3() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Integer, List<Integer>> grouped = App.groupByRemainder3(input);
        assertEquals(Arrays.asList(3, 6), grouped.get(0), "Group 0 mod 3");
        assertEquals(Arrays.asList(1, 4), grouped.get(1), "Group 1 mod 3");
        assertEquals(Arrays.asList(2, 5), grouped.get(2), "Group 2 mod 3");
    }

    @Test
    @DisplayName("Boolean list: even = true, odd = false")
    void testEvenIntegersAsBooleans() {
        assertEquals(
                Arrays.asList(false, true),
                App.evenIntegersAsBooleans(Arrays.asList(1, 2)),
                "Even=TRUE, odd=FALSE");
    }

    @Test
    @DisplayName("Unique elements reversed")
    void testUniqueElementsReversed() {
        List<Integer> in = Arrays.asList(1, 2, 2, 3);
        assertEquals(Arrays.asList(3, 2, 1), App.uniqueElementsReversed(in), "Unique reversed");
    }

    @Test
    @DisplayName("Returns top 5 of 100 random numbers")
    void testTop5Of100Random() {
        List<Integer> list = App.top5Of100Random();
        assertEquals(5, list.size(), "Size is 5");
        for (int i = 1; i < list.size(); ++i)
            assertTrue(list.get(i) <= list.get(i - 1), "List should be descending");
    }

    @Test
    @DisplayName("Groups strings by length")
    void testGroupStringsByLength() {
        Map<Integer, List<String>> map = App.groupStringsByLength(Arrays.asList("a", "bb"));
        assertEquals(Arrays.asList("a"), map.get(1), "Group of length 1 has 'a'");
        assertEquals(Arrays.asList("bb"), map.get(2), "Group length 2 has 'bb'");
    }

    @Test
    @DisplayName("Finds string with largest length")
    void testLongestString() {
        assertEquals(
                "aaaa", App.longestString(Arrays.asList("a", "bb", "aaaa")), "Should be 'aaaa'");
        assertEquals("", App.longestString(Collections.emptyList()), "Empty list returns ''");
    }

    @Test
    @DisplayName("Removes names starting with 'J'")
    void testRemoveUsersWithJ() {
        List<String> in = Arrays.asList("Jim", "Bob", "Jackie");
        assertEquals(Arrays.asList("Bob"), App.removeUsersWithJ(in), "Only Bob remains");
    }

    @Test
    @DisplayName("Map: number to its square")
    void testIntegersToSquareMap() {
        Map<Integer, Integer> m = App.integersToSquareMap(Arrays.asList(2, 3, 4));
        assertEquals(4, m.get(2), "2->4");
        assertEquals(9, m.get(3), "3->9");
    }

    @Test
    @DisplayName("Counts total number of all words in sentences")
    void testTotalWordsInSentences() {
        assertEquals(3, App.totalWordsInSentences(Arrays.asList("a b", "c")), "Total words = 3");
    }

    @Test
    @DisplayName("Returns 'yes' if even, 'no' if not")
    void testYesNoIfEven() {
        List<String> expected = Arrays.asList("no", "yes", "yes");
        assertEquals(
                expected, App.yesNoIfEven(Arrays.asList(1, 2, 4)), "Correct 'yes'/'no' mapping");
    }

    @Test
    @DisplayName("Calculates range (max-min) in list")
    void testRangeOfNumbers() {
        assertEquals(9, App.rangeOfNumbers(Arrays.asList(3, 5, 12)), "12-3 = 9");
        assertEquals(0, App.rangeOfNumbers(Collections.emptyList()), "Empty returns 0");
    }

    @Test
    @DisplayName("List of string lengths, descending")
    void testLengthsDescending() {
        List<Integer> out = App.lengthsDescending(Arrays.asList("a", "bbb", "zz"));
        assertEquals(Arrays.asList(3, 2, 1), out, "Sort lengths descending");
    }

    @Test
    @DisplayName("Finds sum of all string lengths")
    void testSumStringLengths() {
        assertEquals(6, App.sumStringLengths(Arrays.asList("abc", "de", "f")), "3+2+1=6");
    }

    @Test
    @DisplayName("Counts number of elements equals null")
    void testCountNullElements() {
        assertEquals(
                2, App.countNullElements(Arrays.asList("a", null, null)), "Count of nulls = 2");
    }

    @Test
    @DisplayName("Groups users by year of birth")
    void testGroupUsersByBirthYear() {
        User u1 = new User("A", 20), u2 = new User("B", 20);
        u1.getBirthYear();
        u2.getBirthYear(); // avoid stackoverflow
        Map<Integer, List<User>> map = App.groupUsersByBirthYear(Arrays.asList(u1, u2));
        int year = u1.getBirthYear();
        assertTrue(map.containsKey(year), "Should contain year as key");
        assertEquals(2, map.get(year).size(), "Both users in birth group");
    }

    @Test
    @DisplayName("Unique, sorted characters from all strings")
    void testUniqueSortedCharacters() {
        List<Character> chars = App.uniqueSortedCharacters(Arrays.asList("bad", "cab"));
        assertEquals(Arrays.asList('a', 'b', 'c', 'd'), chars, "Sorted unique: a,b,c,d");
    }

    @Test
    @DisplayName("Returns user names sorted by name length")
    void testUserNamesSortedByLength() {
        User u1 = new User("Eve", 23), u2 = new User("Angelina", 30), u3 = new User("Abi", 19);
        List<String> result = App.userNamesSortedByLength(Arrays.asList(u1, u2, u3));
        assertEquals(Arrays.asList("Eve", "Abi", "Angelina"), result, "Sort by length ascending");
    }

    @Test
    @DisplayName("Main method runs without throwing exceptions")
    void testMainRunsWithoutException() {
        assertDoesNotThrow(() -> App.main(new String[] {}));
    }

    @Test
    @DisplayName("Group integers by even and odd")
    void testGroupByEvenOdd() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4);
        Map<Boolean, List<Integer>> result = App.groupByEvenOdd(input);
        assertEquals(Arrays.asList(2, 4), result.get(true), "Even numbers not grouped correctly");
        assertEquals(Arrays.asList(1, 3), result.get(false), "Odd numbers not grouped correctly");
    }

    @Test
    @DisplayName("Find the second largest element")
    void testSecondLargest() {
        List<Integer> input = Arrays.asList(10, 20, 30, 40);
        assertEquals(Optional.of(30), App.secondLargest(input), "Second largest number incorrect");
    }

    @Test
    @DisplayName("Get comma-separated list of first letters")
    void testFirstLettersAsString() {
        List<String> input = Arrays.asList("apple", "banana", "carrot");
        String result = App.firstLettersAsString(input);
        assertEquals("a,b,c", result, "First letters not joined correctly");
    }

    @Test
    @DisplayName("Partition strings by presence of digits")
    void testPartitionByContainsDigit() {
        List<String> input = Arrays.asList("abc", "a2b", "xyz3", "nope");
        Map<Boolean, List<String>> result = App.partitionByContainsDigit(input);
        assertEquals(
                Arrays.asList("a2b", "xyz3"),
                result.get(true),
                "Strings with digits not partitioned correctly");
        assertEquals(
                Arrays.asList("abc", "nope"),
                result.get(false),
                "Strings without digits not partitioned correctly");
    }

    @Test
    @DisplayName("Remove palindromes from a list")
    void testRemovePalindromes() {
        List<String> input = Arrays.asList("madam", "apple", "kayak");
        List<String> result = App.removePalindromes(input);
        assertTrue(result.contains("apple"), "Non-palindromes were removed incorrectly");
        assertFalse(result.contains("madam"), "Palindrome was not removed");
        assertFalse(result.contains("kayak"), "Palindrome was not removed");
    }

    @Test
    @DisplayName("Find most frequent string")
    void testMostFrequentString() {
        List<String> input = Arrays.asList("apple", "banana", "apple", "carrot", "banana", "apple");
        Optional<String> result = App.mostFrequentString(input);
        assertEquals(Optional.of("apple"), result, "Most frequent string not correct");
    }

    @Test
    @DisplayName("Remove blank and empty strings")
    void testRemoveBlankStrings() {
        List<String> input = Arrays.asList("apple", "", "  ", "banana");
        List<String> result = App.removeBlankStrings(input);
        assertEquals(
                Arrays.asList("apple", "banana"), result, "Blank or empty strings not removed");
    }

    @Test
    @DisplayName("Double odd numbers")
    void testDoubleOdds() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        List<Integer> result = App.doubleOdds(input);
        assertEquals(Arrays.asList(2, 2, 6), result, "Odds were not doubled correctly");
    }

    @Test
    @DisplayName("Replace negatives with zero")
    void testReplaceNegativesWithZero() {
        List<Integer> input = Arrays.asList(-5, 3, 0, -1);
        List<Integer> result = App.replaceNegativesWithZero(input);
        assertEquals(
                Arrays.asList(0, 3, 0, 0), result, "Negatives not replaced with zero correctly");
    }

    @Test
    @DisplayName("Map string-lengths to their count")
    void testLengthToCountMap() {
        List<String> input = Arrays.asList("a", "bb", "b", "aaa");
        Map<Integer, Long> result = App.lengthToCountMap(input);
        assertEquals(2L, result.get(1), "Count for length 1 incorrect");
        assertEquals(1L, result.get(2), "Count for length 2 incorrect");
        assertEquals(1L, result.get(3), "Count for length 3 incorrect");
    }

    @Test
    @DisplayName("Filter perfect squares")
    void testFilterPerfectSquares() {
        List<Integer> input = Arrays.asList(1, 2, 4, 9, 16, 20);
        List<Integer> result = App.filterPerfectSquares(input);
        assertEquals(Arrays.asList(1, 4, 9, 16), result, "Perfect squares not filtered correctly");
    }

    @Test
    @DisplayName("Find first non-repeating string")
    void testFirstNonRepeatingString() {
        List<String> input = Arrays.asList("a", "b", "a", "c", "b", "d");
        Optional<String> result = App.firstNonRepeatingString(input);
        assertEquals(Optional.of("c"), result, "First non-repeating string not correct");
    }

    @Test
    @DisplayName("Sum all odd numbers")
    void testSumOfOdds() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        int sum = App.sumOfOdds(input);
        assertEquals(9, sum, "Sum of odd numbers incorrect");
    }

    @Test
    @DisplayName("Capitalize first letter of each string")
    void testCapitalizeFirstLetter() {
        List<String> input = Arrays.asList("apple", "banana", "cat");
        List<String> result = App.capitalizeFirstLetter(input);
        assertEquals(
                Arrays.asList("Apple", "Banana", "Cat"),
                result,
                "Strings not capitalized correctly");
    }

    @Test
    @DisplayName("Find all pairs that sum to a given value")
    void testPairsThatSumTo() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4);
        List<int[]> result = App.pairsThatSumTo(input, 5);
        assertTrue(
                result.stream().anyMatch(arr -> arr[0] + arr[1] == 5),
                "Pairs not found for sum correctly");
    }

    @Test
    @DisplayName("Map word frequency in sentence, case-insensitive")
    void testWordFrequency() {
        String sentence = "apple banana apple Carrot banana carrot";
        Map<String, Long> result = App.wordFrequency(sentence);
        assertEquals(2L, result.get("banana"), "Banana frequency incorrect");
        assertEquals(2L, result.get("carrot"), "Carrot frequency incorrect");
    }

    @Test
    @DisplayName("Repeat each string twice")
    void testRepeatStringsTwice() {
        List<String> input = Arrays.asList("abc", "de");
        List<String> result = App.repeatStringsTwice(input);
        assertEquals(
                Arrays.asList("abcabc", "dede"), result, "Strings not repeated twice correctly");
    }

    @Test
    @DisplayName("Unique words from sentences")
    void testUniqueWords() {
        List<String> sentences = Arrays.asList("the cat", "the dog");
        Set<String> result = App.uniqueWords(sentences);
        assertTrue(
                result.contains("cat") && result.contains("the"),
                "Unique words not extracted correctly");
    }

    @Test
    @DisplayName("Sum excluding largest and smallest numbers")
    void testSumExcludingExtremes() {
        List<Integer> input = Arrays.asList(10, 20, 30, 40);
        int sum = App.sumExcludingExtremes(input);
        assertEquals(50, sum, "Sum excluding extremes incorrect");
    }

    @Test
    @DisplayName("Elements until first zero")
    void testUntilFirstZero() {
        List<Integer> input = Arrays.asList(1, 2, 0, 5);
        List<Integer> result = App.untilFirstZero(input);
        assertEquals(Arrays.asList(1, 2), result, "Elements until zero not found correctly");
    }

    @Test
    @DisplayName("Group words by first character")
    void testGroupByFirstChar() {
        List<String> input = Arrays.asList("apple", "arm", "bat");
        Map<Character, List<String>> result = App.groupByFirstChar(input);
        assertEquals(
                Arrays.asList("apple", "arm"),
                result.get('a'),
                "Grouping by first character incorrect");
    }

    @Test
    @DisplayName("Get N longest strings")
    void testNLongestStrings() {
        List<String> input = Arrays.asList("a", "ab", "abc");
        List<String> result = App.nLongestStrings(input, 2);
        assertEquals(
                Arrays.asList("abc", "ab"), result, "N longest strings not selected correctly");
    }

    @Test
    @DisplayName("Join numbers with dash")
    void testJoinNumbersWithDash() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        String result = App.joinNumbersWithDash(input);
        assertEquals("1-2-3", result, "Numbers not joined with dash correctly");
    }

    @Test
    @DisplayName("Swap even and odd indexed elements")
    void testSwapEvenOddIndexed() {
        List<String> input = Arrays.asList("a", "b", "c", "d");
        List<String> result = App.swapEvenOddIndexed(input);
        assertEquals(Arrays.asList("b", "a", "d", "c"), result, "Even and odd indices not swapped");
    }

    @Test
    @DisplayName("Return last N elements of list")
    void testLastNElements() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = App.lastNElements(input, 2);
        assertEquals(Arrays.asList(4, 5), result, "Last N elements not returned correctly");
    }

    @Test
    @DisplayName("Partition numbers into primes and non-primes")
    void testPartitionPrimes() {
        List<Integer> input = Arrays.asList(2, 4, 5, 6);
        Map<Boolean, List<Integer>> result = App.partitionPrimes(input);
        assertEquals(Arrays.asList(2, 5), result.get(true), "Primes not partitioned correctly");
    }

    @Test
    @DisplayName("Map strings to their reverse")
    void testStringToReverse() {
        List<String> input = Arrays.asList("abc", "de");
        Map<String, String> result = App.stringToReverse(input);
        assertEquals("cba", result.get("abc"), "String reverse incorrect");
        assertEquals("ed", result.get("de"), "String reverse incorrect");
    }

    @Test
    @DisplayName("Get all prefixes of each string")
    void testGetAllPrefixes() {
        List<String> input = Arrays.asList("ab");
        List<String> result = App.getAllPrefixes(input);
        assertTrue(result.containsAll(Arrays.asList("a", "ab")), "String prefixes not found");
    }

    @Test
    @DisplayName("Multiply all numbers in list")
    void testMultiplyAll() {
        List<Integer> input = Arrays.asList(2, 3, 4);
        int product = App.multiplyAll(input);
        assertEquals(24, product, "Product not calculated correctly");
    }

    @Test
    @DisplayName("Remove all vowels from strings")
    void testRemoveVowels() {
        List<String> input = Arrays.asList("apple", "sky");
        List<String> result = App.removeVowels(input);
        assertEquals(Arrays.asList("ppl", "sky"), result, "Vowels not removed correctly");
    }

    @Test
    @DisplayName("Count vowels in strings (per item)")
    void testVowelCounts() {
        List<String> input = Arrays.asList("apple", "sky");
        Map<String, Long> result = App.vowelCounts(input);
        assertEquals(2L, result.get("apple"), "Vowel count of 'apple' incorrect");
        assertEquals(0L, result.get("sky"), "Vowel count of 'sky' incorrect");
    }

    @Test
    @DisplayName("Count the number of palindromes")
    void testCountPalindromes() {
        List<String> input = Arrays.asList("madam", "abba", "apple");
        long count = App.countPalindromes(input);
        assertEquals(2L, count, "Number of palindromes incorrect");
    }

    @Test
    @DisplayName("Collect indices of negative numbers")
    void testIndicesOfNegatives() {
        List<Integer> input = Arrays.asList(-1, 2, -3, 4);
        List<Integer> result = App.indicesOfNegatives(input);
        assertEquals(Arrays.asList(0, 2), result, "Indices of negatives incorrect");
    }

    @Test
    @DisplayName("Group numbers by digit sum")
    void testGroupByDigitSum() {
        List<Integer> input = Arrays.asList(12, 21, 3, 30);
        Map<Integer, List<Integer>> result = App.groupByDigitSum(input);
        assertTrue(result.get(3).contains(3), "Digit sum grouping incorrect - 3");
        assertTrue(
                result.get(3).contains(12) || result.get(3).contains(21),
                "Digit sum grouping incorrect - 12/21");
    }

    @Test
    @DisplayName("Repeat each word by its length")
    void testRepeatByLength() {
        List<String> input = Arrays.asList("hi", "a");
        List<String> result = App.repeatByLength(input);
        assertEquals(Arrays.asList("hihi", "a"), result, "Repeat by length incorrect");
    }

    @Test
    @DisplayName("Check if string list is sorted")
    void testIsSorted() {
        List<String> input = Arrays.asList("a", "b", "c");
        assertTrue(App.isSorted(input), "List should be sorted");
        List<String> input2 = Arrays.asList("b", "a", "c");
        assertFalse(App.isSorted(input2), "List should be unsorted");
    }

    @Test
    @DisplayName("Zip two lists into entry pairs")
    void testZip() {
        List<String> l1 = Arrays.asList("a", "b");
        List<Integer> l2 = Arrays.asList(1, 2);
        List<Map.Entry<String, Integer>> result = App.zip(l1, l2);
        assertEquals("a", result.get(0).getKey(), "First element of zipped pair incorrect");
        assertEquals(1, result.get(0).getValue(), "Second element of zipped pair incorrect");
    }

    @Test
    @DisplayName("Get all substrings from string list")
    void testAllSubstrings() {
        List<String> input = Arrays.asList("ab");
        List<String> result = App.allSubstrings(input);
        assertTrue(result.containsAll(Arrays.asList("a", "ab", "b")), "All substrings not found");
    }

    @Test
    @DisplayName("Set all numbers to absolute value")
    void testSetNegativesToAbsolute() {
        List<Integer> input = Arrays.asList(-1, 2, -3);
        List<Integer> result = App.setNegativesToAbsolute(input);
        assertEquals(Arrays.asList(1, 2, 3), result, "Negative numbers not converted to absolute");
    }

    @Test
    @DisplayName("Find all palindromic numbers")
    void testPalindromicNumbers() {
        List<Integer> input = Arrays.asList(121, 12, 22, 132);
        List<Integer> result = App.palindromicNumbers(input);
        assertTrue(result.containsAll(Arrays.asList(121, 22)), "Palindromic numbers not found");
    }

    @Test
    @DisplayName("Map lowercased strings to their frequency")
    void testLowerCaseFrequency() {
        List<String> input = Arrays.asList("a", "A", "b");
        Map<String, Long> result = App.lowerCaseFrequency(input);
        assertEquals(2L, result.get("a"), "Lowercase frequency incorrect");
    }

    @Test
    @DisplayName("Filter Fibonacci numbers")
    void testFilterFibonacci() {
        List<Integer> input = Arrays.asList(2, 3, 5, 6);
        List<Integer> result = App.filterFibonacci(input);
        assertTrue(result.containsAll(Arrays.asList(2, 3, 5)), "Fibonacci numbers not filtered");
        assertFalse(result.contains(6), "Non-Fibonacci number included");
    }

    @Test
    @DisplayName("Get all differences between consecutive numbers")
    void testDifferences() {
        List<Integer> input = Arrays.asList(1, 3, 6, 10);
        List<Integer> result = App.differences(input);
        assertEquals(
                Arrays.asList(2, 3, 4),
                result,
                "Differences between consecutive elements incorrect");
    }

    @Test
    @DisplayName("Count how many strings end with a vowel")
    void testCountEndsWithVowel() {
        List<String> input = Arrays.asList("apple", "banana", "dog");
        long count = App.countEndsWithVowel(input);
        assertEquals(2L, count, "Strings ending with vowel counted incorrectly");
    }

    @Test
    @DisplayName("Get unique sorted words out of sentences")
    void testUniqueSortedWords() {
        List<String> input = Arrays.asList("the dog", "The Cat");
        List<String> result = App.uniqueSortedWords(input);
        assertEquals(Arrays.asList("cat", "dog", "the"), result, "Unique sorted words not found");
    }

    @Test
    @DisplayName("Get product of all even numbers")
    void testProductOfEvens() {
        List<Integer> input = Arrays.asList(2, 3, 4, 5);
        int result = App.productOfEvens(input);
        assertEquals(8, result, "Product of even numbers incorrect");
    }

    @Test
    @DisplayName("Replace each string by its length")
    void testStringLengths() {
        List<String> input = Arrays.asList("a", "abc");
        List<Integer> result = App.stringLengths(input);
        assertEquals(Arrays.asList(1, 3), result, "String lengths not mapped correctly");
    }

    @Test
    @DisplayName("Flatten a list of integer lists")
    void testFlattenIntegerLists() {
        List<List<Integer>> input = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3));
        List<Integer> result = App.flattenIntegerLists(input);
        assertEquals(Arrays.asList(1, 2, 3), result, "Integer lists not flattened");
    }

    @Test
    @DisplayName("Remove multiples of 3 or 5")
    void testRemoveMultiplesOf3Or5() {
        List<Integer> input = Arrays.asList(3, 5, 7, 9, 10, 11);
        List<Integer> result = App.removeMultiplesOf3Or5(input);
        assertEquals(Arrays.asList(7, 11), result, "Multiples of 3 or 5 not removed");
    }

    @Test
    @DisplayName("Longest string for each string length")
    void testLongestStringForEachLength() {
        List<String> input = Arrays.asList("a", "bb", "cc", "bbb");
        Map<Integer, String> result = App.longestStringForEachLength(input);
        assertEquals("a", result.get(1), "Longest string for length 1 incorrect");
        assertEquals("bbb", result.get(3), "Longest string for length 3 incorrect");
    }
}
