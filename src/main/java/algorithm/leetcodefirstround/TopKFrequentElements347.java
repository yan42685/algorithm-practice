package algorithm.leetcodefirstround;

import java.util.*;

/**
 * @author alexyan
 * @date 1/12/2020 10:53
 */
public class TopKFrequentElements347 {
    /**
     * 优先级队列
     */
    public List<Integer> topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Integer> pq = new PriorityQueue<>(k, (a, b) -> map.get(a) - map.get(b));
        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.offer(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.poll();
                pq.offer(key);
            }
        }
        return new ArrayList<>(pq);
    }

    /**
     * 桶排序
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] buckets =  new List[nums.length + 1];
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            if (buckets[i] != null) {
                result.addAll(buckets[i]);
            }
        }
        return result;
    }

}
