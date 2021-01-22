package datastruct;

/**
 * @author alexyan
 * @date 1/11/2020 21:38
 */
public interface MaxHeap<E extends Comparable<E>> {
    int size();

    boolean isEmpty();

    E findMax() throws Exception;

    void add(E element);

    E extractMax() throws Exception;

    E replace(E element) throws Exception;
}
