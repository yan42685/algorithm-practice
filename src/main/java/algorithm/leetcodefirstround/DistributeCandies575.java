package algorithm.leetcodefirstround;

import java.util.HashSet;
import java.util.Set;

/**
 * @author alexyan
 * @date 1/8/2020 07:23
 */
public class DistributeCandies575 {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>(candies.length);
        for (int candy : candies) {
            set.add(candy);
        }
        return Math.min(set.size(), candies.length / 2);
    }
}
