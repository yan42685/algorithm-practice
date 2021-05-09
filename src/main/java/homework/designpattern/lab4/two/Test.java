package homework.designpattern.lab4.two;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] data = {3, 2, 1};
        DataOperationAdapter operationAdapter = new DataOperationAdapter();
        int index = operationAdapter.search(data, 2);
        System.out.printf("2的索引是%d\n", index);
        System.out.println("排序前：");
        Arrays.stream(data).forEach(System.out::println);
        operationAdapter.sort(data);
        System.out.println("排序后：");
        Arrays.stream(data).forEach(System.out::println);

    }
}
