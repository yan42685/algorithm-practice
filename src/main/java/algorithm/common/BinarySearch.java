package algorithm.common;


/**
 * @author alexyan
 * @date 11/17/2019 10:36
 */
public class BinarySearch {
    public static <T extends Comparable<T>> int bSearch(T[] list, T key) {

        int low = 0;
        int high = list.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comp = key.compareTo(list[mid]);
            if (comp > 0) {
                low = mid + 1;
            } else if (comp < 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private void test() {
        return;
    }
}
