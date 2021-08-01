package homework.shixunweb.day05;

import java.util.ArrayList;

public class T5 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("xyz");
        System.out.println(listTest(list, "xyz"));
        System.out.println(listTest(list, "xyz123"));
    }

    private static boolean listTest(ArrayList<String> al, String s) {
        return al.contains(s);
    }
}
