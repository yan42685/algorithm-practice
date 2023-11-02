package trash.homework.shixunweb.day05;

import java.util.ArrayList;
import java.util.Collection;

public class T2 {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        System.out.println("a:" + listTest(list, "a"));
        System.out.println("b:" + listTest(list, "b"));
        System.out.println("c:" + listTest(list, "c"));
        System.out.println("xxx:" + listTest(list, "xxx"));

    }

    /**
     * 统计指定元素出现次数
     */
    public static int listTest(Collection<String> list, String s) {
        int count = 0;
        for (String element : list) {
            if (element.equals(s)) {
                ++count;
            }
        }
        return count;
    }
}
