package homework.shixun.day02;

import java.util.Random;

public class T4 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            arr[i] = 1 + random.nextInt(99);
        }
        int count = getScore(arr);
        System.out.println("大于平均值的元素个数为: " + count);
    }

    /**
     * 获取大于平均值元素的个数
     */
    private static int getScore(int[] arr) {
        int result = 0;
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        double average = (double) sum / arr.length;
       
        for (int num : arr) {
            if (num > average) {
                result++;
            }
        }
        return result;
    }
}
