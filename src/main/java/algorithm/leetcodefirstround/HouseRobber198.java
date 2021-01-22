package algorithm.leetcodefirstround;

import java.util.Arrays;

/**
 * @author alexyan
 * @date 1/6/2020 07:39
 */
public class HouseRobber198 {
    /**
     * top-bottom 重复计算了 rob(i)
     */
    public int rob1(int[] nums) {
        return rob1(nums, nums.length - 1);
    }

    private int rob1(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        return Math.max(rob1(nums, i - 2) + nums[i], rob1(nums, i - 1));
    }


    /**
     * top-bottom 用memo数组记忆rob(i)
     */
    int[] memo;

    public int rob2(int[] nums) {
        this.memo = new int[nums.length];
        Arrays.fill(this.memo, -1);
        return rob2(nums, nums.length - 1);
    }

    private int rob2(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        if (this.memo[i] >= 0) {
            return this.memo[i];
        }
        int result = Math.max(rob2(nums, i - 2) + nums[i], rob2(nums, i - 1));
        this.memo[i] = result;
        return result;
    }

    /**
     * 动态规划
     * 状态转移方程：dp[i] = Math.max(dp[i - 2] + nums[i - 2], dp[i - 1])
     */
    public int rob3(int[] nums) {
        int prev1 = 0;
        int prev2 = 0;
        int tmp = 0;
        for (int num : nums) {
            tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }

}
