package algorithm.leetcodefirstround;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: alexyan
 * @date: 10/11/2019 19:41
 * @description:
 */
public class IntersectionOfTwoArraysII350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        for (int num : nums1) {
            Integer count = map.get(num);
            if (count == null) {
                map.put(num, 1);
            } else {
                map.put(num, count + 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            Integer count = map.get(num);
            if (count != null && count != 0) {
                list.add(num);
                map.put(num, count - 1);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }


        return res;
    }
}
