package datastruct;

/**
 * @author alexyan
 * @date 1/12/2020 22:01
 */
public interface Merger<E> {
    E merge(E a, E b);
}
