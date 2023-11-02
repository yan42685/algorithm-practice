package trash.homework.shixunweb.day05;

import java.util.ArrayList;

public class T8 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        System.out.println(listTest(list, 3));
        System.out.println(listTest(list, 5));
    }

    private static int listTest(ArrayList<Integer> al, Integer s) {
        return al.indexOf(s);
    }
}
