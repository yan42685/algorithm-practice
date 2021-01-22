package algorithm.leetcodefirstround;

/**
 * @author alexyan
 * @date 1/7/2020 06:24
 */

/**
 * 1. num & (num-1) 一定为0
 * 2. num的二进制表示只有一个1且在奇数位
 */
public class PowerOfFour342 {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }
}
