package algorithm.leetcodefirstround;

/**
 * @author: alexyan
 * @date: 5/28/2019 12:17
 * @description:
 */
public class TwoSumII167 {
    /**
     * 双指针法,用到了数组sorted的性质，如果数组无序就用HashMap
     */
    public int[] twoSum(int[] numbers, int target) {
        int a = 0, b = numbers.length - 1;
        while (a < b) {
            int sum = numbers[a] + numbers[b];
            if (sum == target) break;
            else if (sum < target) a++;
            else b--;
        }
        return new int[]{a + 1, b + 1};
    }


}
