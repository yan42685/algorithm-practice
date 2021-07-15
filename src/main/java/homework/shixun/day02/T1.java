package homework.shixun.day02;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        int[] input = new int[10];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            input[i] = scanner.nextInt();
        }
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        for (int num : input) {
            if (num == 1) {
                count1++;
            } else if (num == 2) {
                count2++;
            } else if (num == 3) {
                count3++;
            } else {
                count4++;
            }
        }
        System.out.printf("1的个数：%d,\t2的个数：%d,\t3的个数：%d,\t不合法数字的个数：%d\n", count1, count2, count3, count4);
    }
}
