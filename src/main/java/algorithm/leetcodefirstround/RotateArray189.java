package algorithm.leetcodefirstround;

/**
 * @author: alexyan
 * @date: 5/28/2019 17:48
 * @description:
 */
public class RotateArray189 {
    /**
     * 三次翻转
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    /**
     * 法二：复制一个数组
     */
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        int[] tmp = nums.clone();
        for (int i = 0; i < k; i++) {
            nums[i] = nums[nums.length-k+i];
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = tmp[i-k];
        }
    }
}
