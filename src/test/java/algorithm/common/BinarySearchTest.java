package algorithm.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BinarySearchTest {
    @Test
    public void testBSearch() {
        assertEquals(-1, BinarySearch.bSearch(new Integer[]{}, 1));
        assertEquals(-1, BinarySearch.bSearch(new Integer[]{1, 3}, 2));
        assertEquals(0, BinarySearch.bSearch(new Integer[]{1, 2, 3}, 1));
    }
}

