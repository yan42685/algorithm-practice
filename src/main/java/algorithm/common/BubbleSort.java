package algorithm.common;

import java.util.Comparator;

/**
 * @author alexyan
 * @date 11/17/2019 10:12
 */
public class BubbleSort implements Sorter {
    private <T> void swap(T[] list, int i, int j) {
        T temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] list) {
        boolean swapped = true;
        for (int i = 0; i < list.length && swapped; i++) {
            swapped = false;
            for (int j = 0; j < list.length - i - 1; j++) {
                swap(list, j, j + 1);
                swapped = true;
            }
        }
    }

    @Override
    public <T> void sort(T[] list, Comparator<T> comp) {
        boolean swapped = true;
        for (int i = 0; i < list.length && swapped; i++) {
            swapped = false;
            for (int j = 0; j < list.length - i - 1; j++) {
                if (comp.compare(list[j], list[j + 1]) > 0) {
                    swap(list, j, j + 1);
                    swapped = true;
                }
            }
        }

    }
}
