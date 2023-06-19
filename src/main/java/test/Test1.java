package test;


import algorithm.common.Trie;
import cn.hutool.Hutool;
import utils.Asserts;
import utils.TimeUtils;

import java.util.HashMap;

public class Test1 {

    public static void main(String[] args) {
        Asserts.isTrue(findMax(new int[]{2, 1, 2, 2, 2, 2}) == 2);
        Asserts.isTrue(findMax(new int[]{2, 2, 2, 2, 1, 2}) == 2);
        Asserts.isTrue(findMax(new int[]{2, 1, 2, 2, 2, 5}) == 5);
        Asserts.isTrue(findMax(new int[]{5, 5, 6, 1, 2, 2, 2, 5}) == 6);
        Asserts.isTrue(findMax(new int[]{1, 1, 1, 1}) == 1);
        Asserts.isTrue(findMax(new int[]{1, 2, 3, 4, 5}) == 5);
        Asserts.isTrue(findMax(new int[]{4, 3, 2, 2}) == 4);
        Asserts.isTrue(findMax(new int[]{7, 8, 9, 1, 2, 3, 4}) == 9);
    }

//    public static int findMax(int[] nums) {
//        int left = 0, right = nums.length - 1;
//        while (left < right) {
//            // left + 1 <= mid <= right
//            // 右中心，因为
//            int mid = left + (right - left) / 2 + 1;
//            if (nums[mid] < nums[left]) {
//                right = mid - 1;
//            } else if (nums[mid] > nums[left]) {
//                left = mid;
//            } else {
//                ++left;
//            }
//        }
//        return nums[left];
//    }

    //  2 3 1 2 2 2 2 2 2
    public static int findMax(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // 右中心 相同元素收缩左侧 mid != left
            int mid = left + (right - left + 1) / 2;
            // 因为mid可能等于right, 所以只比较mid指针和right指针
            if (nums[mid] > nums[left]) {
                left = mid;
            } else if (nums[mid] < nums[left]) {
                right = mid - 1;
            } else {
                ++left;
            }
        }
        return nums[left];
    }

//    public static int findMax(int[] nums) {
//        int left = 0, right = nums.length - 1;
//        while (left < right) {
//            // left <= mid <= right - 1
//            int mid = left + (right - left) / 2;
//            // 因为left指针可能等于mid指针, 所以只比较mid指针和right指针
//            if (nums[mid] < nums[right]) {
//                left = mid + 1;
//            } else if (nums[mid] > nums[right]) {
//                right = mid;
//            } else {
//                --right;
//            }
//        }
//        // 当 left == right 时，返回 nums[left]
//        return nums[left];
//    }
}
