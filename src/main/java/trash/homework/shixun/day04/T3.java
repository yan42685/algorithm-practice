package trash.homework.shixun.day04;

import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        StringBuilder strBuilder1 = new StringBuilder(s1);
        StringBuilder strBuilder2 = new StringBuilder(s2);
        String str = strBuilder1.reverse().append(strBuilder2.reverse()).toString();
        System.out.println(str);
    }
}
