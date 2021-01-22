package algorithm.leetcodefirstround;

import java.util.Arrays;

/**
 * @author: alexyan
 * @date: 5/29/2019 20:07
 * @description:
 */
public class ThreeSumCloset16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == target) return sum;
                else if (sum < target) low++;
                else high--;
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
            }
        }
        return res;
    }
}
