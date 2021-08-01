package homework.shixunweb.day05;

import java.util.ArrayList;

public class T6 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("abc");

        System.out.println(listTest(list1));
        System.out.println(listTest(list2));
    }

    private static boolean listTest(ArrayList<String> al) {
        return al.isEmpty();
    }
}
