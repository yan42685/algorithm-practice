package algorithm.leetcodefirstround;

/**
 * @author: alexyan
 * @date: 5/26/2019 11:16
 * @description:
 */
public class RemoveElement26 {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
