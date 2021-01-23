package utils;

public class AssertUtils {
    public static void nonNull(Object object) {
        if (object == null) {
            throw new RuntimeException("非null断言失败");
        }
    }

    public static void equals(Object objectA, Object objectB) {
        if (!objectA.equals(objectB)) {
            throw new RuntimeException("相等断言失败");
        }
    }

    public static void isTrue(boolean predication) {
        if (!predication) {
            throw new RuntimeException("为真断言失败");
        }
    }

    public static void isFalse(boolean predication) {
        if (predication) {
            throw new RuntimeException("为假断言失败");
        }
    }
}
