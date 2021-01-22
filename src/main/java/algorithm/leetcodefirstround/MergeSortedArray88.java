package algorithm.leetcodefirstround;

/**
 * @author: alexyan
 * @date: 5/26/2019 23:31
 * @description:
 */
public class MergeSortedArray88 {
    /**
     * 更好的做法是原地从后往前merge
     */
    public void merge(int[]nums1, int m, int[] nums2, int n) {
        if (nums2 == null || n == 0) return;
        int a = 0, b = 0, c = 0;
        int[] tmp = new int[m+n];
        while (a < m && b < n) {
            tmp[c++] = nums1[a] <= nums2[b] ? nums1[a++] : nums2[b++];
        }

        while (a < m) {
            tmp[c++] = nums1[a++];
        }
        while(b < n) {
            tmp[c++] = nums2[b++];
        }

        a = c = 0;
        for (int k = 0; k < tmp.length; k++) {
            nums1[a++] = tmp[c++];
        }
    }
}
