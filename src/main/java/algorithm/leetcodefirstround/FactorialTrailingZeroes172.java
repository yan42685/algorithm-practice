package algorithm.leetcodefirstround;

/**
 * @author alexyan
 * @date 1/6/2020 06:43
 */
public class FactorialTrailingZeroes172 {
    /**
     * recursive
     */
    public int trailingZeroes1(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes1(n / 5);
    }

    /**
     * Iterative
     */
    public int trailingZeroes2(int n) {
        int result = 0;
        for (long i = 5; n / i > 0; i *= 5) {
            result += n / i;
        }
        return result;
    }

}
