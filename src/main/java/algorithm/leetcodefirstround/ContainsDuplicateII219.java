package algorithm.leetcodefirstround;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: alexyan
 * @date: 5/28/2019 19:00
 * @description:
 */
public class ContainsDuplicateII219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> distinct = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (distinct.containsKey(nums[i]) && Math.abs(i - distinct.get(nums[i])) <= k)
                return true;
            distinct.put(nums[i], i);
        }
        return false;
    }
}
