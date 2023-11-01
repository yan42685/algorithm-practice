package algorithm.basic;

import java.util.Comparator;

/**
 * @author alexyan
 * @date 11/17/2019 10:07
 */
public interface Sorter {
    <T extends Comparable<T>> void sort(T[] list);
    <T> void sort(T[] list, Comparator<T> comp);
}
