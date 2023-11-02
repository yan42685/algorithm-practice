package trash.homework.shixun.day04;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        // 大写字符数量
        int count1 = 0;
        // 小写字符数量
        int count2 = 0;
        // 数字字符数量
        int count3 = 0;
        for (char ch : input.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                ++count1;
            } else if (Character.isLowerCase(ch)) {
                ++count2;
            } else if (Character.isDigit(ch)) {
                ++count3;
            }
        }
        System.out.printf("大写字符个数: %d, 小写字符个数: %d，数字字符个数：%d\n", count1, count2, count3);
    }
}
