package algorithm.basic.stringmatch;

public class StringMatch {

    // 假设字符集是ASCII
    private static final int BASE = 256;
    private static final int PRIME_NUMBER = 1111111139;

    // 返回第一个匹配的首字符位置
    public static int match(String s, String target) {
        long targetHash = 0;
        for (char c : target.toCharArray()) {
            targetHash = hash(targetHash, target.length(), c, "expand");
        }
        long windowHash = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            ++right;
            windowHash = hash(windowHash, target.length(), c, "expand");
            if (right - left == target.length()) {
                // hash相同可能是hash冲突了，所以需要暴力匹配来确认
                if (windowHash == targetHash && isEqual(s, left, target)) {
                    return left;
                } else {
                    char removed = s.charAt(left);
                    ++left;
                    windowHash = hash(windowHash, target.length(), removed, "shrink");
                }
            }
        }
        return -1;
    }

    private static long hash(long originHash, int length, char c, String mode) {
        int num = c;
        long result = -1;
        if ("expand".equals(mode)) {
            result = originHash * BASE + num;
        } else if ("shrink".equals(mode)) {
            result = originHash - num * pow(BASE, length - 1);
        } else {
            throw new IllegalArgumentException("mode: " + mode);
        }
        return result;
    }

    // 不使用Math.pow的double结果，防止溢出
    private static long pow(int base, int length) {
        int result = 1;
        for (int i = 0; i < length; i++) {
            result = (result * base) % PRIME_NUMBER;
        }
        return result;
    }

    // 替代subString, 减少不必要的字符访问
    private static boolean isEqual(String s, int left, String target) {
        for (int i = 0; i < target.length(); i++) {
            if (s.charAt(left + i) != target.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
