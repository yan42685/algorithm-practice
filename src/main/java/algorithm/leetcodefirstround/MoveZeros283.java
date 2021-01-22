package algorithm.leetcodefirstround;

/**
 * @author: alexyan
 * @date: 5/28/2019 20:30
 * @description:
 */
public class MoveZeros283 {
    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                swap(nums, i++, j);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
