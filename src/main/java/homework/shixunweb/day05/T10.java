package homework.shixunweb.day05;

import java.util.LinkedList;
import java.util.Random;

public class T10 {
    public static void main(String[] args) {
        Random random = new Random();
        LinkedList<Integer> list = new LinkedList<>();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1 + random.nextInt(100);
        }
        for (int i : array) {
            if (i >= 10) {
                list.add(i);
            }
        }
        list.forEach(num -> System.out.print(num + "\t"));
        System.out.println();
    }
}
