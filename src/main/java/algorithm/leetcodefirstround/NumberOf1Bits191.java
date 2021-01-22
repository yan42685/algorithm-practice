package algorithm.leetcodefirstround;

/**
 * @author alexyan
 * @date 1/6/2020 07:37
 */
public class NumberOf1Bits191 {
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            result += n & 1;
            n >>>= 1;
        }
        return result;
    }
}
