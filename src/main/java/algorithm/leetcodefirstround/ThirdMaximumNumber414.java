package algorithm.leetcodefirstround;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author: alexyan
 * @date: 5/29/2019 09:35
 * @description:
 */
public class ThirdMaximumNumber414 {
    /**
     * 优先级队列和集合
     */
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.add(num)) {
                pq.offer(num);
                if (pq.size() > 3)
                    pq.poll();
            }
        }
        if (pq.size() == 2)
            pq.poll();
        return pq.peek();
    }
}
