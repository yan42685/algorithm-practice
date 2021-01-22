package algorithm.leetcodefirstround;

/**
 * @author: alexyan
 * @date: 10/12/2019 15:53
 * @description: 此题关键是解决溢出问题，这里将 newBase = base*10 + tail 拆分为乘法和加法分别检测溢出
 */
public class StringToInteger8 {
    public static int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty()) return 0;
        int i = 0, sign = 1, base = 0;
        if (str.charAt(i) == '-' || str.charAt(i) == '+')
            sign = str.charAt(i++) == '-' ? -1 : 1;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int tail = str.charAt(i) - '0';
            long tmp = (long) base * (long) 10;
            if (tmp != (int)tmp) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            int newBase = (int) tmp + tail;
            if (((newBase ^ (int) tmp) & (newBase ^ tail)) < 0) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = newBase;
            i++;
        }
        return sign * base;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-91283472332"));
    }
}
