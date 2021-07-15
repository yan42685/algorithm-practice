package homework.shixun.day04;

import java.util.Random;
import java.util.Scanner;

public class T5 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "123456";

    public static void main(String[] args) {
        String checkCode = getCheckCode();
        System.out.println("验证码: " + checkCode);

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名: ");
        String inputUsername = scanner.nextLine();
        System.out.println("请输入密码：");
        String inputPassword = scanner.nextLine();
        System.out.println("请输入验证码：");
        String inputCheckCode = scanner.nextLine();

        boolean isValid = USERNAME.equals(inputUsername) && PASSWORD.equals(inputPassword)
                && checkCode.equals(inputCheckCode);
        if (isValid) {
            System.out.println("登陆成功");
        } else {
            System.out.println("登陆失败");
        }

    }

    public static String getCheckCode() {
        //1)定义一个长度为26+26+10的字符数组
        char[] chars = new char[62];
        //2)给数组中的元素赋值所有的小写字母、大写字母、数字字符
        char lowerCase = 'a';
        char upperCase = 'A';
        char number = '1';
        for (int i = 0; i < 26; i++) {
            chars[i] = lowerCase;
            ++lowerCase;
        }
        for (int i = 26; i < 52; i++) {
            chars[i] = upperCase;
            ++upperCase;
        }
        for (int i = 52; i < 62; i++) {
            chars[i] = number;
            ++number;
        }
        //3)随机从数组中产生4个索引，并获取索引位置的字符
        Random random = new Random();
        char[] charArray = new char[4];
        for (int i = 0; i < charArray.length; i++) {
            int index = random.nextInt(62);
            charArray[i] = chars[index];
        }
        //4)把随机产生的字符拼接成一个字符串，这个字符串就是验证码
        StringBuilder builder = new StringBuilder();
        for (char ch : charArray) {
            builder.append(ch);
        }
        //5)把验证码字符串返回
        return builder.toString();
    }
}
