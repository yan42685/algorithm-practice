package homework.shixun.day02;

import java.util.Random;

public class T3 {
    public static void main(String[] args) {
        int[] lottery = getLottery();
        printLottery(lottery);
    }

    public static int[] getLottery() {
        int[] result = new int[7];
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            result[i] = 1 + random.nextInt(33);
        }
        result[6] = 1 + random.nextInt(16);
        return result;
    }

    public static void printLottery(int[] lottery) {
        for (int i = 0; i < 5; i++) {
            System.out.print(lottery[i] + ",");
        }
        System.out.print(lottery[5] + "+" + lottery[6] + "\n");
    }

}
