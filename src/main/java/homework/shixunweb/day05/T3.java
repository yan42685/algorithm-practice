package homework.shixunweb.day05;

import java.util.Collection;
import java.util.LinkedList;

public class T3 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        Collection<Integer> collection = convert(array);
        collection.forEach(System.out::println);

    }

    private static Collection<Integer> convert(int[] array) {
        Collection<Integer> result = new LinkedList<>();
        for (int num : array) {
            result.add(num);
        }
        return result;
    }
}
