package homework.shixun.day01;

public class T6 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 9999; i > 1000; --i) {
            int a = i / 1000;
            int b = (i - 1000 * a) / 100;
            int c = (i - 1000 * a - 100 * b) / 10;
            int d = i % 10;
            if (a + c == b + d) {
                System.out.print(i + "\t");
                ++count;
                if (count % 5 == 0) {
                    System.out.println();
                }
            }
        }
        System.out.printf("共有%d个满足条件的数字", count);
    }
}
