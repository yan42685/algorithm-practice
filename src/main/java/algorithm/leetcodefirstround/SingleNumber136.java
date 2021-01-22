package algorithm.leetcodefirstround;

/**
 * @author: alexyan
 * @date: 10/11/2019 18:57
 * @description: 异或的去重性质应用
 */
public class SingleNumber136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
