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
}
