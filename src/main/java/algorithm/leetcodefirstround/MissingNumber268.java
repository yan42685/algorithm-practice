package algorithm.leetcodefirstround;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: alexyan
 * @date: 5/28/2019 19:18
 * @description:
 */
public class MissingNumber268 {
    /**
     * O(N) time O(N) space
     */
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        for (int i = 0; i < nums.length + 1; i++)
            if (!set.contains(i))
                return i;
        throw new IllegalArgumentException("no missing number in nums");
    }

    /**
     * Bit Manipulation O(N) time O(1) space
     */
    public int missingNumber2(int[] nums) {
        int xor = nums.length;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor;
    }

    /**
     * 求和相减 O(N) time O(1) space
     */
    public int missingNumber3(int[] nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result += i - nums[i];
        }
        return result;
    }

}
