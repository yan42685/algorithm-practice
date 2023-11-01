package algorithm.basic.sort;

// 这段代码不能一次性写出bug free的，
public class MergeSort implements SortAlgorithm {
    @Override
    public void sort(int[] nums) {
        int[] temp = new int[nums.length];
        sort(nums, temp, 0, nums.length - 1);
    }

    private void sort(int[] array, int[] temp, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(array, temp, left, mid);
        sort(array, temp, mid + 1, right);
        merge(array, temp, left, mid, right);
    }

    private void merge(int[] array, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
        }
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                array[k] = temp[j++];
            } else if (j == right + 1) {
                array[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                array[k] = temp[i++];
            } else {
                array[k] = temp[j++];
            }
        }
    }


}
