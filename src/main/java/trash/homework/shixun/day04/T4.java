package trash.homework.shixun.day04;

public class T4 {
    public static void main(String[] args) {
        String str1 = "hellojava123asfhjava888java666javakikhjavahhh";
        String str2 = "java";

        int count = 0;
        int index = str1.indexOf(str2);

        while (index != -1) {
            index = str2.length() + index;
            count++;
            index = str1.indexOf(str2, index);
        }
        System.out.println(count);
    }
}
