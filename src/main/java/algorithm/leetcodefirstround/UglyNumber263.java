package algorithm.leetcodefirstround;

/**
 * @author alexyan
 * @date 1/7/2020 06:11
 */
public class UglyNumber263 {
    public boolean isUgly(int num) {
        for (int i = 2; i < 6 && num > 0; i++) {
            while (num % i == 0) {
                num /= i;
            }
        }
        return num == 1;
    }
}
