package trash.homework.shixunweb.day05;

import java.util.Collection;
import java.util.LinkedList;

public class T4 {
    public static void main(String[] args) {
        Collection<Integer> collection = new LinkedList<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        Object[] nums = convert(collection);
        for (Object num : nums) {
            System.out.println(num);
        }

    }

    private static Object[] convert(Collection<Integer> collection) {
        return collection.toArray();
    }
}

