package utils;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AtomicUtilsTest {
    @Test
    public void testAddInt() {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        AtomicUtils.addInt(atomicInteger, 5);
        assertEquals(5, atomicInteger.get());
    }

}

