package homework.shixun.day03;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String s = scanner.nextLine();
        String reverse = reverse(s);
        System.out.println("反转之后" + reverse);

    }

    public static String reverse(String str) {
        String s1 = "";
        for (int i = str.length()-1; i >=0; i--) {
            s1 += str.charAt(i);
        }
        return s1;
    }
}
