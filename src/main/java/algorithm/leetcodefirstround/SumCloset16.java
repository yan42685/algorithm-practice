package algorithm.leetcodefirstround;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: alexyan
 * @date: 5/29/2019 16:56
 * @description:
 */
public class SumCloset16 {

    Comparator<Integer> a = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return 0;
        }
    };

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(3, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                return 0;
            }
        });
        System.out.println(pq.size());

    }




}
