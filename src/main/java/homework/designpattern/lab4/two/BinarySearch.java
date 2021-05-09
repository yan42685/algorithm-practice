package homework.designpattern.lab4.two;

import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(int[] data, int target) {
        int result = Arrays.binarySearch(data, target);
        System.out.println("二分搜索完成");
        return result;
    }
}
