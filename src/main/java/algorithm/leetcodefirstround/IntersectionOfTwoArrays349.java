package algorithm.leetcodefirstround;

import java.util.HashSet;
import java.util.Set;

/**
 * @author alexyan
 * @date 1/7/2020 06:38
 */
public class IntersectionOfTwoArrays349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersection.add(nums2[i]);
            }
        }
        int i = 0;
        int[] result = new int[intersection.size()];
        for (Integer num : intersection) {
            result[i++] = num;
        }
        return result;
    }
}
