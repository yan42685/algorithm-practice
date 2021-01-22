package algorithm.leetcodefirstround;

/**
 * @author: alexyan
 * @date: 10/12/2019 09:48
 * @description:
 */
public class ReverseInteger7 {
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result*10 + tail;
            if ((newResult-tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1463847429));
    }

}
