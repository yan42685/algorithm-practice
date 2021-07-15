package homework.shixun.day01;

import java.util.Scanner;

public class T5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scoreOverEightyCount = 0;
        System.out.print("学生人数：");
        int studentCount = scanner.nextInt();
        System.out.println("---- 请开始录入学生成绩 ----");
        for (int i = 0; i < studentCount; i++) {
            System.out.printf("学生%d: ", i + 1);
            int score = scanner.nextInt();
            if (score >= 80) {
                scoreOverEightyCount++;
            }
        }
        double rate = (double) scoreOverEightyCount / studentCount;
        System.out.printf("80分以上学生占比: %.2f%%", 100 * rate);
    }
}
