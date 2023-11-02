package trash.homework.shixun.day04;

public class T1 {
    public static void main(String[] args) {
        String s = "Hello-World";
        //1.使用"-"进行切割，得到一个数组
        String[] split = s.split("-");
        //2.判断数组的1索引元素，与字符串"world"是否相等忽略大小写
        boolean isEquals = "world".equalsIgnoreCase(split[1]);
        System.out.println("是否相等：" + isEquals);
        //3.获取字符串s的3号索引的字符,打印到控制台上
        System.out.println("Char at 3：" + s.charAt(3));
        //4.获取字符串s的长度,打印在控制台上
        System.out.println("length: " + s.length());
        //5.将字符串s中的字符遍历并输出
        for (char ch : s.toCharArray()) {
            System.out.print(ch + " ");
        }
    }
}
