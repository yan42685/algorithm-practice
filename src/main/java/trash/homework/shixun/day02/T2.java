package trash.homework.shixun.day02;

import java.util.Random;
import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入班级人数：");
        int studentCount = scanner.nextInt();
        int[] scores = new int[studentCount];

        Random random = new Random();
        for (int i = 0; i < scores.length; i++) {
            scores[i] = random.nextInt(100);
        }

        // 不及格人数
        int failCount = 0;
        int scoreSum = 0;
        for (int score : scores) {
            scoreSum += score;
            if (score < 60) {
                failCount++;
            }
        }
        System.out.printf("不及格人数：%d\n班级平均分：%.2f\n", failCount, (double) scoreSum / studentCount);
    }
}
