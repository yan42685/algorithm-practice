package algorithm.leetcodefirstround;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: alexyan
 * @date: 5/28/2019 13:11
 * @description:
 */
public class MajorityElement169 {
    /**
     * O(nlogn) time O(1) space
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 摩尔投票法, O(n) time O(1) space
     */
    public int majorityElement2(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
                count++;
            }
            else if (nums[i] == major) count++;
            else count--;
        }
        return major;
    }

    /**
     * 用HashMap time: O(n)~O(n^2)
     */
    public int majorityElement3(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.replace(nums[i], map.get(nums[i]) + 1);
                if (map.get(nums[i]) > nums.length / 2)
                    return nums[i];
            }
            else map.put(nums[i], 1);
        }
        return nums[0];
    }
}
