package algorithm.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BinarySearchTest {
    @Test
    public void testBSearch() {
        assertEquals(-1, BinarySearch.bSearch(new Integer[]{}, 1));
        assertEquals(-1, BinarySearch.bSearch(new Integer[]{1, 3}, 2));
        assertEquals(0, BinarySearch.bSearch(new Integer[]{1, 2, 3}, 1));

        // 断言抛出异常
        String i = null;
        assertThrows(Exception.class, () -> Integer.valueOf(i));
    }
}

