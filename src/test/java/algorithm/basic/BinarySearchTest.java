package algorithm.basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BinarySearchTest {
    private final BinarySearch bs = new BinarySearch();
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3,4,5}, 3, 2, 2, 2),    //target is in the middle
                Arguments.of(new int[]{1,2,3,3,3,6,7}, 3, 3, 2, 4), //multiple targets
                Arguments.of(new int[]{1,2,3,4,5}, 6, -1, -1, -1), //target is larger than any element
                Arguments.of(new int[]{1,2,3,4,5}, 0, -1, -1, -1), //target is smaller than any element
                Arguments.of(new int[]{1,2,3,4,5}, 1, 0, 0, 0),    //target is the first element
                Arguments.of(new int[]{1,2,3,4,5}, 5, 4, 4, 4)     //target is the last element
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testSearch(int[] nums, int target, int expectedSearch, int expectedFirst, int expectedLast) {
        Assertions.assertEquals(expectedSearch, bs.search(nums, target));
    }
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testFirst(int[] nums, int target, int expectedSearch, int expectedFirst, int expectedLast) {
        Assertions.assertEquals(expectedFirst, bs.findFirst(nums, target));
    }
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testLast(int[] nums, int target, int expectedSearch, int expectedFirst, int expectedLast) {
        Assertions.assertEquals(expectedLast, bs.findLast(nums, target));
    }
}
