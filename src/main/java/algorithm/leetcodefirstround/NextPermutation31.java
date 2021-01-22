package algorithm.leetcodefirstround;

/**
 * @author: alexyan
 * @date: 5/29/2019 20:53
 * @description:
 */
public class NextPermutation31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i+1])
            i--;
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[i] >= nums[j])
                j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] a, int m, int n) {
        int tmp = a[m];
        a[m] = a[n];
        a[n] = tmp;
    }

    private void reverse(int[] a, int low, int high) {
        while (low < high)
            swap(a, low++, high--);
    }
}
