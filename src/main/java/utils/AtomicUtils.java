package utils;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicUtils {
    /**
     * 尝试加一个值，直到成功为止
     */
    public static void addInt(AtomicInteger atomicInteger, int delta) {
        int prevValue;
        int newValue;
        do {
            prevValue = atomicInteger.get();
            newValue = prevValue + delta;
        } while (!atomicInteger.compareAndSet(prevValue, newValue));
    }

    /**
     * 尝试减去一个值，直到成功为止。
     */
    public static void reduceInt(AtomicInteger atomicInteger, int delta) {
        int prevValue;
        int newValue;
        do {
            prevValue = atomicInteger.get();
            newValue = prevValue - delta;
        } while (!atomicInteger.compareAndSet(prevValue, newValue));
    }

    /**
     * 尝试加一个值，直到成功为止
     */
    public static void addLong(AtomicLong atomicLong, long delta) {
        long prevValue;
        long newValue;
        do {
            prevValue = atomicLong.get();
            newValue = prevValue + delta;
        } while (!atomicLong.compareAndSet(prevValue, newValue));
    }

    /**
     * 尝试减去一个值，直到成功为止。
     */
    public static void reduceLong(AtomicLong atomicLong, long delta) {
        long prevValue;
        long newValue;
        do {
            prevValue = atomicLong.get();
            newValue = prevValue - delta;
        } while (!atomicLong.compareAndSet(prevValue, newValue));
    }
}
