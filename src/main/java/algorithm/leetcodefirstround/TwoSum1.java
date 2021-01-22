package algorithm.leetcodefirstround;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: alexyan
 * @date: 5/26/2019 10:15
 * @description:
 */
public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
        
    }
}
