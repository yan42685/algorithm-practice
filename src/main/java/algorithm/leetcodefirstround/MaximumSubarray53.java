package algorithm.leetcodefirstround;

/**
 * @author: alexyan
 * @date: 5/26/2019 12:39
 * @description:
 */
public class MaximumSubarray53 {
    /**
     * dp问题，sum保存去掉负数和前缀的子序列的各项之和,
     * tmpMax保存最大的和，因为之后加上的nums[i]可能导致sum变小
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException();
        int sum = 0;
        int tmpMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(sum, 0) + nums[i];
            tmpMax = Math.max(tmpMax, sum);
        }
        return tmpMax;
    }
}
