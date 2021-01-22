package algorithm.leetcodefirstround;

/**
 * @author alexyan
 * @date 1/7/2020 12:42
 * 这里额外实现了减法
 */
public class SumOfTwoIntegers371 {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    private int negate(int a) {
        return getSum(~a, 1);
    }

    public int getSubtraction(int a, int b) {
        return getSum(a, negate(b));
    }
}
