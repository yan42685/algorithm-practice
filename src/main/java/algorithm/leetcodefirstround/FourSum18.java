package algorithm.leetcodefirstround;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: alexyan
 * @date: 5/29/2019 20:13
 * @description:
 */


public class FourSum18 {
    /**
     * O(N^3) time
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] * 4 > target) {
                break;
            }
            if (i == 0 || nums[i - 1] != nums[i]) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i + 1 || nums[j - 1] != nums[j]) {
                        int low = j + 1, high = nums.length - 1;
                        int sum = target - nums[i] - nums[j];
                        while (low < high) {
                            if (nums[low] + nums[high] == sum) {
                                list.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                                while (low < high && nums[low] == nums[low + 1]) {
                                    low++;
                                }
                                while (low < high && nums[high] == nums[high - 1]) {
                                    high--;
                                }
                                low++;
                                high--;
                            } else if (nums[low] + nums[high] < sum) {
                                low++;
                            } else {
                                high--;
                            }
                        }
                    }
                }
            }
        }
        return list;
    }
}
