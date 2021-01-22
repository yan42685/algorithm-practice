package algorithm.leetcodefirstround;

/**
 * @author: alexyan
 * @date: 5/26/2019 11:28
 * @description:
 */
public class SearchInsertPosition35 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (target == nums[mid]) return mid;
            else if (target < nums[mid]) high = mid - 1;
            else low = mid + 1;
        }

        return low;
    }
}
