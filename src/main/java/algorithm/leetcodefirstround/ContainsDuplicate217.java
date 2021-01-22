package algorithm.leetcodefirstround;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: alexyan
 * @date: 5/28/2019 18:42
 * @description:
 */
public class ContainsDuplicate217 {
    /**
     * O(N) time O(N) space
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> distinct = new HashSet<>();
        for (int num : nums) {
            if (distinct.contains(num))
                return true;
            distinct.add(num);
        }
        return false;
    }

    /**
     * O(NlogN) time O(1) space
     */
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
