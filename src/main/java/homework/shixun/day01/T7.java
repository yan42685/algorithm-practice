package homework.shixun.day01;

public class T7 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 100; ++i) {
            int a = i / 10;
            int b = i % 10;
            if (a != 9 && b != 9) {
                System.out.print(i + "\t");
                ++count;
                if (count == 5) {
                    count = 0;
                    System.out.println();
                }
            }
        }
    }
}
