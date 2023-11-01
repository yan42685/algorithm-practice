package algorithm.basic.sort;

import java.util.Random;

public class QuickSort3Ways implements SortAlgorithm {
    private static final Random RAND = new Random();
    @Override
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int[] pair = partition(nums, left, right);
        sort(nums, left, pair[0] - 1);
        sort(nums, pair[1] + 1, right);
    }

    // 三路快速排序，选第一个数作为pivot的值
    private int[] partition(int[] nums, int left, int right) {
        int pivot = left + RAND.nextInt(right - left + 1);
        swap(nums, left, pivot);
        int i = left + 1;
        int p = left + 1;
        int j = right;
        // [left+1, i-1] 小于pivot; [i, j]等于pivot; [j+1, right]大于pivot
        // 实际上是 p 和 j 在遍历数据
        while (p <= j) {
            if (nums[p] == nums[left]) {
                ++p;
            } else if (nums[p] < nums[left]) {
                swap(nums, i++, p++);
            } else {
                swap(nums, j--, p);
            }
        }
        // 让最后一个pivot回到正确位置
        swap(nums, left, i - 1);
        return new int[]{i - 1, j};
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
