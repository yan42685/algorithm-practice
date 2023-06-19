package test;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{5, 1, 3}));
    }

    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // 左中心 相同元素收缩右侧 mid != right
            int mid = left + (right + 1 - left) / 2;
            // 因为mid可能等于left, 所以只比较mid和right
            if (nums[mid] > nums[left]) {
                right = mid - 1;
            } else if (nums[mid] < nums[left]) {
                left = mid;
            } else {
                ++left;
            }
        }
        return nums[left];
    }
}
