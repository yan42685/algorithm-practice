package algorithm.leetcodefirstround;

/**
 * @author: alexyan
 * @date: 7/18/2019 18:20
 * @description:
 */
public class SearchInrotatedSortedArray33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        if (nums.length == 1)
            return target == nums[0] ? 0 : -1;
        int low = 0;
        int high = nums.length - 1;
        if (target <= nums[nums.length-1]) {
            while (low < high) {
                int mid = low + (high-low) / 2;
                if (nums[mid] >= nums[0] || target > nums[mid]) low = mid;
                else if (target < nums[mid]) high = mid;
                else return mid;
            }
        }
        else if (target >= nums[0]) {
            while (low < high) {
                int mid = low + (high-low) / 2;
                if (target > nums[mid]) low = mid;
                else if (nums[mid] <= nums[nums.length - 1] || target < nums[mid]) high = mid;
                else return mid;
            }
        }
        return -1;
    }


}
